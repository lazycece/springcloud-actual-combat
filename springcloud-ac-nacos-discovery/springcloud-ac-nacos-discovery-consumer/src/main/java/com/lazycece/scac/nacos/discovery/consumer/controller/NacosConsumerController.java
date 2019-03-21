package com.lazycece.scac.nacos.discovery.consumer.controller;

import com.lazycece.scac.nacos.discovery.consumer.api.FeignConsumerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lazycece
 * @date 2019/03/19
 */
@RestController
@RequestMapping("/nacos/consumer")
public class NacosConsumerController {

    private LoadBalancerClient loadBalancerClient;
    private RestTemplate restTemplate;
    private FeignConsumerApi feignConsumerApi;

    @Autowired
    public NacosConsumerController(LoadBalancerClient loadBalancerClient, RestTemplate restTemplate,
                                   FeignConsumerApi feignConsumerApi) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
        this.feignConsumerApi = feignConsumerApi;
    }

    @GetMapping("/rest/{name}")
    public String rest(@PathVariable String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-service-provider");
        String url = String.format("http://%s:%s/nacos/provider/%s",
                serviceInstance.getHost(), serviceInstance.getPort(), name);
        System.out.println("url -> " + url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/feign/{name}")
    public String feign(@PathVariable String name) {
        return feignConsumerApi.provider(name);
    }


    @GetMapping("/ribbon/{name}")
    public String ribbon(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-service-provider/nacos/provider/" +
                name, String.class);
    }
}