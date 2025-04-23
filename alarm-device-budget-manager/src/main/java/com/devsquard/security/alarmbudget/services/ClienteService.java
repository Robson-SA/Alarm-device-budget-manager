package com.devsquard.security.alarmbudget.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devsquard.security.alarmbudget.dto.ClienteDTO;
import com.devsquard.security.alarmbudget.dto.ProjetoDTO;
import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.entities.Projeto;
import com.devsquard.security.alarmbudget.repositories.ClienteRepository;
import com.devsquard.security.alarmbudget.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente save(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		copyDtoToEntity(dto, cliente);
		
		if (dto.getProjetos() != null) {
			Set<Projeto> projetos = dto.getProjetos().stream().map(projDTO -> {
				Projeto p = new Projeto();
				copyDtoEntity(projDTO, p);
				return p;
			}).collect(Collectors.toSet());

			cliente.setProjetos(projetos);
		}

		return clienteRepository.save(cliente);

	}

	@Transactional
	public Page<ClienteDTO> findAll(Pageable pageable) {
		return clienteRepository.findClientesWithProjetos(pageable)
				.map(ClienteDTO::new);
	}

	@Transactional
	public Page<ClienteDTO> findByNome(String nome, Pageable pageable) {
		Page<Cliente> clienteExiste = clienteRepository.findByNome(nome, pageable);

		return clienteExiste.map(x -> new ClienteDTO(x));

	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClienteDTO(cliente);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		clienteRepository.deleteById(id);

	}

	@Transactional
	public @Valid ClienteDTO update(Long id, ClienteDTO dto) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

		copyDtoToEntity(dto, cliente);

		if (dto.getProjetos() != null) {
			cliente.getProjetos().clear();
			Set<Projeto> projetos = dto.getProjetos().stream().map(projDTO -> {
				Projeto p = new Projeto();
				copyDtoEntity(projDTO, p);
				p.setCliente(cliente);
				return p;
			}).collect(Collectors.toSet());
			cliente.getProjetos().addAll(projetos);
		}

		Cliente updatedCliente = clienteRepository.save(cliente);
		return new ClienteDTO(updatedCliente);
	}

	private void copyDtoToEntity(ClienteDTO dto, Cliente cliente) {
		cliente.setNome(dto.getNome());
		cliente.setCnpj(dto.getCnpj());
		cliente.setContato(dto.getContato());
		cliente.setTelefone(dto.getTelefone());
		cliente.setEmail(dto.getEmail());
	}

	private void copyDtoEntity(ProjetoDTO projDTO, Projeto p) {
		p.setCodigo(projDTO.getCodigo());
		p.setNome(projDTO.getNome());
		p.setArea(projDTO.getArea());
		p.setEndereco(projDTO.getEndereco());
		p.setData(projDTO.getData());

	}

}
