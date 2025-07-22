package com.giodad.progetto_utente_todo.model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "descrizione", nullable = false, length = 100)
    private String descrizione;
    private boolean completato;

    @Autowired
    public Todo(String descrizione, boolean completato) {
        this.descrizione = descrizione;
        this.completato = completato;
    }
}

