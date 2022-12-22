package com.github.nogueiralegacy.ordenacao.domain;

public enum Genero {
    M("Male"),
    F("Female");

    final String genero;
    Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
