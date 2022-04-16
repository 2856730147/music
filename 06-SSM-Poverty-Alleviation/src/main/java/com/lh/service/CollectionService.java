package com.lh.service;

import com.lh.entity.Collection;
import com.lh.vo.ResultVo;

public interface CollectionService {
    ResultVo list(Integer pageNum, Integer pageSize, Long id);

    ResultVo add(Collection collection);

    ResultVo delete(Long id);
}
