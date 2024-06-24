package org.munhoz.rafael.tstpratico.inif.services;

import org.munhoz.rafael.tstpratico.inif.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

public class FuncionarioService {
    public static Funcionario incluirFuncionario(Collection<Funcionario> funcionarioCollection, String nome, LocalDate dtNascimento, BigDecimal salario, String funcao) {
        var funcionario = Funcionario.builder()
                .nome(nome)
                .dtNascimento(dtNascimento)
                .salario(salario)
                .funcao(funcao)
                .build();
        funcionarioCollection.add(funcionario);
        return funcionario;
    }

    public static Funcionario removerFuncionarioPeloNome(Collection<Funcionario> funcionarioCollection, String nome) {
        var funcionarioRemovido = funcionarioCollection.stream().filter(f -> f.getNome().equals(nome)).findFirst().orElseThrow();
        funcionarioCollection.remove(funcionarioRemovido);
        return funcionarioRemovido;
    }
}
