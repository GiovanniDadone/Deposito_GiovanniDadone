package com.giodad.progetto1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giodad.progetto1.model.Prodotto;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
    private List<Prodotto> prodotti = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Prodotto> getAll() {
        return prodotti;
    }

    @PostMapping
    public Prodotto crea(@RequestBody Prodotto nuovo) {
        nuovo.setId(idCounter++);
        prodotti.add(nuovo);
        return nuovo;
    }

    @GetMapping("/{id}")
    public Prodotto getProdottoById(@PathVariable Long id) {
        // @PathVariable indica che questa richiesta si esprime con
        // http://localhost:8080/prodotti/1, quindi con quell'id
        // finale dopo uno slash, invece che con
        // "prodotti?param=qualcosa" con l'annotazione
        // @RequestParam
        return prodotti.stream() // apro uno stream della lista dei prodotti
                .filter(p -> p.getId().equals(id)) // cerco quello con il Long id uguale a quello raccolto
                .findFirst() // ritorna il primo che trova
                .orElse(null); // se non trova nulla ritorna null, **DA GESTIRE**
    }
}
