package com.devsquard.security.alarmbudget.dto;

import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;

public class ItemDoProjetoDTO {

	private Long produtoid;
	private String nome;
	private Integer quantidade;
	private String observacao;

	public ItemDoProjetoDTO() {

	}

	public ItemDoProjetoDTO(Long produtoid, String nome, Integer quantidade, String observacao) {
		this.produtoid = produtoid;
		this.nome = nome;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public ItemDoProjetoDTO(ItemDoProjeto entity) {
		this.produtoid = entity.getProduto().getId();
		this.nome = entity.getProjeto().getNome();
		this.quantidade = entity.getQuantidade();
		this.observacao = entity.getObservacao();
	}

	public Long getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(Long produtoid) {
		this.produtoid = produtoid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
