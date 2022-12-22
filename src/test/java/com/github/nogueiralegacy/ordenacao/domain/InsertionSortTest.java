package com.github.nogueiralegacy.ordenacao.domain;

import com.github.nogueiralegacy.ordenacao.io.CSVFuncionarioRepository;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertionSortTest {
    @Test
    public void primeirosNomesIguais() {
        Funcionario func1 = new Funcionario("A", "B", "@", "F", "1");
        Funcionario func2 = new Funcionario("A", "A", "@", "F", "1");

        Funcionario[] funcionarios = {func1, func2};
        InsertionSort.ordena(funcionarios);

        Funcionario[] funcionariosOrdenados = {func1, func2};
        for (int indice = 0; indice < funcionariosOrdenados.length; indice++) {
            assertTrue(funcionariosOrdenados[indice].getPrimeiroNome()
                    .equals(funcionarios[indice].getPrimeiroNome()));
        }
    }

    @Test
    public void desordenadoRandom() {
        Funcionario func1 = new Funcionario("B", "B", "@", "F", "1");
        Funcionario func2 = new Funcionario("C", "A", "@", "F", "1");
        Funcionario func3 = new Funcionario("A", "A", "@", "F", "1");

        Funcionario[] funcionarios = {func1, func2, func3};
        InsertionSort.ordena(funcionarios);

        ArrayList<Funcionario> funci = new ArrayList();
        funci.add(func1);
        funci.add(func2);
        funci.add(func3);
        funci.sort((Funcionario f1, Funcionario f2) -> f1.getPrimeiroNome().compareTo(f2.getPrimeiroNome()));

        Funcionario[] funcionariosOrdenados = {func3, func1, func2};
        for (int indice = 0; indice < funcionariosOrdenados.length; indice++) {
            assertTrue(funcionariosOrdenados[indice].getPrimeiroNome()
                    .equals(funcionarios[indice].getPrimeiroNome()));
        }
    }

    @Test
    public void desordenadoInvertido() {
        Funcionario func1 = new Funcionario("C", "B", "@", "F", "1");
        Funcionario func2 = new Funcionario("B", "A", "@", "F", "1");
        Funcionario func3 = new Funcionario("A", "A", "@", "F", "1");

        Funcionario[] funcionarios = {func1, func2, func3};
        InsertionSort.ordena(funcionarios);

        Funcionario[] funcionariosOrdenados = {func3, func2, func1};
        for (int indice = 0; indice < funcionariosOrdenados.length; indice++) {
            assertTrue(funcionariosOrdenados[indice].getPrimeiroNome()
                    .equals(funcionarios[indice].getPrimeiroNome()));
        }
    }

    @Test
    public void altaCargaDeElementos() {
        FuncionarioRepository funcionarioRepo = new CSVFuncionarioRepository();
        String path = Path.of("dados", "1000", "random.csv").toString();
        String pathCrescente = Path.of("dados", "1000", "crescente.csv").toString();

        Funcionario[] funcionarios = funcionarioRepo
                .load(funcionarioRepo.getPath(path));
        Funcionario[] funcionariosOrdenados = funcionarioRepo
                .load(funcionarioRepo.getPath(pathCrescente));

        InsertionSort.ordena(funcionarios);

        for (int indice = 0; indice < funcionarios.length; indice++) {
            assertTrue(funcionariosOrdenados[indice].getPrimeiroNome()
                    .equals(funcionarios[indice].getPrimeiroNome()));
        }

    }

    @Test
    public void mostrarPerformance() {
        FuncionarioRepository funcionarioRepo = new CSVFuncionarioRepository();
        String path = Path.of("dados", "1000", "random.csv").toString();

        Funcionario[] funcionarios = funcionarioRepo
                .load(funcionarioRepo.getPath(path));

        Performance performance = InsertionSort.ordena(funcionarios);
        System.out.println("Quantidade de movimentacao = " + performance.getQntMovimentacao());
        System.out.println("Quantidade de comparacao = " + performance.getQntComparacao());
        System.out.println("Tempo de execucao = " + performance.getTempoDeExecucao() + " ms\n");
    }
}
