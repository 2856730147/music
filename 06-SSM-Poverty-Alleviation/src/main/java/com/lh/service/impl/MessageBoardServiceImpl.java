package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.MessageBoardMapper;
import com.lh.entity.MessageBoardWithBLOBs;
import com.lh.service.MessageBoardService;
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
public class MessageBoardServiceImpl implements MessageBoardService {

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        //传个前端的信息
        ResultVo resultVo;
        //分页相关的信息
        DataVo<MessageBoardWithBLOBs> dataVo;
        //结果中对应的数组
        List<MessageBoardWithBLOBs> lists;

        if (id != null){
           lists= new ArrayList<>();
            MessageBoardWithBLOBs messageBoardWithBLOBs = messageBoardMapper.selectByPrimaryKey(id);

            if (id == null){
                dataVo= new DataVo<>(0L,lists,pageNum,pageSize);
                resultVo= new ResultVo(1212,"查询失败",false,dataVo);
            }else {

                lists.add(messageBoardWithBLOBs);

                dataVo= new DataVo<>(0L,lists,pageNum,pageSize);
                resultVo= new ResultVo(1212,"查询成功",true,dataVo);
            }
        }else {
            PageHelper.startPage(pageNum,pageSize);

            lists= messageBoardMapper.selectByExampleWithBLOBs(null);

            if (lists.size() == 0){
                dataVo = new DataVo<>(0L, lists, pageNum, pageSize);
                resultVo = new ResultVo(2342, "没有留言板", false, dataVo);
            } else {
                PageInfo<MessageBoardWithBLOBs> info = new PageInfo<>(lists);
                dataVo = new DataVo<>(info.getTotal(), lists, pageNum, pageSize);
                resultVo = new ResultVo(2342, "查到了留言板", true, dataVo);
            }
        }

        return resultVo;
    }

    @Override
    public ResultVo add(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        ResultVo vo;

        int insert = messageBoardMapper.insert(messageBoardWithBLOBs);

        if (insert>0){

            vo = new ResultVo(2342, "添加留言板成功", true, null);
        }else {
            vo = new ResultVo(2342, "添加留言板成功失败", false, null);

        }

        return vo;
    }

    @Override
    public ResultVo update(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        ResultVo vo;

        int affectedRows = messageBoardMapper.updateByPrimaryKeyWithBLOBs(messageBoardWithBLOBs);
    if (affectedRows>0){
        MessageBoardWithBLOBs messageBoardWithBLOBs1 = messageBoardMapper.selectByPrimaryKey(messageBoardWithBLOBs.getId());

        vo = new ResultVo(2342, "修改留言板成功", true, messageBoardWithBLOBs1);
    }else {
        vo = new ResultVo(2342, "修改留言板成功失败", false, null);

    }
        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;

        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            vo = new ResultVo(2342, "删除成功", true, null);
        }else {
            vo = new ResultVo(2342, "删除失败", false, null);

        }
        return vo;
    }
}
