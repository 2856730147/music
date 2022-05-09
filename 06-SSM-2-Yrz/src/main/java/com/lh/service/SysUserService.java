package com.lh.service;

import com.lh.entity.TbUser;

public interface SysUserService {
    //根据用户和密码去user查询是否存在
    TbUser loginUser(String username, String password);
}
