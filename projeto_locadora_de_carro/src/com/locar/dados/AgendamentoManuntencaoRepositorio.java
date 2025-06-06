package com.locar.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locar.entidades.AgendamentoManutencao;
import com.locar.entidades.Carro;

public class AgendamentoManuntencaoRepositorio extends RepositorioBase {
	
	public void registrarAgendamentoManutencao(AgendamentoManutencao agendamentoManuntencao) {
	    String sql = "INSERT INTO agendamentomanuntencao (id_carro, tipoManuntencao, dataManuntencao, hora, observacao) " +
	                 "VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        ps.setLong(1, agendamentoManuntencao.getCarro().getId());
	        ps.setString(2, agendamentoManuntencao.getTipoManuntencao());
	        ps.setString(3, agendamentoManuntencao.getDataManuntencao());
	        ps.setString(4, agendamentoManuntencao.getHora());
	        ps.setString(5, agendamentoManuntencao.getObservacao());

	        ps.executeUpdate();

	        System.out.println("Agendamento de manutenção registrado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar agendamento de manutenção: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public List<AgendamentoManutencao> buscarTodosAgendamentosManutencao() {
	    String sql = "SELECT id_carro, tipoManutencao, dataManutencao, hora, observacao FROM agendamentomanutencao";
	    List<AgendamentoManutencao> agendamentos = new ArrayList<>();
	    CarroRepositorio carroRepositorio = new CarroRepositorio();

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            long carroId = rs.getLong("id_carro");
	            Carro carro = carroRepositorio.buscarCarroPorId(carroId);

	            agendamentos.add( new AgendamentoManutencao(
	                carro,
	                rs.getString("tipoManutencao"),
	                rs.getString("dataManutencao"),
	                rs.getString("hora"),
	                rs.getString("observacao"))
	            );
	            
	        }

	        System.out.println("Agendamentos de manutenção recuperados com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar agendamentos de manutenção: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return agendamentos;
	}

}
