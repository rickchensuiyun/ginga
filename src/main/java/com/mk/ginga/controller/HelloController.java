package com.mk.ginga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() {

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>hello");
        return "hello ginga!";
    }
}
