package com.practice.microservice.limitsservice.controller;

import com.practice.microservice.limitsservice.LimitServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigController {

    @Autowired
    private LimitServiceConfig limitServiceConfig;

    @GetMapping("/retrieveConfig")
    public LimitServiceConfig getConfig() {
        return limitServiceConfig;
    }
}
