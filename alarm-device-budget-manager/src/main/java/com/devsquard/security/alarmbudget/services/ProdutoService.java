package com.devsquard.security.alarmbudget.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
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
	public ProdutoDTO save(ProdutoDTO dto) {
		
		Produto produto = new Produto(dto.getCodigo(), dto.getNome());
		Produto produtoSalvo = produtoRepository.save(produto);
		return new ProdutoDTO(produtoSalvo.getCodigo(), produtoSalvo.getNome());
		
	}
	
	@Transactional
	public List<ProdutoDTO> findAll() {
		List<Produto> produtos = produtoRepository.findAll();
	    return produtos.stream()
	    		.map(produto -> new ProdutoDTO(produto.getCodigo(), produto.getNome()))
	    		.toList();
	}
	
	@Transactional
	public ProdutoDTO findByCodigo(String codigo) {
	
		Produto produto = produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		return new ProdutoDTO(produto.getCodigo(),produto.getNome());
		
		
	}
	
	@Transactional
	public String removeByCodigo(String codigo) {
		Produto produto = produtoRepository.findByCodigo(codigo)
		        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		    produtoRepository.delete(produto);

		    return "Produto com código " + codigo + " removido com sucesso!";		
		
	}
	
	@Transactional
	public ProdutoDTO update(ProdutoDTO dto) {
		Produto updateProduto = produtoRepository.findByCodigo(dto.getCodigo())
		        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		updateProduto.setCodigo(dto.getCodigo());
		updateProduto.setNome(dto.getNome());
		produtoRepository.save(updateProduto);
		
		return new ProdutoDTO(updateProduto.getCodigo(), updateProduto.getNome());

		
	}
	
	
	

}
