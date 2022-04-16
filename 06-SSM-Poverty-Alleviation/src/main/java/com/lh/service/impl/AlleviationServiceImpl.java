package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.AlleviationMapper;
import com.lh.entity.Alleviation;
import com.lh.service.AlleviationService;
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
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    private AlleviationMapper alleviationMapper;
    /**
     *  查询、分页查询、id查询
     */
    @Override
    public ResultVo getlist(Integer pageNum, Integer pageSize, Long id) {
//        返回给前端信息
        ResultVo resultVo;
//        分页相关的东西
        DataVo<Alleviation> dataVo;
//        结果中对应的数组
        List<Alleviation> alleviations;

        if (id!=null){
          alleviations= new ArrayList<>();
          //查询

            Alleviation alleviation = alleviationMapper.selectByPrimaryKey(id);

            if (id == null){
                dataVo = new DataVo<>(0L, alleviations, pageNum, pageSize);

               resultVo= new ResultVo(1212,"查询失败",false,dataVo);
            }else {
                // 如果是查询单个,那么点击量加1
                click(alleviation.getId(),null);

                alleviation.setClickNum(alleviation.getClickNum()+1);

                alleviations.add(alleviation);



                dataVo = new DataVo<>(1L, alleviations, pageNum, pageSize);

                resultVo= new ResultVo(1212,"查询成功",true,dataVo);

            }
        }else {
            PageHelper.startPage(pageNum,pageSize);
            alleviations = alleviationMapper.selectByExample(null);
//            判断数据库是否为空
            if (alleviations.size()==0){
                dataVo = new DataVo<>(0L, alleviations, pageNum, pageSize);

                resultVo= new ResultVo(1212,"没有扶贫政策",false,dataVo);

            }else {
                PageInfo<Alleviation> info = new PageInfo<>(alleviations);
                DataVo<Alleviation> dataVo1 = new DataVo<>(info.getTotal(), alleviations, pageNum, pageSize);

                resultVo= new ResultVo(1212,"查到了扶贫政策",true,dataVo1);

            }
        }


        return resultVo;
    }
/**
 * 添加方法
 * 添加没有时间就自动补当前时间
 */
    @Override
    public ResultVo add(Alleviation alleviation) {
        ResultVo vo;
//判断是否存在创建时间,没有就直接加上
        if (alleviation.getLastClickTime()==null){
            alleviation.setCreateTime(new Date());
        }
//        新创建的扶贫政策,点击量应该为0
        alleviation.setClickNum(0);
        alleviation.setLastClickTime(null);
        int affectedRows = alleviationMapper.insertSelective(alleviation);

        if (affectedRows>0){
           vo= new ResultVo(1000,"添加政策成功",true,alleviation);
        }else {
           vo= new ResultVo(5000,"添加政策失败",false,null);
        }
        return vo;
    }

    /**
     * 通过id来加1操作
     */
    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        if (lastClickTime ==null){
            lastClickTime=new Date();

        }
        Integer affectedRows = alleviationMapper.click(id,lastClickTime);

        ResultVo vo;

        if (affectedRows>0){
            vo= new ResultVo(1212,"播放量加一",true,null);
        }else {
            vo= new ResultVo(1122,"播放量加一失败",false,null);

        }
        return vo;
    }

    /**
     * 修改操作
     */
    @Override
    public ResultVo update(Alleviation alleviation) {
        ResultVo vo;
        int affectedRows = alleviationMapper.updateByPrimaryKeySelective(alleviation);

        if (affectedRows>0){

            Alleviation alleviation1 = alleviationMapper.selectByPrimaryKey(alleviation.getId());

           vo= new ResultVo(12121,"修改成功",true,alleviation1);
        }else {
            vo= new ResultVo(5758,"修改失败",false,null);
        }
        return vo;
    }

    /**
     *删除操作
     */
    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;
        int affectedRows = alleviationMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            vo= new ResultVo(12121,"删除成功",true,null);
        }else {
            vo= new ResultVo(12121,"删除失败",false,null);
        }
        return vo;

    }
}
