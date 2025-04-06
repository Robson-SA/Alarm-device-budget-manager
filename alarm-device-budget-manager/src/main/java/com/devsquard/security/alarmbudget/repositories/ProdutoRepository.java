package com.devsquard.security.alarmbudget.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsquard.security.alarmbudget.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	 Optional<Produto> findByCodigo(String codigo);

}
