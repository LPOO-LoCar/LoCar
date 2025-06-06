package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;
import com.locar.entidades.Locacao;

public class LocacaoRepositorio extends RepositorioBase {
	public void registrarLocacao(Locacao locacao) {
		String sql = "INSERT INTO locacao (cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status, dataLocacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = estabelecerConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setLong(1, locacao.getCliente().getId());
			preparedStatement.setLong(2, locacao.getCarro().getId());
			preparedStatement.setDouble(3, locacao.getValorDiaria());
			preparedStatement.setInt(4, locacao.getDiasLocados());
			preparedStatement.setDouble(5, locacao.getValorTotal());
			preparedStatement.setString(6, locacao.getFormaPagamento());
			preparedStatement.setString(7, locacao.getStatus());
			preparedStatement.setString(8, locacao.getDataLocacao());

			preparedStatement.executeUpdate();

			System.out.println("locação registrada com sucesso");

		} catch (SQLException e) {
			System.err.println("Erro ao registrar locação: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void editarLocacao(Locacao locacao) {
		String sql = "UPDATE locacao SET cliente_id = ?, carro_id = ?, valorDiaria = ?, diasLocados = ?, "
				+ "valorTotal = ?, formaPagamento = ?, status = ? WHERE cliente_id = ? AND carro_id = ?";

		try (Connection connection = estabelecerConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setLong(1, locacao.getCliente().getId());
			ps.setLong(2, locacao.getCarro().getId());
			ps.setDouble(3, locacao.getValorDiaria());
			ps.setInt(4, locacao.getDiasLocados());
			ps.setDouble(5, locacao.getValorTotal());
			ps.setString(6, locacao.getFormaPagamento());
			ps.setString(7, locacao.getStatus());
			ps.setLong(8, locacao.getCliente().getId());
			ps.setLong(9, locacao.getCarro().getId());

			ps.executeUpdate();

			System.out.println("locação editada com sucesso");

		} catch (SQLException e) {
			System.err.println("Erro ao editar locação: " + e.getMessage());
		}
	}

	public void excluirLocacao(String cpf, String placa) {
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		CarroRepositorio carroRepositorio = new CarroRepositorio();
		Cliente cliente = clienteRepositorio.buscarIdPorCpf(cpf);
		Carro carro = carroRepositorio.buscarIdPorPlaca(placa);

		String sql = "DELETE FROM locacao WHERE cliente_id = ? AND carro_id = ?";

		try (Connection connection = estabelecerConexao(); 
			PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setLong(1, cliente.getId());
			ps.setLong(2, carro.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erro ao excluir locação: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Locacao buscarDadosLocacao(String cpf, String placa) {
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		CarroRepositorio carroRepositorio = new CarroRepositorio();
		Cliente cliente = clienteRepositorio.buscarIdPorCpf(cpf);
		Carro carro = carroRepositorio.buscarIdPorPlaca(placa);

		String sql = "SELECT valorDiaria, diasLocados, valorTotal, formaPagamento, status"
				+ " FROM locacao WHERE cliente_id = ? AND carro_id = ?";

		try (Connection conn = estabelecerConexao(); 
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setLong(1, cliente.getId());
			ps.setLong(2, carro.getId());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Locacao(rs.getDouble("valorDiaria"), rs.getInt("diasLocados"),
							rs.getDouble("valorTotal"), rs.getString("formaPagamento"),
							rs.getString("status"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar dados da locação: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Locacao> buscarTodasLocacoes() {
	    String sqlLocacao = "SELECT cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao";
	    List<Locacao> locacoes = new ArrayList<>();

	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement ps = conn.prepareStatement(sqlLocacao);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            long clienteId = rs.getLong("cliente_id");
	            Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	            long carroId = rs.getLong("carro_id");
	            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	            locacoes.add(new Locacao(
	                cliente,
	                carro,
	                rs.getDouble("valorDiaria"),
	                rs.getInt("diasLocados"),
	                rs.getDouble("valorTotal"),
	                rs.getString("formaPagamento"),
	                rs.getString("status"))
	            );

	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar locações: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return locacoes;
	}
	
	public List<Locacao> buscarLocacaoPorCpf(String cpf) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlLocacao = "SELECT carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE cliente_id = ?";
	    List<Locacao> locacoes = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement psCliente = conn.prepareStatement(sqlCliente)) {

	        psCliente.setString(1, cpf);
	        try (ResultSet rsCliente = psCliente.executeQuery()) {

	            if (rsCliente.next()) {
	                long clienteId = rsCliente.getLong("id");
	                Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	                try (PreparedStatement psLocacao = conn.prepareStatement(sqlLocacao)) {
	                    psLocacao.setLong(1, clienteId);
	                    try (ResultSet rsLocacao = psLocacao.executeQuery()) {

	                        while (rsLocacao.next()) {
	                            long carroId = rsLocacao.getLong("carro_id");
	                            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	                            Locacao locacao = new Locacao(
	                                cliente,
	                                carro,
	                                rsLocacao.getDouble("valorDiaria"),
	                                rsLocacao.getInt("diasLocados"),
	                                rsLocacao.getDouble("valorTotal"),
	                                rsLocacao.getString("formaPagamento"),
	                                rsLocacao.getString("status")
	                            );

	                            locacoes.add(locacao);
	                        }
	                    }
	                }
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar locações por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return locacoes;
	}
	
	public List<Locacao> buscarLocacaoPorPlaca(String placa) {
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlLocacao = "SELECT cliente_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE carro_id = ?";
	    List<Locacao> locacoes = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement psCarro = conn.prepareStatement(sqlCarro)) {

	        psCarro.setString(1, placa);
	        try (ResultSet rsCarro = psCarro.executeQuery()) {

	            if (rsCarro.next()) {
	                long carroId = rsCarro.getLong("id");
	                Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	                try (PreparedStatement psLocacao = conn.prepareStatement(sqlLocacao)) {
	                    psLocacao.setLong(1, carroId);
	                    try (ResultSet rsLocacao = psLocacao.executeQuery()) {

	                        while (rsLocacao.next()) {
	                            long clienteId = rsLocacao.getLong("cliente_id");
	                            Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	                            Locacao locacao = new Locacao(
	                                cliente,
	                                carro,
	                                rsLocacao.getDouble("valorDiaria"),
	                                rsLocacao.getInt("diasLocados"),
	                                rsLocacao.getDouble("valorTotal"),
	                                rsLocacao.getString("formaPagamento"),
	                                rsLocacao.getString("status")
	                            );

	                            locacoes.add(locacao);
	                        }
	                    }
	                }
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar locações por placa: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return locacoes;
	}


}
