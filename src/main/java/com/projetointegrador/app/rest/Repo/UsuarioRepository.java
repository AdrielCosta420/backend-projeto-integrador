package com.projetointegrador.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetointegrador.app.rest.Models.Usuario;

import jakarta.transaction.Transactional;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByLogin(String login);
	
	Usuario findByLoginAndSenha(String login, String senha);
	

}
