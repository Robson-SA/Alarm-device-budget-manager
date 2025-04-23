package com.devsquard.security.alarmbudget.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsquard.security.alarmbudget.entities.Cliente;
import com.devsquard.security.alarmbudget.entities.Produto;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT obj FROM Cliente obj WHERE UPPER(obj.nome) LIKE UPPER(CONCAT('%',:nome,'%'))")
	Page<Cliente> findByNome(@Param("nome") String nome, Pageable pageable);

		@Query(value = "SELECT obj FROM Cliente obj JOIN FETCH obj.projetos", countQuery = "SELECT COUNT(obj) FROM Cliente obj JOIN obj.projetos")
	Page<Cliente> findClientesWithProjetos(Pageable pageable);


}
