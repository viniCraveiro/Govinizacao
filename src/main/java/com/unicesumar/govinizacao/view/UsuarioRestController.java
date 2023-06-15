package com.unicesumar.govinizacao.view;

import com.unicesumar.govinizacao.domain.model.usuario.Usuario;
import com.unicesumar.govinizacao.domain.model.usuario.UsuarioRepository;
import com.unicesumar.govinizacao.domain.model.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    UsuarioRepository usuarioRepository;

    public UsuarioRestController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listUsuarios() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable String id) {
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario user = new Usuario();
        user.setNome(usuario.getNome());
        user.setCnh(usuario.getCnh());
        user.setClassificacao(usuario.getClassificacao());
        user.setStatus(usuario.getStatus());
        user.setSenha(usuario.getSenha());
        Usuario saved = usuarioService.save(usuario);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
