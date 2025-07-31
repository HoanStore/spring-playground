package com.hoan.springplayground.validate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


/**
 * Bean Validation 기본 어노테이션 학습
 *
 *
 */
public class UserRequest {

    @NotAdmin
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    private String password;


    public @NotBlank(message = "이름은 필수입니다.") String getName() {
        return name;
    }

    public @Email(message = "이메일 형식이 아닙니다.") String getEmail() {
        return email;
    }

    public @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.") String getPassword() {
        return password;
    }
}
