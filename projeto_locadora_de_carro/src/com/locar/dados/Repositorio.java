package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.locar.entidades.*;

public class Repositorio {
	
	private Connection estabelecerConexao() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/locadora_de_carro", "root", "192815Math@");
            
		} catch (Exception e1){
			// TODO Tratar exceção
		}
		return connection;   
	}
	
	public void registrarCliente (Cliente cliente) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO cliente (nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh, bairroRua,"
					+ " numero, cep, cidade, estado, telefone, email) VALUES ('" + cliente.getNomeCompleto() + "', '" + cliente.getDataNascimento()
					+"', '" + cliente.getCpf() + "', '" + cliente.getSexo() + "', '" + cliente.getCnh() + "', '" + cliente.getVencimentoCnh() + "', '" + cliente.getBairroRua() + "', '" + cliente.getNumero()
					+ "', '" + cliente.getCep() + "', '" + cliente.getCidade() + "', '" + cliente.getEstado() 
					+ "', '" + cliente.getTelefone() + "', '" + cliente.getEmail() + "')");
			
		} catch (SQLException e) {
			// TODO tratar exceção
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e) {
				//TODO tratar exeção
			}
		}
		
	}
	
	public void registrarCarro (Carro carro) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO carro (marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,"
					+ " conservacao, direcao, kmRodados, numLugares, numPortas) VALUES ('" + carro.getMarca() + "', '" + carro.getModelo()
					+ "', '" + carro.getAno() + "', '" + carro.getCor() + "', '" + carro.getPlaca() + "', '" + carro.getNumMotor()
					+ "', '" + carro.getChassi() + "', '" + carro.getCombustivel() + "', '" + carro.getTransmissao()
					+ "', '" + carro.getCategoria() + "', '" + carro.getConservacao() + "', '" + carro.getDirecao()
					+ "', '" + carro.getKmRodados() + "', '" + carro.getNumLugares() + "', '" + carro.getNumPortas() + "')");
			
		} catch (SQLException e) {
			// TODO tratar exceção
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e) {
				//TODO tratar exeção
			}
		}
		
	}
	
    public Cliente buscarClientePorCPF(String cpf) {
        String sql = "SELECT nomeCompleto, telefone, email FROM cliente WHERE cpf = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(rs.getString("nomeCompleto"), rs.getString("telefone"), rs.getString("email"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
}
