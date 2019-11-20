package com.consul.demo.controllers;

import com.consul.demo.clients.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/20 10:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class TestController {
    @Autowired
    private DemoClient demoClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getResult")
    public String getResult() {
        return demoClient.getData();
    }

    @GetMapping("/getApi")
    public List<URI> getApi(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-provider");
        return instances.parallelStream().map(ServiceInstance::getUri).collect(Collectors.toList());
    }

    @GetMapping("/getDemo")
    public String getDemo(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-provider");
        ServiceInstance serviceInstance = instances.get(0);
       String url =  "http://"+serviceInstance.getServiceId()+":"+serviceInstance.getPort()+"/demo/getData";
        return restTemplate.getForObject(url,String.class);
    }
}
