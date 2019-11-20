package com.consul.demo.commen.client;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/20 10:51
 * @Version 1.0
 */
public interface DemoRemoteService {
    @GetMapping("/demo/getData")
    public String getData();
}
