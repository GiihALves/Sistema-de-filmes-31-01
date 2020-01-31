package br.com.mastertech.masterflix.masterflix.service;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.repository.filmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class filmeService {

    @Autowired
    private filmeRepository repository;

    public Filme cadastrarFilme(Filme filmes){
        filmes.getAtivo(Boolean.TRUE);
        filmes.getDataCriacao(LocalDate.now());
        return repository.save(filmes);
    }

    public Iterable<Filme> listarFilmes(){
        Iterable<Filme> filmes = repository.findAll();
        return filmes;
    }

    public Filme listarFilme(String nome){
        Optional<Filme> filme = repository.findByNome(nome);
            if (filme.isPresent()){
            return filme.get();
        }
        return null;
    }
}
