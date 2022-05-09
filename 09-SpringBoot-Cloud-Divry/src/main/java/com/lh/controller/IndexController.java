package com.lh.controller;


import com.github.pagehelper.PageInfo;
import com.lh.entity.TbNote;
import com.lh.entity.TbUser;
import com.lh.service.IndexService;
import com.lh.vo.NoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;


    @RequestMapping("page")
    public ModelAndView page(Integer id, String title, String date,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             ModelAndView mv, HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("user");

       PageInfo<TbNote> pageInfo=  indexService.page(pageNum,pageSize,user.getId(),id,title,date);


        mv.addObject("page",pageInfo);

        //获取日期分类
        List<NoteVo> dateInfo= indexService.findCountByDate(user.getId());
        session.setAttribute("dateInfo",dateInfo);
        //获取类别分类
        List<NoteVo> typeInfo= indexService.findCountByType(user.getId());
        session.setAttribute("typeInfo",typeInfo);


        mv.addObject("menu_page", "index");
        mv.addObject("changPage", "/note/list.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("searchTitle")
    public  ModelAndView searchTitle(String title,ModelAndView mv){
        mv.addObject("title",title);
        mv.setViewName("forward:/index/page");
        return  mv;
    }
    @GetMapping("searchDate")
    public  ModelAndView searchDate(String date,ModelAndView mv){
        mv.addObject("date",date);
        mv.setViewName("forward:/index/page");
        return  mv;
    }
    @GetMapping("searchType")
    public  ModelAndView searchType(Integer id,ModelAndView mv){
        mv.addObject("id",id);
        mv.setViewName("forward:/index/page");
        return  mv;
    }

















}
