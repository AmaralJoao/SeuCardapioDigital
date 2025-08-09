package com.amaral.SeuCardapioDigital.Dto.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequestDto {
    @NotNull(message = "Cliente é obrigatório")
    private ClienteRequestDto cliente;

    @NotNull(message = "ID do estabelecimento é obrigatório")
    private Long idEstabelecimento;

    @NotEmpty(message = "O pedido deve conter ao menos um item")
    @Valid
    private List<ItemPedidoRequestDto> itens;

    @NotNull(message = "Informações de pagamento são obrigatórias")
    @Valid
    private PagamentoRequestDto pagamento;

    @NotNull(message = "Informações de entrega são obrigatórias")
    @Valid
    private EntregaPedidoRequestDto entrega;

    public ClienteRequestDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequestDto cliente) {
        this.cliente = cliente;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public List<ItemPedidoRequestDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoRequestDto> itens) {
        this.itens = itens;
    }

    public PagamentoRequestDto getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoRequestDto pagamento) {
        this.pagamento = pagamento;
    }

    public EntregaPedidoRequestDto getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaPedidoRequestDto entrega) {
        this.entrega = entrega;
    }
}
