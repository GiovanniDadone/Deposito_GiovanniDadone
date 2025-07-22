package com.giodad.progetto_todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giodad.progetto_todo.model.Todo;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Todo> getAll() {
        return todos;
    }

    public Optional<Todo> getById(Long id) {
        return todos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Todo create(Todo nuovo) {
        nuovo.setId(idCounter++);
        todos.add(nuovo);
        return nuovo;
    }

    public Optional<Todo> update(Long id, Todo modificato) {
        return getById(id).map(todo -> {
            todo.setDescrizione(modificato.getDescrizione());
            todo.setCompletato(modificato.isCompletato());
            return todo;
        });
    }

    public boolean delete(Long id) {
        return todos.removeIf(t -> t.getId().equals(id));
    }
}
