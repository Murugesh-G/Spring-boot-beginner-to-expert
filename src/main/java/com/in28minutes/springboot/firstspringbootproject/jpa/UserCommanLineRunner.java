package com.in28minutes.springboot.firstspringbootproject.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommanLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommanLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new User("Murugesh1", "admin"));
        repository.save(new User("Murugesh2", "user"));
        repository.save(new User("Murugesh3", "admin"));
        repository.save(new User("Murugesh4", "user"));

        for (User user : repository.findAll()) {
            log.info(user.toString());
        }


        log.info("Admin users are .......");
        log.info("-----------------------");
        for (User user : repository.findByRole("admin")) {
            log.info(user.toString());
        }
    }
}
