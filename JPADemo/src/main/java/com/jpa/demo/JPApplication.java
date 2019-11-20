package com.jpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 15:04
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
//@EntityScan(basePackages = {"com.jpa.demo.model"})
//@EnableJpaRepositories("com.jpa.demo.repositories")
public class JPApplication {

    public static void main(String[] args) {
//        org.hibernate.dialect.PostgreSQLDialect
        SpringApplication.run(JPApplication.class,args);
    }
}
