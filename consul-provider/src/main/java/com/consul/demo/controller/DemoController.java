package com.consul.demo.controller;

import com.consul.demo.commen.client.DemoRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/20 10:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController implements DemoRemoteService {

@Override
@GetMapping("/getData")
public String getData(){
    return "hello world";
}

}
