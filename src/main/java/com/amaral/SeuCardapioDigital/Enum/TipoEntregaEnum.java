package com.amaral.SeuCardapioDigital.Enum;

public enum TipoEntregaEnum {
    RETIRADA_NO_LOCAL(0),
    ENTREGA_DOMICILIO(1);

    private int valor;

    private TipoEntregaEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
