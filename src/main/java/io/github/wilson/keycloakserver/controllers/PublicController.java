package io.github.wilson.keycloakserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("/public/hello")
    public String hello() {
        return "olá";
    }
}