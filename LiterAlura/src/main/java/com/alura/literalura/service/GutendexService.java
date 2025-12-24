package com.alura.literalura.service;

import com.alura.literalura.dto.LivroDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GutendexService {

    private static final String API_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GutendexService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Consulta a API Gutendex e retorna uma lista de LivroDTO
     */
    public List<LivroDTO> buscarLivros() {
        // Faz a requisição GET
        String response = restTemplate.getForObject(API_URL, String.class);

        try {
            // Converte JSON em Map
            Map<String, Object> jsonMap = objectMapper.readValue(response, new TypeReference<>() {});
            // Extrai lista de resultados
            List<LivroDTO> livros = objectMapper.convertValue(jsonMap.get("results"), new TypeReference<>() {});
            return livros;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar API Gutendex", e);
        }
    }
}