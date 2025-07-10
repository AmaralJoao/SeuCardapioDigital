package com.amaral.SeuCardapioDigital.Dto.Request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class ClienteRequestDto {

    @NotNull(message = "nome é obrigatorio")
    private String nomeDocliente;
    @NotNull(message = "ddd é obrigadtorio")
    private int ddd;
    @NotNull(message = "telefone é obrigadtorio")
    private String telefone;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
