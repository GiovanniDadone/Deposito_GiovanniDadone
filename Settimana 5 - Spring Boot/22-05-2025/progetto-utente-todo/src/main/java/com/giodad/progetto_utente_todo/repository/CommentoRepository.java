package com.giodad.progetto_utente_todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodad.progetto_utente_todo.model.Commento;

public interface CommentoRepository extends JpaRepository<Commento, Long> {
    List<Commento> findByTodoId(Long todoId);
}
