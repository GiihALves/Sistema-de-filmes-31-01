package br.com.mastertech.masterflix.masterflix.repository;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface filmeRepository extends CrudRepository<Filme, Long> {
    Optional<Filme>findByNome(String nome);
}
