package com.jin.demo.integration;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "vendor")
@Component
public interface VendorService {

    @GetMapping(value = "/vendor/get", params = "id")
    @CircuitBreaker(name = "order")
    String get(@RequestParam(value = "id") Long id);
}
