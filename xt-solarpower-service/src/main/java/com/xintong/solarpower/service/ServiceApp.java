package com.xintong.solarpower.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ServiceApp
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 13:46
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class,args);
    }

    private void test(){
       // LoadBalance
    }
}
