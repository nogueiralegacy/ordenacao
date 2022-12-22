package com.github.nogueiralegacy.ordenacao.domain;

import java.util.Arrays;

public class MergeSort {
    static public void ordena(Funcionario[] funcionarios, int tamanho, Performance performance) {
        if (tamanho == funcionarios.length) {
            performance.setTempoInicio(System.currentTimeMillis());
        }
        if (tamanho < 2) {
            return;
        }

        int metade = tamanho / 2;
        Funcionario[] esquerda = Arrays
                .copyOfRange(funcionarios, 0, metade);
        Funcionario[] direita = Arrays
                .copyOfRange(funcionarios, metade, funcionarios.length);

        ordena(direita, tamanho - metade, performance);
        ordena(esquerda, metade, performance);

        merge(funcionarios, esquerda, direita, metade, tamanho - metade, performance);
        if (tamanho == funcionarios.length) {
            performance.setTempoFinal(System.currentTimeMillis());
        }
    }

    static public void merge(Funcionario[] funcionarios, Funcionario[] esquerda, Funcionario[] direita, int tamanhoEsquerda, int tamanhoDireita, Performance performance) {
        int indiceDireta = 0;
        int indiceEsquerda = 0;
        int indiceFuncionarios = 0;

        while (indiceEsquerda < tamanhoEsquerda && indiceDireta < tamanhoDireita) {
            String nomeEsquerda = esquerda[indiceEsquerda].getPrimeiroNome();
            String nomeDireita = direita[indiceDireta].getPrimeiroNome();

            performance.setQntComparacao(performance.getQntComparacao() + 1);
            performance.setQntMovimentacao(performance.getQntMovimentacao() + 1);

            if (nomeEsquerda.compareTo(nomeDireita) <= 0) {
                funcionarios[indiceFuncionarios++] = esquerda[indiceEsquerda++];
            } else {
                funcionarios[indiceFuncionarios++] = direita[indiceDireta++];
            }
        }
        while (indiceEsquerda < tamanhoEsquerda) {
            performance.setQntMovimentacao(performance.getQntMovimentacao() + 1);
            funcionarios[indiceFuncionarios++] = esquerda[indiceEsquerda++];
        }
        while (indiceDireta < tamanhoDireita) {
            performance.setQntMovimentacao(performance.getQntMovimentacao() + 1);
            funcionarios[indiceFuncionarios++] = direita[indiceDireta++];
        }
    }
}
