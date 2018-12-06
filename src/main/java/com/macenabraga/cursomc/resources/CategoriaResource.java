package com.macenabraga.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.macenabraga.cursomc.domain.CategoriaDomain;
import com.macenabraga.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	@Autowired
	public CategoriaService service; //estanciando categoriaService! mesma coisa que "CategoriaService service = new CategoriaService ()"
	
	@RequestMapping(value= "/{id}" ,method=RequestMethod.GET) // o value acresenta na url do codigo ex: /categorias/id
	public ResponseEntity<?> find (@PathVariable Integer id) { // @PathVariable informa ao Spring que o id da url vai ser usado 
		
		CategoriaDomain  obj = service.buscaPorId(id); // chamada do metodo buscaPor id
		
		return ResponseEntity.ok() .body(obj.getNomeCategoria());
	}
 }
