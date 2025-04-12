package com.devsquard.security.alarmbudget.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
