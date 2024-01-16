package com.example.springsecuritybasic;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String greet() {
        final var who = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return "Hello %s! You are granted with %s.".formatted(who.getName(), who.getAuthorities());
    }

    @PreAuthorize("hasRole('AUTHORIZED_PERSONNEL')")
    public String getSecret() {
        return "Only authorized personnel can read that";
    }
}