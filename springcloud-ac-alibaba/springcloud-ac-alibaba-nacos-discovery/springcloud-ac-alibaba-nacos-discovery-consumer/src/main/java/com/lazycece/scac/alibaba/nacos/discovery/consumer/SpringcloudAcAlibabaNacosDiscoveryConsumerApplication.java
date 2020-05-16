package com.lazycece.scac.alibaba.nacos.discovery.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringcloudAcAlibabaNacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAcAlibabaNacosDiscoveryConsumerApplication.class, args);
    }

}
