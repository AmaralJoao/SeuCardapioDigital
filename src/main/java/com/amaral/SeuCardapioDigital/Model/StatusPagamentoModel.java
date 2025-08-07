package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "status_pagamento")
public class StatusPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String status; // Ex: PENDENTE, REALIZADO

    @Column
    private String descricao;

    @Column(name = "ordem_exibicao")
    private int ordem;

    @Column(name = "finaliza_pedido", nullable = false)
    private boolean finalizaPedido;

    // Getters, Setters, equals, hashCode
}
