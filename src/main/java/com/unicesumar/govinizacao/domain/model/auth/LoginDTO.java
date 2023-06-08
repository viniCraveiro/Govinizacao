package com.unicesumar.govinizacao.domain.model.auth;

import com.unicesumar.govinizacao.domain.model.usuario.Usuario;

public class LoginDTO {
    public String cpf;
    public String senha;

    public LoginDTO() {
    }

    public LoginDTO(Usuario entity) {
        this.cpf = entity.getCpf();
        this.senha = entity.getSenha();
    }
}
