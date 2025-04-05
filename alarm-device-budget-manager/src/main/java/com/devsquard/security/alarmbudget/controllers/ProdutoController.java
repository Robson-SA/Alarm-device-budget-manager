package com.devsquard.security.alarmbudget.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.entities.Produto;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;
import com.devsquard.security.alarmbudget.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService service;

    ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody ProdutoDTO dto) {
	
		Produto produto = service.save(dto);
		return ResponseEntity.ok(produto);
		
	}
	
}
