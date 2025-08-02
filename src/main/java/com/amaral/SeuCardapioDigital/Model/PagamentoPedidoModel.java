package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "pagamentoPedido")
public class PagamentoPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idTipoPagamento; // 0 para pagamento no local, 1 para pagamento na estrega

    private FormaDePagamentoDoEstabelecimentoModel formaDePagamentoDoEstabelecimento;

    private Integer pagamentoRealizado; // 0 para não realizado, 1 para realizado

    private LocalTime dataConfirmaçãoPagamento;
}
