package com.devsquard.security.alarmbudget.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "tb_item_projeto")
public class ItemDoProjeto {

	@EmbeddedId
	private ItemDoProjetoPK id = new ItemDoProjetoPK();

	private Integer quantidade;

	private String observacao;

	public ItemDoProjeto(Produto produto,Projeto projeto,Integer quantidade, String observacao) {
		id.setProduto(produto);
		id.setProjeto(projeto);
		this.quantidade = quantidade;
		this.observacao = observacao;
	}
	
	public ItemDoProjeto() {
		
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
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Projeto getProjeto() {
		return id.getProjeto();
	}

	public void setProjeto(Projeto projeto) {
		id.setProjeto(projeto);
	}
}
