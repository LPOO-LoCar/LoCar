package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.AgendamentoVistoria;
import com.locar.entidades.Carro;

public class AgendamentoVistoriaRepositorio extends RepositorioBase {
	
	public void registrarAgendamentoVistoria(AgendamentoVistoria agendamentoVistoria) {
	    String sql = "INSERT INTO agendamentovistoria (id_carro, tipoVistoria, dataVistoria, hora, observacao) " +
	                 "VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setLong(1, agendamentoVistoria.getCarro().getId());
	        ps.setString(2, agendamentoVistoria.getTipoVistoria());
	        ps.setString(3, agendamentoVistoria.getDataVistoria());
	        ps.setString(4, agendamentoVistoria.getHora());
	        ps.setString(5, agendamentoVistoria.getObservacao());

	        ps.executeUpdate();

	        System.out.println("Agendamento de vistoria registrado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar agendamento de vistoria: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public List<AgendamentoVistoria> buscarTodosAgendamentosVistoria() {
	    String sql = "SELECT id_carro, tipoVistoria, dataVistoria, hora, observacao FROM agendamentovistoria";
	    List<AgendamentoVistoria> agendamentosVistoria = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            long carroId = rs.getLong("id_carro");
	            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	            agendamentosVistoria.add(new AgendamentoVistoria(
	                carro,
	                rs.getString("tipoVistoria"),
	                rs.getString("dataVistoria"),
	                rs.getString("hora"),
	                rs.getString("observacao"))
	            );
	            
	        }

	        System.out.println("Agendamentos de vistoria recuperados com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar agendamentos de vistoria: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return agendamentosVistoria;
	}


}
