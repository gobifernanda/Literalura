package com.alura.literalura.service;

import com.alura.literalura.dto.LivroDTO;
import java.util.List;

public class GutendexResponse {
    private List<LivroDTO> results;

    public List<LivroDTO> getResults() {
        return results;
    }

    public void setResults(List<LivroDTO> results) {
        this.results = results;
    }
}