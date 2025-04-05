package com.devsquard.security.alarmbudget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto save(ProdutoDTO dto) {
		
		Produto produto = new Produto(dto.getCodigo(), dto.getNome());
		produtoRepository.save(produto);
		return produto;
		
	}
	

}
