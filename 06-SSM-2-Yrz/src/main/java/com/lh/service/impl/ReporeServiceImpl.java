package com.lh.service.impl;

import com.lh.dao.TbNoteMapper;
import com.lh.entity.TbNote;
import com.lh.entity.TbNoteExample;
import com.lh.service.ReporeService;
import com.lh.vo.ResultInfo;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporeServiceImpl implements ReporeService {

    @Autowired
    private TbNoteMapper reporeMapper;


    @Override
    public ModelAndView findAll(TbNoteExample tbNoteExample, HttpServletRequest request) {
        List<TbNote> tbNotes = reporeMapper.selectByExampleWithBLOBs(tbNoteExample);
        request.setAttribute("menu_page",tbNotes);
        request.setAttribute("changePage","/report/info.jsp");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/index.jsp");
        return modelAndView;
    }

    @Override
    public ResultInfo findByAll(TbNoteExample tbNoteExample) {
        List<TbNote> tbNotes = reporeMapper.selectByExampleWithBLOBs(tbNoteExample);

        Map map = new HashMap<>();
            map.put("monthArray",tbNotes);
            map.put("dataArray",tbNotes);

        ResultInfo info = new ResultInfo();
            info.setCode(200);
            info.setMessage("查询成功");
            info.setData(map);
        return info;
    }
}
