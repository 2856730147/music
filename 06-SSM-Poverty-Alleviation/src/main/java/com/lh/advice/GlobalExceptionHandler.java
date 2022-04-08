package com.lh.advice;

import com.lh.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//用于对Controller进行增强
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DuplicateKeyException.class )
    @ResponseBody
     public ResultVo exception(Exception e){
         return new ResultVo(4500,"用户名的能重复,哪里凉快待哪去",false,e.getMessage());
     }
    @ExceptionHandler(value = DuplicateKeyException.class )
    @ResponseBody
    public ResultVo excRuntime(RuntimeException e){
        return new ResultVo(5000,"系统操作异常，请稍后重试",false,e.getMessage());
    }

}
