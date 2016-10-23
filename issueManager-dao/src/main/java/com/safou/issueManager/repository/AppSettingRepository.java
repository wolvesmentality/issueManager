package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppSetting;

public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {

    AppSetting findByName(String name);
}
