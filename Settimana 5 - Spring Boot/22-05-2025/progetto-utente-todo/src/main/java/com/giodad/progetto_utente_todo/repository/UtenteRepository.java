package com.giodad.progetto_utente_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodad.progetto_utente_todo.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
