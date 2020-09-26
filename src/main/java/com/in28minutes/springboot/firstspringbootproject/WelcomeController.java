package com.in28minutes.springboot.firstspringbootproject;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.firstspringbootproject.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @Autowired
    private BasicConfiguration basicConfiguration;

    @RequestMapping("/welcome")
    public String welcome() {
        return welcomeService.retrieveWelcomeMessage();
    }

    @RequestMapping("/dynamic-configuration")
    public Map dynamicCOnfiguration() {
        Map map = new HashMap();
        map.put("message", basicConfiguration.getMessage());
        map.put("number", basicConfiguration.getNumber());
        map.put("value", basicConfiguration.isValue());
        return map;
    }
}

@Component
class WelcomeService {

    @Value("${welcome.message}")
    private String message;

    public String retrieveWelcomeMessage() {
        return message;
    }
}