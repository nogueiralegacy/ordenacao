package com.github.nogueiralegacy.ordenacao.domain;

public class QuickSort {
    public static void ordena(Funcionario[] funcionarios, int comeco, int fim, Performance performance) {
        if (fim == funcionarios.length - 1) {
            performance.setTempoInicio(System.currentTimeMillis());
        }

        if (comeco < fim) {
            int meioIndex = separador(funcionarios, comeco, fim, performance);

            ordena(funcionarios, comeco, meioIndex - 1, performance);
            ordena(funcionarios, meioIndex + 1, fim, performance);
        }
        if (comeco == funcionarios.length - 1) {
            performance.setTempoFinal(System.currentTimeMillis());
        }
    }

    public static int separador(Funcionario[] funcionarios, int comeco, int fim, Performance performance) {
        Funcionario meio = funcionarios[fim];
        int indice = comeco - 1;

        for (int corrente = comeco; corrente < fim; corrente++) {
            String name1 = funcionarios[corrente].getPrimeiroNome();
            performance.setQntComparacao(performance.getQntComparacao() + 1);
            if (name1.compareTo(meio.getPrimeiroNome()) < 0) {
                indice++;

                Funcionario auxiliar = funcionarios[indice];
                funcionarios[indice] = funcionarios[corrente];
                funcionarios[corrente] = auxiliar;
                performance.setQntMovimentacao(performance.getQntMovimentacao() + 1);
            }
        }
        Funcionario auxiliar = funcionarios[indice + 1];
        funcionarios[indice + 1] = funcionarios[fim];
        funcionarios[fim] = auxiliar;
        performance.setQntMovimentacao(performance.getQntMovimentacao() + 1);

        return indice + 1;
    }
}
