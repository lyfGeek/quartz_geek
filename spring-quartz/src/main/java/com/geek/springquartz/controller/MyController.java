package com.geek.springquartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author geek
 */
@Controller
public class MyController {

    @RequestMapping("login")// 用来处理前台的 login 请求。
    private @ResponseBody
    String hello(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {
        return "Hello " + username + ", Your password is: " + password;
    }

}
