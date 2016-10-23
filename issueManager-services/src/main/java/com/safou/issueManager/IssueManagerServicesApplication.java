package com.safou.issueManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({ @PropertySource("classpath:issueManager-services.properties"),
	@PropertySource(value = "classpath:issueManager-services-local.properties", ignoreResourceNotFound = true) })
public class IssueManagerServicesApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
	SpringApplication.run(IssueManagerServicesApplication.class, args);
    }

    /**
     * Used when run as WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(IssueManagerServicesApplication.class);
    }
}