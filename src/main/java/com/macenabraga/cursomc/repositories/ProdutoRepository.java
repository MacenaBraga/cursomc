package com.macenabraga.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macenabraga.cursomc.domain.ProdutoDomain;

@Repository //informa que a interface eé a responsavel de fazer as consultas na base
public interface ProdutoRepository extends JpaRepository<ProdutoDomain, Integer> {// JpaRepository serve para usar abase de acordo com o tipo que voce passar 
		// Um objeto do tipo  CategoriaRepository vai conseguir fazer todo o CRUD
}
