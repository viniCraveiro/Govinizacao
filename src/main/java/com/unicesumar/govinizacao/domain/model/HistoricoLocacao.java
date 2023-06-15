package com.unicesumar.govinizacao.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicesumar.govinizacao.domain.model.usuario.Usuario;
import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
import com.unicesumar.govinizacao.domain.model.veiculo.VeiculoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "historicoLocacao")
public class HistoricoLocacao {
    @Id
    private String id;

    @Field("usuario")
    @DBRef
    private Usuario usuario;

    @Field("veiculo")
    @DBRef
    private Veiculo veiculo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date dataLocacao;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private Date dataDevolucao;

    public HistoricoLocacao() {
    }

    public HistoricoLocacao(Usuario usuario, Veiculo veiculo, Date dataLocacao, Date dataDevolucao) {
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
