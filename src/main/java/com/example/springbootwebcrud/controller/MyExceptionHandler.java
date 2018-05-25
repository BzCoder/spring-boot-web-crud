package com.example.springbootwebcrud.controller;

import com.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BaoZhou
 * @date 2018/5/22
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //定义错误码，否则默认为200
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code", "user.notexist");
        map.put("message", "用户出错");
        //将自定义map放入Attribute中
        request.setAttribute("ext",map);
        //重定向到error页面
        return "forward:error";
    }
}
