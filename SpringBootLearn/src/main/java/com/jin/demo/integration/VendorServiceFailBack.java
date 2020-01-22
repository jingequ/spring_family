package com.jin.demo.integration;

import org.springframework.stereotype.Component;

@Component
public class VendorServiceFailBack implements VendorService {
    @Override
    public String get(Long id) {
        return "chu cuo le !";
    }
}
