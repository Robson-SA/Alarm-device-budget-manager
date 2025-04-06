package com.devsquard.security.alarmbudget.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_produto")
public class Produto {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	private Long id;

	
	@Column(name="PRO_COD", unique = true)
	@NotNull(message = "O codigo do produto é obrigatório")
	private String codigo;
	
	
	@Column(name="PRO_NOME")
	@NotNull(message = "O codigo do produto é obrigatório")
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "PRO_PRJ_FK", nullable = true)
    private Projeto projeto;


	public Produto(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	// Implementar equals e hashCode para evitar duplicatas no HashSet
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Projeto)) return false;
	        Produto produto = (Produto) o;
	        return id != null && id.equals(produto.id);
	    }
	 
	 @Override
	 public int hashCode() {
	     return id != null ? id.hashCode() : 0;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", nomeProduto=" + nome
				+ "]";
	}
	

	
}
