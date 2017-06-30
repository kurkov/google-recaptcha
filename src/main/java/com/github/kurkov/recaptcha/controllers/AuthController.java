package com.github.kurkov.recaptcha.controllers;

import com.github.kurkov.recaptcha.dto.RegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksey Kurkov. Created on 30.06.2017
 */
@Slf4j
@RestController
public class AuthController {
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(RegisterDto registerDto) {
        log.info("{}", registerDto);
    }
}
