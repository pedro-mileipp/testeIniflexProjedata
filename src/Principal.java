import classes.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        /* Item 3.1 – inserindo os funcionarios da tabela mencionada  */
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        FuncionarioService funcionarioService = new FuncionarioService();

        System.out.println("Impressao antes da remocao");
        funcionarios.forEach(System.out::println);
        System.out.println('\n');

        /* Item 3.2 - Remover o funcionário “João” da lista. */
        funcionarioService.removerPorNome(funcionarios, "João");

        /* Item 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        • informação de data deve ser exibido no formato dd/mm/aaaa;
        • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.*/
        //.forEach(System.out::println);

        /* Item 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor. */
        funcionarioService.aplicarAumento(funcionarios, 10.0);

        /* Item 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”. */
        //Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarioService.agruparPorFuncao(funcionarios);

        /* Item 3.6 – Imprimir os funcionários, agrupados por função.*/
        //funcionarioService.imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

        /* Item 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.*/
        funcionarioService.imprimirAniversariantesOutubroDezembro(funcionarios);
        System .out.println("\n");

        /* Item 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade. */
        System.out.println(funcionarioService.funcionarioMaisVelho(funcionarios));
        System .out.println("\n");

        /* Item 3.10 – Imprimir a lista de funcionários por ordem alfabética. */
        funcionarioService.listarEmOrdemAlfabetica(funcionarios).forEach(System.out::println);
        System .out.println("\n");


        /* Item 3.11 – Imprimir o total dos salários dos funcionários. */
        System.out.println(funcionarioService.totalSalarios(funcionarios));

        /* 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00. */
        funcionarioService.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));

    }
}