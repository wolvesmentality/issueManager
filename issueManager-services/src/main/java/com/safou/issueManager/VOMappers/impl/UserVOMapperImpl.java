package com.safou.issueManager.VOMappers.impl;

import org.springframework.stereotype.Service;

import com.safou.issueManager.VOMappers.UserVOMapper;
import com.safou.issueManager.VOs.UserVO;
import com.safou.issueManager.models.AppUser;

@Service
public class UserVOMapperImpl implements UserVOMapper {

    @Override
    public UserVO toUserVO(AppUser user) {
	UserVO userVO = null;
	if (user != null) {
	    userVO = new UserVO();
	    userVO.setFirstName(user.getFirstName());
	}
	return userVO;
    }

}
