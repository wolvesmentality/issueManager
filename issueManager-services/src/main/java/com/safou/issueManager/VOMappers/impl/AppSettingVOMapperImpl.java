package com.safou.issueManager.VOMappers.impl;

import org.springframework.stereotype.Service;

import com.safou.issueManager.VOMappers.AppSettingVOMapper;
import com.safou.issueManager.VOs.AppSettingVO;
import com.safou.issueManager.models.AppSetting;

@Service
public class AppSettingVOMapperImpl implements AppSettingVOMapper {

    public AppSettingVO toAppSettingVO(AppSetting appSetting) {
	AppSettingVO result = null;
	if (appSetting != null) {
	    result = new AppSettingVO();
	    result.setId(appSetting.getId());
	    result.setName(appSetting.getName());
	    result.setValue(appSetting.getName());
	}
	return result;
    }

}
