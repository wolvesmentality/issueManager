package com.safou.issueManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
	LOGGER.info("hello");
	int i = 0;
	i = 5;
    }

}
