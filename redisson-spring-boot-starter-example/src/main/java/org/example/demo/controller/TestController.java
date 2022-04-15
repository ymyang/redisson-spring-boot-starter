package org.example.demo.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/get")
    public String get() {
        return redissonClient.getSortedSet("key").last().toString();
    }

    @GetMapping("/set")
    public String set() {
        long time = new Date().getTime();
        redissonClient.getSortedSet("key").add(time);

        return time + "";
    }

}
