package com.barley.training.biz.config;

import com.barley.common.auth.session.MyAuthSession;
import com.barley.common.auth.session.SessionService;
import com.barley.common.base.JsonUtils;
import com.barley.common.base.LoginUser;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class AuthConfig implements MyAuthSession {
    private final SessionService sessionService;

    @Override
    public boolean checkToken(String token) {
        return sessionService.checkToken(token);
    }

    @Override
    public LoginUser getUserSession(String authorize, String value) {
        final String userId = Objects.toString(sessionService.getToken(authorize), null);
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        return sessionService.getUserSession(userId);
    }

    @Override
    public String failResponse(String message) {
        return JsonUtils.stringify(Map.of("message", Optional.ofNullable(message).orElse(""), "code", "401"));
    }
}
