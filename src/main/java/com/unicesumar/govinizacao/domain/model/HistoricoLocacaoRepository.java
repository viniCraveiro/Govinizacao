package com.unicesumar.govinizacao.domain.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoLocacaoRepository extends MongoRepository<HistoricoLocacao, String> {
}
