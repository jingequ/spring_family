package com.jin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 将spring session中的序列化器替换成json的
    @Bean
    public RedisSerializer springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }

    // 将spring cache中的序列化器替换成json的
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
    }

    @Bean
    public CacheManager simpleCacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    @Primary
    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory, RedisCacheConfiguration configuration){
        return RedisCacheManager.builder(factory).cacheDefaults(configuration).build();
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}
