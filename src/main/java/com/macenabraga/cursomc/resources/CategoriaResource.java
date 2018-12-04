package com.macenabraga.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macenabraga.cursomc.domain.CategoriaDomain;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CategoriaDomain> listar () {
		
		CategoriaDomain cat1 = new CategoriaDomain(1,"Informatica");		
		CategoriaDomain cat2 = new CategoriaDomain(2,"Escritorio");
		
		List< CategoriaDomain > listacat = new ArrayList<>();
		listacat.add(cat1);
		listacat.add(cat2);
		
		return listacat ;
	}
 }
