package com.github.nogueiralegacy.ordenacao.domain;

import java.nio.file.Path;

public interface FuncionarioRepository {

    Funcionario[] load(Path path);

    Path getPath(String fileName);
}
