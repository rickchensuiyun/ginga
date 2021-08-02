package com.mk.ginga.controller;

import com.mk.ginga.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public String register(){

        return "register";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(String account,String password){

        String msg = null;
        int result = userService.addUser(account,password);
        if(result > 0){
            msg = "注册成功";
        }else{
            msg = "注册失败";
        }
        return msg;
    }
}
