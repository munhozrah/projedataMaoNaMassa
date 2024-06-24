package org.munhoz.rafael.tstpratico.inif;

import lombok.Getter;
import org.munhoz.rafael.tstpratico.inif.model.Funcionario;
import org.munhoz.rafael.tstpratico.inif.model.Funcoes;
import org.munhoz.rafael.tstpratico.inif.model.Pessoa;
import org.munhoz.rafael.tstpratico.inif.services.FuncionarioService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Getter
public class ManipuladorFuncionarios {
    private static final BigDecimal CEM = new BigDecimal("100");
    public static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    public Collection<Funcionario> funcionarioCollection;
    public Collection<Funcionario> incluirFuncionarios31() {
        this.funcionarioCollection = new ArrayList<>();
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), Funcoes.Operador.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), Funcoes.Operador.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), Funcoes.Coordenador.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), Funcoes.Diretor.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), Funcoes.Recepcionista.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), Funcoes.Operador.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), Funcoes.Contador.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), Funcoes.Gerente.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), Funcoes.Eletricista.name());
        FuncionarioService.incluirFuncionario(this.funcionarioCollection, "Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), Funcoes.Gerente.name());
        return this.funcionarioCollection;
    }

    public Funcionario removerFuncionarioPeloNome32(String nome) {
        return FuncionarioService.removerFuncionarioPeloNome(this.funcionarioCollection, nome);
    }

    public void imprimirCollection33(Collection<Funcionario> collection) {
        collection.forEach(System.out::println);
    }

    public Collection<Funcionario> darAumento34(BigDecimal percentualAumento) {
        this.funcionarioCollection.forEach(funcionario -> funcionario.setSalario(funcionario.getSalario().multiply(percentualAumento)));
        return this.funcionarioCollection;
    }

    public Map<String, List<Funcionario>> agruparFuncionariosEmMap35() {
        Map<String, List<Funcionario>> map = new HashMap<>();
        this.funcionarioCollection.forEach(funcionario -> {
            var funcao = funcionario.getFuncao();
            if (!map.containsKey(funcao))
                map.put(funcao, new ArrayList<>());
            map.get(funcao).add(funcionario);
        });
        return map;
    }

    public void imprimirMapCollection36(Map<String, List<Funcionario>> mapCollection) {
        var keySet = mapCollection.keySet();
        keySet.forEach(key -> {
            System.out.println("====> Chave: " + key);
            this.imprimirCollection33(mapCollection.get(key));
        });
    }

    public Collection<Funcionario> filtrarPorMesAniversario38(List<Integer> meses) {
        return this.funcionarioCollection.stream().filter(funcionario -> meses.contains(funcionario.getDtNascimento().getMonthValue())).collect(Collectors.toList()); //boxing
    }

    public Funcionario getFuncionarioMaisVelho39() {
        AtomicReference<Funcionario> funcionario = new AtomicReference<>(Funcionario.builder().dtNascimento(LocalDate.MAX).build());
        this.funcionarioCollection.forEach(f -> {
            if (f.getDtNascimento().isBefore(funcionario.get().getDtNascimento()))
                funcionario.set(f);
        });
        return funcionario.get();
    }

    public Collection<Funcionario> sortByNameCollectionFuncionario310() {
        return this.funcionarioCollection.stream().sorted(Comparator.comparing(Pessoa::getNome)).collect(Collectors.toList());
    }

    public BigDecimal getTotalFolha311() {
        return this.funcionarioCollection
                .stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public HashMap<String, BigDecimal> getTotalSalariosPorFuncionario (){
        HashMap<String, BigDecimal> map = new HashMap<>();
        this.funcionarioCollection.forEach(f -> map.put(f.getNome(), f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_DOWN)));
        return map;
    }
}
