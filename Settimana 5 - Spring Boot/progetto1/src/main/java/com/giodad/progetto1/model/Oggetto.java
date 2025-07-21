package com.giodad.progetto1.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Oggetto {
    private Long id;
    private Integer numero;

    public Oggetto() {}

    @Autowired
    public Oggetto(Long id, Integer numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    
}
