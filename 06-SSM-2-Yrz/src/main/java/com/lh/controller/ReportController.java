package com.lh.controller;

import com.lh.entity.TbNote;
import com.lh.entity.TbNoteExample;
import com.lh.service.ReporeService;
import com.lh.vo.ResultInfo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReporeService reporeService;

    @GetMapping("info")
    public ModelAndView info(TbNoteExample tbNoteExample, HttpServletRequest request){
       return reporeService.findAll(tbNoteExample,request);
    }
    @GetMapping("month")
    public ResultInfo month(TbNoteExample tbNoteExample){
        return reporeService.findByAll(tbNoteExample);
    }
    @GetMapping("location")
    public ResultInfo location(TbNoteExample tbNoteExample){
        return reporeService.findByAll(tbNoteExample);
    }
}
