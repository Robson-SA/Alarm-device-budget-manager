package com.devsquard.security.alarmbudget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;


	@GetMapping(value = ("/buscar"))
	public ResponseEntity<Page<ProdutoDTO>> findByCodigo(@RequestParam(name = "codigo", defaultValue = "") String nome,
			Pageable pageable) {
		Page<ProdutoDTO> produtos = service.findByCodigo(nome, pageable);
		return ResponseEntity.ok(produtos);
	}

	@DeleteMapping(value = ("/remover"))
	public ResponseEntity<String> deleteByCodigo(@RequestParam(name = "codigo", defaultValue = "") String codigo) {
		String mensagem = service.removeByCodigo(codigo);
		return ResponseEntity.ok(mensagem);

	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@RequestBody @Valid ProdutoDTO dto) {

		ProdutoDTO produto = service.save(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(produto);

	}

	@PutMapping(value = ("/update"))
	public ResponseEntity<ProdutoDTO> update(@RequestParam(name = "codigo", defaultValue = "") String codigo,
			@RequestBody ProdutoDTO dto) {

		ProdutoDTO produto = service.update(codigo, dto);
		return ResponseEntity.ok(produto);

	}
}
