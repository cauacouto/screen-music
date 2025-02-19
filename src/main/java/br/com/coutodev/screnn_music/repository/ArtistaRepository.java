package br.com.coutodev.screnn_music.repository;

import br.com.coutodev.screnn_music.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista,Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
}
