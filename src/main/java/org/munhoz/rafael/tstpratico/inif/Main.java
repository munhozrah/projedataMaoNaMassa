package org.munhoz.rafael.tstpratico.inif;

import org.munhoz.rafael.tstpratico.inif.model.Funcionario;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class Main {
    private static final String NOME_JOAO = "João";
    private static final List<Integer> OUTUBRO_DEZEMBRO = List.of(10, 12);
    private static Collection<Funcionario> funcionarioCollection;

    public static void main(String[] args) {
        var manipuladorFuncionarios = new ManipuladorFuncionarios();
        funcionarioCollection = manipuladorFuncionarios.incluirFuncionarios31();
        var funcionario = manipuladorFuncionarios.removerFuncionarioPeloNome32(NOME_JOAO);

        System.out.println("====>>>> IMPRIMIR APOS EXCLUIR JOAO");
        manipuladorFuncionarios.imprimirCollection33(manipuladorFuncionarios.getFuncionarioCollection());
        funcionarioCollection = manipuladorFuncionarios.darAumento34(new BigDecimal("1.1"));
        var funcionarioMap = manipuladorFuncionarios.agruparFuncionariosEmMap35();

        System.out.println("====>>>> AGRUPADOS POR FUNCAO");
        manipuladorFuncionarios.imprimirMapCollection36(funcionarioMap);
        var funcionariosNascidosEmOutubroOuDezembro = manipuladorFuncionarios.filtrarPorMesAniversario38(OUTUBRO_DEZEMBRO);

        System.out.println("====>>>> NASCIDOS EM OUTUBRO OU DEZEMBRO");
        manipuladorFuncionarios.imprimirCollection33(funcionariosNascidosEmOutubroOuDezembro);

        System.out.println("====>>>> FUNCIONARIO MAIS VELHO");
        var funcionarioMaisVelho = manipuladorFuncionarios.getFuncionarioMaisVelho39();
        System.out.println(funcionarioMaisVelho.pessoaToString());

        System.out.println("====>>>> LISTA DE FUNCIONARIOS ORDENADA");
        var funcionarioSortedCollection = manipuladorFuncionarios.sortByNameCollectionFuncionario310();
        manipuladorFuncionarios.imprimirCollection33(funcionarioSortedCollection);

        System.out.println("====>>>> TOTAL SALARIO");
        var totalSalario = manipuladorFuncionarios.getTotalFolha311();
        System.out.printf("Total: %s", Formatador.formatarCurrency(totalSalario));

        System.out.println("====>>>> SALARIO MINIMO POR FUNCIONARIO");
        var salarioMinimoPorFuncionarioMap = manipuladorFuncionarios.getTotalSalariosPorFuncionario();
        salarioMinimoPorFuncionarioMap.forEach((key, value) -> {
            System.out.println();
                System.out.printf("====> FUncionario(a): %s; Salarios: %.2f", key, value);
        });
    }
}