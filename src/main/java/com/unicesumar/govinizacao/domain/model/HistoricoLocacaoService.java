package com.unicesumar.govinizacao.domain.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoLocacaoService {
    HistoricoLocacaoRepository historicoLocacaoRepository;

    public HistoricoLocacaoService(HistoricoLocacaoRepository historicoLocacaoRepository) {
        this.historicoLocacaoRepository = historicoLocacaoRepository;
    }

    public HistoricoLocacao findById(String id) {
        return historicoLocacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Locacao não encontrada."));
    }

    public List<HistoricoLocacao> findAll() {
        return historicoLocacaoRepository.findAll();
    }

    public HistoricoLocacao save(HistoricoLocacao historicoLocacao){
        return historicoLocacaoRepository.save(historicoLocacao);
    }

}
