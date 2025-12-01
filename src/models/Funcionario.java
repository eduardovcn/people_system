package models;


import extensions.Cargo;
import extensions.Endereco;
import extensions.Telefone;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;;

public class Funcionario extends Pessoa {
    private int matricula;
    private Cargo cargo;
    private double salario;
    private LocalDate dataAdmissao;


    public Funcionario(String nome, LocalDate dataNascimento, String email, Endereco endereco, Cargo cargo, double salario) {
        super(nome, dataNascimento,email, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = LocalDate.now();

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void reajustarSalario(double percentual) {

        if (percentual > 0) {
            this.salario += salario * (percentual / 100);
        }

    }

    public Cargo promover(Cargo novoCargo) {
        this.cargo  = novoCargo;
        return this.cargo;
    }

    public void cadastrarFuncionario(String nome, LocalDate dataNascimento, Endereco endereco, Telefone tel, Cargo cargo, String email, double salario) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.cargo = cargo;

    }

    @Override
    public String toString() {
        return "Funcionário" +
                "\nNome: " + nome +
                "\nMatrícula: " + getMatricula() +
                "\nCargo: " + cargo +
                "\nSalário: " + salario +
                "\nData de Admissão: " + dataAdmissao +
                "\nEmail: " + email +
                "\nTelefone: " + getTelefonesFormatados() +
                "\nEndereço: " + endereco +
                "\nData de Nascimento: " + dataNascimento +
                "\nIdade: " + getIdade() + " anos";
    }
}

