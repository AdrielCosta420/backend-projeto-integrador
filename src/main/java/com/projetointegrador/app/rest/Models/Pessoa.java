package com.projetointegrador.app.rest.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pessoa {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private Date dataNasc;
	
	@Column
	private Date dataInclusao;
	
	@Column
	private String situacao;
	
	@Column
	private String perfil;
	
	@Column
	private String cpf;
	
	public Pessoa() {}
	
	 public Pessoa(int id, String nome, String email, String telefone, Date dataNasc, Date dataInclusao, String situacao, String perfil, String cpf) {
	        this.id = id;
	        this.nome = nome;
	        this.email = email;
	        this.telefone = telefone;
	        this.dataNasc = dataNasc;
	        this.dataInclusao = dataInclusao;
	        this.situacao = situacao;
	        this.perfil = perfil;  
	        this.cpf = cpf;
	    }
}
