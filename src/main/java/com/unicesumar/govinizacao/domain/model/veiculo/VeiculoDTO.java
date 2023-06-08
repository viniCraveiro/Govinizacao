package com.unicesumar.govinizacao.domain.model.veiculo;

import jakarta.validation.constraints.NotBlank;

public class VeiculoDTO {

    public String id;

    @NotBlank
    public String placa;
    public String identificacao;
    public String quilometragem;
    public String renavam;
    public String chassi;
    public String cor;
    public String anoFabricacao;
    public String anoModelo;
    public String modelo;
    public String marca;
    public String tipoVeiculo;
    public String categoriaCnh;
    public String statusVeiculo;

    public VeiculoDTO() {

    }

    public VeiculoDTO(Veiculo entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.identificacao = entity.getIdentificacao();
        this.quilometragem = entity.getQuilometragem();
        this.renavam = entity.getRenavam();
        this.chassi = entity.getChassi();
        this.cor = entity.getCor();
        this.anoFabricacao = entity.getAnoFabricacao();
        this.anoModelo = entity.getAnoModelo();
        this.modelo = entity.getModelo();
        this.marca = entity.getMarca();
        this.tipoVeiculo = entity.getTipoVeiculo();
        this.categoriaCnh = entity.getCategoriaCnh();
        this.statusVeiculo = entity.getStatusVeiculo();
    }

    public VeiculoDTO(String id){
        this.id = id;
    }
}
