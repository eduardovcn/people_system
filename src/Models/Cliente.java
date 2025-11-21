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

    public Cliente(String nome, LocalDate dataNascimento, Telefone tel, String email, Endereco endereco, Profissao profissao) {
        super(nome, dataNascimento, tel, email, endereco);
        this.dataCadastro = LocalDate.now();
        this.profissao = profissao;

    }

    public int getCodigo() {
        return this.codigo;
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


    @Override
    public String toString() {
        return "Cliente" +
                "\nNome: " + nome +
                "\nCódigo: " + codigo +
                "\nData de Nascimento: " + dataNascimento +
                "\nIdade: " + getIdade() +
                "\nEndereço: " + endereco +
                "\nTelefone: " + tel +
                "\nProfissão: " + profissao +
                "\nEmail: " + email +
                "\nData de Cadastro: " + dataCadastro;
    }
}




