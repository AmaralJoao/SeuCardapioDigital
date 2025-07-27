package com.amaral.SeuCardapioDigital.Dto.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoRequestDto {
    @NotNull(message = "ID do cliente é obrigatório")
    private Long idCliente;

    @NotNull(message = "ID do estabelecimento é obrigatório")
    private Long idEstabelecimento;

    @NotEmpty(message = "O pedido deve conter ao menos um item")
    private List<ItemPedidoRequestDto> itens;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
}
