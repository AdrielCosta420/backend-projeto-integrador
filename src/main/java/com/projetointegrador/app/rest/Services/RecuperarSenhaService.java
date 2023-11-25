package com.projetointegrador.app.rest.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.app.rest.Models.Pessoa;
import com.projetointegrador.app.rest.Repo.PessoaRepository;

@Service
public class RecuperarSenhaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public String recuperarSenha(String login, Date dataNasc) {
        Pessoa pessoa = pessoaRepository.findByLoginAndDataNasc(login, dataNasc);
        return pessoa != null ? pessoa.getSenha() : null;
    }
}
