package com.trilogyed.tasker.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "adserver-service")
public interface AdserverFeignClient {
    @GetMapping("/ad")
    String getAd();
}
