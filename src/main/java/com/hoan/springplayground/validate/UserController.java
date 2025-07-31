package com.hoan.springplayground.validate;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated  // 클래스에 붙여도 되고, 메서드 인자에 @Valid 써도 됨
public class UserController {

    @PostMapping
    public String registerUser(@RequestBody @Valid UserRequest request) {
        return "가입 완료: " + request.getName();
    }
}
