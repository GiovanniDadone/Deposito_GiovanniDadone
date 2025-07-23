package com.giodad.progetto_utente_todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodad.progetto_utente_todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUtenteId(Long utenteId);
    // tutti i metodi crud base già pronti!
    // ****I METODI SONO I SEGUENTI*****
    /*------------------------------------- */
    // <S extends T> S save(S entity);
    // <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    // Optional<T> findById(ID id);
    // boolean existsById(ID id);
    // Iterable<T> findAll();
    // Iterable<T> findAllById(Iterable<ID> ids);
    // long count();
    // void deleteById(ID id);
    // void delete(T entity);
    // void deleteAllById(Iterable<? extends ID> ids);
    // void deleteAll(Iterable<? extends T> entities);
    // void deleteAll();
}
