package com.lh.service;

import com.github.pagehelper.PageInfo;
import com.lh.entity.TbNote;
import com.lh.vo.NoteVo;

import java.util.List;

public interface IndexService {
    PageInfo<TbNote> page(Integer pageNum, Integer pageSize, Integer userId, Integer typeId, String title, String data);

    List<NoteVo> findCountByDate(Integer id);

    List<NoteVo> findCountByType(Integer id);
}
