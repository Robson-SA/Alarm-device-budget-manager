package com.devsquard.security.alarmbudget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findAll(@PageableDefault(sort="nome") Pageable pageable) {
		Page<ProdutoDTO> produtos = service.findAll(pageable);
		return ResponseEntity.ok(produtos);
	}
	
	@GetMapping(value = ("buscarId/{id}"))
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		ProdutoDTO produto = service.findById(id);
		return ResponseEntity.ok(produto);
	}
	

	@GetMapping(value = ("/buscar/{codigo}"))
	public ResponseEntity<ProdutoDTO> findByCodigo(@PathVariable String codigo) {
		ProdutoDTO produtos = service.findByCodigo(codigo);
		return ResponseEntity.ok(produtos);
	}

	@DeleteMapping(value = ("/remover/{codigo}"))
	public ResponseEntity<String> deleteByCodigo(@PathVariable String codigo) {
		String mensagem = service.removeByCodigo(codigo);
		return ResponseEntity.ok(mensagem);

	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@RequestBody @Valid ProdutoDTO dto) {

		ProdutoDTO produto = service.save(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(produto);

	}

	@PutMapping(value = ("/update/{codigo}"))
	public ResponseEntity<ProdutoDTO> update(@PathVariable String codigo,
			@RequestBody ProdutoDTO dto) {

		ProdutoDTO produto = service.update(codigo, dto);
		return ResponseEntity.ok(produto);

	}
}
