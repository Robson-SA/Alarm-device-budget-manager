package com.devsquard.security.alarmbudget.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PRJ_NUMERO")
	private Long codigo;

	@Column(name = "PRJ_NOME")
	@NotNull(message = "O nome do projeto é obrigatório")
	private String nome;

	@NotNull(message = "O área do projeto é obrigatório")
	@Column(name = "PRJ_AREA")
	private String area;

	@NotNull(message = "O endereço do projeto é obrigatório")
	@Column(name = "PRJ_ENDERECO")
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Produto> produtos = new ArrayList<>();

	@Column(name = "PRJ_DATA")
	private String data;

}
