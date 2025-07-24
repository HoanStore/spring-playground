package com.hoan.springplayground.circularreference;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Lazy가 없으면 아래와 같은 에러 메시지가 뜸.
 *
 * ┌─────┐
 * |  a defined in file [/Users/keunwan/hoan_workspace/spring-playground/build/classes/java/main/com/hoan/springplayground/circularreference/A.class]
 * ↑     ↓
 * |  b defined in file [/Users/keunwan/hoan_workspace/spring-playground/build/classes/java/main/com/hoan/springplayground/circularreference/B.class]
 * └─────┘
 *
 * [순환 참조 해결책]
 * 1. 생성자 주입 x, Setter 주입으로 변경
 * 2. 지연주입 @Lazy 사용
 * 3. 설계 변경 (진짜 해결책) - 두 객체가 이 정도로 강하게 엮여 있다면, 중재자 역할의 서비스로 분리하는게 이상적.
 *
 */

@Component
public class A {
    private final B b;

    public A(@Lazy B b) {
        this.b = b;
    }
}
