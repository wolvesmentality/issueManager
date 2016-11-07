package com.safou.issueManager.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.safou.issueManager.VOMappers.UserVOMapper;
import com.safou.issueManager.VOs.UserVO;
import com.safou.issueManager.models.AppUser;
import com.safou.issueManager.repository.AppUserRepository;
import com.safou.issueManager.services.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Inject
    private AppUserRepository appUserRepository;

    @Inject
    private UserVOMapper userVOMapper;

    // === UserDetailsService implementation ===

    @Override
    public UserVO loadUser(String username) {
	UserVO result = null;
	AppUser user = appUserRepository.findByLogin(username);
	if (user != null) {
	    result = userVOMapper.toUserVO(user);
	}
	return result;
    }

}
