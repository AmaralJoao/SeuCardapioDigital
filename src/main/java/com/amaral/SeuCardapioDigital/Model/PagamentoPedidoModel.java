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
    @Column(name = "localPagamento", nullable = false)
    private LocalPagamentoEnum localPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdMetodoPagamento", nullable = false)
    private MetodoPagamentoModel metodoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdBandeiraCartao")
    private BandeiraCartaoModel bandeiraCartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdStatusPagamento", nullable = false)
    private StatusPagamentoModel statusPagamento;

    @Column(name = "dataHoraPagamento")
    private LocalDateTime dataHoraPagamento;

    @OneToOne
    @JoinColumn(name = "cdPedido", nullable = false)
    private PedidoModel pedido;

    public PagamentoPedidoModel() {
    }

    public PagamentoPedidoModel(Long id, LocalPagamentoEnum localPagamento, MetodoPagamentoModel metodoPagamento, BandeiraCartaoModel bandeiraCartao, StatusPagamentoModel statusPagamento, LocalDateTime dataHoraPagamento, PedidoModel pedido) {
        this.id = id;
        this.localPagamento = localPagamento;
        this.metodoPagamento = metodoPagamento;
        this.bandeiraCartao = bandeiraCartao;
        this.statusPagamento = statusPagamento;
        this.dataHoraPagamento = dataHoraPagamento;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalPagamentoEnum getLocalPagamento() {
        return localPagamento;
    }

    public void setLocalPagamento(LocalPagamentoEnum localPagamento) {
        this.localPagamento = localPagamento;
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

    public StatusPagamentoModel getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamentoModel statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }
}
