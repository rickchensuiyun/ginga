package com.mk.ginga.service.impl;

import com.mk.ginga.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private StringRedisTemplate redisString;

    @Override
    public void set(String key ,String val){
        redisString.opsForValue().set(key, val);
    }

}
