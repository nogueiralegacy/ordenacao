package com.github.nogueiralegacy.ordenacao.domain;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {
    @Test
    public void equalsMesmaReferenciaTrue() {
        Funcionario funcionario = new Funcionario
                ("a", "a", "@", "M", "1");

        assertTrue(funcionario.equals(funcionario));
    }

    @Test
    public void equalsDiferentesClassesFalse() {
        Funcionario funcionario = new Funcionario
                ("a", "a", "@", "M", "1");


        assertFalse(funcionario.equals("funcionario"));
    }

    @Test
    public void equalsDiferentesAtributosFalse() {
        Funcionario funcionario1 = new Funcionario
                ("a", "a", "@", "M", "1");
        Funcionario funcionario2 = new Funcionario
                ("a", "a", "@", "M", "2");

        assertFalse(funcionario1.equals(funcionario2));
    }

    @Test
    public void equalsMesmosAtributosTrue() {
        Funcionario funcionario1 = new Funcionario
                ("a", "a", "@", "M", "1");
        Funcionario funcionario1Copy = new Funcionario
                ("a", "a", "@", "M", "1");

        assertTrue(funcionario1.equals(funcionario1Copy));
    }
}
