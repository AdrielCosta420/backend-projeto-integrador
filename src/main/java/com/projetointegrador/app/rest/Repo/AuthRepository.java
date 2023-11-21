package com.projetointegrador.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetointegrador.app.rest.Models.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long> {

}
