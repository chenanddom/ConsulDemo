package com.consul.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/19 11:38
 * @Version 1.0
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulApplication {

    @Autowired
    private DiscoveryClient discoveryClient;



    @GetMapping("/getApi")
    public List<URI> getApi(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-provider");
        return instances.parallelStream().map(ServiceInstance::getUri).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class,args);
    }
}
