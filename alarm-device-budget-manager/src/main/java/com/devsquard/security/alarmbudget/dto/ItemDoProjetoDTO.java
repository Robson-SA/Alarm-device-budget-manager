package com.devsquard.security.alarmbudget.dto;

import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;

public class ItemDoProjetoDTO {

	private Long id;
	private Long projetoId;
	private Long produtoId;
	private Integer quantidade;
	private String observacao;

	public ItemDoProjetoDTO() {
	}

	public ItemDoProjetoDTO(Long id, Long projetoId, Long produtoId, Integer quantidade, String observacao) {
		this.id = id;
		this.projetoId = projetoId;
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public ItemDoProjetoDTO(ItemDoProjeto entity) {
		this.id = entity.getId();
		this.projetoId = entity.getProjeto() != null ? entity.getProjeto().getId() : null;
		this.produtoId = entity.getProduto() != null ? entity.getProduto().getId() : null;
		this.quantidade = entity.getQuantidade();
		this.observacao = entity.getObservacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
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
