package com.example.springbootwebcrud.controller;

import com.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author BaoZhou
 * @date 2018/5/22
 */
@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user)
    {
        if (user.equals("aaa"))
        {
            throw  new UserNotExistException();
        }
        return "Hello";
    }
}
