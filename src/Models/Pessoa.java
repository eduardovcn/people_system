package Models;

import extensions.Endereco;
import extensions.Telefone;

import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;
    protected int idade;
    public static List<Telefone> telsContato = new ArrayList<>();
    protected String email;
    protected Endereco endereco;


    public Pessoa(String nome, LocalDate dataNascimento, List<Telefone> telsContato, String email, Endereco endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telsContato = telsContato;
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


    //public ListaDeTelefonesNaoOrdenados getTelsContato() {
    //    return telsContato;
    //}

    public List<Telefone> getTelsContato() {
        return telsContato;
    }

    //public void setTelsContato(ListaDeTelefonesNaoOrdenados telsContato) {
    //    this.telsContato = telsContato;
    //}

    public void adicionarTelefone(Telefone telefone) {
        this.telsContato.add(telefone);
    }

}
