package com.jin.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("com.jin")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonStr {
    private String name;
    private String sex;
}
