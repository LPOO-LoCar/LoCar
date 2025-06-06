package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.Funcionario;

public class FuncionarioRepositorio extends RepositorioBase {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/locadora_de_carro";
    private static final String USER = "root";
    private static final String PASSWORD = "192815Math@";

    public void inserirFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
                                   String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
                                   String rua, String numeroRua, String bairro, String cidade, String complemento,
                                   String senha) {
        String sql = "INSERT INTO funcionario (nome, cpf, rg, org_exp, telefone, email, data_nascimento, data_exp, " +
                "cnh, validade_cnh, cep, rua, numero_rua, bairro, cidade, complemento, senha) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, orgExp);
            stmt.setString(5, telefone);
            stmt.setString(6, email);
            stmt.setString(7, dataNascimento);
            stmt.setString(8, dataExp);
            stmt.setString(9, cnh);
            stmt.setString(10, validadeCNH);
            stmt.setString(11, cep);
            stmt.setString(12, rua);
            stmt.setString(13, numeroRua);
            stmt.setString(14, bairro);
            stmt.setString(15, cidade);
            stmt.setString(16, complemento);
            stmt.setString(17, senha);

            stmt.executeUpdate();
            
            System.out.println("Funcionario registrado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void editarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, rg = ?, org_exp = ?, telefone = ?, email = ?, data_nascimento = ?, "
        		   + "data_exp = ?, cnh = ?, validade_cnh = ?, cep = ?, rua = ?, numero_rua = ?, bairro = ?, cidade = ?, "
                   + "complemento = ?, senha = ? WHERE cpf = ?";

        try (Connection connection = estabelecerConexao();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getRg());
            ps.setString(3, funcionario.getOrgExp());
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getEmail());
            ps.setString(6, funcionario.getDataNascimento());
            ps.setString(7, funcionario.getDataExp());
            ps.setString(8, funcionario.getCnh());
            ps.setString(9, funcionario.getValidadeCNH());
            ps.setString(10, funcionario.getCep());
            ps.setString(11, funcionario.getRua());
            ps.setString(12, funcionario.getNumeroRua());
            ps.setString(13, funcionario.getBairro());
            ps.setString(14, funcionario.getCidade());
            ps.setString(15, funcionario.getComplemento());
            ps.setString(16, funcionario.getSenha());
            ps.setString(17, funcionario.getCpf());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao editar funcionário: " + e.getMessage());
            e.printStackTrace();
        }
    }

	public void excluirFuncionario(String cpf) {
	    String sql = "DELETE FROM funcionario WHERE cpf = ?";
	    
	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, cpf);
	        
	        preparedStatement.executeUpdate();
	        
	        System.out.println("Funcionário excluído com sucesso");

	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir funcionário: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public Funcionario buscarDadosFuncionario(String cpf) {
	    String sql = "SELECT nome, rg, org_exp, telefone, email, data_nascimento, data_exp, cnh, validade_cnh, cep, rua, " +
	                 "numero_rua, bairro, cidade, complemento, senha FROM funcionario WHERE cpf = ?";

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, cpf);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Funcionario(
	                    rs.getString("nome"),
	                    rs.getString("rg"),
	                    rs.getString("org_exp"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("data_nascimento"),
	                    rs.getString("data_exp"),
	                    rs.getString("cnh"),
	                    rs.getString("validade_cnh"),
	                    rs.getString("cep"),
	                    rs.getString("rua"),
	                    rs.getString("numero_rua"),
	                    rs.getString("bairro"),
	                    rs.getString("cidade"),
	                    rs.getString("complemento"),
	                    rs.getString("senha")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados do funcionário: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public List<Funcionario> buscarTodosFuncionarios() {
	    String sql = "SELECT nome, rg, telefone, email, data_nascimento, cnh, validade_cnh, cep FROM funcionario";
	    List<Funcionario> funcionarios = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	        	funcionarios.add(new Funcionario(
	                rs.getString("nome"),
	                rs.getString("rg"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("data_nascimento"),  
	                rs.getString("cnh"),
	                rs.getString("validade_cnh"),
	                rs.getString("cep"))
	            );
	        	
	        }

	        System.out.println("Funcionários buscados com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar funcionários: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return funcionarios;
	}
	
	public Funcionario buscarFuncionarioPorCpf(String cpf) {
	    String sql = "SELECT nome, rg, telefone, email, data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE cpf = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cpf);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Funcionario(
	                    rs.getString("nome"),
	                    rs.getString("rg"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("data_nascimento"),
	                    rs.getString("cnh"),
	                    rs.getString("validade_cnh"),
	                    rs.getString("cep")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar funcionário por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public Funcionario buscarFuncionarioPorNome(String nome) {
	    String sql = "SELECT nome, rg, telefone, email, data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE nome = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, nome);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Funcionario(
	                    rs.getString("nome"),
	                    rs.getString("rg"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("data_nascimento"),
	                    rs.getString("cnh"),
	                    rs.getString("validade_cnh"),
	                    rs.getString("cep")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar funcionário por nome: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}

	public boolean autenticarFuncionario(String cpf, String senha) {
	    String sql = "SELECT senha FROM funcionario WHERE cpf = ?";

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            String senhaCorreta = rs.getString("senha");
	            return senha.equals(senhaCorreta);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    }

	    return false;
	}
}