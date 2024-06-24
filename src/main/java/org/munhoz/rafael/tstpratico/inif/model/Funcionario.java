package org.munhoz.rafael.tstpratico.inif.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.munhoz.rafael.tstpratico.inif.Formatador;

import java.math.BigDecimal;

@SuperBuilder
@EqualsAndHashCode
@Getter
@Setter
public class Funcionario extends Pessoa {
    BigDecimal salario;
    String funcao;

    @Override
    public String toString() {
        return StringTemplate.STR."""
                Nome: \{nome}
                Data de Nascimento: \{Formatador.formatarData(dtNascimento)}
                Salario: \{Formatador.formatarCurrency(salario)}
                Função: \{funcao}
                """;
    }

    public String pessoaToString() {
        return StringTemplate.STR."""
                Nome: \{nome}
                Data de Nascimento: \{Formatador.formatarData(dtNascimento)}
                """;
    }
}
