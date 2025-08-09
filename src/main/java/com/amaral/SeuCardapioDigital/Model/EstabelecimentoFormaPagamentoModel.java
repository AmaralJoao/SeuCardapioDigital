package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estabelecimentoFormaPagamento"/*, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"estabelecimento_id", "metodo_pagamento_id", "bandeira_cartao_id"})
}*/)
public class EstabelecimentoFormaPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdEstabelecimentoFormaPagamento")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdEstabelecimento", nullable = false)
    private EstabelecimentoModel estabelecimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMetodoPagamento", nullable = false)
    private MetodoPagamentoModel metodoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdBandeiraCartao", nullable = false)
    private BandeiraCartaoModel bandeiraCartao;

    @Column(nullable = false)
    private boolean ativo;

    public EstabelecimentoFormaPagamentoModel() {
    }

    public EstabelecimentoFormaPagamentoModel(Long id, EstabelecimentoModel estabelecimento, MetodoPagamentoModel metodoPagamento, BandeiraCartaoModel bandeiraCartao, boolean ativo) {
        this.id = id;
        this.estabelecimento = estabelecimento;
        this.metodoPagamento = metodoPagamento;
        this.bandeiraCartao = bandeiraCartao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public MetodoPagamentoModel getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamentoModel metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public BandeiraCartaoModel getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartaoModel bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
