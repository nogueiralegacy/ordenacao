package com.github.nogueiralegacy.ordenacao.domain;

public class InsertionSort {
    static public Performance ordena(Funcionario[] funcionarios) {
        int qntComparacao = 0;
        int qntMovimentacao = 0;
        long start = System.currentTimeMillis();
        for (int corrente = 1; corrente < funcionarios.length; corrente++) {
            String nameKey = funcionarios[corrente].getPrimeiroNome();

            Funcionario funcionarioKey = funcionarios[corrente];
            int indice = corrente - 1;
            qntComparacao++;
            while (indice >= 0 && nameKey.compareTo(funcionarios[indice].getPrimeiroNome()) < 0) {
                if (indice != corrente - 1) {
                    qntComparacao++;
                }
                qntMovimentacao++;
                funcionarios[indice + 1] = funcionarios[indice];
                indice--;
            }
            qntMovimentacao++;
            funcionarios[indice + 1] = funcionarioKey;
        }
        long end = System.currentTimeMillis();
        long tempoOdenarInsertionSort = end - start;

        return new Performance(tempoOdenarInsertionSort, qntComparacao, qntMovimentacao);
    }
}
