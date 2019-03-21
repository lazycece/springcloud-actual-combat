package com.lazycece.scac.nacos.discovery.consumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lazycece
 * @date 2019/03/19
 */
@FeignClient("nacos-service-provider")
@RequestMapping("/nacos")
public interface FeignConsumerApi {

    @GetMapping("/provider/{name}")
    String provider(@PathVariable String name);
}
