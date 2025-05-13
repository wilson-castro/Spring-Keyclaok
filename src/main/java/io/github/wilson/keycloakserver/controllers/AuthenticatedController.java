package io.github.wilson.keycloakserver.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticatedController {
    @GetMapping("/authenticated/info")
    public Map<String, Object> getInfo(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();

        if (authentication instanceof JwtAuthenticationToken jwt) {
            response.put("name", jwt.getName());
            response.put("email", jwt.getTokenAttributes().get("email"));
            response.put("roles", jwt.getAuthorities());
            response.put("token", ((Jwt) jwt.getPrincipal()).getTokenValue());
            response.put("preferred_username", jwt.getTokenAttributes().get("preferred_username"));
        }

        return response;
    }
}