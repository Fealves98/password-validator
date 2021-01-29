package com.itau.passwordValidator.config.template;

import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.itau.passwordValidator.web.request.PasswordRequest;

import static br.com.six2six.fixturefactory.Fixture.of;

public class PasswordValidatorRequestTemplate implements TemplateLoader {

    public static final String PASSWORD_INVALID = "PASSWORD_AAAbbbCc";

    public static final String PASSWORD_VALID = "PASSWORD_AbTp9!fok";

    @Override
    public void load() {
        of(PasswordRequest.class)
                .addTemplate(PASSWORD_INVALID, new Rule() {{
                    add("password", "AAAbbbCc");
                }})
                .addTemplate(PASSWORD_VALID, new Rule() {{
                    add("password", "AbTp9!fok");
                }});

    }
}
