package com.mk.ginga.service.impl;

import com.mk.ginga.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HelloServiceImpl implements HelloService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate redisString;

    @Override
    public void set(String key, String val) {
        redisString.opsForValue().set(key, val);
    }

    public void showAllData() {
        Set<String> set = redisString.keys("*");
        if (set != null && set.size() > 0) {
            log.debug(">>>>>>>>>>>>>>>>>>>redis中键的数量：" + set.size());
            for (String o : set) {
                log.debug(">>>>>>>>>>>>>>>>>>" + o);
            }
        }
    }

}
