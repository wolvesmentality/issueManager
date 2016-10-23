package com.safou.issueManager.cache;

import com.safou.issueManager.models.AppSetting;

public interface AppSettingCache extends ICache {

    AppSetting find(String name);
}
