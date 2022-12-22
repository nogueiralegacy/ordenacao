package com.github.nogueiralegacy.ordenacao.domain;

import java.util.Objects;

public class Funcionario {
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private Genero genero;
    private String ip;

    public Funcionario(String primeiroNome, String ultimoNome, String email, String genero, String ip) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.genero = Genero.valueOf(genero);
        this.ip = ip;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return primeiroNome.equals(that.primeiroNome) && ultimoNome.equals(that.ultimoNome) && email.equals(that.email) && genero == that.genero && ip.equals(that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiroNome, ultimoNome, email, genero, ip);
    }
}
