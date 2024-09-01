package org.example.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import io.atlassian.util.concurrent.Promise;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

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

    @Test
    public void jql() throws ExecutionException, InterruptedException {
        Promise<SearchResult> searchResultPromise = jiraRestClient.getSearchClient().searchJql("");
        SearchResult searchResult = searchResultPromise.get();
        System.out.println(searchResult);
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