package com.localswapi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	private String nome;
	private String clima;
	private String terreno;
	private Integer aparicoes; 
	@JsonIgnore
	private String remoteUrl; 
	
	public Planet() {
		
	}
	
	public Planet(String nome, String clima, String terreno) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicoes() {
		return aparicoes;
	}

	public void setAparicoes(Integer aparicoes) {
		this.aparicoes = aparicoes;
	}

	public String getRemoteUrl() {
		return remoteUrl;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
