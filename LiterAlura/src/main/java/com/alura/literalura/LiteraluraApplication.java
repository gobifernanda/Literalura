package com.alura.literalura;

import com.alura.literalura.console.MenuConsole;
import com.alura.literalura.service.LivroService;
import com.alura.literalura.service.ApiLivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    private final LivroService livroService;
    private final ApiLivroService apiLivroService;

    // O Spring injeta automaticamente os serviços aqui
    public LiteraluraApplication(LivroService livroService, ApiLivroService apiLivroService) {
        this.livroService = livroService;
        this.apiLivroService = apiLivroService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Cria o menu passando os dois serviços
        MenuConsole menu = new MenuConsole(livroService, apiLivroService);
        menu.exibirMenu();
    }
}