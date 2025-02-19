package br.com.coutodev.screnn_music.principal;

import br.com.coutodev.screnn_music.model.Artista;
import br.com.coutodev.screnn_music.model.Musica;
import br.com.coutodev.screnn_music.model.TipoArtista;
import br.com.coutodev.screnn_music.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class principal {

    private final ArtistaRepository repository;
    private Scanner leitura = new Scanner(System.in);


    public principal(ArtistaRepository repository) {
        this.repository=repository;

    }


    public void exibeMenu() {
        var opção = 1;

        while (opção != 5) {

            var menu = """
            *** screnn-music***
                       
             1- Cadastrar artistas
                                                
              2- Cadastrar músicas
                                                
                3- Listar músicas
                                                
           4- Buscar músicas por artistas
                        
               5-sair                        
                                                
               """;

            System.out.println(menu);
            opção = leitura.nextInt();
            leitura.nextLine();

            switch (opção) {
                case 1:
                    cadastraArtistas();
                    break;

                case 2:
                    cadastrarMusicas();
                    break;

                case 3:
                    listarMusicas();
                    break;


                case 4:
                    buscarMusicaPorArtista();
                    break;

                case 5:
                    System.out.println("saindo..");
            }
        }
    }

    private void buscarMusicaPorArtista() {
        System.out.println("digite o");


    }

    private void listarMusicas() {
        List<Artista> artistas = repository.findAll();
        artistas.forEach(a-> a.getMusicas().forEach(System.out::println));


    }

    private void cadastrarMusicas() {
        System.out.println("cadastra musica de que artista");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()){
            System.out.println("informe o titulo da musica");
            var nomeMusica=leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repository.save(artista.get());
        }else {
            System.out.println("artista não encontrado");
        }
    }


    private void cadastraArtistas() {

        var cadastrarNovo = "S";
        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista: ");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla ou banda)");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
            repository.save(artista);
        }


    }
 }





