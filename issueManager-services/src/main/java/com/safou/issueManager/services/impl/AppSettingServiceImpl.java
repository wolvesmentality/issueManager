package com.safou.issueManager.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.safou.issueManager.cache.AppSettingCache;
import com.safou.issueManager.models.AppSetting;
import com.safou.issueManager.repository.AppSettingRepository;
import com.safou.issueManager.services.AppSettingService;

@Service
public class AppSettingServiceImpl implements AppSettingService {

    @Inject
    private AppSettingRepository appSettingRepository;

    @Inject
    private AppSettingCache appSettingCache;

    @Transactional
    public List<AppSetting> findAllAppSettings() {
	return appSettingRepository.findAll();
    }

    @Transactional
    public AppSetting findByName(String name) {
	return appSettingCache.find(name);
    }

}
