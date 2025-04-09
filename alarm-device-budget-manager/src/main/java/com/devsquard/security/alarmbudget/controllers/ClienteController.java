package com.devsquard.security.alarmbudget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.security.alarmbudget.dto.ClienteDTO;
import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;
	
		@GetMapping(value = ("/{id}"))
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		ClienteDTO dto = clienteService.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> save(@RequestBody @Valid ClienteDTO dto) {
		Cliente clienteSalvo = clienteService.save(dto);
		ClienteDTO clienteDTO = new ClienteDTO(clienteSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
		
	}
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findByNome(@RequestParam(name = "nome", defaultValue = "") String nome, Pageable pageable){
		Page<ClienteDTO> clienteDTO = clienteService.findByNome(nome, pageable);
		return ResponseEntity.ok(clienteDTO);
	}
	
	@GetMapping("/cliente")
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
        Page<ClienteDTO> clientes = clienteService.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }
	
	

}
