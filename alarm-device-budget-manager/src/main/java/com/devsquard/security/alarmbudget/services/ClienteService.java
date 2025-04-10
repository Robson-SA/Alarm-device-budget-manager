package com.devsquard.security.alarmbudget.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ClienteDTO;
import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente save(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		
		cliente.setNome(dto.getNome());
	    cliente.setCnpj(dto.getCnpj());
	    cliente.setContato(dto.getContato());
	    cliente.setTelefone(dto.getTelefone());
	    cliente.setEmail(dto.getEmail());
	      
	    if (dto.getProjetos() != null) {
	        Set<Projeto> projetos = dto.getProjetos().stream().map(projDTO -> {
	            Projeto p = new Projeto();
	            p.setCodigo(projDTO.getCodigo());
	            p.setNome(projDTO.getNome());
	            p.setArea(projDTO.getArea());
	            p.setEndereco(projDTO.getEndereco());
	            p.setQuantidade(projDTO.getQuantidade());
	            p.setObservacao(projDTO.getObservacao());
	            p.setData(projDTO.getData());
	            p.setCliente(cliente);
	            return p;
	        }).collect(Collectors.toSet());

	        cliente.setProjetos(projetos);
	    }

	    if (dto.getProjetos() != null) {
	        Set<Projeto> projetos = dto.getProjetos().stream().map(projDTO -> {
	            Projeto p = new Projeto();
	            p.setCodigo(projDTO.getCodigo());
	            p.setNome(projDTO.getNome());
	            p.setArea(projDTO.getArea());
	            p.setEndereco(projDTO.getEndereco());
	            p.setQuantidade(projDTO.getQuantidade());
	            p.setObservacao(projDTO.getObservacao());
	            p.setData(projDTO.getData());
	            p.setCliente(cliente);
	            return p;
	        }).collect(Collectors.toSet());

	        cliente.setProjetos(projetos);
	    }

	    return clienteRepository.save(cliente);
		
	}
	
	@Transactional
	public Page<ClienteDTO> findAll(Pageable pageable) {
	    return clienteRepository.findAll(pageable)
	            .map(ClienteDTO::new);
	}
	
	@Transactional
	public Page<ClienteDTO> findByNome(String nome, Pageable pageable) {
		 Page<Cliente> clienteExiste = clienteRepository.findByNome(nome,pageable);
				
		 return clienteExiste.map(x -> new ClienteDTO(x));
		 
		
	}
	
}
