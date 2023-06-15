package com.unicesumar.govinizacao.view;

import com.unicesumar.govinizacao.domain.model.HistoricoLocacao;
import com.unicesumar.govinizacao.domain.model.HistoricoLocacaoService;
import com.unicesumar.govinizacao.domain.model.usuario.Usuario;
import com.unicesumar.govinizacao.domain.model.usuario.UsuarioService;
import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v0/locacao")
public class HistoricoLocacaoRestController {
    @Autowired
    HistoricoLocacaoService historicoLocacaoService;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Map<String, Object>>> listLocacao() {
        List<HistoricoLocacao> historico = mongoOperations.findAll(HistoricoLocacao.class);
        return new ResponseEntity<>(historico.stream().map(this::convertToMap).toList(), HttpStatus.OK);
    }

    private Map<String, Object> convertToMap(HistoricoLocacao historicoLocacao) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", historicoLocacao.getId());
        map.put("usuario", historicoLocacao.getUsuario());
        map.put("veiculo", historicoLocacao.getVeiculo());
        map.put("dataLocacao", historicoLocacao.getDataLocacao());
        map.put("dataDevolucao", historicoLocacao.getDataDevolucao());
        return map;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable String id) {
        return new ResponseEntity<>(convertToMap(historicoLocacaoService.findById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<HistoricoLocacao> agendar(@RequestBody HistoricoLocacao agendamento) {
        Usuario usuario = usuarioService.findById(agendamento.getUsuario().getId());
        Veiculo veiculo = veiculoService.findById(agendamento.getVeiculo().getId());
        if (veiculo != null && usuario != null) {
            HistoricoLocacao historicoLocacao = new HistoricoLocacao();
            historicoLocacao.setUsuario(usuario);
            historicoLocacao.setVeiculo(veiculo);
            historicoLocacao.setDataLocacao(agendamento.getDataLocacao());
            historicoLocacao.setDataDevolucao(agendamento.getDataDevolucao());
            HistoricoLocacao saved = historicoLocacaoService.save(historicoLocacao);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
