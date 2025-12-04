package database;


import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDb {
    /// Cria as tabelas no banco de dados, caso não existam
    public static void inicializarBanco() {

        String sqlCreateTableCliente = "CREATE TABLE IF NOT EXISTS lista_clientes (" +
                "    codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    nome TEXT NOT NULL," +
                "    dataNascimento TEXT," +
                "    idade INTEGER," +
                "    endereco TEXT," +
                "    telefone TEXT," +
                "    profissao TEXT," +
                "    email TEXT," +
                "    dataCadastro TEXT" +
                ");";

        String sqlCreateTableFuncionarios = "CREATE TABLE IF NOT EXISTS lista_funcionarios (" +
                "    matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    nome TEXT NOT NULL," +
                "    dataNascimento TEXT," +
                "    idade INTEGER," +
                "    endereco TEXT," +
                "    telefone TEXT," +
                "    cargo TEXT," +
                "    email TEXT," +
                "    dataAdmissao TEXT" +
                ");";

        try (Connection conn = ConexaoDb.getConexao()) {

            assert conn != null;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sqlCreateTableCliente);
                stmt.execute(sqlCreateTableFuncionarios);

            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar o banco de dados.");
            e.printStackTrace();
        }
    }

    public static void adicionarCliente(models.Cliente cliente) {

        String sqlInsertCliente = "INSERT INTO lista_clientes(nome, dataNascimento, idade, endereco, telefone, profissao, email, dataCadastro) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertCliente)) {

                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, String.valueOf(cliente.getDataNascimento()));
                pstmt.setInt(3, cliente.getIdade());
                pstmt.setString(4, String.valueOf(cliente.getEndereco()));
                pstmt.setString(5, cliente.getTelefonesFormatados());
                pstmt.setString(6, String.valueOf(cliente.getProfissao()));
                pstmt.setString(7, cliente.getEmail());
                pstmt.setString(8, String.valueOf(cliente.getDataCadastro()));

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente.");
            e.printStackTrace();
        }

    }

    public static void adicionarFuncionario(models.Funcionario funcionario) {

        String sqlInsertFuncionario = "INSERT INTO lista_funcionarios(nome, dataNascimento, idade, endereco, telefone, cargo, email, dataAdmissao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertFuncionario)) {

                pstmt.setString(1, funcionario.getNome());
                pstmt.setString(2, String.valueOf(funcionario.getDataNascimento()));
                pstmt.setInt(3, funcionario.getIdade());
                pstmt.setString(4, String.valueOf(funcionario.getEndereco()));
                pstmt.setString(5, funcionario.getTelefonesFormatados());
                pstmt.setString(6, String.valueOf(funcionario.getCargo()));
                pstmt.setString(7, funcionario.getEmail());
                pstmt.setString(8, String.valueOf(funcionario.getDataAdmissao()));

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar funcionário.");
            e.printStackTrace();
        }
    }

    public static void listarClientes() {
        String sqlSelectClientes = "SELECT * FROM lista_clientes";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement()) {
                var rs = stmt.executeQuery(sqlSelectClientes);

                while (rs.next()) {
                    System.out.println("Código: " + rs.getInt("codigo"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Data de Nascimento: " + rs.getString("dataNascimento"));
                    System.out.println("Idade: " + rs.getInt("idade"));
                    System.out.println("Endereço: " + rs.getString("endereco"));
                    System.out.println("Telefone: " + rs.getString("telefone"));
                    System.out.println("Profissão: " + rs.getString("profissao"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Data de Cadastro: " + rs.getString("dataCadastro"));
                    System.out.println("\n---------------------------\n");
                }

            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }

    public static void listarFuncionarios() {
        String sqlSelectFuncionarios = "SELECT * FROM lista_funcionarios";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement()) {
                var rs = stmt.executeQuery(sqlSelectFuncionarios);

                while (rs.next()) {
                    System.out.println("Matrícula: " + rs.getInt("matricula"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Data de Nascimento: " + rs.getString("dataNascimento"));
                    System.out.println("Idade: " + rs.getInt("idade"));
                    System.out.println("Endereço: " + rs.getString("endereco"));
                    System.out.println("Telefone: " + rs.getString("telefone"));
                    System.out.println("Cargo: " + rs.getString("cargo"));
                    System.out.println("Email: " + rs.getString("email"));
                    System.out.println("Data de Admissão: " + rs.getString("dataAdmissao"));
                    System.out.println("\n---------------------------\n");
                }

            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionários.");
            e.printStackTrace();

        }
    }

  public static void consultarCadastroCliente(int id) {
      String sqlCliente = "SELECT * FROM lista_clientes WHERE codigo = ?";

      try (Connection conn = ConexaoDb.getConexao()) {
          assert conn != null;
          try (PreparedStatement ps = conn.prepareStatement(sqlCliente)) {
              ps.setInt(1, id);
              try (var rs = ps.executeQuery()) {
                  if (rs.next()) {
                      System.out.println("Cliente encontrado:");
                      System.out.println("Código: " + rs.getInt("codigo"));
                      System.out.println("Nome: " + rs.getString("nome"));
                      System.out.println("Data de Nascimento: " + rs.getString("dataNascimento"));
                      System.out.println("Idade: " + rs.getInt("idade"));
                      System.out.println("Endereço: " + rs.getString("endereco"));
                      System.out.println("Telefone: " + rs.getString("telefone"));
                      System.out.println("Profissão: " + rs.getString("profissao"));
                      System.out.println("Email: " + rs.getString("email"));
                      System.out.println("Data de Cadastro: " + rs.getString("dataCadastro"));
                      System.out.println("\n---------------------------\n");
                  } else {
                      System.out.println("Cliente com id " + id + " não encontrado.");
                  }
              }
          }
      } catch (SQLException e) {
          System.err.println("Erro ao consultar cliente.");
          e.printStackTrace();
      }
  }

  public static void consultarCadastroFuncionario(int id) {
      String sqlFuncionario = "SELECT * FROM lista_funcionarios WHERE matricula = ?";

      try (Connection conn = ConexaoDb.getConexao()) {
          assert conn != null;
          try (PreparedStatement ps = conn.prepareStatement(sqlFuncionario)) {
              ps.setInt(1, id);
              try (var rs = ps.executeQuery()) {
                  if (rs.next()) {
                      System.out.println("Funcionário encontrado:");
                      System.out.println("Matrícula: " + rs.getInt("matricula"));
                      System.out.println("Nome: " + rs.getString("nome"));
                      System.out.println("Data de Nascimento: " + rs.getString("dataNascimento"));
                      System.out.println("Idade: " + rs.getInt("idade"));
                      System.out.println("Endereço: " + rs.getString("endereco"));
                      System.out.println("Telefone: " + rs.getString("telefone"));
                      System.out.println("Cargo: " + rs.getString("cargo"));
                      System.out.println("Email: " + rs.getString("email"));
                      System.out.println("Data de Admissão: " + rs.getString("dataAdmissao"));
                      System.out.println("\n---------------------------\n");
                  } else {
                      System.out.println("Funcionário com id " + id + " não encontrado.");
                  }
              }
          }
      } catch (SQLException e) {
          System.err.println("Erro ao consultar funcionário.");
          e.printStackTrace();
      }
  }
}
