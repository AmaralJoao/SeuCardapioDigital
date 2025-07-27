package com.amaral.SeuCardapioDigital.Model;

import com.amaral.SeuCardapioDigital.Enum.StatusPedidoEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdPedido")
    private long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemPedidoModel> itemDoPedido;

    @OneToOne
    @JoinColumn(name = "cdCliente", nullable = false)
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "cdEstabelecimento", nullable = false)
    private EstabelecimentoModel estabelecimento;

    @Column(name = "codigoDoPedido", unique = true)
    private Long codigoDoPedido;

    @Column(name = "dataHoraDoPedido", nullable = false)
    private LocalDateTime dataHoraDoPedido;

    @Column(name = "idStatus", nullable = false)
    private StatusPedidoEnum status;

    @Column(name = "valorTotalDoPedido", nullable = false)
    private BigDecimal valorTotalDoPedido;

    public PedidoModel() {
    }

    public PedidoModel(long id, List<ItemPedidoModel> itemDoPedido, ClienteModel cliente, EstabelecimentoModel estabelecimento, Long codigoDoPedido, LocalDateTime dataHoraDoPedido, StatusPedidoEnum status, BigDecimal valorTotalDoPedido) {
        this.id = id;
        this.itemDoPedido = itemDoPedido;
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.codigoDoPedido = codigoDoPedido;
        this.dataHoraDoPedido = dataHoraDoPedido;
        this.status = status;
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItemPedidoModel> getItemDoPedido() {
        return itemDoPedido;
    }

    public void setItemDoPedido(List<ItemPedidoModel> itemDoPedido) {
        this.itemDoPedido = itemDoPedido;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Long getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(Long codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
    }

    public LocalDateTime getDataHoraDoPedido() {
        return dataHoraDoPedido;
    }

    public void setDataHoraDoPedido(LocalDateTime dataHoraDoPedido) {
        this.dataHoraDoPedido = dataHoraDoPedido;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public BigDecimal getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }
}
