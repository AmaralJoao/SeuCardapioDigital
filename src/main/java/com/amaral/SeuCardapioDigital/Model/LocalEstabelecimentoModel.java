package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "LocalEstabelecimento")
public class LocalEstabelecimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdLocalEstabelecimento")
    private long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "rua")
    private String rua;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "nrLatitude")
    private String latitude;

    @Column(name = "nrLongitude")
    private String longitude;

    @OneToOne
    @JoinColumn(name = "cdEstabelecimento", nullable = false)
    private EstabelecimentoModel estabelecimento;

    public LocalEstabelecimentoModel() {
    }

    public LocalEstabelecimentoModel(long id, String cep, String estado, String cidade, String rua, String complemento, String latitude, String longitude, EstabelecimentoModel estabelecimento) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.complemento = complemento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.estabelecimento = estabelecimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
