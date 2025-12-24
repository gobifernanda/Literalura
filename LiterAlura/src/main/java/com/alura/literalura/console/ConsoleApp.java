package com.alura.literalura.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alura.literalura.service.LivroService;
import com.alura.literalura.service.ApiLivroService;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final LivroService livroService;
    private final ApiLivroService apiLivroService;

    // O Spring injeta automaticamente os dois serviços
    public ConsoleApp(LivroService livroService, ApiLivroService apiLivroService) {
        this.livroService = livroService;
        this.apiLivroService = apiLivroService;
    }

    @Override
    public void run(String... args) {
        // Cria o menu passando os dois serviços
        MenuConsole menu = new MenuConsole(livroService, apiLivroService);
        menu.exibirMenu();
    }
}