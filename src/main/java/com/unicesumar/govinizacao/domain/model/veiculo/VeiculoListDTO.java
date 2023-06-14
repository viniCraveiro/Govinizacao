package com.unicesumar.govinizacao.domain.model.veiculo;

public class VeiculoListDTO {

    public String id;

    public String placa;
    public String cor;
    public String modelo;
    public String marca;
    public String ano;
    public String statusVeiculo;

    public VeiculoListDTO() {

    }

    public VeiculoListDTO(Veiculo entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.cor = entity.getCor();
        this.modelo = entity.getModelo();
        this.marca = entity.getMarca();
        this.ano = entity.getAno();
        this.statusVeiculo = entity.getStatusVeiculo();
    }

    public VeiculoListDTO(String id) {
        this.id = id;
    }

}
