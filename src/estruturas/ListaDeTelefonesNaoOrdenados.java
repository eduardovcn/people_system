package estruturas;

import extensions.Telefone;
import java.util.Arrays;

public class ListaDeTelefonesNaoOrdenados {

    //vetor de telefones - Lista de telefones.
    private Telefone[] telefones;
    //Quantidade de telefones - O quanto eu já guardei
    private int tamanhoLista;
    //Capacidade inicial - pode ser alterada
    private static final int CAPACIDADE_PADRAO = 3; // O quanto eu posso guardar
    private int capacidadePadrao = CAPACIDADE_PADRAO;

    public int getCapacidadePadrao() {
        return capacidadePadrao;
    }

    public ListaDeTelefonesNaoOrdenados() {
        this.telefones = new Telefone[CAPACIDADE_PADRAO];
        this.tamanhoLista = 0;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public boolean isFull() {
        // Preciso somar 1 para que de fato o tamanho lista cheque a quantidade de elementos, sem se basear no indice, que começa em 0
        return this.tamanhoLista == CAPACIDADE_PADRAO + 1;
    }

    public void adicionarTelefone(Telefone telefone) {
        if (this.tamanhoLista < CAPACIDADE_PADRAO) {
            //Indice é "index+1".
            this.telefones[this.tamanhoLista] = telefone;
            this.tamanhoLista = this.tamanhoLista + 1;
        } else {
            System.out.println("Não há mais espaços para adicionar" + telefone);
        }
    }

    public void removerTelefone(Telefone telefone) {
        int indice = buscarTelefoneIndex(telefone);
        if (indice != -1) {
            for (int i = indice; i < this.tamanhoLista -1; i++) {
                this.telefones[i] = this.telefones[i + 1];
            }
            //Reduzindo o tamanho da lista
            this.tamanhoLista = tamanhoLista -1;
            telefones[tamanhoLista] = null; //Limpar a última posição
            System.out.println("Telefone " + telefone + " removido com sucesso.");
        } else {
            System.out.println("Não tem o " + telefone + " para ser removido.");
        }

    }

    // Procurar o indice do telefone no Vetor
    private int buscarTelefoneIndex(Telefone telefone) {
        for(int i = 0; i < this.tamanhoLista; i++) {
            // Validação do telefone.
            if(this.telefones[i].equals(telefone)) {
                return i;
            }
        }
        System.out.println("Telefone não encontrado na Lista.");
        return -1;
    }

    @Override
    public String toString() {

        return "Lista De Telefones\n" +
                "telefones: " + Arrays.toString(telefones) +
                '}';
    }
}
