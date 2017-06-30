package com.github.kurkov.recaptcha.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Aleksey Kurkov. Created on 30.06.2017
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReCaptchaResponseDto {
    private boolean success;
    @JsonProperty("challenge_ts")
    private String challengeTs;
    private String hostname;
    @JsonProperty("error-codes")
    private List<String> errorCodes;
}
