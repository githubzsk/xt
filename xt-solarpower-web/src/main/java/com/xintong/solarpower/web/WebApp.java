package com.xintong.solarpower.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName WebApp
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 13:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
    }
}
