package com.unicesumar.govinizacao.view;

import com.unicesumar.govinizacao.domain.model.HistoricoLocacao;
import com.unicesumar.govinizacao.domain.model.HistoricoLocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/locacao")
public class HistoricoLocacaoRestController {
    @Autowired
    HistoricoLocacaoService historicoLocacaoService;

    @Autowired
    MongoOperations mongoOperations;

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
        map.put("ocorrencia", historicoLocacao.getOcorrencia());
        map.put("observacao", historicoLocacao.getObservacao());
        return map;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable String id) {
        return new ResponseEntity<>(convertToMap(historicoLocacaoService.findById(id)), HttpStatus.OK);
    }
}
