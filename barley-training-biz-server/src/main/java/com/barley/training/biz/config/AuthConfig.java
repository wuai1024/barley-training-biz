package com.barley.training.biz.config;

import com.barley.common.auth.session.MyAuthSession;
import com.barley.common.base.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class AuthConfig implements MyAuthSession {
    @Override
    public boolean checkToken(String token) {
        return true;
    }

    @Override
    public LoginUser getUserSession(String authorize, String value) {
        final LoginUser a = new LoginUser();
        a.setId("1");
        return a;
    }

    @Override
    public String failResponse(String message) {
        return "";
    }
}
