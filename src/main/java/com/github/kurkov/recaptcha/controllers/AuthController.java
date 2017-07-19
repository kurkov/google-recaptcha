package com.github.kurkov.recaptcha.controllers;

import com.github.kurkov.recaptcha.dtos.ReCaptchaResponseDto;
import com.github.kurkov.recaptcha.dtos.RegisterDto;
import com.github.kurkov.recaptcha.services.ReCaptchaApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aleksey Kurkov. Created on 30.06.2017
 */
@Slf4j
@RestController
// @CrossOrigin(origins = "http://localhost:8080")
public class AuthController {
    @Autowired
    private ReCaptchaApiClient reCaptchaApiClient;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(RegisterDto registerDto) {
        log.info("{}", registerDto);

        ReCaptchaResponseDto reCaptchaResponse = reCaptchaApiClient.verify(registerDto.getRecaptchaResponse());
        log.info("{}", reCaptchaResponse);

        if (!reCaptchaResponse.isSuccess()) {
            throw new RuntimeException();
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
