package com.unicesumar.govinizacao.domain.model.veiculo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "veiculo")
public class Veiculo {
    @Id
    private String id;

    private String placa;
    private String quilometragem;
    private String renavam;
    private String chassi;
    private String cor;
    private String ano;
    private String modelo;
    private String marca;
    private String tipoVeiculo;
    private String categoriaCnh;
    private String statusVeiculo;

    public Veiculo() {

    }

    public Veiculo(String id, String placa, String quilometragem, String renavam, String chassi, String cor,
                   String ano, String modelo, String marca, String tipoVeiculo, String categoriaCnh,
                   String statusVeiculo) {
        this.id = id;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.renavam = renavam;
        this.chassi = chassi;
        this.cor = cor;
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.categoriaCnh = categoriaCnh;
        this.statusVeiculo = statusVeiculo;
    }

    public String getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(String categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    public String getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(String statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
