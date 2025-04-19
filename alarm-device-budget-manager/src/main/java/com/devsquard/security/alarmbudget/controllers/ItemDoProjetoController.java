package com.devsquard.security.alarmbudget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.security.alarmbudget.dto.ItemDoProjetoDTO;
import com.devsquard.security.alarmbudget.dto.ItemDoProjetoInsertDTO;
import com.devsquard.security.alarmbudget.services.ItemDoProjetoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itemDoProjeto")
public class ItemDoProjetoController {
	
	
	@Autowired
	private ItemDoProjetoService itemDoProjetoService;

	
	@PostMapping
	 public ResponseEntity<ItemDoProjetoDTO> create(@Valid @RequestBody ItemDoProjetoInsertDTO dto) {
        ItemDoProjetoDTO saved = itemDoProjetoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
	
	@GetMapping
	public ResponseEntity<Page<ItemDoProjetoDTO>> findAll(Pageable pageable){
		Page<ItemDoProjetoDTO> itemsDTO = itemDoProjetoService.findAll(pageable);
		return ResponseEntity.ok(itemsDTO);
		
	}
	
	@GetMapping(value = ("/buscarId/{id}"))
	public ResponseEntity<ItemDoProjetoDTO> findById(@PathVariable Long id){
		ItemDoProjetoDTO itemDto = itemDoProjetoService.findById(id);
		return ResponseEntity.ok(itemDto);
	}
	
	@PutMapping(value = ("/update/{id}"))
	public ResponseEntity<ItemDoProjetoDTO> update(@PathVariable Long id, @Valid @RequestBody ItemDoProjetoDTO dto) {
	    ItemDoProjetoDTO itemDto = itemDoProjetoService.update(id, dto);
	    return ResponseEntity.ok(itemDto);
	}
	
	@DeleteMapping(value = ("/delete/{id}"))
	public ResponseEntity<String> delete(@PathVariable Long id){
		String mensagem = itemDoProjetoService.delete(id);
		return ResponseEntity.ok(mensagem);
	}
	
}
