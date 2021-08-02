package com.mk.ginga.util;

import com.mk.ginga.constant.UserConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public long getUserKey(){
        long id = 0;
        String userIdNum = redisTemplate.opsForValue().get(UserConstant.KEY_USER_ID_NUM);
        if(StringUtils.isEmpty(userIdNum)){
            id = 1;
        }else{
            id = redisTemplate.opsForValue().increment(UserConstant.KEY_USER_ID_NUM);
        }
        redisTemplate.opsForValue().set(UserConstant.KEY_USER_ID_NUM,id+"");
        return id;
    }

    public String md5DigestTwo(String str){

        String s = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        return  DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
    }


}
