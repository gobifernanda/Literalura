package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String idioma;

    @ManyToOne
    private Autor autorObj;

    public Livro() {}

    public Livro(String titulo, String autor, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIdioma() { return idioma; }
    public Autor getAutorObj() { return autorObj; }

    // Setter para autorObj
    public void setAutorObj(Autor autorObj) {
        this.autorObj = autorObj;
    }
}