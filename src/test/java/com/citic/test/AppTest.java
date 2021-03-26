package com.citic.test;

import com.citic.asp.upgrade.test.UpgradeTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author DELL
 * @date 2021/03/26 15:52.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UpgradeTestApplication.class)
public class AppTest {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Test
    public void testRedis(){
        Map<String, String> map = new HashMap();
        map.put("testField", "testValue");
        redisTemplate.opsForHash().putAll("test_hash", map);

        String fieldValue = (String) redisTemplate.opsForHash().get("test_hash", "testField");
        System.out.println(fieldValue);
    }
}
