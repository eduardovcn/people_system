package extensions;

import java.util.Scanner;

public class Routes {
    private final Scanner in;

    public Routes(Scanner in) {
        this.in = in;
    }

    public int menuPrincipal() {
        System.out.println("GERENCIADOR DE CADASTROS");
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Cadastrar Funcionario");
        System.out.println("3. Consultar Cadastro");
        System.out.println("0. Sair\n");
        System.out.print("Escolha uma opção: ");

        /* Se a entrada nao for um int, exibe o erro */
        while (!in.hasNextInt()) {
            System.out.println("Erro: Entrada inválida. Digite um número.");
            in.nextLine();
            System.out.print("Escolha uma opção: ");
        }
        int opcao = in.nextInt();
        in.nextLine(); // consumir quebra de linha
        return opcao;
    }

    public void opcaoSelecionada(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarPessoa();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
                consultarCadastro();
                break;
            case 0:
                System.out.println("Saindo do programa. Até mais!");
                break;
            default:
                System.out.println("Erro: Opção inválida! Tente novamente.");
        }
    }

    private void cadastrarPessoa() {
        // Implementar lógica de leitura/validação para criar Pessoa
        System.out.println("Cadastrar Pessoa");
    }

    private void cadastrarFuncionario() {
        // Implementar lógica de leitura/validação para criar Funcionário
        System.out.println("Cadastrar Funcionário");
    }

    private void consultarCadastro() {
        // Implementar lógica de consulta
        System.out.println("Consultar Cadastro");
    }
}
