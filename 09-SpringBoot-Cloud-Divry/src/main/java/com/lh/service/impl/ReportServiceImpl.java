package com.lh.service.impl;

import com.lh.dao.ReportDao;
import com.lh.entity.TbNote;
import com.lh.service.ReportService;
import com.lh.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public Map<String, Object> getNoteCountByMonth(Integer id) {
        Map<String, Object> data=null;

       List<NoteVo> notes=  reportDao.getNoteCountByMonth(id);

       if (notes != null && notes.size()>0){
           List<String> months = new ArrayList<>();
           List<Integer> noteCounts = new ArrayList<>();

           for (NoteVo note : notes) {
               months.add(note.getGroupName());
               noteCounts.add(note.getNoteCount());
           }
           data=new HashMap<>();
           data.put("monthArray",months);
           data.put("dataArray",noteCounts);


       }
        return data;
    }

    @Override
    public List<TbNote> getLocation(Integer id) {
        return reportDao.getLocation(id);
    }
}
