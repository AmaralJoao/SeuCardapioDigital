package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdProduto")
    private long id;

    @Column(name = "nmProduto")
    private String nomeDoProduto;

    @Column(name = "dsProduto")
    private String descricaoDoPoduto;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "srcImagem")
    private String srcImagem;

    @ManyToOne
    @JoinColumn(name = "cdEstabelecimento", nullable = false)
    private EstabelecimentoModel estabelecimento;

    public ProdutoModel() {
    }

    public ProdutoModel(long id, String nomeDoProduto, String descricaoDoPoduto, BigDecimal preco, String srcImagem, EstabelecimentoModel estabelecimento) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.descricaoDoPoduto = descricaoDoPoduto;
        this.preco = preco;
        this.srcImagem = srcImagem;
        this.estabelecimento = estabelecimento;
    }

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

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
