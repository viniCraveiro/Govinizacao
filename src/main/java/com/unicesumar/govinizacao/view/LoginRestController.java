package com.unicesumar.govinizacao.view;

import com.unicesumar.govinizacao.domain.model.auth.LoginDTO;
import com.unicesumar.govinizacao.domain.model.usuario.Usuario;
import com.unicesumar.govinizacao.domain.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/login")
public class LoginRestController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public boolean login(@RequestBody LoginDTO login) {
        Usuario usuario = usuarioService.findByCpf(login.cpf);
        return usuario.getSenha().equals(login.senha);
    }

}
