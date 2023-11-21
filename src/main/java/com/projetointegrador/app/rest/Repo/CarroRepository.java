package com.projetointegrador.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.app.rest.Models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}

