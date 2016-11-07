package com.safou.issueManager.resources.impl;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.safou.issueManager.resources.CORSResponseFilter;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
	registerEndpoints();
    }

    private void registerEndpoints() {

	// Add filters
	register(CORSResponseFilter.class);

	// Add Resources
	register(AppSettingResourceImpl.class);
	register(AuthenticationResourceImpl.class);

    }

}