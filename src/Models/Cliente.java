package Models;

import estruturas.ListaDeTelefonesNaoOrdenados;
import extensions.Endereco;
import extensions.Profissao;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

public class Cliente extends Pessoa {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);
    private int codigo;
    private LocalDate dataCadastro;
    private Profissao profissao;

    public Cliente(String nome, LocalDate dataNascimento, ListaDeTelefonesNaoOrdenados telsContato, String email, Endereco endereco, Profissao profissao) {
        super(nome, dataNascimento, telsContato, email, endereco);
        this.dataCadastro = LocalDate.now();
        this.profissao = profissao;
        this.idade = getIdade();
        this.codigo = SEQUENCE.incrementAndGet();

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
                "\nIdade: " + idade +
                "\nEndereço: " + endereco +
                "\nTelefone: " + telsContato +
                "\nProfissão: " + profissao +
                "\nEmail: " + email +
                "\nData de Cadastro: " + dataCadastro;
    }
}




