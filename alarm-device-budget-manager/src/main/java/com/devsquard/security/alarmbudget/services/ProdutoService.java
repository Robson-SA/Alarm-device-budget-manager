package com.devsquard.security.alarmbudget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public ProdutoDTO save(ProdutoDTO dto) {

		Produto produto = new Produto();
		copyToEntity(produto, dto);
		produto = produtoRepository.save(produto);
		return new ProdutoDTO(produto);

	}

	@Transactional
	public Page<ProdutoDTO> findAll(Pageable pageable) {
		Page<Produto> produtos = produtoRepository.findAll(pageable);
		return produtos.map(produto -> new ProdutoDTO(produto));
	}

	@Transactional
	public ProdutoDTO findByCodigo(String codigo) {

		Produto produto = produtoRepository.findByCodigo(codigo);
				
		return new ProdutoDTO(produto);

	}

	@Transactional
	public String removeByCodigo(String codigo) {
		Produto produto = produtoRepository.findByCodigo(codigo);
		
		produtoRepository.delete(produto);

		return "Produto com código " + codigo + " removido com sucesso!";

	}

	@Transactional
	public ProdutoDTO update(String codigo, ProdutoDTO dto) {
		Produto updateProduto = produtoRepository.findByCodigo(codigo);

		if (dto.getCodigo() != null && !dto.getCodigo().equals(updateProduto.getCodigo())) {
			updateProduto.setCodigo(dto.getCodigo());
		}
		if (dto.getNome() != null && !dto.getNome().equals(updateProduto.getNome())) {
			updateProduto.setNome(dto.getNome());
		}

		produtoRepository.save(updateProduto);

		return new ProdutoDTO(updateProduto);

	}

	public void copyToEntity(Produto entity, ProdutoDTO dto) {
		entity.setId(dto.getId());
		entity.setCodigo(dto.getCodigo());
		entity.setNome(dto.getNome());
	}

}
