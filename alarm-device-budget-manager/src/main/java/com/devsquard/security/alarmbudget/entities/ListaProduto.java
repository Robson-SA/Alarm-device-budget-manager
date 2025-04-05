package com.devsquard.security.alarmbudget.entities;

import java.util.ArrayList;

public class ListaProduto {

	private String codigo;

	private ArrayList<Produto> produtos;

	private Integer quantidade;

	private String observacao;

	public ListaProduto(String codigo, ArrayList<Produto> produtos, Integer quantidade, String observacao) {
		super();
		this.codigo = codigo;
		this.produtos = produtos;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
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
