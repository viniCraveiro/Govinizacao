package com.unicesumar.govinizacao.domain.model.veiculo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(String id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
    }

    public Veiculo edit(String id, Veiculo veiculo) {
        if (veiculoRepository.existsById(id)) {
            veiculo.setId(id);
            return veiculoRepository.save(veiculo);
        } else {
            return null;
        }
    }

    public void save(Veiculo veiculo) {
        this.veiculoRepository.save(veiculo);
    }

    public boolean remove(String id) {
        if (veiculoRepository.existsById(id)) {
            this.veiculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
