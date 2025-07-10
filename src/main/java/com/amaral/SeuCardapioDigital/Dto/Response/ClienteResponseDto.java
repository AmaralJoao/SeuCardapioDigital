package com.amaral.SeuCardapioDigital.Dto.Response;

public class ClienteResponseDto {

    private String nomeDocliente;

    private int ddd;

    private long telefone;

    public String getNomeDocliente() {
        return nomeDocliente;
    }

    public void setNomeDocliente(String nomeDocliente) {
        this.nomeDocliente = nomeDocliente;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
