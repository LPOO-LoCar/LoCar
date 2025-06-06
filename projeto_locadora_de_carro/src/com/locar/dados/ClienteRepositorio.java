package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.Cliente;

public class ClienteRepositorio extends RepositorioBase {
	
	public void registrarCliente(Cliente cliente) {
	    String sql = "INSERT INTO cliente (nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh, bairroRua, " +
	                 "numero, cep, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cliente.getNomeCompleto());
	        ps.setString(2, cliente.getDataNascimento());
	        ps.setString(3, cliente.getCpf());
	        ps.setString(4, cliente.getSexo());
	        ps.setString(5, cliente.getCnh());
	        ps.setString(6, cliente.getVencimentoCnh());
	        ps.setString(7, cliente.getBairroRua());
	        ps.setInt(8, cliente.getNumero());
	        ps.setString(9, cliente.getCep());
	        ps.setString(10, cliente.getCidade());
	        ps.setString(11, cliente.getEstado());
	        ps.setString(12, cliente.getTelefone());
	        ps.setString(13, cliente.getEmail());

	        ps.executeUpdate();
	        
	        System.out.println("Cliente registrado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void editarCliente(Cliente cliente) {
	    String sql = "UPDATE cliente SET nomeCompleto = ?, dataNascimento = ?, sexo = ?, cnh = ?, vencimentoCnh = ?, " +
	                 "bairroRua = ?, numero = ?, cep = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE cpf = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cliente.getNomeCompleto());
	        ps.setString(2, cliente.getDataNascimento());
	        ps.setString(3, cliente.getSexo());
	        ps.setString(4, cliente.getCnh());
	        ps.setString(5, cliente.getVencimentoCnh());
	        ps.setString(6, cliente.getBairroRua());
	        ps.setInt(7, cliente.getNumero());
	        ps.setString(8, cliente.getCep());
	        ps.setString(9, cliente.getCidade());
	        ps.setString(10, cliente.getEstado());
	        ps.setString(11, cliente.getTelefone());
	        ps.setString(12, cliente.getEmail());
	        ps.setString(13, cliente.getCpf()); 

	        ps.executeUpdate();
	        
	        System.out.println("Cliente atualizado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao editar cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void excluirCliente(String cpf) {
	    String sql = "DELETE FROM cliente WHERE cpf = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cpf);
	        
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	public Cliente buscarDadosCliente(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, sexo, cnh, vencimentoCnh, bairroRua, numero, "
	               + "cep, cidade, estado, telefone, email FROM cliente WHERE cpf = ?";

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, cpf);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Cliente(
	                    rs.getString("nomeCompleto"),
	                    rs.getString("dataNascimento"),
	                    rs.getString("sexo"),
	                    rs.getString("cnh"),
	                    rs.getString("vencimentoCnh"),
	                    rs.getString("bairroRua"),
	                    rs.getInt("numero"),
	                    rs.getString("cep"),
	                    rs.getString("cidade"),
	                    rs.getString("estado"),
	                    rs.getString("telefone"),
	                    rs.getString("email")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados do cliente: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}

	
	public List<Cliente> buscarTodosClientes() {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente";
	    List<Cliente> clientes = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Cliente cliente = new Cliente(
	                rs.getString("nomeCompleto"),
	                rs.getString("dataNascimento"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("sexo"),
	                rs.getString("cnh"),
	                rs.getString("vencimentoCnh")
	            );
	            clientes.add(cliente);
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar clientes: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return clientes;
	}
	
	public Cliente buscarClientePorCpf(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE cpf = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cpf);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Cliente(
	                    rs.getString("nomeCompleto"),
	                    rs.getString("dataNascimento"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("sexo"),
	                    rs.getString("cnh"),
	                    rs.getString("vencimentoCnh")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar cliente por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public List<Cliente> buscarClientesPorCpf(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE cpf LIKE ?";
	    List<Cliente> clientes = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cpf);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                clientes.add(new Cliente(
	                    rs.getString("nomeCompleto"),
	                    rs.getString("dataNascimento"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("sexo"),
	                    rs.getString("cnh"),
	                    rs.getString("vencimentoCnh")
	                ));
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar clientes por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return clientes;
	}
	
	public List<Cliente> buscarClientesPorNomeCompleto(String nomeCompleto) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE nomeCompleto LIKE ?";
	    List<Cliente> clientes = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "%" + nomeCompleto + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                clientes.add(new Cliente(
	                    rs.getString("nomeCompleto"),
	                    rs.getString("dataNascimento"),
	                    rs.getString("telefone"),
	                    rs.getString("email"),
	                    rs.getString("sexo"),
	                    rs.getString("cnh"),
	                    rs.getString("vencimentoCnh")
	                ));
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar clientes por nome completo: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return clientes;
	}
	
	public Cliente buscarClientePorId(long id) {
	    String sql = "SELECT id , nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh " +
	                 "FROM cliente WHERE id = " + id;
	    try (Connection conn = estabelecerConexao();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        if (rs.next()) {
	            Cliente cliente = new Cliente(rs.getString("nomeCompleto"), rs.getString("dataNascimento"),
	                               rs.getString("telefone"), rs.getString("email"),
	                               rs.getString("sexo"), rs.getString("cnh"),
	                               rs.getString("vencimentoCnh"));
	            cliente.setId(rs.getLong("id")); // Define o ID corretamente
	            return cliente;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public Cliente buscarIdPorCpf(String cpf) {
	    String sql = "SELECT id FROM cliente WHERE cpf = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, cpf);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Cliente(rs.getLong("id"));
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar ID de cliente por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
}
