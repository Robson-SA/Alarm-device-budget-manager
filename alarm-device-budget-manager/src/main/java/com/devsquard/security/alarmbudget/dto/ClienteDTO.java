package com.devsquard.security.alarmbudget.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O cnpj é obrigatório")
	private String cnpj;

	private String Contato;

	private String telefone;

	@Email(message = "Informe um e-mail válido")
	@NotBlank(message = "O e-mail é obrigatório")
	private String email;
	

	public ClienteDTO(String nome, String cnpj, String contato, String telefone, String email) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		Contato = contato;
		this.telefone = telefone;
		this.email = email;
	}
	
	
	public ClienteDTO() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
