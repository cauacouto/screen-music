package br.com.coutodev.screnn_music.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @ManyToOne
    private Artista artista;


    public Musica(){}
    public Musica(String nomeMusica) {
    this.titulo=nomeMusica;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }



    @Override
    public String toString() {
        return " Musica " +
                "titulo='" + titulo + '\'' +
                ", artista=" + artista.getNome();


    }
}

