package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bandeira_cartao")
public class BandeiraCartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: VISA, MASTERCARD

    @Column(name = "codigo_api")
    private String codigoApi; // Identificador externo (ex: para integração futura)

    @Column(nullable = false)
    private boolean ativo;

    // Getters, Setters, equals, hashCode
}
