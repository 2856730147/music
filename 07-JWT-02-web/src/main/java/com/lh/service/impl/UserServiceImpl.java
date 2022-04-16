package com.lh.service.impl;

import com.lh.service.UserService;
import com.lh.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVo login(String username, String password) {
        UserVo userVo=null;
        if (username.equals("李豪")&& password.equals("123456")){
            userVo = new UserVo();

            userVo.setId(1);
           userVo.setUsername(username);
           userVo.setLastAccessTime(new Date());
        }


        return null;
    }
}
