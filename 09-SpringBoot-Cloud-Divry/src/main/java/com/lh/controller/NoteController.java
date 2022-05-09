package com.lh.controller;

import com.lh.entity.TbNote;
import com.lh.entity.TbNoteType;
import com.lh.entity.TbUser;
import com.lh.service.NoteService;
import com.lh.service.TypeService;
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
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private TypeService typeService;


    @GetMapping("detail")
    public ModelAndView detail(@RequestParam Integer id, ModelAndView mv) {
        NoteVo noteVo = noteService.findById(id);

        //高亮显示
        mv.addObject("menu_page", "note");
        mv.addObject("note", null);
        //包含的页面
        mv.addObject("changePage", "/note/detail.jsp");


        mv.setViewName("forward:/index.jsp");
        return mv;
    }

    @GetMapping("view")
    public ModelAndView view(Integer noteId, HttpSession session, ModelAndView mv) {
        //判断id是否传递过来了
        //就是从添加页面进行去的
        if (noteId != null) {
            NoteVo note = noteService.findById(noteId);

            mv.addObject("noteInfo", note);
        }
            //id存在说明我们要根据id去做修改操作
            TbUser user = (TbUser) session.getAttribute("user");
            //根据用户id获取用户所有的日记分类
            List<TbNoteType> types = typeService.getTypes(user.getId());
            mv.addObject("typeList", types);
            mv.addObject("changePage", "/note/view.jsp");
            mv.addObject("menu_page", "note");
            return mv;

    }
}