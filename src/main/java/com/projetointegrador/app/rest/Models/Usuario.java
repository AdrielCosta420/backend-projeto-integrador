package com.projetointegrador.app.rest.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	 	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column
	    private String login;
		
		@Column
	    private String senha;
		
		@Column
	    private String nome;
		
		@Column
	    private boolean ativo;
		
		@Column
	    private Date dataNascimento;
		
		@Column
	    private Date dataCadastro;
		
		@Column
		private boolean admin;

		public Usuario() {
			
		}
		
	    public Usuario(int id, String login, String senha, String nome, boolean ativo, Date dataNascimento, Date dataCadastro, boolean admin) {
	        this.id = id;
	        this.login = login;
	        this.senha = senha;
	        this.nome = nome;
	        this.ativo = ativo;
	        this.dataNascimento = dataNascimento;
	        this.dataCadastro = dataCadastro;
	        this.admin = admin;
	    }

	    
	    public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public boolean isAtivo() {
	        return ativo;
	    }

	    public void setAtivo(boolean ativo) {
	        this.ativo = ativo;
	    }

	    public Date getDataNascimento() {
	        return dataNascimento;
	    }

	    public void setDataNascimento(Date dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }

	    public Date getDataCadastro() {
	        return dataCadastro;
	    }

	    public void setDataCadastro(Date dataCadastro) {
	        this.dataCadastro = dataCadastro;
	    }
}
