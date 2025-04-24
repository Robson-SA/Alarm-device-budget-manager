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

	    Projeto projeto = projetoRepository.findByCodigo(dto.getProjetoId().toString());
	    if (projeto == null) {
	        throw new ResourceNotFoundException("Projeto não encontrado");
	    }

	    Produto produto = produtoRepository.findByCodigo(dto.getProdutoId().toString());
	    if (produto == null) {
	        throw new ResourceNotFoundException("Produto não encontrado");
	    }

	    ItemDoProjeto item = new ItemDoProjeto();
	    item.setProjeto(projeto);
	    item.setProduto(produto);
	    item.setQuantidade(dto.getQuantidade());
	    item.setObservacao(dto.getObservacao());

	    item = itemDoProjetoRepository.save(item);

	    return new ItemDoProjetoDTO(item);
	}
	
	@Transactional
    public Page<ItemDoProjetoDTO> findAll(Pageable pageable) {
        Page<ItemDoProjeto> page = itemDoProjetoRepository.findAll(pageable);
        return page.map(ItemDoProjetoDTO::new);
    }

	
	@Transactional
	public ItemDoProjetoDTO findById(Long id) {
		ItemDoProjeto item = itemDoProjetoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Codigo não encontrado: " + id));
		    return new ItemDoProjetoDTO(item);
		
	}

	 @Transactional
	    public ItemDoProjetoDTO update(Long id, ItemDoProjetoDTO dto) {
	        return itemDoProjetoRepository.findById(id)
	            .map(existingItem -> {
	                if (dto.getQuantidade() != null && dto.getQuantidade() > 0 &&
	                    !dto.getQuantidade().equals(existingItem.getQuantidade())) {
	                    existingItem.setQuantidade(dto.getQuantidade());
	                }

	                if (dto.getObservacao() != null &&
	                    !dto.getObservacao().equals(existingItem.getObservacao())) {
	                    existingItem.setObservacao(dto.getObservacao());
	                }

	                // Atualização de produto via produtoid
	                if (dto.getProdutoId() != null &&
	                    (existingItem.getProduto() == null || !dto.getProdutoId().equals(existingItem.getProduto().getId()))) {
	                    Produto produto = produtoRepository.findById(dto.getProdutoId())
	                            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
	                    existingItem.setProduto(produto);
	                }

	                // NÃO está mais atualizando projeto pois DTO atual não carrega ID de projeto
	                // Se necessário, inclua `projetoid` no DTO

	                existingItem = itemDoProjetoRepository.save(existingItem);
	                return new ItemDoProjetoDTO(existingItem);
	            })
	            .orElseThrow(() -> new ResourceNotFoundException("Item do Projeto não encontrado com id: " + id));
	    }
	
	@Transactional
	public String delete(Long id) {
		ItemDoProjeto item = itemDoProjetoRepository.findById(id)
		        .orElseThrow(() -> new EntityNotFoundException("Codigo não encontrado: " + id));
		
		itemDoProjetoRepository.delete(item);
		String mensagem = "O item com o id " +  item.getProduto().getId() + " foi removido com sucesso!";
	
		return mensagem;
	}
	
	
}
