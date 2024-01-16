package com.example.springsecuritybasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:8083", allowedHeaders = "*")
@RestController
public class OAuth2ResourceServerController {
    @Autowired
    private final MessageService messageService;

    public OAuth2ResourceServerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
//    public String index(@AuthenticationPrincipal Jwt jwt) {
//        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
//    }
    public String index() {
        return String.format("Hello, World!");
    }

    @GetMapping("/protected/premium")
    public String premium(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok(messageService.greet());
    }

    @GetMapping("/secured-route")
    public ResponseEntity<String> securedRoute() {
        return ResponseEntity.ok(messageService.getSecret());
    }

    @GetMapping("/secured-method")
    @PreAuthorize("hasRole('AUTHORIZED_PERSONNEL')")
    public ResponseEntity<String> securedMethod() {
        return ResponseEntity.ok(messageService.getSecret());
    }

    @Service
    public static class MessageService {
        public String greet() {
            final var who = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            return "Hello %s! You are granted with %s.".formatted(who.getName(), who.getAuthorities());
        }

        @PreAuthorize("hasRole('AUTHORIZED_PERSONNEL')")
        public String getSecret() {
            return "Only authorized personnel can read that";
        }
    }
}