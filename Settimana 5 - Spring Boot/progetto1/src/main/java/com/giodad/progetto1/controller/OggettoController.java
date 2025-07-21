package com.giodad.progetto1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giodad.progetto1.model.Oggetto;

@RestController
@RequestMapping("/oggetti")
public class OggettoController {
    private final List<Oggetto> oggetti = new ArrayList<>();
    private Long id = 1L;

    @GetMapping
    public List<Oggetto> getAllOggetti() {
        return oggetti;
    }

    @GetMapping("/{id}")
    public Oggetto getOggettoById(@PathVariable Long id) {
        return oggetti.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Oggetto addOggetto(@RequestBody Oggetto nuovo) {
        nuovo.setId(id++);
        oggetti.add(nuovo);
        return nuovo;
    }

    @GetMapping("/somma")
    public Integer getSomma() {
        return oggetti.stream()
                .mapToInt(p -> p.getNumero())
                .sum();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        boolean removed = oggetti.removeIf(p -> p.getId().equals(id));
        return (removed) ? "Removed successfully" : "Error: not removed";
    }

    @PutMapping("/{id}")
    public Integer putOggetto(@PathVariable Long id, @RequestBody Oggetto aggiornato) {
        return oggetti.stream()
                .filter(oggetto -> oggetto.getId().equals(id))
                .findFirst()
                .map(oggetto -> {
                    oggetto.setNumero(aggiornato.getNumero());
                    return oggetto.getNumero();
                })
                .orElse(0);
    }

}
