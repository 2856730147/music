package com.lh.service;

import com.lh.vo.UserVo;

public interface UserService {
    UserVo login(String username, String password);
}
