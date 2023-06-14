package com.unicesumar.govinizacao.domain.model.usuario;

import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElseThrow(()->new IllegalArgumentException("Usuario nao existe !"));
    }
}
