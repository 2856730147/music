package com.lh.service;


import com.lh.vo.ResultVo;

public interface UserService {

    ResultVo login(String username, String password);
}
