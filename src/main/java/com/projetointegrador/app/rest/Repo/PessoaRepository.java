package com.projetointegrador.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.app.rest.Models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
