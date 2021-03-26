package com.citic.asp.upgrade.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author DELL
 * @date 2021/03/26 11:22.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/time")
    public Long currentTime(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("test", "aaaa");
        return System.currentTimeMillis();
    }

    @GetMapping("/getHash/{field}")
    public String getHash(@PathVariable String field){
        return (String) redisTemplate.opsForHash().get("test_hash", field);
    }

    @GetMapping("/setHash/{field}/{value}")
    public String setHash(@PathVariable String field, @PathVariable String value){
        Map<String, String> map = new HashMap<>();
        map.put(field, value);
        redisTemplate.opsForHash().putAll("test_hash", map);
        return "success";
    }
}
