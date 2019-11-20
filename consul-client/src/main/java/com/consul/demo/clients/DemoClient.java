package com.consul.demo.clients;

import com.consul.demo.commen.client.DemoRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @Description:一句话的功能说明
 * @Author: chendom
 * @Date: 2019/11/20 10:34
 * @Version 1.0
 */
@FeignClient(name = "consul-provider",fallbackFactory = DemoClient.DemoClientFallback.class)
public interface DemoClient extends DemoRemoteService {
    @Component
    public class DemoClientFallback implements FallbackFactory<DemoClient>{

        @Override
        public DemoClient create(Throwable throwable) {
            return new DemoClient() {
                @Override
                public String getData() {
                    return "fall back result";
                }
            };
        }
    }
}
