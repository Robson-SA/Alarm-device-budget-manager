package com.devsquard.security.alarmbudget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.devsquard.security.alarmbudget.dto.ProdutoUpdateDTO;
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
    
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
    	List<Produto> produtos = service.findAll();
    	return ResponseEntity.ok(produtos);
    }
    
    
    @GetMapping(value = ("/buscar"))
    public ResponseEntity<Produto> findByCodigo(@RequestBody ProdutoCodigoDTO dto){
    	Produto produtos = service.findByCodigo(dto.getCodigo());
    	return ResponseEntity.ok(produtos);
    }
    
    @DeleteMapping(value = ("/remover"))
    public ResponseEntity<String> deleteByCodigo(@RequestBody ProdutoCodigoDTO dto){
    	String mensagem = service.removeByCodigo(dto.getCodigo());
    	return ResponseEntity.ok(mensagem);
    	
    	
    }
    

	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody ProdutoDTO dto) {
	
		Produto produto = service.save(dto);
		return ResponseEntity.ok(produto);
		
	}
	
	@PutMapping(value = ("/update"))
	public ResponseEntity<Produto> update(@RequestBody ProdutoUpdateDTO dto) {
		
		Produto produto = service.update(dto);
		return ResponseEntity.ok(produto);
		
	}
}
