package com.lh.service;

import com.lh.entity.Alleviation;
import com.lh.vo.ResultVo;

import java.util.Date;

public interface AlleviationService {
    ResultVo getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Alleviation alleviation);

    ResultVo click(Long id, Date lastClickTime);

    ResultVo update(Alleviation alleviation);

    ResultVo delete(Long id);
}
