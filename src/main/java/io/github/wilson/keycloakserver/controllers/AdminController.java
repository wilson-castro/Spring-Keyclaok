package io.github.wilson.keycloakserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private static final List<String> MONTHS = List.of(
            "Janeiro","Fevereiro","Março","Abril","Maio","Junho",
            "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"
    );

    @GetMapping("/admin/list")
    public List<String> listMonths() {
        return MONTHS;
    }
}