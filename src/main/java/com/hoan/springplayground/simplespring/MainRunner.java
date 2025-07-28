package com.hoan.springplayground.simplespring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// MainRunner.java
@SpringBootApplication
public class MainRunner implements ApplicationRunner {

    private final MessageService messageService;

    public MainRunner(MessageService messageService) {
        this.messageService = messageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainRunner.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(messageService.getMessage());
    }

}

