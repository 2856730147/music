package com.lh.controller;

import com.lh.entity.TbNote;
import com.lh.entity.TbUser;
import com.lh.service.ReportService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.rmi.server.RemoteServer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("info")
    public  ModelAndView toInfo(ModelAndView mv){
        mv.addObject("menu_page","report");
        mv.addObject("changePage","/report/info.jsp");
        mv.setViewName("forward:/index.jsp");
    return mv;
    }
    @GetMapping("month")
    @ResponseBody
    public ResultVo getMonth(HttpSession session){
        TbUser user = (TbUser) session.getAttribute("user");

          Map<String, Object> data= reportService.getNoteCountByMonth(user.getId());

        ResultVo Vo = new ResultVo();
        if (data != null){
            Vo.setData(data);
            Vo.setCode(1);
        }
        return Vo;
    }
    @GetMapping("location")
    @ResponseBody
    public  ResultVo getLocation(HttpSession session){
        TbUser  user = (TbUser) session.getAttribute("user");

       List<TbNote> notes= reportService.getLocation(user.getId());
        ResultVo resultVo = new ResultVo();
        if (notes != null && notes.size()>0){
            resultVo.setCode(1);
            resultVo.setSuccess(true);
            resultVo.setData(notes);
        }
        return resultVo;
    }










}
