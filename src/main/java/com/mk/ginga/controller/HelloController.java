package com.mk.ginga.controller;

import com.mk.ginga.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String hello() {

        return "hello ginga!";
    }

    @RequestMapping("/show")
    public String show() {
        service.showAllData();
        return "show";
    }


}
