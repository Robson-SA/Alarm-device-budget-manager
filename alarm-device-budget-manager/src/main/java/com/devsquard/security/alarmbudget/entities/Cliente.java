package com.devsquard.security.alarmbudget.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 100)
	private String nome;

	
	@Column(unique = true)
	private String cnpj;

	private String contato;

	private String telefone;

	private String email;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Projeto> projetos = new HashSet<>();
	
	
	public Cliente(
			@NotBlank(message = "O nome é obrigatório") 
			String nome,
			@NotBlank(message = "O cnpj é obrigatório") 
			String cnpj, 
			String contato, 
			String telefone,
			@Email(message = "Informe um e-mail válido") 
			@NotBlank(message = "O e-mail é obrigatório") 
			String email) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		this.telefone = telefone;
		this.email = email;
	}

	public Cliente() {
	}


	public Long getId() {
		return id;
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
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

}
