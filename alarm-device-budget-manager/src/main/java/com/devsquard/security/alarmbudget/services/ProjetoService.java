package com.devsquard.security.alarmbudget.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsquard.security.alarmbudget.dto.ProjetoDTO;
import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;
import com.devsquard.security.alarmbudget.entities.ItemDoProjetoPK;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;
import com.devsquard.security.alarmbudget.repositories.ProjetoRepository;
import com.devsquard.security.alarmbudget.services.exceptions.ResourceNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
    private  ProjetoRepository repository;
	@Autowired
	private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public Page<ProjetoDTO> findAll(Pageable pageable) {
        Page<Projeto> pages = repository.findAll(pageable);
        return pages.map(ProjetoDTO::new);
    }

  
    @Transactional(readOnly = true)
    public ProjetoDTO findByCodigo(String codigo) {
        Projeto entity = repository.findByCodigo(codigo);
        return new ProjetoDTO(entity);
    }

    @Transactional
    public ProjetoDTO save(ProjetoDTO dto) {
        Projeto entity = new Projeto();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProjetoDTO(entity);
    }

    @Transactional
    public ProjetoDTO update(Long id, ProjetoDTO dto) {
        Projeto entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProjetoDTO(entity);
    }

    public String delete(Long id) {
        Optional<Projeto> projeto = repository.findById(id);
        
        if (projeto.isPresent()) {
            ProjetoDTO dto = new ProjetoDTO(projeto.get());
            repository.deleteById(id);
            return "Projeto com o nome \"" + dto.getNome() + "\" deletado com sucesso!";
        } else {
            return "Projeto com o id " + id + " não encontrado.";
        }
    }

    private void copyDtoToEntity(ProjetoDTO dto, Projeto entity) {
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setArea(dto.getArea());
        entity.setEndereco(dto.getEndereco());
        entity.setData(dto.getData());
        entity.getItens().clear();

     

        dto.getList().forEach(itemDTO -> {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoid())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + itemDTO.getProdutoid()));

            ItemDoProjeto item = new ItemDoProjeto();
            item.setProduto(produto);
            item.setProjeto(entity);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setObservacao(itemDTO.getObservacao());

            entity.getItens().add(item);
        });
    }
}
