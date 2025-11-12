package models;

import extensions.Endereco;
import extensions.Profissao;
import extensions.Telefone;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private int codigo;
    private LocalDate dataCadastro;
    private Profissao profissao;


    public Cliente(String codigo, String nome, LocalDate dataCadastro, Endereco endereco, Telefone tel, Profissao profissao, String email) {
        super(nome, dataCadastro, tel, email, endereco);

    }

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

    public void cadastrarCliente(int codigo, String nome,LocalDate dataNascimento,Endereco endereco,Telefone tel, Profissao profissao, String email) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.tel = tel;
        this.profissao = profissao;
        this.email = email;


    }
}


