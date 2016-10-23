package com.safou.issueManager.resources.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.safou.issueManager.models.AppSetting;
import com.safou.issueManager.resources.AppSettingResource;
import com.safou.issueManager.services.AppSettingService;

@Component
public class AppSettingResourceImpl implements AppSettingResource {

    @Inject
    private AppSettingService appSettingService;

    public Response findAll() {
	List<AppSetting> appSettings = appSettingService.findAllAppSettings();
	return Response.ok(appSettings).build();
    }

    public Response findByName(String name) {
	AppSetting appSetting = appSettingService.findByName(name);
	return Response.ok(appSetting).build();
    }

}
