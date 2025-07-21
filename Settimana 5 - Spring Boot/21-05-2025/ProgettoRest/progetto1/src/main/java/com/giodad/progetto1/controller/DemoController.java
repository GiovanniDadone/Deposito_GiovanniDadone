package com.giodad.progetto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giodad.progetto1.service.MessaggioService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {
    private final MessaggioService service;

    @Autowired
    public DemoController(MessaggioService service) {
        this.service = service;
    }

    @GetMapping("/saluta")
    public String mandaSaluto() {
        service.saluta();  //questo stampa in console
        return "Saluto inviato";  //questo lo ritrovi su http://localhost:8080/saluta
    }

    @GetMapping("/insulto")
    public String insulta(@RequestParam String param) {
        return param;
    }
    
}
