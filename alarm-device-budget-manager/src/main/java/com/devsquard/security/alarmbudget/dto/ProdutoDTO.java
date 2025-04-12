package com.devsquard.security.alarmbudget.dto;

import com.devsquard.security.alarmbudget.entities.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
	
	private Long id;
	
	@NotNull(message = "O codigo do produto é obrigatório")
	private String codigo;
	
	@NotBlank(message = "O codigo do produto é obrigatório")
	@Size(min = 5, max = 100)
	private String nome;


	public ProdutoDTO(Long id, String codigo, String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public ProdutoDTO(Produto entity) {
		this.id = entity.getId();
		this.codigo = entity.getCodigo();
		this.nome = entity.getNome();
		
	}
	
	public ProdutoDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
