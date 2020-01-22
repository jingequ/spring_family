package com.jin.vendor;

import com.jin.vendor.integration.VendorMsg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableBinding(VendorMsg.class)
public class VendorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendorApplication.class, args);
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> {
            builder.indentOutput(true);
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        };
    }
}
