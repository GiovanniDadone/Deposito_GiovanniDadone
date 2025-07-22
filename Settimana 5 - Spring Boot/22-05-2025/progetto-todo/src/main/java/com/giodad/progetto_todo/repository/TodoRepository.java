package com.giodad.progetto_todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giodad.progetto_todo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    // i metodi CRUD da aggiungere
}
