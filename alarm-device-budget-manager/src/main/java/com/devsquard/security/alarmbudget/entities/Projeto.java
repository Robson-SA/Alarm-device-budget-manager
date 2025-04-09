package com.devsquard.security.alarmbudget.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PRJ_NUMERO")
	private Long codigo;

	@Column(name = "PRJ_NOME")
	@NotNull(message = "O nome do projeto é obrigatório")
	private String nome;

	@NotNull(message = "O área do projeto é obrigatório")
	@Column(name = "PRJ_AREA")
	private String area;

	@NotNull(message = "O endereço do projeto é obrigatório")
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@NotNull(message = "A quantidade de items é obrigatório")
	private Integer quantidade;
	
	private String observacao;

	@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Produto> produtos = new HashSet<>();

	@Column(name = "PRJ_DATA")
	private LocalDate data;
	
	
	public Projeto(
			Long id, 
			Long codigo, 
			@NotNull(message = "O nome do projeto é obrigatório") 
			String nome,
			@NotNull(message = "O área do projeto é obrigatório") 
			String area,
			@NotNull(message = "O endereço do projeto é obrigatório") 
			String endereco, 
			Cliente cliente,
			@NotNull(message = "A quantidade de items é obrigatório") 
			Integer quantidade, String observacao,
			Set<Produto> produtos, LocalDate data) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.area = area;
		this.endereco = endereco;
		this.cliente = cliente;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.produtos = produtos;
		this.data = data;
	}
	
	public Projeto() {
		
	}

	public Integer SomarQuantidadeItens() {
		int total = 0;
		for(int i = 1; i < produtos.size(); i++) {
			
			total += this.quantidade;
		}
		
		return total;
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Projeto))
			return false;
		Projeto projeto = (Projeto) o;
		return id != null && id.equals(projeto.id);
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	public Long getId() {
		return id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(HashSet<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
