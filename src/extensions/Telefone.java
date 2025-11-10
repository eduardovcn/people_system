package extensions;

public class Telefone {
    private String ddi;
    private String ddd;
    private String numero;

    /// Construtor da classe Telefone
    public Telefone(String ddi, String ddd, String numero) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    /// Getters e Setters para acessar os atributos
    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

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
        return "+" + ddi + " " + "(" + ddd + ")" + numero;

    }
}
