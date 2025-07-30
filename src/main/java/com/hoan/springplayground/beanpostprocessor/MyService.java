package com.hoan.springplayground.beanpostprocessor;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @PostConstruct
    public void init() {
        doWork(); // 여기서 호출
    }

    public void doWork() {
        System.out.println("MyService 작업 실행 중...");
    }
}
