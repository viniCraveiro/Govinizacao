package com.unicesumar.govinizacao.domain.model.veiculo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            return veiculoRepository.save(veiculo);
        } else {
            return null;
        }
    }

    public Veiculo save(Veiculo veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    public boolean remove(String id) {
        if (veiculoRepository.existsById(id)) {
            this.veiculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Veiculo> verifyDisponible() {
        ArrayList<Veiculo> disponiveis = new ArrayList<>();
        List<Veiculo> veiculoList = veiculoRepository.findAll();
        for (Veiculo veiculo : veiculoList) {
            if (veiculo.getStatusVeiculo().equals("Disponivel")) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }

}
