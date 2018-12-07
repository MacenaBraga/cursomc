package com.macenabraga.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.macenabraga.cursomc.domain.CategoriaDomain;
import com.macenabraga.cursomc.domain.ProdutoDomain;
import com.macenabraga.cursomc.repositories.CategoriaRepository;
import com.macenabraga.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CategoriaDomain cat1 =  new CategoriaDomain(null,"Informática" );
		CategoriaDomain cat2 =  new CategoriaDomain(null,"Escritório" );
		
		ProdutoDomain p1= new ProdutoDomain(null,"Computador" ,  2000.00 );
		ProdutoDomain p2= new ProdutoDomain(null," Impressora " , 800.00 );
		ProdutoDomain p3= new ProdutoDomain(null, "Mouse",  80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
