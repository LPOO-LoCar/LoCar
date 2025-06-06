package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class FinanceiroRepositorio extends RepositorioBase {

	public Map<String, Integer> obterDadosRelatorioMarca() {
		Map<String, Integer> contagemMarcas = new HashMap<>();

		String sqlLocacoes = "SELECT carro_id FROM locacao";
		String sqlMarca = "SELECT marca FROM carro WHERE id = ?";

		try (Connection connection = estabelecerConexao();
				Statement stmtLocacao = connection.createStatement();
				ResultSet rsLocacao = stmtLocacao.executeQuery(sqlLocacoes);
				PreparedStatement ps = connection.prepareStatement(sqlMarca)) {

			while (rsLocacao.next()) {
				Long carroId = rsLocacao.getLong("carro_id");

				ps.setLong(1, carroId); 
				try (ResultSet rsCarro = ps.executeQuery()) {
					if (rsCarro.next()) {
						String marca = rsCarro.getString("marca");
						contagemMarcas.put(marca, contagemMarcas.getOrDefault(marca, 0) + 1);
					}
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao obter dados do relatório de marcas: " + e.getMessage());
			e.printStackTrace();
		}

		return contagemMarcas;
	}

	public Map<String, Integer> obterDadosRelatorioModelo() {
	    Map<String, Integer> contagemModelos = new HashMap<>();

	    String sqlLocacoes = "SELECT carro_id FROM locacao";
	    String sqlModelo = "SELECT modelo FROM carro WHERE id = ?";

	    try (Connection connection = estabelecerConexao();
	         Statement stmtLocacao = connection.createStatement();
	         ResultSet rsLocacao = stmtLocacao.executeQuery(sqlLocacoes);
	         PreparedStatement psModelo = connection.prepareStatement(sqlModelo)) {

	        while (rsLocacao.next()) {
	            Long carroId = rsLocacao.getLong("carro_id");

	            psModelo.setLong(1, carroId);
	            try (ResultSet rsModelo = psModelo.executeQuery()) {
	                if (rsModelo.next()) {
	                    String modelo = rsModelo.getString("modelo");
	                    contagemModelos.put(modelo, contagemModelos.getOrDefault(modelo, 0) + 1);
	                }
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao obter dados do relatório de modelos: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return contagemModelos;
	}
	
	public double calcularReceitaTotal() {
	    String sql = "SELECT SUM(valorTotal) FROM locacao";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement statement = connection.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {

	        if (resultSet.next()) {
	            return resultSet.getDouble(1);
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao calcular receita total: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return 0.0;
	}


	public double calcularReceitaMesAtual() {
		return calcularReceita("WHERE STR_TO_DATE(dataLocacao, '%d/%m/%Y') >= DATE_FORMAT(NOW(), '%Y-%m-01')");
	}

	public double calcularReceitaSemestreAtual() {
		return calcularReceita(
				"WHERE STR_TO_DATE(dataLocacao, '%d/%m/%Y') >= DATE_FORMAT(NOW() - INTERVAL (MONTH(NOW())-1) MONTH, '%Y-01-01')");
	}

	public double calcularReceitaAnoAtual() {
		return calcularReceita("WHERE STR_TO_DATE(dataLocacao, '%d/%m/%Y') >= DATE_FORMAT(NOW(), '%Y-01-01')");
	}

	private double calcularReceita(String filtro) {
		String sql = "SELECT SUM(valorTotal) FROM locacao " + filtro;
		try (Connection connection = estabelecerConexao();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			if (resultSet.next()) {
				return resultSet.getDouble(1);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao calcular receita com filtro: " + e.getMessage());
			e.printStackTrace();
		}
		return 0.0;
	}

}
