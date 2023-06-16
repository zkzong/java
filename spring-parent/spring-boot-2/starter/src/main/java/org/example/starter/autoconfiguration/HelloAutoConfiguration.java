package org.example.starter.autoconfiguration;

import org.example.starter.HelloFormatTemplate;
import org.example.starter.format.FormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(HelloProperties.class)
@Configuration
public class HelloAutoConfiguration {

    @Bean
    public HelloFormatTemplate helloFormatTemplate(HelloProperties helloProperties, FormatProcessor formatProcessor) {
        return new HelloFormatTemplate(helloProperties, formatProcessor);
    }
}
