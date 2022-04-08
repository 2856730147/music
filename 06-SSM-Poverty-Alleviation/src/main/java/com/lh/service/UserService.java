package com.lh.service;

import com.lh.entity.User;
import com.lh.vo.ResultVo;

public interface UserService {
    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(User user);
}
