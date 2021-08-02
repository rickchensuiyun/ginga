package com.mk.ginga.service.impl;

import com.mk.ginga.constant.UserConstant;
import com.mk.ginga.service.UserService;
import com.mk.ginga.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserUtils userUtils;

    @Override
    public int addUser(String account, String password) {

        long userId = userUtils.getUserKey();
        long test = redisTemplate.opsForSet().add("accountset", account);

        if(test > 0){
            //将用户对象作为hash存入
            redisTemplate.opsForHash().put(UserConstant.KEY_USER + userId, "account", account);
            redisTemplate.opsForHash().put(UserConstant.KEY_USER + userId, "password", userUtils.md5DigestTwo(password));
            return 1;
        }
        return -1;

    }
}
