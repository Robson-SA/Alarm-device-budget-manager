package com.devsquard.security.alarmbudget.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.security.alarmbudget.dto.ProdutoCodigoDTO;
import com.devsquard.security.alarmbudget.dto.ProdutoDTO;
import com.devsquard.security.alarmbudget.repositories.ProdutoRepository;
import com.devsquard.security.alarmbudget.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private final ProdutoService service;

    ProdutoController(ProdutoService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findAllPaged(
        @PageableDefault(size = 10, sort = "nome") Pageable pageable
    ) {
        Page<ProdutoDTO> produtos = service.findAllPaged(pageable);
        return ResponseEntity.ok(produtos);
    }
    
    
    @GetMapping(value = ("/buscar"))
    public ResponseEntity<ProdutoDTO> findByCodigo(@RequestBody ProdutoCodigoDTO dto){
    	ProdutoDTO produtos = service.findByCodigo(dto.getCodigo());
    	return ResponseEntity.ok(produtos);
    }
    
    @DeleteMapping(value = ("/remover"))
    public ResponseEntity<String> deleteByCodigo(@RequestBody ProdutoCodigoDTO dto){
    	String mensagem = service.removeByCodigo(dto.getCodigo());
    	return ResponseEntity.ok(mensagem);
    	
    	
    }
    

	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@RequestBody @Valid ProdutoDTO dto) {
	
		ProdutoDTO produto = service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
		
		
	}
	
	@PutMapping(value = ("/update"))
	public ResponseEntity<ProdutoDTO> update(@RequestBody @Valid ProdutoDTO dto) {
		
		ProdutoDTO produto = service.update(dto);
		return ResponseEntity.ok(produto);
		
	}
}
