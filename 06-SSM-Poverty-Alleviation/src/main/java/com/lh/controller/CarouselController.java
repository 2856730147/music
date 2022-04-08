package com.lh.controller;

import com.lh.entity.Carousel;
import com.lh.service.CarouselService;
import com.lh.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("getlist")
    public ResultVo getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            Integer id){

    return carouselService.getlist(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody Carousel carousel){
       return carouselService.add(carousel);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Integer id) {
        return carouselService.delete(id);
    }
}
