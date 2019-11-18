package com.trilogyed.taskerservice.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "adserver-service")
public interface AdserverFeignClient {
    @GetMapping("/ad")
    String getAdFromService();
}
