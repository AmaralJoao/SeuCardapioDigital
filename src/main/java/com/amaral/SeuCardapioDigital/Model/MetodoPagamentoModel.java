package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "metodoPagamento")
public class MetodoPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: CREDITO, DEBITO, TICKET

    @Column
    private String descricao;

    @Column(nullable = false)
    private boolean ativo;

    public MetodoPagamentoModel() {
    }

    public MetodoPagamentoModel(Long id, String nome, String descricao, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

