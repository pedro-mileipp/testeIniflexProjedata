package service;

import classes.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    // item 3.2
    public void removerPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    // item 3.4
    public void aplicarAumento(List<Funcionario> funcionarios, double percentual) {
        funcionarios.forEach(f -> f.setSalario(
                f.getSalario().multiply(BigDecimal.valueOf(1 + (percentual/100)))
        ));
    }

    // item 3.5
    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // item 3.6
    public void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao){
        funcionariosPorFuncao.values().forEach(lista -> {
            lista.forEach(System.out::println);
        });
    }

    // item 3.8
    public void imprimirAniversariantesOutubroDezembro(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(System.out::println);
    }

    // Item 3.9
    public Funcionario funcionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    // Item 3.10
    public List<Funcionario> listarEmOrdemAlfabetica(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    // Item 3.11
    public BigDecimal totalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Item 3.12
    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo){
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos");
        });
    }
}

