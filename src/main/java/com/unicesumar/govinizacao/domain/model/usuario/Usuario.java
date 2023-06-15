package com.unicesumar.govinizacao.domain.model.usuario;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;

    private String nome;
    private String cpf;
    private String senha;
    private String status = "ATIVO";
    private String classificacao;
    private List<String> cnh;

    public Usuario() {
    }

    public Usuario(String id){
        this.id = id;
    }

    public Usuario(String id, String nome, String cpf, String senha, String status, String classificacao, List<String> cnh) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.status = status;
        this.classificacao = classificacao;
        this.cnh = cnh;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<String> getCnh() {
        return cnh;
    }

    public void setCnh(List<String> cnh) {
        this.cnh = cnh;
    }
}
