package com.safou.issueManager;

import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SystemPropertyDefaultsInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

	// set time zone
	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    }

}
