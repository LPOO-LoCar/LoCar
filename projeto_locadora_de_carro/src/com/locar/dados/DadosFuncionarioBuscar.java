package com.locar.dados;

import com.locar.entidades.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DadosFuncionarioBuscar {

    private Connection conexao;

    public DadosFuncionarioBuscar() {
        conectarBancoDeDados();
    }

    private void conectarBancoDeDados() {
        try {
            String url = "jdbc:mysql://localhost:3306/mydb-lpoo?useTimezone=true&serverTimezone=America/Recife&useSSL=false";
            String usuario = "root";
            String senha = "1234";
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public List<Funcionario> buscarFuncionarios(String cpf, String nome, String telefone) {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios WHERE 1=1";

        if (cpf != null && !cpf.isEmpty()) {
            sql += " AND cpf = ?";
        }

        if (nome != null && !nome.isEmpty()) {
            sql += " AND nome LIKE ?"; // Busca parcial por nome (case-insensitive)
        }

        if (telefone != null && !telefone.isEmpty()) {
            sql += " AND telefone = ?";
        }

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            int paramIndex = 1;

            if (cpf != null && !cpf.isEmpty()) {
                stmt.setString(paramIndex++, cpf);
            }

            if (nome != null && !nome.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nome + "%"); // Adiciona % para busca parcial
            }

            if (telefone != null && !telefone.isEmpty()) {
                stmt.setString(paramIndex++, telefone);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Funcionario funcionario = new Funcionario(
                            rs.getString("cpf"),
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("data_nascimento"),
                            rs.getString("email"),
                            rs.getString("cnh")
                    );
                    funcionarios.add(funcionario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionários: " + e.getMessage());
        }
        return funcionarios;
    }

    public Funcionario buscarPorCPF(String cpf) { // Adiciona o parâmetro cpf
        try {
            String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf); // Usa o cpf como valor

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario(
                            rs.getString("cpf"),
                            rs.getString("nome"),
                            rs.getString("telefone")
                    );
                    return funcionario;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário por CPF:");
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar funcionário por CPF: " + e.getMessage());
        }
        return null;
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                System.out.println("Conexão com o banco de dados fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão:");
            e.printStackTrace();
            throw new RuntimeException("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

	public Connection getConexao() {
		return this.conexao;
	}

private void verificarConexao() {
    try {
        if (conexao == null || conexao.isClosed()) {
            conectarBancoDeDados(); // Reabre a conexão se estiver fechada
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao verificar a conexão com o banco de dados: " + e.getMessage());
    }
}
}