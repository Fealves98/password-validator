package com.itau.passwordValidator.web.request;

import lombok.Data;
import org.apache.catalina.Session;

@Data
public class PasswordRequest {

    private String password;

}
