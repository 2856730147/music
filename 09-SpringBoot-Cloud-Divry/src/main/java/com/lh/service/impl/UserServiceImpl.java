package com.lh.service.impl;

import com.lh.dao.TbUserMapper;
import com.lh.entity.TbUser;
import com.lh.entity.TbUserExample;
import com.lh.service.UserService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private TbUserMapper userMapper;

    @Override
    public ResultVo login(String username, String password) {
        ResultVo resultVo = new ResultVo();
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);


        List<TbUser> tbUsers = userMapper.selectByExample(tbUserExample);

        if (tbUsers.size()>0){
            resultVo.setData(tbUsers.get(0));
            resultVo.setSuccess(true);
            resultVo.setMessage("login success!");
            resultVo.setCode(200);
        }else {
            resultVo.setMessage("登录失败，用户名和密码错误!");
            resultVo.setCode(0);
        }

        return resultVo;
    }
}


