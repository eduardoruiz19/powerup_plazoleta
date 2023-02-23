package com.example.hexagonal.infrastructure.feignClient;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return  Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor securityFeignRequestInterceptor() {
        return new SecurityFeignRequestInterceptor();
    }
}
