package extensions;

public class Telefone {
    private String ddd;
    private String numero;

    /// Construtor da classe Telefone
    public Telefone(String ddd, String numero) {

        this.ddd = ddd;
        this.numero = numero;
    }

    /// Getters e Setters para acessar os atributos
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /// Melhorar a exibição do telefone
    @Override
    public String toString() {
        return "(" + ddd + ")" + numero;

    }
}
