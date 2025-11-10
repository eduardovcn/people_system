package Models;

import extensions.Endereco;
import extensions.Profissao;
import extensions.Telefone;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String codigo;
    private LocalDate dataCadastro;
    private Profissao profissao;


    public Cliente(String codigo, String nome, LocalDate dataCadastro, Endereco endereco, Telefone tel, Profissao profissao, String email) {
        super(nome, dataCadastro, tel, email, endereco);

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public void cadastrarCliente() {

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, endereco, tel, profissao, email);

    }
}


