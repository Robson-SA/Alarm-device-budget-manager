package com.devsquard.security.alarmbudget.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.devsquard.security.alarmbudget.entities.ItemDoProjeto;
import com.devsquard.security.alarmbudget.entities.Projeto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProjetoDTO {
	
    private Long id;
    
    @NotNull(message="O codigo do projeto e obrigatório")
    private String codigo;
    
    @NotBlank(message="O nome do projeto e obrigatório")
    private String nome;
    
    @NotBlank(message="A área do projeto e obrigatório")
    private String area;
    
    @NotBlank(message="O endereço do projeto e obrigatório")
    private String endereco;
    
    private LocalDate data;
    

    private List<ItemDoProjetoDTO> itens = new ArrayList<>();

    public ProjetoDTO() {
    }

    public ProjetoDTO(Long id, String codigo, String nome, String area, String endereco,LocalDate data) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
        this.endereco = endereco;
        this.data = data;
    }
    
    public ProjetoDTO(Projeto entity) {
		this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.nome = entity.getNome();
        this.area = entity.getArea();
        this.endereco = entity.getEndereco();
        this.data = entity.getData();
        
        for (ItemDoProjeto item : entity.getItens()) {
            this.itens.add(new ItemDoProjetoDTO(item));
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

    public List<ItemDoProjetoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoProjetoDTO> itens) {
        this.itens = itens;
    }

}
