package com.unicesumar.govinizacao.domain.model.usuario;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;

    private String nome;
    private String identificacao;
    private String senha;
    private String status;
    private String classificacao;

    public Usuario() {
    }

    public Usuario(String id, String nome, String identificacao, String senha, String status, String classificacao) {
        this.id = id;
        this.nome = nome;
        this.identificacao = identificacao;
        this.senha = senha;
        this.status = status;
        this.classificacao = classificacao;
    }

    public String getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
