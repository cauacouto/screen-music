package br.com.coutodev.screnn_music;

import br.com.coutodev.screnn_music.principal.principal;
import br.com.coutodev.screnn_music.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrennMusicApplication implements CommandLineRunner {
@Autowired
private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScrennMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal principal=new principal(repository);


		principal.exibeMenu();
	}
}
