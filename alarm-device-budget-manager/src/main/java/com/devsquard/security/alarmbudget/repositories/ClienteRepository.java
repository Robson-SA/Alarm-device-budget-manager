package com.devsquard.security.alarmbudget.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsquard.security.alarmbudget.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByNome(String nome);
	Page<Cliente> findAll(Pageable pageable);

}
