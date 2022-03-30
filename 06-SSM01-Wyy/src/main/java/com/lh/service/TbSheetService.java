package com.lh.service;

import com.lh.entity.TbMusic;
import com.lh.entity.TbSheet;

import java.util.List;

public interface TbSheetService {

    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);

    int insertSheet(TbSheet tbSheet);
}
