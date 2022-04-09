package com.lh.service;

import com.lh.entity.Poor;
import com.lh.entity.PoorWithBLOBs;
import com.lh.vo.ResultVo;

import java.util.Date;

public interface PoorService {
    ResultVo list(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(PoorWithBLOBs poorWithBLOBs);

    ResultVo update(PoorWithBLOBs poorWithBLOBs);

    ResultVo delete(Long id);

    ResultVo click(Long id, Date lastClickTime);
}
