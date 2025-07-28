package com.hoan.springplayground.simplespring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// MessageService.java
@Component
@Scope("singleton") // prototype으로도 변경해보자
public class MessageService {

    @PostConstruct
    public void init() {
        System.out.println("MessageService: 빈 초기화됨");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MessageService: 빈 소멸됨");
    }

    public String getMessage() {
        return "Hello from Spring Bean!";
    }
}

