package com.lh.service.impl;

import com.lh.dao.TbNoteMapper;
import com.lh.service.NoteService;
import com.lh.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper noteMapper;
    @Override
    public NoteVo findById(Integer id) {
        return noteMapper.findById(id);
    }
}
