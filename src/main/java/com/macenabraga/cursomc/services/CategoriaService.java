package com.macenabraga.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macenabraga.cursomc.domain.CategoriaDomain;
import com.macenabraga.cursomc.repositories.CategoriaRepository;

@Service // define o tipoda classe
public class CategoriaService {
	
	@Autowired //istaciando a CategoriaRepository
	private CategoriaRepository repo;
	
	public CategoriaDomain buscaPorId (Integer id) {
			Optional<CategoriaDomain> obj = repo.findById(id);
			return obj.orElse(null);
	}
	
}
