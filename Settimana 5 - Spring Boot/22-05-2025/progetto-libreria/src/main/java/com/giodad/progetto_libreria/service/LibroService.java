package com.giodad.progetto_libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giodad.progetto_libreria.model.Libro;

@Service
public class LibroService {
    private List<Libro> libreria = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Libro> getLibreria() {
        return libreria;
    }

    public Optional<Libro> getById(Long id) {
        return libreria.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Libro create(Libro nuovo) {
        nuovo.setId(idCounter++);
        libreria.add(nuovo);
        return nuovo;
    }

    public Optional<Libro> update(Long id, Libro modificato) {
        return getById(id).map(Libro -> {
            Libro.setTitolo(modificato.getTitolo());
            Libro.setAutore(modificato.getAutore());
            Libro.setPrezzo(modificato.getPrezzo());
            return Libro;
        });
    }

    public boolean delete(Long id) {
        return libreria.removeIf(t -> t.getId().equals(id));
    }

}
