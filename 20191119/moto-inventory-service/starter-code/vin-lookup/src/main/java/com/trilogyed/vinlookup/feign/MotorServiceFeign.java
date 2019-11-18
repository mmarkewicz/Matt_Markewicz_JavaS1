package com.trilogyed.vinlookup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "moto-inventory-service")
public interface MotorServiceFeign {
    @GetMapping("/motorcycles/{vin}")
    String getMotorcycleByVin(@PathVariable("vin") String vin);
}
