package com.dyb.demo.monitor.service.impl;

import com.dyb.demo.monitor.entity.RedisInfo;
import com.dyb.demo.monitor.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private RedisConnection execute() {
        return (RedisConnection) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection;
            }
        });
    }

    @Override
    public List<RedisInfo> getRedisInfo() {
        try {
            List<RedisInfo> list = new ArrayList<>();
            Properties info = execute().info();
            for (String key : info.stringPropertyNames()) {
                RedisInfo redisInfo = new RedisInfo();
                redisInfo.setKey(key);
                redisInfo.setValue(info.getProperty(key));
                list.add(redisInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Map<String, Object> getRedisMemory() {
        return getData("memory", execute().info("memory").get("used_memory"));
    }

    @Override
    public Map<String, Object> getRedisDbSize() {
        return getData("dbsize", execute().dbSize());
    }

    private Map<String, Object> getData(String name, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("create_time", (new Date()).getTime());
        map.put(name, data);
        return map;
    }
}