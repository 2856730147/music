package com.lh.service;

import com.lh.entity.User;
import com.lh.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    ResultVo getList(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(User user);

    ResultVo update(User user);

    ResultVo delete(long id);

    ResultVo login(String username, String password);
}
