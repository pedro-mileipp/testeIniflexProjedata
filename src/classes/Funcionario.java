package classes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public int getIdade() {
        return Period.between(getDataNascimento(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat fmtSalario = new DecimalFormat("#,##0.00");

        return "Nome: " + getNome() +
                " | Data Nasc: " + getDataNascimento().format(fmtData) +
                " | Salário: R$ " + fmtSalario.format(salario) +
                " | Função: " + getFuncao();
    }
}