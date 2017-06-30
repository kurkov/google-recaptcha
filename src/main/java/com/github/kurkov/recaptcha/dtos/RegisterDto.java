package com.github.kurkov.recaptcha.dtos;

import lombok.Data;

/**
 * @author Aleksey Kurkov. Created on 30.06.2017
 */
@Data
public class RegisterDto {
    private String email;
    private String password;
    private String recaptchaResponse;
}
