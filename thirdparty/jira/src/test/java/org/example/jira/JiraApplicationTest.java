package org.example.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import io.atlassian.util.concurrent.Promise;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zongz
 * @Date: 2024/8/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class JiraApplicationTest {

    private String serverUri;
    private String username;
    private String password;

    private JiraRestClient jiraRestClient;

    @Before
    public void setUp() throws Exception {
        serverUri = "http://localhost:8081/rest/api/2";
        username = "admin";
        password = "admin";

        AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        jiraRestClient = factory.createWithBasicHttpAuthentication(new URI(serverUri), username, password);
    }

    /**
     * jql查询
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void jql() throws ExecutionException, InterruptedException {
        Promise<SearchResult> searchResultPromise = jiraRestClient.getSearchClient().searchJql("");
        SearchResult searchResult = searchResultPromise.get();
        System.out.println(searchResult);
    }

    @Test
    public void page() {
        List<Issue> issues = new ArrayList<>();

        // 获取所有符合条件的issue
        int start = 0;
        int maxPerPage = 50;  /* batch size (max 50) */
        int total = 0;
        do {
            SearchResult result = jiraRestClient.getSearchClient()
                    .searchJql("jql", maxPerPage, start, new HashSet<>())
                    .claim();
            total = result.getTotal();
            start += maxPerPage;
            result.getIssues().iterator().forEachRemaining(issues::add);
        } while (total > start);

        // 分析所有issue
        for (Issue issue : issues) {
            System.out.println("issue的标题：" + issue.getSummary());
        }
    }

    @Test
    public void timeout() throws ExecutionException, InterruptedException, TimeoutException {
        final SearchResult searchResult = jiraRestClient.getSearchClient()
                .searchJql("jqlSearch", 100, 0, null)
                .get(100, TimeUnit.SECONDS);
    }

    @Test
    public void getAllProjects() throws ExecutionException, InterruptedException {
        Promise<Iterable<BasicProject>> allProjects = jiraRestClient.getProjectClient().getAllProjects();
        Iterable<BasicProject> iterable = allProjects.get();
        Iterator<BasicProject> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}