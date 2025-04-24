package com.devsquard.security.alarmbudget.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquard.security.alarmbudget.dto.ProjetoDTO;
import com.devsquard.security.alarmbudget.services.ProjetoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProjetoDTO>> findAll(@PageableDefault(sort="nome") Pageable pageable) {
    	Page<ProjetoDTO> projetoDTO = service.findAll(pageable);
        return ResponseEntity.ok(projetoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity <ProjetoDTO> findByCodigo(@PathVariable String id) {
        ProjetoDTO projetoDTO = service.findByCodigo(id);
    	return ResponseEntity.ok(projetoDTO);
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> create(@Valid @RequestBody ProjetoDTO dto) {
        ProjetoDTO saved = service.save(dto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> update(@PathVariable Long id, @Valid @RequestBody ProjetoDTO dto) {
        ProjetoDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String mensagem = service.delete(id);
        return ResponseEntity.ok(mensagem);
    }
}
