package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.VolunteerRecruitmentMapper;
import com.lh.entity.VolunteerRecruitment;
import com.lh.service.VolunteerService;
import com.lh.vo.DataVo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
//        返回给前端的信息
        ResultVo resultVo;
        //分页相关的信息
        DataVo<VolunteerRecruitment> dataVo;
        //结果中对应的数组
        List<VolunteerRecruitment> lists;

        if (id !=null){
           lists= new ArrayList<>();
           //查询
            VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);

            if (volunteerRecruitment ==null){
               dataVo= new DataVo<>(0L,lists,pageNum,pageSize);

               resultVo=new ResultVo(1212,"查询志愿者失败",false,dataVo);
            }else {
//                如果查询单个,数量就加一
                click(volunteerRecruitment.getId(), new Date());
                volunteerRecruitment.setClickNum(volunteerRecruitment.getClickNum()+1);
                lists.add(volunteerRecruitment);

                lists.add(volunteerRecruitment);
                dataVo= new DataVo<>(1L,lists,pageNum,pageSize);

                resultVo=new ResultVo(1212,"查询志愿者成功",true,dataVo);
            }
        }else {
            PageHelper.startPage(pageNum,pageSize);
            lists = volunteerRecruitmentMapper.selectByExample(null);
//            判断数据库是否为空
            if (lists.size()==0){
                resultVo=new ResultVo(1212,"没有志愿者信息",false,null);

            }else {
                PageInfo<VolunteerRecruitment> info= new PageInfo<>(lists);
               dataVo=  new DataVo<>(info.getTotal(),lists,pageNum,pageSize);
                resultVo=new ResultVo(1212,"查到了志愿者信息",true,dataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo add(VolunteerRecruitment volunteerRecruitment) {

        ResultVo vo;

        if (volunteerRecruitment.getLastClickTime()==null){
            volunteerRecruitment.setLastClickTime(new Date());
        }
//        新创建的应该浏览量为0
        volunteerRecruitment.setClickNum(0);
        volunteerRecruitment.setLastClickTime(null);
        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        if (affectedRows>0){
           vo= new ResultVo(121212,"添加成功",true,volunteerRecruitment);
        }else {
            vo= new ResultVo(121212,"添加失败",true,null);

        }

        return vo;
    }

    @Override
    public ResultVo update(VolunteerRecruitment volunteerRecruitment) {
        ResultVo vo;
        int affectedRows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);

        if (affectedRows>0){
            VolunteerRecruitment volunteerRecruitment1 = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

            vo= new ResultVo(121212,"修改成功",true,volunteerRecruitment1);
        }else {
            vo= new ResultVo(121212,"修改失败",true,null);

        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        if (affectedRows>0){
            vo= new ResultVo(121212,"删除成功",true,null);
        }else {
            vo= new ResultVo(121212,"删除失败",true,null);

        }
        return vo;

    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {

        if (lastClickTime == null){
            lastClickTime=new Date();
        }
        Integer click = volunteerRecruitmentMapper.click(id, lastClickTime);

        ResultVo vo;

        if (click>0){
          vo=  new ResultVo(1212,"数据加一",true,null);
        }else {
            vo=  new ResultVo(3434,"数据加一失败",false,null);

        }

        return vo;
    }


}
