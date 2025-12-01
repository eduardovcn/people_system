package models;

import extensions.Endereco;
import extensions.Profissao;

import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

public class Cliente extends Pessoa {
    private int codigo;
    private LocalDate dataCadastro;
    private Profissao profissao;

    public Cliente(String nome, LocalDate dataNascimento, String email, Endereco endereco, Profissao profissao) {
        super(nome, dataNascimento, email, endereco);
        this.dataCadastro = LocalDate.now();
        this.profissao = profissao;

    }

    public int getCodigo() {
        return this.codigo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }


    @Override
    public String toString() {
        return "Cliente" +
                "\nNome: " + nome +
                "\nCódigo: " + codigo +
                "\nData de Nascimento: " + dataNascimento +
                "\nIdade: " + idade +
                "\nEndereço: " + endereco +
                "\nTelefone: " + getTelefonesFormatados() +
                "\nProfissão: " + profissao +
                "\nEmail: " + email +
                "\nData de Cadastro: " + dataCadastro;
    }
}




