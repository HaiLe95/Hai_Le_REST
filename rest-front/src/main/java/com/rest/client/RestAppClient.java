package com.rest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rest.client")
public class RestAppClient {
    public static void main(String[] args) {
        SpringApplication.run(RestAppClient.class, args);
    }
}
