package com.safou.issueManager.services;

import java.util.List;

import com.safou.issueManager.models.AppSetting;

public interface AppSettingService {

    List<AppSetting> findAllAppSettings();

    AppSetting findByName(String name);

}
