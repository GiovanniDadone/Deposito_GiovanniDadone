package com.giodad.progetto_todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giodad.progetto_todo.model.Todo;
import com.giodad.progetto_todo.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository repo;

    @Autowired
    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getAll() {
        List<Todo> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
    }

    public Optional<Todo> getById(Long id) {
        return repo.findById(id);
    }

    public Todo create(Todo nuovo) {
        return repo.save(nuovo);
    }

    public Optional<Todo> update(Long id, Todo modificato) {
        return repo.findById(id).map(t -> {
            t.setDescrizione(modificato.getDescrizione());
            t.setCompletato(modificato.isCompletato());
            return repo.save(t);
        });
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
