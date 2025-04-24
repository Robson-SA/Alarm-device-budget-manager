package com.devsquard.security.alarmbudget.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRJ_ID")
	private Long id;

	@Column(name = "PRJ_NUMERO")
	private String codigo;

	@Column(name = "PRJ_NOME")
	private String nome;

	@Column(name = "PRJ_AREA")
	private String area;

	private String endereco;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "id.projeto")
	private Set<ItemDoProjeto> itens = new HashSet<>();

	@Column(name = "PRJ_DATA")
	private LocalDate data;

	public Projeto(Long id, String codigo, String nome, String area, String endereco, Cliente cliente,
			Set<ItemDoProjeto> itens, LocalDate data) {
		
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.area = area;
		this.endereco = endereco;
		this.cliente = cliente;
		this.itens = itens;
		this.data = data;
	}

	public Projeto() {

	}

	public Long getId() {
		return id;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemDoProjeto> getItens() {
		return itens;
	}

	public void setItens(Set<ItemDoProjeto> itens) {
		this.itens = itens;
	}
	
	

}
