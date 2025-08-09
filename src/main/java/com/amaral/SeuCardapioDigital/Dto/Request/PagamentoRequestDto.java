package com.amaral.SeuCardapioDigital.Dto.Request;

import jakarta.validation.constraints.NotNull;

public class PagamentoRequestDto {

    @NotNull(message = "Local do pagamento é obrigatório")
    private String localPagamento; // Enum: ESTABELECIMENTO, ENTREGA, APLICACAO

    @NotNull(message = "Método de pagamento é obrigatório")
    private Long idMetodoPagamento; // FK para MetodoPagamentoModel

    @NotNull(message = "Bandeira do cartão é obrigatória")
    private Long idBandeiraCartao; // FK para BandeiraCartaoModel

    public String getLocalPagamento() {
        return localPagamento;
    }

    public void setLocalPagamento(String localPagamento) {
        this.localPagamento = localPagamento;
    }

    public Long getIdMetodoPagamento() {
        return idMetodoPagamento;
    }

    public void setIdMetodoPagamento(Long idMetodoPagamento) {
        this.idMetodoPagamento = idMetodoPagamento;
    }

    public Long getIdBandeiraCartao() {
        return idBandeiraCartao;
    }

    public void setIdBandeiraCartao(Long idBandeiraCartao) {
        this.idBandeiraCartao = idBandeiraCartao;
    }
}
