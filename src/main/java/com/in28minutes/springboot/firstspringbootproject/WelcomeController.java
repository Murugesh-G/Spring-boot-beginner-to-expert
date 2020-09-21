package com.in28minutes.springboot.firstspringbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @RequestMapping("/welcome")
    public String welcome() {
        return welcomeService.retrieveWelcomeMessage();
    }
}

@Component
class WelcomeService {
    public String retrieveWelcomeMessage() {
        return "Good Morning";
    }
}