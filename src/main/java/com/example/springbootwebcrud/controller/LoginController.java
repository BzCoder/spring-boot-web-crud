package com.example.springbootwebcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author BaoZhou
 * @date 2018/5/15
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (password.equals("123")) {
            map.put("msg", "123");
            session.setAttribute("username",username);
            return "redirect:/main";
        } else {
            map.put("msg", "用户名或密码错误");
            return "index";
        }
    }
}
