package com.safou.issueManager.cache.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.safou.issueManager.cache.AppSettingCache;
import com.safou.issueManager.models.AppSetting;
import com.safou.issueManager.repository.AppSettingRepository;

@Repository
public class AppSettingCacheImpl implements AppSettingCache {

    @Inject
    private AppSettingRepository appSettingRepository;

    @Inject
    private Environment env;

    private Map<String, AppSetting> appSettingCacheMap = new HashMap<String, AppSetting>(0);

    @Override
    public void refresh() {
	createCache();
    }

    public AppSetting find(String name) {
	AppSetting result = null;
	String value;
	if (StringUtils.isNotEmpty(name)) {
	    result = appSettingCacheMap.get(name);
	    if (result == null) {
		result = appSettingRepository.findByName(name);
		if (result == null) {
		    value = env.getProperty(name);
		    if (value != null) {
			result = new AppSetting();
			result.setValue(value);
		    }
		}
		if (result != null) {
		    appSettingCacheMap.put(name, result);
		}
	    }
	}
	return result;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
	createCache();
    }

    private void createCache() {
	appSettingCacheMap = new HashMap<String, AppSetting>();
	List<AppSetting> appSettings = appSettingRepository.findAll();
	if (CollectionUtils.isNotEmpty(appSettings)) {
	    for (AppSetting appSetting : appSettings) {
		appSettingCacheMap.put(appSetting.getName(), appSetting);
	    }
	}
    }

}
