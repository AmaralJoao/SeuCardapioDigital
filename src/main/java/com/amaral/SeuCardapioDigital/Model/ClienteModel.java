package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdCliente")
    private long id;

    @Column(name = "nmCliente")
    private String nomeDocliente;

    @Column(name = "ddd")
    private int ddd;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoModel> pedidos;

    public ClienteModel() {
    }

    public ClienteModel(long id, String nomeDocliente, int ddd, String telefone) {
        this.id = id;
        this.nomeDocliente = nomeDocliente;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
