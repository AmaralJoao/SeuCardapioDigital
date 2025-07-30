package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "LocalEstabelecimento")
public class LocalEstabelecimentoModel {

    private long id;

    private String cep;

    private String estado;

    private String cidade;

    private String rua;

    private String complemento;

    private String latitude;

    private String longitude;

    @OneToOne
    @JoinColumn(name = "cdEstabelecimento", nullable = false)
    private EstabelecimentoModel estabelecimento;
}
