package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.PoorMapper;
import com.lh.entity.PoorWithBLOBs;
import com.lh.service.PoorService;
import com.lh.vo.DataVo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 的增、删、改、查
 */
@Service
public class PoorServiceImpl implements PoorService {

    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        //发给前端的信息
        ResultVo resultVo;
        //分页相关的信息;
        DataVo<PoorWithBLOBs> dataVo;
        //结果data的集合
        List<PoorWithBLOBs> lists;

        if (id != null) {
            lists = new ArrayList<>();
            //查询
            PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);

            if (id == null) {
                dataVo = new DataVo<>(0L, lists, pageNum, pageSize);
                resultVo = new ResultVo(2342, "没有查到贫困户", false, dataVo);
            } else {
              // 如果是查询单个,那么点击量加1
                click(poorWithBLOBs.getId(),null);

                poorWithBLOBs.setClickNum(poorWithBLOBs.getClickNum()+1);

                lists.add(poorWithBLOBs);



                dataVo = new DataVo<>(1L, lists, pageNum, pageSize);

                resultVo= new ResultVo(1212,"查询成功",true,dataVo);
            }
        } else {
//            开启分页
            PageHelper.startPage(pageNum, pageSize);

            lists = poorMapper.selectByExampleWithBLOBs(null);
//            如果查询数据库是空的
            if (lists.size() == 0) {
                dataVo = new DataVo<>(0L, lists, pageNum, pageSize);
                resultVo = new ResultVo(2342, "没有贫困户", false, dataVo);
            } else {
//                那到数据总和
                PageInfo<PoorWithBLOBs> poorPageInfo = new PageInfo<>(lists);
//                封装到数据中
                dataVo = new DataVo<>(poorPageInfo.getTotal(), lists, pageNum, pageSize);
                resultVo = new ResultVo(2342, "查到贫困户", true, dataVo);
            }
        }

        return resultVo;
    }

    @Override
    public ResultVo add(PoorWithBLOBs poorWithBLOBs) {
        ResultVo vo;
//        判断是否有日期
        if (poorWithBLOBs.getCreateTime() == null) {
            poorWithBLOBs.setCreateTime(new Date());
        }
        int affectedRows = poorMapper.insert(poorWithBLOBs);

        if (affectedRows > 0) {
            vo = new ResultVo(1000, "添加用户成功", true, poorWithBLOBs);
        } else {
            vo = new ResultVo(5000, "添加用户失败", false, null);

        }
        return vo;
    }

    @Override
    public ResultVo update(PoorWithBLOBs poorWithBLOBs) {
        ResultVo vo;
        int affectedRows = poorMapper.updateByPrimaryKeyWithBLOBs(poorWithBLOBs);

        if (affectedRows > 0) {

            PoorWithBLOBs poorWithBLOBs1 = poorMapper.selectByPrimaryKey(poorWithBLOBs.getId());
            vo = new ResultVo(2312, "修改成功", true, poorWithBLOBs1);
        } else {
            vo = new ResultVo(2312, "修改失败", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;
        int affectedRows = poorMapper.deleteByPrimaryKey(id);
        if (affectedRows > 0) {
            vo = new ResultVo(2312, "修改成功", true, null);
        } else {
            vo = new ResultVo(2312, "修改成功", false, null);
        }
        return vo;
    }

    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        ResultVo vo;
        if (lastClickTime == null) {
            lastClickTime = new Date();
        }

        Integer click = poorMapper.click(id, lastClickTime);

        if (click > 0) {
            vo = new ResultVo(2312, "数据加一", true, null);
        } else {
            vo = new ResultVo(2312, "数据加一失败", false, null);
        }
        return vo;
    }
}
