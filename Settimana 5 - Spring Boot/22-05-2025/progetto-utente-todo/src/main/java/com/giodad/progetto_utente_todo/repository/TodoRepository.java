package com.giodad.progetto_utente_todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giodad.progetto_utente_todo.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
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

