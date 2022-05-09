package com.lh.service;

import com.lh.entity.TbNoteType;

import java.util.List;

public interface TypeService {
    List<TbNoteType> getTypes(Integer id);
}
