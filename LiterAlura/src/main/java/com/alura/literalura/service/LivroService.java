package com.alura.literalura.service;

import com.alura.literalura.model.Livro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // 1 - Listar todos os livros registrados no banco
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // 2 - Listar autores registrados
    public List<Autor> listarAutores() {
        return livroRepository.findAll().stream()
                .map(Livro::getAutorObj)
                .filter(a -> a != null)
                .distinct()
                .collect(Collectors.toList());
    }

    // 3 - Listar autores vivos em determinado ano
    public List<Autor> listarAutoresVivosNoAno(int ano) {
        return listarAutores().stream()
                .filter(a -> a.getAnoNascimento() != null && a.getAnoNascimento() <= ano &&
                        (a.getAnoMorte() == null || a.getAnoMorte() > ano))
                .collect(Collectors.toList());
    }

    // 4 - Listar autores por ano de nascimento
    public List<Autor> listarAutoresPorAnoNascimento(int ano) {
        return listarAutores().stream()
                .filter(a -> a.getAnoNascimento() != null && a.getAnoNascimento() == ano)
                .collect(Collectors.toList());
    }

    // 5 - Listar autores por ano de morte
    public List<Autor> listarAutoresPorAnoMorte(int ano) {
        return listarAutores().stream()
                .filter(a -> a.getAnoMorte() != null && a.getAnoMorte() == ano)
                .collect(Collectors.toList());
    }

    // 6 - Listar livros por idioma
    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findAll().stream()
                .filter(l -> l.getIdioma() != null && l.getIdioma().equalsIgnoreCase(idioma))
                .collect(Collectors.toList());
    }
}