package com.zkzong.sb.shutdown.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Spring Boot 1.X Tomcat容器优雅停机
 */
@Configuration
@Slf4j
public class ShutdownConfig {

    /**
     * 用于接受shutdown事件
     *
     * @return
     */
    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }

    /**
     * 用于注入connector
     *
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    ((TomcatEmbeddedServletContainerFactory) container).addConnectorCustomizers(gracefulShutdown());
                }
            }
        };
    }

    private static class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

        private volatile Connector connector;
        private final int waitTime = 120;

        @Override
        public void customize(Connector connector) {
            this.connector = connector;
        }

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            this.connector.pause();
            Executor executor = this.connector.getProtocolHandler().getExecutor();
            if (executor instanceof ThreadPoolExecutor) {
                try {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                    log.info("shutdown start");
                    threadPoolExecutor.shutdown();
                    log.info("shutdown end");
                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                        log.info("Tomcat进程在" + waitTime + "秒内无法结束，尝试强制结束");
                    }
                    log.info("shutdown success");

                    // 其他线程池
                    //ThreadPoolTaskExecutor taskExecutor = event.getApplicationContext().getBean(ThreadPoolTaskExecutor.class);
                    //Executor executors = taskExecutor.getThreadPoolExecutor();
                    //try {
                    //    if (executors instanceof ThreadPoolTaskExecutor) {
                    //        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) executors;
                    //        log.info("Async shutdown start");
                    //        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
                    //        threadPoolTaskExecutor.setAwaitTerminationSeconds(waitTime);
                    //        threadPoolTaskExecutor.shutdown();
                    //    }
                    //} catch (Exception ex) {
                    //    Thread.currentThread().interrupt();
                    //}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
