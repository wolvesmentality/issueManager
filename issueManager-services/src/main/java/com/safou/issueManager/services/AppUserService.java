package com.safou.issueManager.services;

import com.safou.issueManager.VOs.UserVO;

public interface AppUserService {

    UserVO loadUser(String username);

}
