package com.springboot.sso.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.springboot.")
public class SpringBootSSO {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSSO.class, args);
    }

}