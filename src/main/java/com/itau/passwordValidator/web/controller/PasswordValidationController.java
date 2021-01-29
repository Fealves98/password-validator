package com.itau.passwordValidator.web.controller;

import com.itau.passwordValidator.service.PasswordValidationService;
import com.itau.passwordValidator.web.request.PasswordRequest;
import com.itau.passwordValidator.web.response.PasswordResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/password-validation")
public class PasswordValidationController {

    private final PasswordValidationService service;

    @PostMapping
    @ResponseStatus(OK)
    @ApiOperation("Password validation")
    public PasswordResponse validate(@RequestBody PasswordRequest request) {
        log.info("m=validate, request={}", request);
        return this.service.checkPassword(request);
    }
}
