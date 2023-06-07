package com.unicesumar.govinizacao.view;

import com.unicesumar.govinizacao.domain.model.usuario.UsuarioRepository;
import com.unicesumar.govinizacao.domain.model.usuario.UsuarioService;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v0/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    UsuarioRepository usuarioRepository;

    public UsuarioRestController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> listUsuarios() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("usuarios", usuarioService.findAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("usuario", usuarioService.findById(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
