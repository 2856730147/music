package com.lh.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//能够对@RestControlle进行增强
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(SingLetonException.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleSingleton(Exception e){
        HashMap<String, Object> map = new HashMap<>();

        map.put("code",HttpStatus.OK);
        map.put("massage","发生了单身狗异常");
        map.put("success",false);
        map.put("data",e.getMessage());

        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleSystem(Exception e){
        HashMap<String, Object> map = new HashMap<>();

        map.put("code",HttpStatus.BAD_REQUEST);
        map.put("massage","发生了系统异常");
        map.put("success",false);
        map.put("data",null);

return map;
    }
}
