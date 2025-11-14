package models;

import extensions.Endereco;
import extensions.Profissao;
import extensions.Telefone;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

public class Cliente extends Pessoa {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);
    private int codigo;
    private LocalDate dataCadastro;
    private Profissao profissao;


    public Cliente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void cadastrarCliente(String nome,LocalDate dataNascimento,Endereco endereco,Telefone tel, Profissao profissao, String email) {
        this.codigo = SEQUENCE.incrementAndGet();
        this.dataCadastro = LocalDate.now();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.tel = tel;
        this.profissao = profissao;
        this.email = email;


    }

    @Override
    public String toString() {
        return "Cliente" +
                "\nNome: " + nome +
                "\nCódigo: " + codigo +
                "\nData de Nascimento: " + dataNascimento +
                "\nIdade: " + obterIdade() +
                "\nEndereço: " + endereco +
                "\nTelefone: " + tel +
                "\nProfissão: " + profissao +
                "\nEmail: " + email +
                "\nData de Cadastro: " + dataCadastro;
    }
}


