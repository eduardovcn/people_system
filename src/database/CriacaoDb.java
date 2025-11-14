package database;


import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoDb {

    public static void inicializarBanco() {

        String sqlCreateTableCliente = "CREATE TABLE IF NOT EXISTS lista_clientes (" +
                "    codigo INTEGER PRIMARY KEY," +
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
                "    matricula INTEGER PRIMARY KEY," +
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

    public static void adicionarCliente(Cliente cliente) {

        String sqlInsertCliente = "INSERT INTO lista_clientes(codigo, nome, dataNascimento, idade, endereco, telefone, profissao, email, dataCadastro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertCliente)) {

                pstmt.setInt(1, cliente.getCodigo());
                pstmt.setString(2, cliente.getNome());
                pstmt.setString(3, String.valueOf(cliente.getDataNascimento()));
                pstmt.setInt(4, cliente.getIdade());
                pstmt.setString(5, String.valueOf(cliente.getEndereco()));
                pstmt.setString(6, cliente.getTel());
                pstmt.setString(7, String.valueOf(cliente.getProfissao()));
                pstmt.setString(8, cliente.getEmail());
                pstmt.setString(9, String.valueOf(cliente.getDataCadastro()));

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente.");
            e.printStackTrace();
        }

    }

    public static void adicionarFuncionario(Funcionario funcionario) {

        String sqlInsertFuncionario = "INSERT INTO lista_funcionarios(matricula, nome, dataNascimento, idade, endereco, telefone, cargo, email, dataAdmissao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDb.getConexao()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertFuncionario)) {

                pstmt.setInt(1, funcionario.getMatricula());
                pstmt.setString(2, funcionario.getNome());
                pstmt.setString(3, String.valueOf(funcionario.getDataNascimento()));
                pstmt.setInt(4, funcionario.getIdade());
                pstmt.setString(5, String.valueOf(funcionario.getEndereco()));
                pstmt.setString(6, funcionario.getTel());
                pstmt.setString(7, String.valueOf(funcionario.getCargo()));
                pstmt.setString(8, funcionario.getEmail());
                pstmt.setString(9, String.valueOf(funcionario.getDataAdmissao()));

                pstmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar funcionário.");
            e.printStackTrace();
        }
    }

}
