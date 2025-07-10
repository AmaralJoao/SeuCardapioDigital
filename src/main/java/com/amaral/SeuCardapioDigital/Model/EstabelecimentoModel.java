package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "estabelecimentos")
public class EstabelecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdEstabelecimento")
    private long id;

    @Column(name = "nmEstabelecimento", unique = true)
    private String nome;

    @Column(name = "emailEstabelecimento", unique = true)
    private String email;

    @Column(name = "senha", unique = true)
    private String senha;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "contatoEstabelecimento", unique = true)
    private String contato;

    public EstabelecimentoModel() {
    }

    public EstabelecimentoModel(long id, String nome, String email, String senha, String cnpj, String contato) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
