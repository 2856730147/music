package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.CollectionMapper;
import com.lh.entity.Collection;
import com.lh.service.CollectionService;
import com.lh.vo.DataVo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 扶贫的增、删、改、查
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
//        传给前端的信息
        ResultVo resultVo;
        //分页相关的信息
        DataVo<Collection> dataVo;
        //结果中对应的数组
        List<Collection> lists;

        if (id !=null){
           lists= new ArrayList<>();

            Collection collection = collectionMapper.selectByPrimaryKey(id);

            if (id ==null){
                dataVo=new DataVo<>(0L,lists,pageNum,pageSize);
               resultVo= new ResultVo(2341,"查询失败",false,dataVo);
            }else {
                lists.add(collection);

                dataVo=new DataVo<>(1L,lists,pageNum,pageSize);
                resultVo= new ResultVo(2341,"查询成功",true,dataVo);
            }
        }else {
            PageHelper.startPage(pageNum,pageSize);

            lists=collectionMapper.selectByExample(null);
//            如果查到数据库是空的,一个都没有
            if (lists.size() == 0) {
                dataVo = new DataVo<>(0L, lists, pageNum, pageSize);

                resultVo = new ResultVo(3232, "没有收藏", false, dataVo);
            } else {
                PageInfo<Collection> info = new PageInfo<>(lists);
                DataVo<Collection> carouselDataVo = new DataVo<>(info.getTotal(), lists, pageNum, pageSize);
                resultVo = new ResultVo(3232, "查到了收藏", true, carouselDataVo);

            }
        }

        return resultVo;
    }

    @Override
    public ResultVo add(Collection collection) {

        ResultVo vo;
//        如果没有告知轮播图的状态,默认是不可以的
        if (collection.getCreateTime() == null) {
            collection.setCreateTime(new Date());
        }
        int affectedRows = collectionMapper.insertSelective(collection);

        if (affectedRows > 0) {
            vo = new ResultVo(1001, "添加收藏成功", true, collection);
        } else {
            vo = new ResultVo(2323, "添加收藏失败", false, null);

        }
        return vo;
    }


    @Override
    public ResultVo delete(Long id) {
        int affectedRows = collectionMapper.deleteByPrimaryKey(id);
        ResultVo vo;

        if (affectedRows > 0) {
            vo = new ResultVo(1001, "删除收藏成功", true, null);
        } else {
            vo = new ResultVo(2323, "删除图收藏失败", false, null);


        }
        return vo;

    }
}
