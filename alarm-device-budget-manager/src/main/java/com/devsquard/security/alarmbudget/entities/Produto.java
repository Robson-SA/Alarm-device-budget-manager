package com.devsquard.security.alarmbudget.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_produto")
public class Produto {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	private Long id;

	@Column(name="PRO_COD")
	private String codigo;
	
	
	@Column(name="PRO_NOME")
	private String nomeProduto;


	public Produto(String codigo, String nomeProduto) {
		super();
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
	}
	
	public Produto() {
		
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


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", nomeProduto=" + nomeProduto
				+ "]";
	}
	

	
}
