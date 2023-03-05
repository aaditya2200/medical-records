package com.aaditya2200.medicalrecordapi.security;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestAuthenticator {
    public static final String AUTHORIZATION_HEADER = "authorization";

    public boolean isRequestAuthentic(HttpServletRequest httpServletRequest) throws IOException, InterruptedException {
        boolean isValid = false;
        String authorizationHeaderValue = httpServletRequest.getHeader(AUTHORIZATION_HEADER);

        return true;
    }
}
