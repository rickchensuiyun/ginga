package com.mk.ginga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {

    @Autowired
    private RedisTemplate redisTemplate;

    public void test(){
//        redisTemplate.opsForValue().get()
    }
}
