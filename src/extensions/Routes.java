package extensions;
import models.Cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class Routes {
    private final Scanner in;

    public Routes(Scanner in) {
        this.in = in;
    }

    public int menuPrincipal() {
        System.out.println("GERENCIADOR DE CADASTROS");
        System.out.println("1. Cadastrar Cliente");
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
                criarCliente();
                break;
            case 2:
                criarFuncionario();
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

    private void criarCliente() {
        System.out.println("Digite os dados do Cliente:\n");
        System.out.println("Nome:");
        String nome = in.nextLine();

        System.out.println("Data de Nascimento (AAAA-MM-DD):");
        LocalDate dataNascimento = LocalDate.parse(in.nextLine());

        System.out.println("Logradouro:");
        String logradouro = in.nextLine();
        System.out.println("Complemento:");
        String complemento = in.nextLine();
        System.out.println("Bairro:");
        String bairro = in.nextLine();
        System.out.println("Cidade:");
        String cidade = in.nextLine();
        System.out.println("Número:");
        String numero = in.nextLine();
        System.out.println("CEP:");
        String cep = in.nextLine();
        Endereco endereco = new Endereco(logradouro, complemento, bairro, cidade, numero, cep);

        System.out.println("Telefone (DDI + DDD + Número):");
        String ddi = in.nextLine();
        String ddd = in.nextLine();
        String numeroTel = in.nextLine();
        Telefone tel = new Telefone(ddi, ddd, numeroTel);

        System.out.println("Profissão:");
        String profissaoNome = in.nextLine();
        Profissao profissao = new Profissao(profissaoNome);

        System.out.println("Email:");
        String email = in.nextLine();

        Cliente cliente = new Cliente();
        cliente.cadastrarCliente(nome, dataNascimento, endereco, tel, profissao, email);




    }

    private void criarFuncionario() {
        // Implementar lógica de leitura/validação para criar Funcionário
        System.out.println("Cadastrar Funcionário");
    }

    private void consultarCadastro() {
        // Implementar lógica de consulta
        System.out.println("Consultar Cadastro");
    }
}
