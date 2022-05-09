package com.lh.dao;

import com.lh.entity.TbNote;
import com.lh.vo.NoteVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao {

    List<NoteVo> getNoteCountByMonth(Integer id);

    List<TbNote> getLocation(Integer id);
}
