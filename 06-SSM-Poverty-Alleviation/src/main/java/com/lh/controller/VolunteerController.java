package com.lh.controller;

import com.lh.entity.VolunteerRecruitment;
import com.lh.service.VolunteerService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @RequestMapping("getlist")
    public ResultVo GetList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            Long id){
        return  volunteerService.getList(pageNum,pageSize,id);

    }
    @PostMapping("click")
    public ResultVo click(VolunteerRecruitment volunteerRecruitment){
        return  volunteerService.click(volunteerRecruitment.getId(),volunteerRecruitment.getLastClickTime());
    }
    @PostMapping("add")
    public ResultVo add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.add(volunteerRecruitment);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.update(volunteerRecruitment);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return volunteerService.delete(id);
    }
}
