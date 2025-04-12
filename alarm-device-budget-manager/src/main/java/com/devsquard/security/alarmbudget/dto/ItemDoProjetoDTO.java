package com.devsquard.security.alarmbudget.dto;

import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.entities.Projeto;

import jakarta.validation.constraints.NotNull;

public class ItemDoProjetoDTO {

	private Long id;
	private ProdutoDTO produto;   
    private ProjetoDTO projeto; 
	@NotNull(message = "A quantidade de items é obrigatório")
	private Integer quantidade;
	private String observacao;

	public ItemDoProjetoDTO() {
	}

	public ItemDoProjetoDTO(Long id, ProjetoDTO projetoDTO, ProdutoDTO produtoDTO, Integer quantidade, String observacao) {
		this.id = id;
		this.projeto = projetoDTO;
		this.produto = produtoDTO;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public ItemDoProjetoDTO(ItemDoProjeto item, Projeto projeto, Produto produto) {
		this.id = item.getId();
		this.projeto = new ProjetoDTO(projeto);
		this.produto = new ProdutoDTO(produto);
		this.quantidade = item.getQuantidade();
		this.observacao = item.getObservacao();
	}


	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public ProjetoDTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoDTO projeto) {
		this.projeto = projeto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
