package com.giodad.progetto1.controller;



import org.springframework.web.bind.annotation.RestController;

import com.giodad.progetto1.service.Calcolatrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ControllerCalcolatrice {
    private final Calcolatrice calc;

    @Autowired
    public ControllerCalcolatrice(Calcolatrice calc) {
        this.calc = calc;
    }

    @GetMapping("/somma")
    public int somma(@RequestParam int a, @RequestParam int b) {
        return calc.somma(a, b);  //lo richiamo da http://localhost:8080/somma?a=*inserire_numero*&b=*inserire_numero*
    }
    
}
