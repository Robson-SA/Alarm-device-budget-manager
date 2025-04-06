package com.devsquard.security.alarmbudget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsquard.security.alarmbudget.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
