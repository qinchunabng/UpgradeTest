package com.citic.asp.upgrade.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * description
 *
 * @author DELL
 * @date 2021/03/26 11:04.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.citic.asp"})
public class UpgradeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpgradeTestApplication.class, args);
    }
}
