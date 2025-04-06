package com.devsquard.security.alarmbudget.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.devsquard.security.alarmbudget.entities.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@NotBlank(message = "O cnpj é obrigatório")
	private String cnpj;

	private String contato;

	private String telefone;

	@Email(message = "Informe um e-mail válido")
	@NotBlank(message = "O e-mail é obrigatório")
	private String email;
    private List<ProjetoDTO> projetos;

	public ClienteDTO(Long id, String nome, String cnpj, String contato, String telefone, String email,List<ProjetoDTO> projetos) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		this.telefone = telefone;
		this.email = email;
	    this.projetos = projetos;
		
	}

	public ClienteDTO(Cliente entity) {
		this.nome = entity.getNome();
		this.cnpj = entity.getCnpj();
		this.contato = entity.getContato();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
        this.projetos = entity.getProjetos()
                .stream()
                .map(ProjetoDTO::new)
                .collect(Collectors.toList());
	}

	public ClienteDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<ProjetoDTO> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoDTO> projetos) {
		this.projetos = projetos;
	}
	

}
