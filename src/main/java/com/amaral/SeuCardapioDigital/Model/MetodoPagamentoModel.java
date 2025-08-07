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

}

