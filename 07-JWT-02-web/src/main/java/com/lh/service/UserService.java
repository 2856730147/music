package com.lh.service;

import com.lh.vo.UserVo;

import java.util.Map;

public interface UserService {
    UserVo login(String username, String password);
}
