# Desafio: Gerenciamento de Funcionários

## Descrição

Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3 – Deve conter uma classe Principal para executar as seguintes ações:
- 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
- 3.2 – Remover o funcionário “João” da lista.
- 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
  - informação de data deve ser exibido no formato dd/mm/aaaa;
  - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
- 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
- 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
- 3.6 – Imprimir os funcionários, agrupados por função.
- 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
- 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
- 3.10 – Imprimir a lista de funcionários por ordem alfabética.
- 3.11 – Imprimir o total dos salários dos funcionários.
- 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.


O projeto possui:

- **Camada de classes**: representa pessoas e funcionários (`Pessoa` e `Funcionario`).
- **Camada de serviço**: implementa operações de negócio sobre os funcionários (`FuncionarioService`).

---

## Estrutura de Pastas

```
C:.
├───out
│   └───production
│       └───testeIniflex
│           │   Principal.class
│           │
│           ├───classes
│           │       Funcionario.class
│           │       Pessoa.class
│           │
│           └───service
│                   FuncionarioService.class
│
└───src
    │   Principal.java
    │
    ├───classes
    │       Funcionario.java
    │       Pessoa.java
    │
    └───service
            FuncionarioService.java
```

## Classes Principais

### Pessoa.java

Classe base que representa uma pessoa.

- **Atributos:**
    - `nome` (String) — nome da pessoa
    - `dataNascimento` (LocalDate) — data de nascimento
- **Métodos:**
    - `getNome()` / `setNome(String nome)`
    - `getDataNascimento()` / `setDataNascimento(LocalDate dataNascimento)`

---

### Funcionario.java

Classe que estende `Pessoa` e representa um funcionário.

- **Atributos:**
    - `salario` (BigDecimal) — salário do funcionário
    - `funcao` (String) — função exercida pelo funcionário
- **Métodos:**
    - `getSalario()` / `setSalario(BigDecimal salario)`
    - `getFuncao()`
    - `getIdade()` — calcula a idade atual com base na data de nascimento
    - `toString()` — retorna uma string formatada com nome, data de nascimento, salário e função

---

## FuncionarioService.java

Classe de serviço responsável por fornecer operações de negócio sobre funcionários.

Abaixo estão os **métodos detalhados**:

---

### 1. `removerPorNome(List<Funcionario> funcionarios, String nome)`

**Propósito:**  
Remover todos os funcionários da lista cujo nome corresponda ao informado, ignorando maiúsculas e minúsculas.

**Funcionamento Interno:**
- Percorre a lista de funcionários usando `removeIf`.
- Para cada funcionário `f`, compara o nome com `equalsIgnoreCase(nome)`.
- Se houver correspondência, o funcionário é removido.

**Exemplo de uso:**
```java
funcionarioService.removerPorNome(funcionarios, "Pedro");
```

### 2. `aplicarAumento(List<Funcionario> funcionarios, double percentual)`

**Propósito:**
Aplicar aumento salarial a todos os funcionários com base em umpercentual.

**Funcionamento Interno:**

- Para cada funcionário:
  - Obtém o salário atual (f.getSalario()).
  - Multiplica pelo fator (1 + percentual/100) para calcular o novo salário. 
  - Atualiza o salário do funcionário com o valor calculado.
  - Permite ajustes de forma proporcional, ex.: 10% → salário * 1.10.

**Exemplo de uso:**
```java
funcionarioService.aplicarAumento(funcionarios, 10); // aumento de 10%
```

### 3. `agruparPorFuncao(List<Funcionario> funcionarios)` e `imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao)`

**Propósito:**  
Agrupar os funcionários por função em um mapa (`Map<String, List<Funcionario>>`).

**Funcionamento Interno:**

- Percorre a lista de funcionários e agrupa cada funcionário de acordo com sua função.
- Utiliza `Collectors.groupingBy(Funcionario::getFuncao)` para criar o mapa.
- Cada chave do mapa é uma função (`String`) e o valor associado é uma lista de funcionários (`List<Funcionario>`) que exercem essa função.

**Exemplo de uso:**
```java
Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarioService.agruparPorFuncao(funcionarios);

/* Item 3.6 – Imprimir os funcionários, agrupados por função.*/
funcionarioService.imprimirFuncionariosPorFuncao(funcionariosPorFuncao);
```

### 4. `imprimirAniversariantesOutubroDezembro(List<Funcionario> funcionarios)`

**Propósito:**  
Imprimir no console todos os funcionários que fazem aniversário nos meses de outubro ou dezembro.

**Funcionamento Interno:**

- Percorre a lista de funcionários usando `stream()`.
- Aplica um filtro (`filter`) para verificar o mês de nascimento de cada funcionário:
    - Obtém o mês com `f.getDataNascimento().getMonthValue()`.
    - Mantém apenas os funcionários cujo mês seja 10 (outubro) ou 12 (dezembro).
- Para cada funcionário que passar no filtro, imprime suas informações no console usando `System.out.println()`.

**Exemplo de uso:**
```java
funcionarioService.imprimirAniversariantesOutubroDezembro(funcionarios);
```

### 5. `imprimirAniversariantesOutubroDezembro(List<Funcionario> funcionarios)`

**Propósito:**  
Imprimir no console todos os funcionários que fazem aniversário nos meses de outubro ou dezembro.

**Funcionamento Interno:**

- Percorre a lista de funcionários usando `stream()`.
- Aplica um filtro (`filter`) para verificar o mês de nascimento de cada funcionário:
    - Obtém o mês com `f.getDataNascimento().getMonthValue()`.
    - Mantém apenas os funcionários cujo mês seja 10 (outubro) ou 12 (dezembro).
- Para cada funcionário que passar no filtro, imprime suas informações no console usando `System.out.println()`.

**Exemplo de uso:**
```java
funcionarioService.imprimirAniversariantesOutubroDezembro(funcionarios);
```

### 6. `listarEmOrdemAlfabetica(List<Funcionario> funcionarios)`

**Propósito:**  
Retornar a lista de funcionários ordenada alfabeticamente pelo nome.

**Funcionamento Interno:**

- Percorre a lista de funcionários usando `stream()`.
- Aplica `sorted(Comparator.comparing(Funcionario::getNome))` para ordenar os funcionários pelo nome em ordem crescente.
- Coleta os elementos ordenados em uma nova lista usando `collect(Collectors.toList())`.
- Retorna a nova lista ordenada, sem alterar a lista original.

**Exemplo de uso:**
```java
funcionarioService.listarEmOrdemAlfabetica(funcionarios).forEach(System.out::println);
```

### 7. `totalSalarios(List<Funcionario> funcionarios)`

**Propósito:**  
Calcular e retornar o total de salários de todos os funcionários da lista.

**Funcionamento Interno:**

- Percorre a lista de funcionários usando `stream()`.
- Mapeia cada funcionário para seu salário com `map(Funcionario::getSalario)`.
- Soma todos os salários usando `reduce(BigDecimal.ZERO, BigDecimal::add)`.
    - `BigDecimal.ZERO` é o valor inicial da soma.
    - `BigDecimal::add` soma cada salário ao acumulador.
- Retorna o resultado como um `BigDecimal`.

**Exemplo de uso:**
```java
System.out.println(funcionarioService.totalSalarios(funcionarios));
```

### 8. `imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo)`

**Propósito:**  
Imprimir no console quantos salários mínimos cada funcionário recebe.

**Funcionamento Interno:**

- Percorre a lista de funcionários usando `forEach`.
- Para cada funcionário:
    - Divide o salário do funcionário pelo valor do salário mínimo (`f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP)`).
        - `2` define duas casas decimais.
        - `RoundingMode.HALF_UP` arredonda o valor corretamente.
    - Imprime no console o nome do funcionário e a quantidade de salários mínimos que ele recebe.

**Exemplo de uso:**
```java
funcionarioService.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
```