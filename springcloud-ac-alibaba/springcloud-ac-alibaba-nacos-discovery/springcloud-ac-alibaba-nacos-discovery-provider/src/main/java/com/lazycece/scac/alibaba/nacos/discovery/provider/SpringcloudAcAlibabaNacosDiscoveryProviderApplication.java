package com.lazycece.scac.alibaba.nacos.discovery.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudAcAlibabaNacosDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAcAlibabaNacosDiscoveryProviderApplication.class, args);
    }

}
