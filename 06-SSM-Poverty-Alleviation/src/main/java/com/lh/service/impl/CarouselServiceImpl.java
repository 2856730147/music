package com.lh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.CarouselMapper;
import com.lh.entity.Carousel;
import com.lh.entity.User;
import com.lh.service.CarouselService;
import com.lh.vo.DataVo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 扶贫的增、删、改、查
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Integer id) {
        //返回前端的信息
        ResultVo resultVo;
        //分页相关的信息
        DataVo<Carousel> CarouselMapperDataVo;
        //结果中对应的用户数组
        List<Carousel> carousels;

        if (id != null) {
            carousels = new ArrayList<>();
//            查询
            Carousel carousel = carouselMapper.selectByPrimaryKey(id);
            if (id == null) {
                CarouselMapperDataVo = new DataVo<>(0L, carousels, pageNum, pageSize);

                resultVo = new ResultVo(3232, "查询失败", false, CarouselMapperDataVo);
            } else {
//                查到了对象扔到集合中
                carousels.add(carousel);

                CarouselMapperDataVo = new DataVo<>(1L, carousels, pageNum, pageSize);

                resultVo = new ResultVo(1200, "查询成功", true, CarouselMapperDataVo);
            }
        } else {
//           开启分页
            PageHelper.startPage(pageNum, pageSize);
            //查询到多条结果扔到集合里
            carousels = carouselMapper.selectByExample(null);

//            如果查到数据库是空的,一个都没有
            if (carousels.size() == 0) {
                CarouselMapperDataVo = new DataVo<>(0L, carousels, pageNum, pageSize);

                resultVo = new ResultVo(3232, "没有用户", false, CarouselMapperDataVo);
            } else {
                PageInfo<Carousel> info = new PageInfo<>(carousels);
                DataVo<Carousel> carouselDataVo = new DataVo<>(info.getTotal(), carousels, pageNum, pageSize);
                resultVo = new ResultVo(3232, "查到了用户", false, carouselDataVo);

            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(Carousel carousel) {
        ResultVo vo;
//        如果没有告知轮播图的状态,默认是不可以的
        if (carousel.getAvailable() == null) {
            carousel.setAvailable(false);
        }
        int affectedRows = carouselMapper.insertSelective(carousel);

        if (affectedRows > 0) {
            vo = new ResultVo(1001, "添加图片成功", true, carousel);
        } else {
            vo = new ResultVo(2323, "添加图片失败", false, null);

        }
        return vo;
    }

    @Override
    public ResultVo update(Carousel carousel) {
        ResultVo vo;
        int affectedRows = carouselMapper.updateByPrimaryKeySelective(carousel);

        if (affectedRows > 0) {
            carousel = carouselMapper.selectByPrimaryKey(carousel.getId());
            vo = new ResultVo(1001, "添加图片成功", true, carousel);
        } else {
            vo = new ResultVo(2323, "添加图片失败", false, null);

        }
        return vo;
    }
    @Override
    public ResultVo delete(Integer id) {
        int affectedRows = carouselMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows > 0) {
            vo = new ResultVo(1001, "删除图片成功", true, null);
        } else {
            vo = new ResultVo(2323, "删除图片失败", false, null);


        }
        return vo;
    }
}
