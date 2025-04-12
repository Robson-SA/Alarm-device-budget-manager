package com.devsquard.security.alarmbudget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ItemDoProjetoDTO;
import com.devsquard.security.alarmbudget.dto.ItemDoProjetoInsertDTO;
import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ItemDoProjetoRepository;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;
import com.devsquard.security.alarmbudget.repositories.ProjetoRepository;
import com.devsquard.security.alarmbudget.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ItemDoProjetoService {

	@Autowired
	private ItemDoProjetoRepository itemDoProjetoRepository;

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public ItemDoProjetoDTO save(ItemDoProjetoInsertDTO dto) {

	    // Buscar entidades usando os IDs
	    Projeto projeto = projetoRepository.findByCodigo(dto.getProjetoId().toString());
	    if (projeto == null) {
	        throw new ResourceNotFoundException("Projeto não encontrado");
	    }

	    Produto produto = produtoRepository.findByCodigo(dto.getProdutoId().toString());
	    if (produto == null) {
	        throw new ResourceNotFoundException("Produto não encontrado");
	    }

	    // Criar a entidade
	    ItemDoProjeto item = new ItemDoProjeto();
	    item.setProjeto(projeto);
	    item.setProduto(produto);
	    item.setQuantidade(dto.getQuantidade());
	    item.setObservacao(dto.getObservacao());

	    item = itemDoProjetoRepository.save(item);

	    return new ItemDoProjetoDTO(item, projeto, produto);
	}
	
	@Transactional
	public Page<ItemDoProjetoDTO> findAll(Pageable pageable){
		Page<ItemDoProjeto> page = itemDoProjetoRepository.findAll(pageable);

		return page.map(item -> {
			Projeto projeto = projetoRepository.findByCodigo(item.getProjeto().getCodigo());
			
			Produto produto = produtoRepository.findByCodigo(item.getProduto().getCodigo());

			return new ItemDoProjetoDTO(item, projeto, produto);
		});
	}

	
	
	private void copyDtoToEntity(ItemDoProjetoDTO dto, ItemDoProjeto entity) {
	    entity.setId(dto.getId());

	    String projetoId = dto.getProjeto() != null ? dto.getProjeto().getCodigo() : null;
	    if (projetoId == null) {
	        throw new ResourceNotFoundException("Projeto não informado");
	    }
	    Projeto projeto = projetoRepository.findByCodigo(projetoId);
	    entity.setProjeto(projeto);

	    String produtoId = dto.getProduto() != null ? dto.getProduto().getCodigo() : null;
	    if (produtoId == null) {
	        throw new ResourceNotFoundException("Produto não informado");
	    }
	    Produto produto = produtoRepository.findByCodigo(produtoId);
	    entity.setProduto(produto);

	    entity.setQuantidade(dto.getQuantidade());
	    entity.setObservacao(dto.getObservacao());
	}


}
