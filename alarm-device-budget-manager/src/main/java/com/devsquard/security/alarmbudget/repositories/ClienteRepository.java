package com.devsquard.security.alarmbudget.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsquard.security.alarmbudget.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
//	Optional<Cliente> findByNome(String nome);
//	Page<Cliente> findAll(Pageable pageable);
	
	@Query("SELECT obj FROM Cliente obj WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%',:nome,'%'))")
	Page<Cliente> findByNome(@Param("nome") String nome, Pageable pageable);


}
