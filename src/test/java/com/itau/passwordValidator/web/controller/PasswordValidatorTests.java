package com.itau.passwordValidator.web.controller;

import com.itau.passwordValidator.AbstractTest;
import com.itau.passwordValidator.config.template.PasswordValidatorRequestTemplate;
import com.itau.passwordValidator.web.request.PasswordRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.junit.jupiter.api.Test;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PasswordValidatorTests extends AbstractTest {

    @Test
    public void validateSucess() throws Exception {
        final var template = PasswordValidatorRequestTemplate.PASSWORD_VALID;
        final PasswordRequest passwordRequest = from(PasswordRequest.class).gimme(template);
        super.mockMvc.perform(post("/password-validation")
                .contentType(APPLICATION_JSON_VALUE)
                .content(super.mapper.writeValueAsString(passwordRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true))
                .andDo(print());
    }

    @Test
    public void validateFailure() throws Exception {
        final var template = PasswordValidatorRequestTemplate.PASSWORD_INVALID;
        final PasswordRequest passwordRequest = from(PasswordRequest.class).gimme(template);
        super.mockMvc.perform(post("/password-validation")
                .contentType(APPLICATION_JSON_VALUE)
                .content(super.mapper.writeValueAsString(passwordRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false))
                .andDo(print());

    }
}