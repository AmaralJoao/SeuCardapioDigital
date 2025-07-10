package com.amaral.SeuCardapioDigital.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itemPedido")
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pedido", nullable = false)
    @JsonBackReference
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "produto", nullable = false)
    private ProdutoModel produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "precoUnitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    public ItemPedidoModel() {
    }

    public ItemPedidoModel(long id, PedidoModel pedido, ProdutoModel produto, int quantidade, BigDecimal precoUnitario, String observacao) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.observacao = observacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
