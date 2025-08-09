package com.amaral.SeuCardapioDigital.Dto.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EntregaPedidoRequestDto {

    @NotNull(message = "Tipo de entrega é obrigatório")
    private Long tipoEntrega; // 0 = Retirada no local, 1 = Entrega a domicílio

    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;

    /**
     * Regra condicional:
     * - Se tipoEntrega == 0 (retirada no local): demais campos não são obrigatórios.
     * - Se tipoEntrega == 1 (entrega a domicílio): endereço, número, bairro e CEP são obrigatórios.
     */
    @AssertTrue(message = "Para entrega a domicílio, endereço, número, bairro e CEP devem ser informados corretamente")
    @JsonIgnore // evita expor no JSON da API
    public boolean isCamposValidosParaEntrega() {
        if (tipoEntrega == null || tipoEntrega == 0) {
            return true; // retirada no local — sem obrigatoriedade
        }

        // Valida obrigatoriedade
        boolean camposPreenchidos =
                endereco != null && !endereco.isBlank() &&
                        numero   != null && !numero.isBlank() &&
                        bairro   != null && !bairro.isBlank() &&
                        cep      != null && cep.matches("\\d{5}-\\d{3}");

        return camposPreenchidos;
    }

    // Getters e Setters
    public Long getTipoEntrega() { return tipoEntrega; }
    public void setTipoEntrega(Long tipoEntrega) { this.tipoEntrega = tipoEntrega; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
