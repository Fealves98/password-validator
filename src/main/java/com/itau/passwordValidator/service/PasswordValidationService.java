package com.itau.passwordValidator.service;

import com.itau.passwordValidator.web.request.PasswordRequest;
import com.itau.passwordValidator.web.response.PasswordResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@Slf4j
public class PasswordValidationService {

    public PasswordResponse checkPassword(PasswordRequest request) {
        log.info("m=checkPassword, request={}", request);
        final var check = this.validate(request);
        var response = new PasswordResponse(check);
        return response;
    }

    public boolean validate(PasswordRequest request) {
        //checks if the password matches the standards
        log.info("m=validate, request={}", request);
        var pattern = "^(?=.*[0-9])(?=.*[a-z]{2})(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{8,}$";
        boolean matches = Pattern.matches(pattern, request.getPassword());

        if (matches == false)
            return false;

        for (int i = 0; i < request.getPassword().length(); i++) {
            char ch = request.getPassword().charAt(i);
            if (Character.isLetter(ch) && request.getPassword().indexOf(ch, i + 1) != -1) {
                return false;
            }
        }
        return true;
    }
}
