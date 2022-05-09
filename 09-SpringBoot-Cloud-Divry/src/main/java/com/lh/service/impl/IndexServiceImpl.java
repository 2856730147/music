package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.TbNoteMapper;
import com.lh.entity.TbNote;
import com.lh.service.IndexService;
import com.lh.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbNoteMapper tbNoteMapper;
    @Override
    public PageInfo<TbNote> page(Integer pageNum, Integer pageSize, Integer userId, Integer typeId, String title, String date) {
        if (title != null && !title.equals("")){
            title="%"+title+"%";
        }
        PageHelper.startPage(pageNum,pageSize);
       List<TbNote> tbNotes= tbNoteMapper.findNoteByUserId(userId,typeId,title,date);
        return new PageInfo<>(tbNotes);
    }

    @Override
    public List<NoteVo> findCountByDate(Integer userId) {
        return tbNoteMapper.findCountByDate(userId);
    }

    @Override
    public List<NoteVo> findCountByType(Integer userId) {
        return tbNoteMapper.findCountByType(userId);
    }
}
