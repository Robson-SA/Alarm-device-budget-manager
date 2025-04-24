package com.devsquard.security.alarmbudget.dto;

import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;

public class ItemDoProjetoDTO {

	private Long produtoId;
	private Long projetoId;
	private Integer quantidade;
	private String observacao;

	public ItemDoProjetoDTO() {
	}

	public ItemDoProjetoDTO(Long produtoId, Long projetoId, Integer quantidade, String observacao) {
		this.produtoId = produtoId;
		this.projetoId = projetoId;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public ItemDoProjetoDTO(ItemDoProjeto entity) {
		this.produtoId = entity.getProduto().getId();
		this.projetoId = entity.getProjeto().getId();
		this.quantidade = entity.getQuantidade();
		this.observacao = entity.getObservacao();
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
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
