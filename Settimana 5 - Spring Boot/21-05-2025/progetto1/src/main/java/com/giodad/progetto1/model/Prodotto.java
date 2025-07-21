package com.giodad.progetto1.model;

public class Prodotto {
    private Long id;
    private String name;
    private double prezzo;

    public Prodotto() {}

    public Prodotto(Long id, String name, double prezzo) {
        this.id = id;
        this.name = name;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
    
}
