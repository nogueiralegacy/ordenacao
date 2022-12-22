package com.github.nogueiralegacy.ordenacao.domain;

public class Performance {
    private long tempoInicio;
    private long tempoFinal;
    private long tempoDeExecucao;
    private int qntComparacao;
    private int qntMovimentacao;

    public Performance(){
        this.qntComparacao = 0;
        this.qntMovimentacao = 0;
    }
    public Performance(long tempoDeExecucao, int qntComparacao, int qntMovimentacao) {
        this.tempoDeExecucao = tempoDeExecucao;
        this.qntComparacao = qntComparacao;
        this.qntMovimentacao = qntMovimentacao;
    }

    public long getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(long tempoDeExecucao) {
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public int getQntComparacao() {
        return qntComparacao;
    }

    public void setQntComparacao(int qntComparacao) {
        this.qntComparacao = qntComparacao;
    }

    public int getQntMovimentacao() {
        return qntMovimentacao;
    }

    public void setQntMovimentacao(int qntMovimentacao) {
        this.qntMovimentacao = qntMovimentacao;
    }
    public void setTempoInicio(long tempo) {
        this.tempoInicio = tempo;
    }
    public long getTempoInicio() {
        return tempoInicio;
    }
    public long getTempoFinal() {
        return tempoFinal;
    }
    public void setTempoFinal(long tempo) {
        this.tempoFinal = tempo;
        this.tempoDeExecucao = this.tempoFinal - this.tempoInicio;
    }
}
