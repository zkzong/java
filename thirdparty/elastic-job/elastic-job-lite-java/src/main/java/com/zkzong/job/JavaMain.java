package com.zkzong.job;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.script.ScriptJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zkzong.job.job.dataflow.JavaDataflowJob;
import com.zkzong.job.job.simple.JavaSimpleJob;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

public class JavaMain {

    private static final int EMBED_ZOOKEEPER_PORT = 2181;

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:" + EMBED_ZOOKEEPER_PORT;

    private static final String JOB_NAMESPACE = "elastic-job-lite-java";

    private static final String EVENT_RDB_STORAGE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String EVENT_RDB_STORAGE_URL = "jdbc:mysql://localhost:3306/elastic_job_log";

    private static final String EVENT_RDB_STORAGE_USERNAME = "root";
    private static final String EVENT_RDB_STORAGE_PASSWORD = "root";

    public static void main(String[] args) throws IOException {
//        EmbedZookeeperServer.start(EMBED_ZOOKEEPER_PORT);
        CoordinatorRegistryCenter regCenter = setUpRegistryCenter();
        JobEventConfiguration jobEventConfig = new JobEventRdbConfiguration(setUpEventTraceDataSource());
        setUpSimpleJob(regCenter, jobEventConfig);
//        setUpDataflowJob(regCenter, jobEventConfig);
//        setUpScriptJob(regCenter, jobEventConfig);
    }

    private static CoordinatorRegistryCenter setUpRegistryCenter() {
        ZookeeperConfiguration zkConfig = new ZookeeperConfiguration(ZOOKEEPER_CONNECTION_STRING, JOB_NAMESPACE);
        CoordinatorRegistryCenter result = new ZookeeperRegistryCenter(zkConfig);
        result.init();
        return result;
    }

    private static DataSource setUpEventTraceDataSource() {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(EVENT_RDB_STORAGE_DRIVER);
        result.setUrl(EVENT_RDB_STORAGE_URL);
        result.setUsername(EVENT_RDB_STORAGE_USERNAME);
        result.setPassword(EVENT_RDB_STORAGE_PASSWORD);
        return result;
    }

    private static void setUpSimpleJob(CoordinatorRegistryCenter regCenter, JobEventConfiguration jobEventConfig) {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("javaSimpleJob", "0/5 * * * * ?", 3)
                .shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou").build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfig, JavaSimpleJob.class.getCanonicalName());
        new JobScheduler(regCenter, LiteJobConfiguration.newBuilder(simpleJobConfig).build(), jobEventConfig).init();
    }

    private static void setUpDataflowJob(CoordinatorRegistryCenter regCenter, JobEventConfiguration jobEventConfig) {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("javaDataflowElasticJob", "0/5 * * * * ?", 3)
                .shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou").build();
        DataflowJobConfiguration dataflowJobConfig = new DataflowJobConfiguration(coreConfig, JavaDataflowJob.class.getCanonicalName(), true);
        new JobScheduler(regCenter, LiteJobConfiguration.newBuilder(dataflowJobConfig).build(), jobEventConfig).init();
    }

    private static void setUpScriptJob(CoordinatorRegistryCenter regCenter, JobEventConfiguration jobEventConfig) throws IOException {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("scriptElasticJob", "0/5 * * * * ?", 3).build();
        ScriptJobConfiguration scriptJobConfig = new ScriptJobConfiguration(coreConfig, buildScriptCommandLine());
        new JobScheduler(regCenter, LiteJobConfiguration.newBuilder(scriptJobConfig).build(), jobEventConfig).init();
    }

    private static String buildScriptCommandLine() throws IOException {
        if (System.getProperties().getProperty("os.name").contains("Windows")) {
            return Paths.get(JavaMain.class.getResource("/script/demo.bat").getPath().substring(1)).toString();
        }
        Path result = Paths.get(JavaMain.class.getResource("/script/demo.sh").getPath());
        Files.setPosixFilePermissions(result, PosixFilePermissions.fromString("rwxr-xr-x"));
        return result.toString();
    }
}
