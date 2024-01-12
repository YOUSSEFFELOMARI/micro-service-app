package com.elomari.customerservice.controller;

import com.elomari.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.a}")
    private int a;
    @Value("${global.params.b}")
    private int b;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;

    private final GlobalConfig globalConfig;

    public ConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig=globalConfig;
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("a",a,"b",b,"x",x,"y",y);
    }
}
