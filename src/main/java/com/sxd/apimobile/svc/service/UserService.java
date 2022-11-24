package com.sxd.apimobile.svc.service;

import com.sxd.apimobile.auth.utils.JWTUtil;
import com.sxd.apimobile.auth.utils.TokenParams;
import com.sxd.apimobile.svc.entity.User;
import com.sxd.apimobile.svc.mapper.UserMapper;
import com.sxd.apimobile.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public Map login(User user) {
        // 判断用户是否存在 生成Token 并存储到Redis
        List<User> res = userMapper.queryUserByUserAndPassword(user);
        Map<String, String> map = null;
        if(res.size()!=0) {
            map = new HashMap<>();
            String token;
            token = JWTUtil.createToken(res.get(0), TokenParams.TOKEN_TIME, TokenParams.TOKEN_KEY);
            map.put("token",token);
            map.put("username",res.get(0).getUserName());
            map.put("id",res.get(0).getId().toString());

            // 放入Redis
            // 注意 修改删除用户信息时需要删除Redis内Token
            String redisTokenKey = res.get(0).getUserName() + res.get(0).getId().toString() + TokenParams.REDIS_TOKEN_KEY_SPLICING;
            String md5 = MD5Util.generate(redisTokenKey);
            redisTemplate.opsForValue().set(md5,token,TokenParams.REDIS_TOKEN_TIMEOUT);
            return map;
        }
        return null;
    }
}
