package com.codeworld.fc.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CodeworldCloudMenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeworldCloudMenuApplication.class, args);
    }

}
