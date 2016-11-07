package com.safou.issueManager.VOMappers;

import com.safou.issueManager.VOs.UserVO;
import com.safou.issueManager.models.AppUser;

public interface UserVOMapper {

    UserVO toUserVO(AppUser user);

}
