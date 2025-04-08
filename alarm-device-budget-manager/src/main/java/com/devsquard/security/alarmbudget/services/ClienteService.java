package com.devsquard.security.alarmbudget.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ClienteDTO;
import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.dto.ProjetoDTO;
import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}


	@Transactional
	public Cliente save(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		
		cliente.setNome(dto.getNome());
	    cliente.setCnpj(dto.getCnpj());
	    cliente.setContato(dto.getContato());
	    cliente.setTelefone(dto.getTelefone());
	    cliente.setEmail(dto.getEmail());

	    Set<Projeto> projetos = dto.getProjetos().stream().map(projDTO -> {
	        Projeto p = new Projeto();
	        p.setCodigo(projDTO.getCodigo());
	        p.setNome(projDTO.getNome());
	        p.setArea(projDTO.getArea());
	        p.setEndereco(projDTO.getEndereco());
	        p.setQuantidade(projDTO.getQuantidade());
	        p.setObservacao(projDTO.getObservacao());
	        p.setData(projDTO.getData());
	        p.setCliente(cliente); // IMPORTANTE para persistir corretamente!
	        return p;
	    }).collect(Collectors.toSet());

	    cliente.setProjetos(projetos);

	    return clienteRepository.save(cliente);
		
	}
	
	@Transactional
	public Page<ClienteDTO> findAll(Pageable pageable) {
	    return clienteRepository.findAll(pageable)
	            .map(ClienteDTO::new);
	}
	
}
