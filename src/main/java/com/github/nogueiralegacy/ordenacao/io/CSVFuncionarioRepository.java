package com.github.nogueiralegacy.ordenacao.io;

import com.github.nogueiralegacy.ordenacao.domain.Funcionario;
import com.github.nogueiralegacy.ordenacao.domain.FuncionarioRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFuncionarioRepository implements FuncionarioRepository {
    public Path getPath(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        URI uri = null;

        try {
            uri = resource.toURI();
        } catch (Exception exp) {
            return null;
        }

        return resource == null ? null : Paths.get(uri);
    }
    public Funcionario[] load(Path path) {
        List<Funcionario> todos = new ArrayList<>();

        try {
            FileReader fr = new FileReader(path.toFile());
                try (BufferedReader br = new BufferedReader(fr)) {
                String linha;
                String[] campos;
                br.readLine();
                while ((linha = br.readLine()) != null) {
                    campos = linha.split(",");
                    campos[3] = String.valueOf(campos[3].charAt(0));
                    todos.add(new Funcionario(campos[0], campos[1], campos[2], campos[3], campos[4]));
                }

                }
            } catch (IOException e) {

            }

        return todos.toArray(new Funcionario[0]);
    }
}
