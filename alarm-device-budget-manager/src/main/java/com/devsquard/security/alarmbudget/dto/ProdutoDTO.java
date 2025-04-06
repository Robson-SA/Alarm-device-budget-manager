package com.devsquard.security.alarmbudget.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {
	
	@NotNull(message = "O codigo do produto é obrigatório")
	private String codigo;
	
	@NotNull(message = "O codigo do produto é obrigatório")
	@Size(min = 20, max = 100)
	private String nome;


	public ProdutoDTO(String codigo, String nome) {
		
		this.codigo = codigo;
		this.nome = nome;
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
