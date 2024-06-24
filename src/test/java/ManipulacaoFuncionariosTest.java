import org.junit.jupiter.api.Test;
import org.munhoz.rafael.tstpratico.inif.ManipuladorFuncionarios;
import org.munhoz.rafael.tstpratico.inif.model.Funcionario;
import org.munhoz.rafael.tstpratico.inif.model.Funcoes;
import org.munhoz.rafael.tstpratico.inif.model.Pessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ManipulacaoFuncionariosTest {
    ManipuladorFuncionarios manipuladorFuncionarios = new ManipuladorFuncionarios();

    //@BeforeEach
    //popular banco h2 com os dados da tabela

    //@AfterEach
    //limpar banco h2
    
    @Test
    public void givenPredefinedTableWhenInlucluirFuncionariosInvokedThenShouldReturnCollectionWithPredefinedTableContent() {
        //given
        var funcionariosList = this.popularFuncionarios();

        //When
        var funcionarioListMain = manipuladorFuncionarios.incluirFuncionarios31();

        //Then
        assertIterableEquals(funcionariosList, funcionarioListMain);
    }

    @Test
    public void givenPredefinedTableWhenRemoverFuncionarioPeloNomeInvokedThenShouldReturnFuncionarioRemoved() {
        ///given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();

        //When
        var funcionarioRemovido = manipuladorFuncionarios.removerFuncionarioPeloNome32("João");

        //Then
        assertEquals("João",funcionarioRemovido.getNome());
        assertEquals(9, predefinedTable.size());
    }

    @Test
    public void givenPredefinedTableWhenDarAumentoInvokedThenShouldReturnCollectionWithIncreasedSalary() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();
        var salarioCalculadoList = this.popularFuncionarios().stream().map(Funcionario::getSalario).map(salario -> salario.multiply(new BigDecimal("1.1"))).toList();


        //When
        predefinedTable = manipuladorFuncionarios.darAumento34(new BigDecimal("1.1"));

        //Then
        var salarioList = predefinedTable.stream().map(Funcionario::getSalario).toList();
        assertEquals(salarioCalculadoList, salarioList);
    }

    @Test
    public void givenPredefinedTableWhenFilterByMonthOfBirthThenShouldReturnSubsetList() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();
        var mesesOutubroDezembroList = List.of(10, 12);

        //When
        var filteredList = manipuladorFuncionarios.filtrarPorMesAniversario38(mesesOutubroDezembroList);

        //Then
        filteredList.forEach( funcionario -> {
            assertTrue(mesesOutubroDezembroList.contains(funcionario.getDtNascimento().getMonthValue()));
        });
    }

    @Test
    public void givenPredefinedTableWhenGetOldestEmployeeThenShouldReturnCaio() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();

        //When
        var funcionarioMaisVelho = manipuladorFuncionarios.getFuncionarioMaisVelho39();

        //Then
        assertEquals("Caio", funcionarioMaisVelho.getNome());
    }

    @Test
    public void givenPredefinedTableWhenGetOrderedThenShouldReturnListOrderedByName() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();
        var funcionariosList = this.popularFuncionarios();

        //When
        predefinedTable = manipuladorFuncionarios.sortByNameCollectionFuncionario310();

        //Then
        var funcionariosOrdenadosList = funcionariosList.stream().sorted(Comparator.comparing(Pessoa::getNome)).collect(Collectors.toList());
        assertIterableEquals(funcionariosOrdenadosList, predefinedTable);
    }

    @Test
    public void givenPredefinedTableWhenSumTotalSalarioReturnTotal() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();

        //When
        var totalSalarios = manipuladorFuncionarios.getTotalFolha311();

        //Then
        assertEquals(new BigDecimal("48563.31"), totalSalarios);
    }

    @Test
    public void givenPredefinedTableWhenCalculatedMinimumWageShouldReturnCorrectHashMap() {
        //given
        var predefinedTable = manipuladorFuncionarios.incluirFuncionarios31();

        //When
        var salarioMinimoPorFuncionarioMap = manipuladorFuncionarios.getTotalSalariosPorFuncionario();
        HashMap<String, BigDecimal> map = new HashMap<>();
        this.popularFuncionarios().forEach(f -> map.put(f.getNome(), f.getSalario().divide(ManipuladorFuncionarios.SALARIO_MINIMO, 2, RoundingMode.HALF_DOWN)));

        //Then
        assertEquals(map, salarioMinimoPorFuncionarioMap);
    }

    private Collection<Funcionario> popularFuncionarios() {
        List<Funcionario> funcionarioCollection = new ArrayList<>();
        funcionarioCollection.add(Funcionario.builder().nome("Maria").dtNascimento(LocalDate.of(2000, 10, 18)).salario(new BigDecimal("2009.44")).funcao(Funcoes.Operador.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("João").dtNascimento(LocalDate.of(1990, 5, 12)).salario(new BigDecimal("2284.38")).funcao(Funcoes.Operador.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Caio").dtNascimento(LocalDate.of(1961, 5, 2)).salario(new BigDecimal("9836.14")).funcao(Funcoes.Coordenador.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Miguel").dtNascimento(LocalDate.of(1988, 10, 14)).salario(new BigDecimal("19119.88")).funcao(Funcoes.Diretor.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Alice").dtNascimento(LocalDate.of(1995, 1, 5)).salario(new BigDecimal("2234.68")).funcao(Funcoes.Recepcionista.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Heitor").dtNascimento(LocalDate.of(1999, 11, 19)).salario(new BigDecimal("1582.72")).funcao(Funcoes.Operador.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Arthur").dtNascimento(LocalDate.of(1993, 3, 31)).salario(new BigDecimal("4071.84")).funcao(Funcoes.Contador.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Laura").dtNascimento(LocalDate.of(1994, 7, 8)).salario(new BigDecimal("3017.45")).funcao(Funcoes.Gerente.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Heloísa").dtNascimento(LocalDate.of(2003, 5, 24)).salario(new BigDecimal("1606.85")).funcao(Funcoes.Eletricista.name()).build());
        funcionarioCollection.add(Funcionario.builder().nome("Helena").dtNascimento(LocalDate.of(1996, 9, 2)).salario(new BigDecimal("2799.93")).funcao(Funcoes.Gerente.name()).build());
        return funcionarioCollection;
    }
}

