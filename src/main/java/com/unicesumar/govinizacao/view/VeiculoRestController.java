package com.unicesumar.govinizacao.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoDTO;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoListDTO;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/veiculo")
public class VeiculoRestController {
    @Autowired
    VeiculoService veiculoService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping()
    public ResponseEntity<List<VeiculoListDTO>> listVeiculos() {
        List<Veiculo> list = veiculoService.findAll();
        List<VeiculoListDTO> dto = list.stream().map(VeiculoListDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(new VeiculoDTO(veiculoService.findById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<VeiculoDTO> save(@RequestBody @Valid VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.placa);
        veiculo.setIdentificacao(dto.identificacao);
        veiculo.setQuilometragem(dto.quilometragem);
        veiculo.setRenavam(dto.renavam);
        veiculo.setChassi(dto.chassi);
        veiculo.setCor(dto.cor);
        veiculo.setAnoFabricacao(dto.anoFabricacao);
        veiculo.setAnoModelo(dto.anoModelo);
        veiculo.setModelo(dto.modelo);
        veiculo.setMarca(dto.marca);
        veiculo.setTipoVeiculo(dto.tipoVeiculo);
        veiculo.setCategoriaCnh(dto.categoriaCnh);
        veiculo.setStatusVeiculo(dto.statusVeiculo);
        Veiculo saved = veiculoService.save(veiculo);
        return new ResponseEntity<>(new VeiculoDTO(saved), HttpStatus.CREATED);
    }


}
