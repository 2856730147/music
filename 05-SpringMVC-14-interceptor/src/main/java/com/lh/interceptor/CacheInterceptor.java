package com.lh.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lh.vo.ResultVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CacheInterceptor implements HandlerInterceptor {
    //在访问Controller之前先查询缓存，如果能查询到就直接返回了
    //查不着在执行控制器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("查询缓存...");

        HttpSession session = request.getSession(false);
            //如果session为null，说明是第一次访问，直接放行就行了
        if (session==null){
            return true;
        }
        Object foods = session.getAttribute("foods");
        //不是第一次访问，但是是第一次执行此控制器，
        if (foods==null){
            return true;
        }

        System.out.println("查到了缓存");

        ResultVO vo = new ResultVO(200, "查到了缓存", true, foods);
        //把缓存转换为json字符串
        String s = new ObjectMapper().writeValueAsString(vo);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(s);

        return false;
    }
    //将查询结果放到缓存中
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView !=null){
            Map<String, Object> model = modelAndView.getModel();

            Object foods = model.get("foods");

            System.out.println("放到缓存中");

            request.getSession(true).setAttribute("foods",foods);

            ResultVO vo = new ResultVO(200, "没有查到缓存", true, foods);
            //把缓存转换为json字符串
            String s = new ObjectMapper().writeValueAsString(vo);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(s);

        }
    }

}

