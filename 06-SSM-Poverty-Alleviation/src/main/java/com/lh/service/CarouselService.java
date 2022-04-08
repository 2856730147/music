package com.lh.service;

import com.lh.entity.Carousel;
import com.lh.vo.ResultVo;

public interface CarouselService {
    ResultVo getlist(Integer pageNum, Integer pageSize,Integer id);


    ResultVo add(Carousel carousel);

    ResultVo update(Carousel carousel);

    ResultVo delete(Integer id);
}
