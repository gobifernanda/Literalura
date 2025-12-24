package com.alura.literalura.console;

import com.alura.literalura.model.Livro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.service.LivroService;
import com.alura.literalura.service.ApiLivroService;

import java.util.List;
import java.util.Scanner;

public class MenuConsole {

    private final LivroService livroService;
    private final ApiLivroService apiLivroService;

    public MenuConsole(LivroService livroService, ApiLivroService apiLivroService) {
        this.livroService = livroService;
        this.apiLivroService = apiLivroService;
    }

    public void exibirMenu() {
        try (Scanner scanner = new Scanner(System.in)) {  // ✅ try-with-resources
            int opcao;

            do {
                System.out.println("=== Menu Literalura ===");
                System.out.println("1 - Importar livros da API Gutendex");
                System.out.println("2 - Listar todos os livros do banco");
                System.out.println("3 - Listar autores registrados");
                System.out.println("4 - Listar autores vivos em determinado ano");
                System.out.println("5 - Listar autores por ano de nascimento");
                System.out.println("6 - Listar autores por ano de morte");
                System.out.println("7 - Listar livros por idioma");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // consumir quebra de linha

                switch (opcao) {
                    case 1 -> {
                        List<Livro> livrosImportados = apiLivroService.importarLivrosDaApi();
                        livrosImportados.forEach(l -> System.out.println("Importado: " + l.getTitulo()));
                    }
                    case 2 -> {
                        List<Livro> livros = livroService.listarTodos();
                        livros.forEach(l -> System.out.println("Livro: " + l.getTitulo() + " - Autor: " + l.getAutor()));
                    }
                    case 3 -> {
                        List<Autor> autores = livroService.listarAutores();
                        autores.forEach(a -> System.out.println("Autor: " + a.getNome()));
                    }
                    case 4 -> {
                        System.out.print("Digite o ano: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine(); // consumir quebra de linha
                        List<Autor> autoresVivos = livroService.listarAutoresVivosNoAno(ano);
                        autoresVivos.forEach(a -> System.out.println("Autor vivo em " + ano + ": " + a.getNome()));
                    }
                    case 5 -> {
                        System.out.print("Digite o ano: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine();
                        List<Autor> autoresNascimento = livroService.listarAutoresPorAnoNascimento(ano);
                        autoresNascimento.forEach(a -> System.out.println("Autor nascido em " + ano + ": " + a.getNome()));
                    }
                    case 6 -> {
                        System.out.print("Digite o ano: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine();
                        List<Autor> autoresMorte = livroService.listarAutoresPorAnoMorte(ano);
                        autoresMorte.forEach(a -> System.out.println("Autor falecido em " + ano + ": " + a.getNome()));
                    }
                    case 7 -> {
                        System.out.print("Digite o idioma: ");
                        String idioma = scanner.nextLine();
                        List<Livro> livrosIdioma = livroService.listarLivrosPorIdioma(idioma);
                        livrosIdioma.forEach(l -> System.out.println("Livro em " + idioma + ": " + l.getTitulo()));
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
    }
}