package com.alura.literalura.service;

import com.alura.literalura.dto.LivroDTO;
import com.alura.literalura.dto.AutorDTO;
import com.alura.literalura.model.Livro;
import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiLivroService {

    private final LivroRepository livroRepository;
    private final GutendexService gutendexService;

    public ApiLivroService(LivroRepository livroRepository, GutendexService gutendexService) {
        this.livroRepository = livroRepository;
        this.gutendexService = gutendexService;
    }

    public List<Livro> importarLivrosDaApi() {
        List<LivroDTO> livrosApi = gutendexService.buscarLivros();

        return livrosApi.stream().map(dto -> {
            Autor autor = null;
            if (dto.getAuthors() != null && !dto.getAuthors().isEmpty()) {
                AutorDTO autorDTO = dto.getAuthors().get(0);
                autor = new Autor(
                        autorDTO.getName(),
                        autorDTO.getBirthYear(),
                        autorDTO.getDeathYear()
                );
            }

            String idioma = (dto.getLanguages() == null || dto.getLanguages().isEmpty())
                    ? "N/A"
                    : dto.getLanguages().get(0);

            Livro livro = new Livro(
                    dto.getTitle(),
                    autor != null ? autor.getNome() : "Desconhecido",
                    idioma
            );

            livro.setAutorObj(autor);

            return livroRepository.save(livro);
        }).toList();
    }
}