package com.amaral.SeuCardapioDigital.Enum;

public enum StatusPedidoEnum {
    pedidoCriado(0),
    aguardandoPagamento(1),
    validacaoDoEstabelecimento(2),
    emPreparacao(3),
    saiuParaEntra(4),
    concluido(5),
    cancelado(6);

    private int valor;

    private StatusPedidoEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
