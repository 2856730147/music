package com.lh.service.impl;

import com.lh.dao.TbNoteTypeMapper;
import com.lh.entity.TbNoteType;
import com.lh.entity.TbNoteTypeExample;
import com.lh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;
    @Override
    public List<TbNoteType> getTypes(Integer id) {
        TbNoteTypeExample example = new TbNoteTypeExample();
        TbNoteTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return   tbNoteTypeMapper.selectByExample(example);

    }













}
