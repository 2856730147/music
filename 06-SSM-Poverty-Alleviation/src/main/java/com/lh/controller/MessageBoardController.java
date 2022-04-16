package com.lh.controller;

import com.lh.entity.MessageBoardWithBLOBs;
import com.lh.service.MessageBoardService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                         Long id){
        return messageBoardService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return  messageBoardService.add(messageBoardWithBLOBs);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return messageBoardService.update(messageBoardWithBLOBs);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return  messageBoardService.delete(id);
    }
}
