package com.github.nogueiralegacy.ordenacao.io;

import com.github.nogueiralegacy.ordenacao.domain.Funcionario;
import com.github.nogueiralegacy.ordenacao.domain.FuncionarioRepository;
import org.junit.Test;

import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVFuncionarioRepositoryTest {


    @Test
    public void testeLeitura() {
        FuncionarioRepository funcionarioRepo = new CSVFuncionarioRepository();
        String path = Path.of("dados","test", "testeLeitura.csv").toString();
       Funcionario[] funcionarios = funcionarioRepo.load(funcionarioRepo.getPath(path));

        Funcionario[] funcionariosExpect = new Funcionario[3];
        funcionariosExpect[0] = new Funcionario
                ("Daniel", "Nogueira", "@ufg", "M", "1");
        funcionariosExpect[1] = new Funcionario
                ("Fabio", "Lucena", "@ufg.br", "M", "2");
        funcionariosExpect[2] = new Funcionario
                ("Matheus", "Filgueira", "@ufg", "F", "3");

        for (int indice = 0; indice < funcionariosExpect.length; indice++) {
            assertTrue(Arrays.deepEquals(funcionariosExpect, funcionarios), "ERRO: " + indice);
        }
    }
}
