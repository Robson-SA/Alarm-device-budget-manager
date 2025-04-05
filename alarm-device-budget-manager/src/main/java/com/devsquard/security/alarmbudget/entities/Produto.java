package com.devsquard.security.alarmbudget.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_produto")
public class Produto {
	
	@Id 
	@Column(name="PRO_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PRO_CLI_FK")
	private Cliente cliente;
	
	@Column(name="PRO_COD")
	private String codigo;
	
	
	@Column(name="PRO_NOME")
	private String nomeProduto;


	public Produto(Long id, Cliente cliente, String codigo, String nomeProduto) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
	}
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	

	
}
