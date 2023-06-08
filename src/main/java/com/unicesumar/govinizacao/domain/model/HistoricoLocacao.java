package com.unicesumar.govinizacao.domain.model;


import com.unicesumar.govinizacao.domain.model.usuario.Usuario;
import com.unicesumar.govinizacao.domain.model.veiculo.Veiculo;
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
    private String usuario;

    @Field("veiculo")
    @DBRef
    private String veiculo;

    private Date dataLocacao;

    private Date dataDevolucao;

    private String ocorrencia;

    private String observacao;

    public HistoricoLocacao() {
    }

    public HistoricoLocacao(String usuario, String veiculo, Date dataLocacao, Date dataDevolucao, String ocorrencia, String observacao) {
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.ocorrencia = ocorrencia;
        this.observacao = observacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
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

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
