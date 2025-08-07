package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartoes")
public class CartaoModel {

    private long id;

    private String nome;

    private String banceira;

    private String tipoCartao;






}
