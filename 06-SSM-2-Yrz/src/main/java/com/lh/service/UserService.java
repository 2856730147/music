package com.lh.service;


import com.lh.vo.ResultVo;
import com.lh.vo.params.LoginParams;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    ResultVo login(String username, String password);
}
