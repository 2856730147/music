package com.lh.service;

import com.lh.entity.MessageBoardWithBLOBs;
import com.lh.vo.ResultVo;

public interface MessageBoardService {
    ResultVo list(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVo delete(Long id);
}
