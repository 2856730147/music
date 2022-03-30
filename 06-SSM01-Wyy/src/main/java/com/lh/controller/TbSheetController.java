package com.lh.controller;


import com.lh.entity.TbMusic;
import com.lh.entity.TbSheet;
import com.lh.entity.TbSheetExample;
import com.lh.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
@Autowired
    private TbSheetService tbSheetService;
@RequestMapping("findAll")
    public List<TbSheet> findAll(){
       return tbSheetService.findAll();
    }
@RequestMapping("findSongsBySheet")
    public  List<TbMusic> findSongsBySheet(String sheetName) {

    return tbSheetService.findSongsBySheet(sheetName);
    }
@RequestMapping("insertSheet")
    public Map<String, Object> insertSheet(TbSheet tbSheet){
         int affectedRows=tbSheetService.insertSheet(tbSheet);


        HashMap<String, Object> map = new HashMap<>();

        if (affectedRows>0){
            map.put("code",200);
        }else {
            map.put("code",-1);
        }
        return map;
    }
}
