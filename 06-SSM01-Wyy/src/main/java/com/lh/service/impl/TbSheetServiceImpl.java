package com.lh.service.impl;

import com.lh.dao.TbSheetMapper;
import com.lh.entity.TbMusic;
import com.lh.entity.TbSheet;
import com.lh.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;
//查询全部歌单
    @Override
    public List<TbSheet> findAll() {

        return  tbSheetMapper.selectByExample(null);
    }
    //添加歌单
    @Override
    public int insertSheet(TbSheet tbSheet) {
        return tbSheetMapper.insertSelective(tbSheet);
    }
    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {

        return tbSheetMapper.findSongsBySheet(sheetName);
    }



}
