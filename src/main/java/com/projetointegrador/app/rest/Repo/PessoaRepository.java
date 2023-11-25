package com.projetointegrador.app.rest.Repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.app.rest.Models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	//Pessoa findByLogin(String login);
	
	Pessoa findByLoginAndSenha(String login, String senha);
	
	Pessoa findByLoginAndDataNasc(String login, Date dataNasc);
}
