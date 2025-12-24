package com.alura.literalura.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alura.literalura.service.LivroService;

@Component
public class ConsoleTest implements CommandLineRunner {

    private final LivroService livroService;

    public ConsoleTest(LivroService livroService) {
        this.livroService = livroService;
    }

    @Override
    public void run(String... args) throws Exception {
        livroService.listarTodos().forEach(livro ->
            System.out.println("Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor())
        );
    }
}