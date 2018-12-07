package com.macenabraga.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

	@Entity
	public class ProdutoDomain implements Serializable  { 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProduto;	
	private String nomeProduto;	
	private Double precoProduto;
	
	@JsonBackReference // omiti a lista de categoria par não provocar fluxo continuo de buscas 
	@ManyToMany 
	@JoinTable  (name =" PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @ JoinColumn (name = "categoria_id")
	)
	// JoinTable PRODUTO_CATEGORIA é o nome da tabela que vai associar as tabelas produto e categoria 
	//joinColumns produto_id especifica  o nome da chave estrangeira 
	//inverseJoinColumns  categoria_id referencia da categoria para produto
	
	private List<CategoriaDomain>  categorias  =  new  ArrayList<>();
	
	public ProdutoDomain() {
		
	}	
	public ProdutoDomain(Integer idProduto, String nomeProduto, Double precoProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public List<CategoriaDomain> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<CategoriaDomain> categorias) {
		this.categorias = categorias;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDomain other = (ProdutoDomain) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
	

}
