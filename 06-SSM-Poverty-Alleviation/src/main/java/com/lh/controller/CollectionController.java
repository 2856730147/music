package com.lh.controller;

import com.lh.entity.Collection;
import com.lh.service.CollectionService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
@GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                         Long id){
        return  collectionService.list(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Collection collection){
        return collectionService.add(collection);
    }
    @GetMapping("delete")
    public ResultVo delete(Long id){
        return collectionService.delete(id);
    }
}
