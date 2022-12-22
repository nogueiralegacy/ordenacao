package com.github.nogueiralegacy.ordenacao.domain;

public class SelectionSort {
    static public Performance ordena(Funcionario[] funcionarios) {
        long timeStart = System.currentTimeMillis();
        int qntComparacao = 0;
        int qntMocimentacao = 0;

        for (int corrente = 0; corrente < funcionarios.length - 1; corrente++) {
            for (int indice = 0; indice < funcionarios.length - (corrente + 1); indice++) {
                String name1 = funcionarios[indice].getPrimeiroNome();
                String name2 = funcionarios[indice + 1].getPrimeiroNome();
                qntComparacao++;
                if (name1.compareTo(name2) > 0) {
                    qntMocimentacao++;
                    Funcionario auxiliar = funcionarios[indice + 1];
                    funcionarios[indice + 1] = funcionarios[indice];
                    funcionarios[indice] = auxiliar;
                }
            }
        }
        long timeEnd = System.currentTimeMillis();
        long tempoOrdenaSlectionSort = timeEnd - timeStart;

        return new Performance(tempoOrdenaSlectionSort, qntComparacao, qntMocimentacao);
    }
}
