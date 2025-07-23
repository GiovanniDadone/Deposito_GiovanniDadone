package com.giodad.progetto_utente_todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.giodad.progetto_utente_todo.model.Utente;
import com.giodad.progetto_utente_todo.repository.UtenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteService {

private final UtenteRepository utenteRepository;

public List<Utente> findAll() {
return utenteRepository.findAll();
}

public Utente findById(Long id) {
return utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));
}

public Utente save(Utente utente) {
return utenteRepository.save(utente);
}

public void delete(Long id) {
utenteRepository.deleteById(id);
}
}
