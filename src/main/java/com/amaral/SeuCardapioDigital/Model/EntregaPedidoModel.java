package com.amaral.SeuCardapioDigital.Model;

import com.amaral.SeuCardapioDigital.Enum.TipoEntregaEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "entregaPedido")
public class EntregaPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdEntregaPedido")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEntrega", nullable = false)
    private TipoEntregaEnum tipoEntrega;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "numero", length = 20)
    private String numero;

    @Column(name = "bairro", length = 100)
    private String bairro;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "cep", length = 10)
    private String cep;

    @OneToOne
    @JoinColumn(name = "cdPedido", nullable = false)
    private PedidoModel pedido;

    public EntregaPedidoModel() {
    }

    public EntregaPedidoModel(Long id, TipoEntregaEnum tipoEntrega, String endereco, String numero, String bairro, String complemento, String cep, PedidoModel pedido) {
        this.id = id;
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEntregaEnum getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntregaEnum tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }
}
