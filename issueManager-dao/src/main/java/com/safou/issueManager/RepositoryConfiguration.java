package com.safou.issueManager;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.safou.issueManager.repository.custom")
@EnableJpaRepositories(basePackages = { "com.safou.issueManager.repository" })
@EnableTransactionManagement
@PropertySources({ @PropertySource("classpath:issueManager-dao.properties"),
	@PropertySource(value = "classpath:issueManager-dao-local.properties", ignoreResourceNotFound = true) })
public class RepositoryConfiguration {

}
