package com.rest.client.config;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@EnableFeignClients(basePackages = {"com.rest.client.feign"})
public class FeignClientConfig {
}
