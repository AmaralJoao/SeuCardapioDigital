package com.amaral.SeuCardapioDigital.Dto.Response;

import java.math.BigDecimal;

public class ItemPedidoResponseDto {

    private Long id;
    private ProdutoResponseDto produto;
    private int quantidade;
    private BigDecimal precoUnitario;
    private String observacao;
}
