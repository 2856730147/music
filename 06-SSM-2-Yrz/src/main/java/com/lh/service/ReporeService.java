package com.lh.service;

import com.lh.entity.TbNote;
import com.lh.entity.TbNoteExample;
import com.lh.vo.ResultInfo;
import com.lh.vo.ResultVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface ReporeService {
    ModelAndView findAll(TbNoteExample tbNoteExample, HttpServletRequest request);

    ResultInfo findByAll(TbNoteExample tbNoteExample);
}
