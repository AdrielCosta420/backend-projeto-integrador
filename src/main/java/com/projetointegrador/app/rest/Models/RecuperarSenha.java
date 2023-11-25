package com.projetointegrador.app.rest.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecuperarSenha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String login;
	
	@Column
	private Date dataNasc;
	
	public RecuperarSenha() {}
	

	public RecuperarSenha(String login, Date dataNasc) {
		super();
		this.login = login;
		this.dataNasc = dataNasc;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setdataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
