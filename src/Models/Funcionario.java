package models;

import extensions.Cargo;
import extensions.Endereco;
import extensions.Telefone;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private int matricula;
    private Cargo cargo;
    private double salario;
    private LocalDate dataAdmissao;


    public Funcionario() {
        super();

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

    public void cadastrarFuncionario(String nome, LocalDate dataNascimento, LocalDate dataAdmissao, Telefone tel, String email, Endereco endereco, double salario, Cargo cargo, int matricula) {
        this.nome = nome;
        this.tel = tel;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.cargo = cargo;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matrícula=" + matricula +
                ", cargo=" + cargo.getNomeCargo() +
                ", salario=" + salario +
                ", dataAdmissao=" + dataAdmissao +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tel=" + tel.getNumero() +
                ", email='" + email + '\'' +
                ", endereco=" + endereco.getLogradouro() +
                '}';
    }
}

