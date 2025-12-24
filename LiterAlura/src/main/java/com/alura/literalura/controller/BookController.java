package com.alura.literalura.controller;

import com.alura.literalura.model.Livro;
import com.alura.literalura.service.LivroService;
import com.alura.literalura.service.ApiLivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final LivroService livroService;
    private final ApiLivroService apiLivroService;

    public BookController(LivroService livroService, ApiLivroService apiLivroService) {
        this.livroService = livroService;
        this.apiLivroService = apiLivroService;
    }

    // Listar todos os livros do banco
    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    // Importar livros da API Gutendex e salvar no banco
    @PostMapping("/import")
    public List<Livro> importarLivros() {
        return apiLivroService.importarLivrosDaApi();
    }
}