package com.unicesumar.govinizacao.domain.model.veiculo;

import java.util.List;

public class VeiculoListDTO {

    public String id;

    public String placa;
    public String identificacao;
    public String cor;
    public String modelo;
    public String marca;
    public String statusVeiculo;

    public VeiculoListDTO() {

    }

    public VeiculoListDTO(Veiculo entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.identificacao = entity.getIdentificacao();
        this.cor = entity.getCor();
        this.modelo = entity.getModelo();
        this.marca = entity.getMarca();
        this.statusVeiculo = entity.getStatusVeiculo();
    }

    public VeiculoListDTO(String id){
        this.id = id;
    }

}
