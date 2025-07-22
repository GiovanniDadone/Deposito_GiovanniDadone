package com.giodad.progetto_libreria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private Long id;
    private String titolo;
    private String Autore;
    private Double prezzo;
}
