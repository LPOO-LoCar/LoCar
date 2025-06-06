package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.Carro;

public class CarroRepositorio extends RepositorioBase {
	
	public void registrarCarro(Carro carro) {
		String sql = "INSERT INTO carro (marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria, " +
	             "conservacao, direcao, kmRodados, numLugares, numPortas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	try (Connection connection = estabelecerConexao();
	     PreparedStatement ps = connection.prepareStatement(sql)) {

	    ps.setString(1, carro.getMarca());
	    ps.setString(2, carro.getModelo());
	    ps.setInt(3, carro.getAno());
	    ps.setString(4, carro.getCor());
	    ps.setString(5, carro.getPlaca());
	    ps.setString(6, carro.getNumMotor());
	    ps.setString(7, carro.getChassi());
	    ps.setString(8, carro.getCombustivel());
	    ps.setString(9, carro.getTransmissao());
	    ps.setString(10, carro.getCategoria());
	    ps.setString(11, carro.getConservacao());
	    ps.setString(12, carro.getDirecao());
	    ps.setString(13, carro.getKmRodados());
	    ps.setInt(14, carro.getNumLugares());
	    ps.setInt(15, carro.getNumPortas());

	    ps.executeUpdate();
	    
	    System.out.println("Carro registrado com sucesso.");

	} catch (SQLException e) {
	    System.err.println("Erro ao registrar carro: " + e.getMessage());
	    e.printStackTrace();
	}

	}
	
	public void editarCarro(Carro carro) {
	    String sql = "UPDATE carro SET marca = ?, modelo = ?, ano = ?, cor = ?, numMotor = ?, chassi = ?, combustivel = ?, " +
	                 "transmissao = ?, categoria = ?, conservacao = ?, direcao = ?, kmRodados = ?, numLugares = ?, " +
	                 "numPortas = ? WHERE placa = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, carro.getMarca());
	        ps.setString(2, carro.getModelo());
	        ps.setInt(3, carro.getAno());
	        ps.setString(4, carro.getCor());
	        ps.setString(5, carro.getNumMotor());
	        ps.setString(6, carro.getChassi());
	        ps.setString(7, carro.getCombustivel());
	        ps.setString(8, carro.getTransmissao());
	        ps.setString(9, carro.getCategoria());
	        ps.setString(10, carro.getConservacao());
	        ps.setString(11, carro.getDirecao());
	        ps.setString(12, carro.getKmRodados());
	        ps.setInt(13, carro.getNumLugares());
	        ps.setInt(14, carro.getNumPortas());
	        ps.setString(15, carro.getPlaca());  

	        ps.executeUpdate();

	        System.out.println("Carro atualizado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao editar carro: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void excluirCarro(String placa) {
	    String sql = "DELETE FROM carro WHERE placa = ?";
	    
	    try (Connection connection = estabelecerConexao();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	    	
	        statement.setString(1, placa);
	        
	        statement.executeUpdate();
	        
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir carro: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public Carro buscarDadosCarro(String placa) {
	    String sql = "SELECT marca, modelo, ano, cor, numMotor, chassi, combustivel, transmissao, categoria, " +
	                 "conservacao, direcao, kmRodados, numLugares, numPortas FROM carro WHERE placa = ?";

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, placa);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("cor"),
	                    rs.getString("numMotor"),
	                    rs.getString("chassi"),
	                    rs.getString("combustivel"),
	                    rs.getString("transmissao"),
	                    rs.getString("categoria"),
	                    rs.getString("conservacao"),
	                    rs.getString("direcao"),
	                    rs.getString("kmRodados"),
	                    rs.getInt("numLugares"),
	                    rs.getInt("numPortas")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados do carro: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public List<Carro> buscarTodosCarros() {
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro";
	    List<Carro> carros = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            carros.add(new Carro(
	                rs.getLong("id"),
	                rs.getString("marca"),
	                rs.getString("modelo"),
	                rs.getInt("ano"),
	                rs.getString("cor"),
	                rs.getString("placa"),
	                rs.getString("numMotor"),
	                rs.getString("chassi"))
	            );

	        }

	        System.out.println("Lista de carros recuperada com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar todos os carros: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return carros;
	}
	
	public Carro buscarCarroPorPlacaParaConsulta(String placa) {
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE placa = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, placa);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(
	                    rs.getLong("id"),
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("cor"),
	                    rs.getString("placa"),
	                    rs.getString("numMotor"),
	                    rs.getString("chassi")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public List<Carro> buscarCarrosPorMarca(String marca) {
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE marca LIKE ?";
	    List<Carro> carros = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "%" + marca + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	carros.add(new Carro(
	                    rs.getLong("id"),
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("cor"),
	                    rs.getString("placa"),
	                    rs.getString("numMotor"),
	                    rs.getString("chassi"))
	                );
	            }
	        }

	        System.out.println("Carros encontrados por marca com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carros por marca: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return carros;
	}
	
	public List<Carro> buscarCarrosPorModelo(String modelo) {
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE modelo LIKE ?";
	    List<Carro> carros = new ArrayList<>();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, "%" + modelo + "%");

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	carros.add( new Carro(
	                    rs.getLong("id"),
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("cor"),
	                    rs.getString("placa"),
	                    rs.getString("numMotor"),
	                    rs.getString("chassi"))
	                );
	            }
	        }

	        System.out.println("Carros encontrados por modelo com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carros por modelo: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return carros;
	}

	
	public Carro buscarCarroPorPlaca(String placa) {
	    String sql = "SELECT marca, modelo, ano, kmRodados, categoria FROM carro WHERE placa = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, placa);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("kmRodados"),
	                    rs.getString("categoria")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public Carro buscarCarroPorId(long id) {
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE id = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setLong(1, id);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(
	                	rs.getLong("id"),
	                    rs.getString("marca"),
	                    rs.getString("modelo"),
	                    rs.getInt("ano"),
	                    rs.getString("cor"),
	                    rs.getString("placa"),
	                    rs.getString("numMotor"),
	                    rs.getString("chassi")
	                );
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carro por ID: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public Carro buscarIdPorPlaca(String placa) {
	    String sql = "SELECT id FROM carro WHERE placa = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setString(1, placa);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(rs.getLong("id"));
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar ID de carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}


}
