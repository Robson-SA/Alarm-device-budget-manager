package com.devsquard.security.alarmbudget.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.dto.ProdutoUpdateDTO;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	@Autowired
	private final ProdutoRepository produtoRepository;
	
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Transactional
	public Produto save(ProdutoDTO dto) {
		
		Produto produto = new Produto(dto.getCodigo(), dto.getNome());
		produtoRepository.save(produto);
		return produto;
		
	}
	
	@Transactional
	public List<Produto> findAll() {
	    return produtoRepository.findAll();
	}
	
	@Transactional
	public Produto findByCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		
	}
	@Transactional
	public String removeByCodigo(String codigo) {
		Produto produto = produtoRepository.findByCodigo(codigo)
		        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		    produtoRepository.delete(produto);

		    return "Produto com código " + codigo + " removido com sucesso!";
		
		
	}
	
	@Transactional
	public Produto update(ProdutoUpdateDTO dto) {
		Produto updateProduto = produtoRepository.findById(dto.getId())
		        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		updateProduto.setCodigo(dto.getCodigo());
		updateProduto.setNome(dto.getNome());
		produtoRepository.save(updateProduto);
		
		return updateProduto;

		    
		
		
	}
	
	
	

}
