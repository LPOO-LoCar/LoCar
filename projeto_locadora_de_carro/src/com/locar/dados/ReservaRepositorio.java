package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;
import com.locar.entidades.Reserva;

public class ReservaRepositorio extends RepositorioBase {
	
	public void registrarReserva(Reserva reserva) {
	    String sql = "INSERT INTO reserva (cliente_id, carro_id, dataRetirada, horaRetirada, dataEntrega, horaEntrega) " +
	                 "VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setLong(1, reserva.getCliente().getId());
	        ps.setLong(2, reserva.getCarro().getId());
	        ps.setString(3, reserva.getDataRetirada());
	        ps.setString(4, reserva.getHoraRetirada());
	        ps.setString(5, reserva.getDataEntrega());
	        ps.setString(6, reserva.getHoraEntrega());

	        ps.executeUpdate();

	        System.out.println("Reserva registrada com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar reserva: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void editarReserva(Reserva reserva) {
	    String sql = "UPDATE reserva SET cliente_id = ?, carro_id = ?, dataRetirada = ?, horaRetirada = ?, " +
	                 "dataEntrega = ?, horaEntrega = ? WHERE cliente_id = ? AND carro_id = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setLong(1, reserva.getCliente().getId());
	        preparedStatement.setLong(2, reserva.getCarro().getId());
	        preparedStatement.setString(3, reserva.getDataRetirada());
	        preparedStatement.setString(4, reserva.getHoraRetirada());
	        preparedStatement.setString(5, reserva.getDataEntrega());
	        preparedStatement.setString(6, reserva.getHoraEntrega());
	        preparedStatement.setLong(7, reserva.getCliente().getId());
	        preparedStatement.setLong(8, reserva.getCarro().getId());

	        preparedStatement.executeUpdate();
	        System.out.println("Reserva editada com sucesso");

	    } catch (SQLException e) {
	        System.err.println("Erro ao editar reserva: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void excluirReserva(String cpf, String placa) {
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		CarroRepositorio carroRepositorio = new CarroRepositorio();
		Cliente cliente = clienteRepositorio.buscarIdPorCpf(cpf);
		Carro carro = carroRepositorio.buscarIdPorPlaca(placa);

		String sql = "DELETE FROM reserva WHERE cliente_id = ? AND carro_id = ?";

		try (Connection connection = estabelecerConexao(); 
			PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setLong(1, cliente.getId());
			ps.setLong(2, carro.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Erro ao excluir reserva: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Reserva buscarDadosReserva(String cpf, String placa) {
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		CarroRepositorio carroRepositorio = new CarroRepositorio();
		Cliente cliente = clienteRepositorio.buscarIdPorCpf(cpf);
		Carro carro = carroRepositorio.buscarIdPorPlaca(placa);
		
		String sql = "SELECT dataRetirada, horaRetirada, dataEntrega, horaEntrega FROM reserva WHERE cliente_id = ? AND carro_id = ?";

		try (Connection conn = estabelecerConexao(); 
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setLong(1, cliente.getId());
			ps.setLong(2, carro.getId());
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Reserva(rs.getString("dataRetirada"), rs.getString("horaRetirada"),
							rs.getString("dataEntrega"), rs.getString("horaEntrega"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar dados da reserva: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reserva> buscarTodasReservas() {
	    String sqlReserva = "SELECT cliente_id, carro_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva";
	    List<Reserva> reservas = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva);
	         ResultSet rsReserva = stmtReserva.executeQuery()) {

	        while (rsReserva.next()) {
	            long clienteId = rsReserva.getLong("cliente_id");
	            Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	            long carroId = rsReserva.getLong("carro_id");
	            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	            Reserva reserva = new Reserva(
	                cliente,
	                carro,
	                rsReserva.getString("dataRetirada"),
	                rsReserva.getString("HoraRetirada"),
	                rsReserva.getString("dataEntrega"),
	                rsReserva.getString("horaEntrega")
	            );
	            reservas.add(reserva);
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar todas as reservas: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return reservas;
	}
	
	public List<Reserva> buscarReservaPorPlaca(String placa) {
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlReserva = "SELECT cliente_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva WHERE carro_id = ?";
	    List<Reserva> reservas = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {

	        stmtCarro.setString(1, placa);
	        try (ResultSet rsCarro = stmtCarro.executeQuery()) {
	            if (rsCarro.next()) {
	                long carroId = rsCarro.getLong("id");
	                Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	                try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
	                    stmtReserva.setLong(1, carroId);
	                    try (ResultSet rsReserva = stmtReserva.executeQuery()) {
	                        while (rsReserva.next()) {
	                            long clienteId = rsReserva.getLong("cliente_id");
	                            Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	                            Reserva reserva = new Reserva(
	                                cliente,
	                                carro,
	                                rsReserva.getString("dataRetirada"),
	                                rsReserva.getString("HoraRetirada"),
	                                rsReserva.getString("dataEntrega"),
	                                rsReserva.getString("horaEntrega")
	                            );
	                            reservas.add(reserva);
	                        }
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar reserva por placa: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return reservas;
	}
	
	public List<Reserva> buscarReservaPorCpf(String cpf) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlReserva = "SELECT carro_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva WHERE cliente_id = ?";
	    List<Reserva> reservas = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();
	    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {

	        stmtCliente.setString(1, cpf);
	        try (ResultSet rsCliente = stmtCliente.executeQuery()) {
	            if (rsCliente.next()) {
	                long clienteId = rsCliente.getLong("id");
	                Cliente cliente = clienteRepositorio.buscarClientePorId(clienteId);

	                try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
	                    stmtReserva.setLong(1, clienteId);
	                    try (ResultSet rsReserva = stmtReserva.executeQuery()) {
	                        while (rsReserva.next()) {
	                            long carroId = rsReserva.getLong("carro_id");
	                            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	                            Reserva reserva = new Reserva(
	                                cliente,
	                                carro,
	                                rsReserva.getString("dataRetirada"),
	                                rsReserva.getString("HoraRetirada"),
	                                rsReserva.getString("dataEntrega"),
	                                rsReserva.getString("horaEntrega")
	                            );
	                            reservas.add(reserva);
	                        }
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar reserva por CPF: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return reservas;
	}

}
