package com.devsquard.security.alarmbudget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public ProdutoDTO save(ProdutoDTO dto) {

		Produto produto = new Produto();

		produto.setCodigo(dto.getCodigo());
		produto.setNome(dto.getNome());

		produtoRepository.save(produto);

		return new ProdutoDTO(produto);

	}

	@Transactional
	public Page<ProdutoDTO> findByCodigo(String codigo, Pageable pageable) {

		Page<Produto> produto = produtoRepository.findByCodigo(codigo, pageable);

		return produto.map(x -> new ProdutoDTO(x));

	}

	@Transactional
	public String removeByCodigo(String codigo) {
		Produto produto = produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		produtoRepository.delete(produto);

		return "Produto com código " + codigo + " removido com sucesso!";

	}

	@Transactional
	public ProdutoDTO update(String codigo, ProdutoDTO dto) {
		Produto updateProduto = produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		if (dto.getCodigo() != null && !updateProduto.getCodigo().equals(dto.getCodigo())) {
			updateProduto.setCodigo(dto.getCodigo());
		}else if(dto.getCodigo() != null && !dto.getCodigo().equals(dto.getCodigo())) {
			updateProduto.setCodigo(dto.getCodigo());
		}
		if (dto.getNome() != null && !dto.getNome().equals(updateProduto.getNome())) {
			updateProduto.setNome(dto.getNome());
		}

		produtoRepository.save(updateProduto);

		return new ProdutoDTO(updateProduto);

	}

}
