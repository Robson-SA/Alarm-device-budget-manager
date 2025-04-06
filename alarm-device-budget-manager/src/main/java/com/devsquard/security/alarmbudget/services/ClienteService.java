package com.devsquard.security.alarmbudget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsquard.security.alarmbudget.dto.ClienteDTO;
import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;

	
	public ClienteService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}


	@Transactional
	public Cliente save(ClienteDTO dto) {
		Cliente novoCliente = new Cliente(dto.getNome(), dto.getCnpj(), dto.getContato(), dto.getTelefone(), dto.getEmail());
		clienteRepository.save(novoCliente);
		return novoCliente;
	}
	
}
