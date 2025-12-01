package extensions;
import database.CriacaoDb;
import models.*;

import java.time.LocalDate;
import java.util.Scanner;


public class Routes {
    private final Scanner in;
    //private List<Telefone> telsContato;

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

        System.out.println("Telefone (DDD + Número):");
        String ddd = in.nextLine();
        String numeroTel = in.nextLine();
        Telefone tel = new Telefone(ddd, numeroTel);

        System.out.println("Profissão:");
        String profissaoNome = in.nextLine();
        Profissao profissao = new Profissao(profissaoNome);

        System.out.println("Email:");
        String email = in.nextLine();


        Cliente cliente = new Cliente(nome, dataNascimento, email, endereco, profissao);
        Cliente.telsContato.add(tel);
        CriacaoDb.adicionarCliente(cliente);
        System.out.println("\nCliente cadastrado com sucesso!\n");

    }

    private void criarFuncionario() {
        System.out.println("Digite os dados do Funcionário:\n");
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

        System.out.println("Telefone (DDD + Número):");

        String ddd = in.nextLine();
        String numeroTel = in.nextLine();
        Telefone tel = new Telefone(ddd, numeroTel);

        System.out.println("Profissão:");
        String cargoNome = in.nextLine();
        Cargo cargo = new Cargo(cargoNome);

        System.out.println("Email:");
        String email = in.nextLine();

        System.out.println("Salário:");
        double salario = Double.parseDouble(in.nextLine());

        Funcionario funcionario = new Funcionario(nome, dataNascimento, email, endereco, cargo, salario);
        Funcionario.telsContato.add(tel);
        CriacaoDb.adicionarFuncionario(funcionario);
        System.out.println("\nFuncionário cadastrado com sucesso!\n");
    }

        private void consultarCadastro() {
        // Implementar lógica de consulta
        System.out.println("Digite 1 para consultar Cliente ou 2 para Funcionario:");
        int tipoConsulta = in.nextInt();
        in.nextLine(); // consumir quebra de linha
        if (tipoConsulta == 1) {
            System.out.println("Digite o código do Cliente para consulta:");
            int codigoCliente = in.nextInt();
            in.nextLine(); // consumir quebra de linha


        } else if (tipoConsulta == 2) {
            System.out.println("Funcionalidade de consulta de Funcionário ainda não implementada.");
        } else {
            System.out.println("Erro: Opção inválida para consulta.");
        }
    }
}
