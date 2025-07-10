package com.amaral.SeuCardapioDigital.Dto.Response;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ProdutoResponseDto {

    private long id;

    private String nomeDoProduto;

    private String descricaoDoPoduto;

    private BigDecimal preco;

    private String srcImagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getDescricaoDoPoduto() {
        return descricaoDoPoduto;
    }

    public void setDescricaoDoPoduto(String descricaoDoPoduto) {
        this.descricaoDoPoduto = descricaoDoPoduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSrcImagem() {
        return srcImagem;
    }

    public void setSrcImagem(String srcImagem) {
        this.srcImagem = srcImagem;
    }
}
