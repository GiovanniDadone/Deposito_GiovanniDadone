package com.giodad.progetto1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {
    private Long id;
    private String name;
    private double prezzo;
}
