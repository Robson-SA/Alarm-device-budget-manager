package com.devsquard.security.alarmbudget.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.controllers.ItemDoProjetoController;
import com.devsquard.security.alarmbudget.dto.ItemDoProjetoDTO;
import com.devsquard.security.alarmbudget.dto.ItemDoProjetoInsertDTO;
import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ItemDoProjetoRepository;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;
import com.devsquard.security.alarmbudget.repositories.ProjetoRepository;
import com.devsquard.security.alarmbudget.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
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

	
	@Transactional
	public ItemDoProjetoDTO findById(Long id) {
		ItemDoProjeto item = itemDoProjetoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Codigo não encontrado: " + id));
		    
		    // Buscar projeto e produto associados
		    Projeto projeto = projetoRepository.findByCodigo(item.getProjeto().getCodigo());
		    Produto produto = produtoRepository.findByCodigo(item.getProduto().getCodigo());
		    
		    // Criar e retornar o DTO
		    return new ItemDoProjetoDTO(item, projeto, produto);
		
	}

	@Transactional
	public ItemDoProjetoDTO update(Long id, ItemDoProjetoDTO dto) {
	    return itemDoProjetoRepository.findById(id)
	            .map(existingItem -> {
	                // Update quantidade only if different and valid
	                Optional.ofNullable(dto.getQuantidade())
	                        .filter(quantidade -> quantidade > 0)
	                        .filter(quantidade -> !quantidade.equals(existingItem.getQuantidade()))
	                        .ifPresent(existingItem::setQuantidade);
	                
	                // Update observacao only if different
	                Optional.ofNullable(dto.getObservacao())
	                        .filter(obs -> !obs.equals(existingItem.getObservacao()))
	                        .ifPresent(existingItem::setObservacao);
	                
	                // Update produto relationship only if different
	                Optional.ofNullable(dto.getProduto())
	                        .filter(produtoDTO -> !produtoDTO.getId().equals(
	                                existingItem.getProduto() != null ? existingItem.getProduto().getId() : null))
	                        .map(produtoDTO -> produtoRepository.findById(produtoDTO.getId())
	                                .orElseThrow(() -> new ResourceNotFoundException("Produto not found")))
	                        .ifPresent(existingItem::setProduto);
	                
	                // Update projeto relationship only if different
	                Optional.ofNullable(dto.getProjeto())
	                        .filter(projetoDTO -> !projetoDTO.getId().equals(
	                                existingItem.getProjeto() != null ? existingItem.getProjeto().getId() : null))
	                        .map(projetoDTO -> projetoRepository.findById(projetoDTO.getId())
	                                .orElseThrow(() -> new ResourceNotFoundException("Projeto not found")))
	                        .ifPresent(existingItem::setProjeto);
	                
	                // Save only if any changes were made (could track changes with a boolean flag)
	                ItemDoProjeto updatedItem = itemDoProjetoRepository.save(existingItem);
	                
	                // Convert back to DTO and return
	                Produto produto = updatedItem.getProduto();
	                Projeto projeto = updatedItem.getProjeto();
	                return new ItemDoProjetoDTO(updatedItem, projeto, produto);
	            })
	            .orElseThrow(() -> new ResourceNotFoundException("Item do Projeto not found with id: " + id));
	}
	
}
