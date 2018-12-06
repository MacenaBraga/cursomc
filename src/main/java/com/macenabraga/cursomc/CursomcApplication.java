package com.macenabraga.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macenabraga.cursomc.domain.CategoriaDomain;
import com.macenabraga.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaDomain cat1 =  new CategoriaDomain(null,"Informática" );
		CategoriaDomain cat2 =  new CategoriaDomain(null,"Escritório" );
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
