package com.lazycece.scac.alibaba.nacos.discovery.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/03/19
 */
@RestController
@RequestMapping("/nacos")
public class NacosProviderController {
    @GetMapping("/provider/{name}")
    public String provider(@PathVariable String name) {
        return "hello," + name;
    }
}
