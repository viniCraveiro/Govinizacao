package com.unicesumar.govinizacao.domain.model.veiculo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
}
