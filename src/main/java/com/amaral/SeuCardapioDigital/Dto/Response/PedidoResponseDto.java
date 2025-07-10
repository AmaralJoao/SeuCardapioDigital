package com.amaral.SeuCardapioDigital.Dto.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDto {

    private Long id;
    private LocalDateTime dataHoraDoPedido;
    private int status;
    private BigDecimal valorTotalDoPedido;
    private Integer codigoPedido;
    private ClienteResponseDto cliente;
    private EstabelecimentoResponseDto estabelecimento;

    private List<ItemPedidoResponseDto> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraDoPedido() {
        return dataHoraDoPedido;
    }

    public void setDataHoraDoPedido(LocalDateTime dataHoraDoPedido) {
        this.dataHoraDoPedido = dataHoraDoPedido;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public ClienteResponseDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponseDto cliente) {
        this.cliente = cliente;
    }

    public EstabelecimentoResponseDto getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoResponseDto estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public List<ItemPedidoResponseDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoResponseDto> itens) {
        this.itens = itens;
    }
}
