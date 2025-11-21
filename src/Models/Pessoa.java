package models;

import extensions.Endereco;
import extensions.Telefone;
import java.time.Period;
import java.time.LocalDate;


public class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;
    protected int idade;
    protected Telefone tel;
    protected String email;
    protected Endereco endereco;


    public Pessoa(String nome, LocalDate dataNascimento, Telefone tel, String email, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
        this.email = email;
        this.endereco = endereco;


    }

    public Pessoa() {

    }

    public int getIdade() {
        idade = Period.between(dataNascimento, LocalDate.now()).getYears();

        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTel() {
                return String.valueOf(tel);
    }

    public void setTel(Telefone tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



}
