package com.unicesumar.govinizacao.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoDTO;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoListDTO;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<VeiculoListDTO> dto = list.stream().map(VeiculoListDTO::new).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(new VeiculoDTO(veiculoService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/disponivel")
    public ResponseEntity<List<VeiculoDTO>> findDisponivel() {
        return new ResponseEntity<>(veiculoService.verifyDisponible().stream().map(VeiculoDTO::new).toList(), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.placa);
        veiculo.setQuilometragem(dto.quilometragem);
        veiculo.setRenavam(dto.renavam);
        veiculo.setChassi(dto.chassi);
        veiculo.setCor(dto.cor);
        veiculo.setAno(dto.ano);
        veiculo.setModelo(dto.modelo);
        veiculo.setMarca(dto.marca);
        veiculo.setTipoVeiculo(dto.tipoVeiculo);
        veiculo.setCategoriaCnh(dto.categoriaCnh);
        veiculo.setStatusVeiculo(dto.statusVeiculo);
        Veiculo saved = veiculoService.save(veiculo);
        return new ResponseEntity<>(new VeiculoDTO(saved), HttpStatus.CREATED);
    }


}
