package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LivroDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private List<AutorDTO> authors;

    @JsonProperty("languages")
    private List<String> languages;

    public LivroDTO() {}

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AutorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AutorDTO> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}