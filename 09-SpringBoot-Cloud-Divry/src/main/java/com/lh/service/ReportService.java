package com.lh.service;

import com.lh.entity.TbNote;

import java.util.List;
import java.util.Map;

public interface ReportService {

    Map<String, Object> getNoteCountByMonth(Integer id);


    List<TbNote> getLocation(Integer id);
}
