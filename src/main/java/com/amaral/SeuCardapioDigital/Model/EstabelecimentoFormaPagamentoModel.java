package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estabelecimentoFormaPagamento"/*, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"estabelecimento_id", "metodo_pagamento_id", "bandeira_cartao_id"})
}*/)
public class EstabelecimentoFormaPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private EstabelecimentoModel estabelecimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pagamento_id", nullable = false)
    private MetodoPagamentoModel metodoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bandeira_cartao_id", nullable = false)
    private BandeiraCartaoModel bandeiraCartao;

    @Column(nullable = false)
    private boolean ativo;

    // Getters, Setters, equals, hashCode
}
