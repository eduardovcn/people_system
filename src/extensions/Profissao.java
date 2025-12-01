package extensions;

public class Profissao {
    private String nomeProfissao;

    public Profissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeCargo) {
        this.nomeProfissao = nomeCargo;
    }

    @Override
    public String toString() {
        return nomeProfissao;
    }
}
