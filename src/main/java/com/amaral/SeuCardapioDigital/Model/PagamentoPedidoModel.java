package com.amaral.SeuCardapioDigital.Model;

import com.amaral.SeuCardapioDigital.Enum.LocalPagamentoEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentoPedido")
public class PagamentoPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "local_pagamento", nullable = false)
    private LocalPagamentoEnum localPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pagamento_id", nullable = false)
    private MetodoPagamentoModel metodoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bandeira_cartao_id")
    private BandeiraCartaoModel bandeiraCartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_pagamento_id", nullable = false)
    private StatusPagamentoModel statusPagamento;

    @Column(name = "data_hora_pagamento")
    private LocalDateTime dataHoraPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoModel pedido;

    // Getters, Setters, equals, hashCode
}
