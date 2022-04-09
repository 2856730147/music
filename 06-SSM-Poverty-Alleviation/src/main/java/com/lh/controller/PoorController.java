package com.lh.controller;

import com.lh.entity.Poor;
import com.lh.entity.PoorWithBLOBs;
import com.lh.service.PoorService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("list")
    public ResultVo getlist(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Long id){
        return poorService.list(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.add(poorWithBLOBs);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.update(poorWithBLOBs);
    }
    @GetMapping("delete")
    public ResultVo delete(Long id ){
        return poorService.delete(id);
    }
    @PostMapping("click")
    public ResultVo click(Poor poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
