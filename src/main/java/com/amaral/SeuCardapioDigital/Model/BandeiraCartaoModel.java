package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bandeiraCartao")
public class BandeiraCartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: VISA, MASTERCARD

    @Column(name = "codigoApi")
    private String codigoApi; // Identificador externo (ex: para integração futura)

    @Column(nullable = false)
    private boolean ativo;

    public BandeiraCartaoModel() {
    }

    public BandeiraCartaoModel(Long id, String nome, String codigoApi, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.codigoApi = codigoApi;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoApi() {
        return codigoApi;
    }

    public void setCodigoApi(String codigoApi) {
        this.codigoApi = codigoApi;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
