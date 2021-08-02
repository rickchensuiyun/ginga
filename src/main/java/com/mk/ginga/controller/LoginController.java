package com.mk.ginga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login(Model model){

        model.addAttribute("name","ginga");
        return "login";
    }

    @RequestMapping("/doLogin")
    public void doLogin(String account,String password){

        log.debug(">>>>>>>>>>>>>>>>>account:"+account);
        log.debug(">>>>>>>>>>>>>>>>>password:"+password);
    }
}
