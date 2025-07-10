package com.amaral.SeuCardapioDigital.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
public class SessaoModel {

    @Id
    private String token; // UUID como chave primária

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdEstabelecimento")
    private EstabelecimentoModel estabelecimento;

    private LocalDateTime criadaEm;

    private LocalDateTime expiraEm;

    private boolean ativa;

    private String ip;

    private String userAgent;

    public SessaoModel() {
    }

    public SessaoModel(String token, EstabelecimentoModel estabelecimento, LocalDateTime criadaEm, LocalDateTime expiraEm, boolean ativa, String ip, String userAgent) {
        this.token = token;
        this.estabelecimento = estabelecimento;
        this.criadaEm = criadaEm;
        this.expiraEm = expiraEm;
        this.ativa = ativa;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    public LocalDateTime getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDateTime expiraEm) {
        this.expiraEm = expiraEm;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
