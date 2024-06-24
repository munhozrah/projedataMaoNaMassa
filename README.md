## Intro
Projeto feito para o processo de seleção da empresa Projedata. Rafael Munhoz

## Desafio
Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:
1. Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
2. Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
3. Deve conter uma classe Principal para executar as seguintes ações:
   - Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
   - Remover o funcionário “João” da lista.
   - Imprimir todos os funcionários com todas suas informações, sendo que:
   - informação de data deve ser exibido no formato dd/mm/aaaa;
   - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
   - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
   - Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
   - Imprimir os funcionários, agrupados por função.
   - Imprimir os funcionários que fazem aniversário no mês 10 e 12.
   - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
   - Imprimir a lista de funcionários por ordem alfabética.
   - Imprimir o total dos salários dos funcionários.
   - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.


## Install
- [Maven]([https://nodejs.org/en/download/releases/](https://maven.apache.org/))
- [Java](https://openjdk.org/)

## Usage
```bash
mvn clean test
```

## Future work
- It would be nice to add hard coded data to an h2 database
- It would be nice to write a springboot version of the same code
- It would be nice to provide Rest API to the functions
- It sould be nice to rewrite the tests (specially because of the h2 change)
