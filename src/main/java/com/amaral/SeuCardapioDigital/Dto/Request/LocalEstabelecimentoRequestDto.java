package com.amaral.SeuCardapioDigital.Dto.Request;

public class LocalEstabelecimentoRequestDto {

    private Long cdEstabelecimento;

    private String cep;

    private String estado;

    private String cidade;

    private String rua;

    private String complemento;

    private String latitude;

    private String longitude;

    public Long getCdEstabelecimento() {
        return cdEstabelecimento;
    }

    public void setCdEstabelecimento(Long cdEstabelecimento) {
        this.cdEstabelecimento = cdEstabelecimento;
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
}
