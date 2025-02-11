package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public void registrarLocacao (Locacao locacao) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO locacao (cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento) "
					+ " VALUES ('" + locacao.getCliente().getId() + "', '" + locacao.getCarro().getId() + "', '" 
					+ locacao.getValorDiaria() + "', '" + locacao.getDiasLocados() + "', '" + locacao.getValorTotal() 
					+ "', '" + locacao.getFormaPagamento() + "')");
			
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
	
	public void registrarReserva (Reserva reserva) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO reserva (cliente_id, carro_id, dataRetirada, horaRetirada,dataEntrega,horaEntrega) "
					+ " VALUES ('" + reserva.getCliente().getId() + "', '" + reserva.getCarro().getId() + "', '" 
					+ reserva.getDataRetirada() + "', '" + reserva.getHoraRetirada() + "', '" + reserva.getDataEntrega() 
					+ "', '" + reserva.getHoraEntrega() + "')");
			
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
	
    public Cliente buscarClientePorCpf(String cpf) {
        String sql = "SELECT nomeCompleto, dataNascimento, telefone, email , sexo, cnh, vencimentoCnh FROM cliente WHERE cpf = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(rs.getString("nomeCompleto"),rs.getString("dataNascimento"), rs.getString("telefone"),
                		rs.getString("email"), rs.getString("sexo"), rs.getString("cnh"), rs.getString("vencimentoCnh"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public Cliente buscarClientePorNomeCompleto(String nomeCompleto) {
        String sql = "SELECT nomeCompleto, dataNascimento, telefone, email , sexo, cnh, vencimentoCnh FROM cliente WHERE nomeCompleto = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCompleto);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(rs.getString("nomeCompleto"),rs.getString("dataNascimento"), rs.getString("telefone"),
                		rs.getString("email"), rs.getString("sexo"), rs.getString("cnh"), rs.getString("vencimentoCnh"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public Carro buscarCarro(String placa) {
        String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE placa = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("cor")
                		, rs.getString("placa"), rs.getString("numMotor"), rs.getString("chassi"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public List<Carro> buscarCarrosPorMarca(String marca) {
        String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE marca = ?";
        List<Carro> carros = new ArrayList<>();
        
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { 
                Carro carro = new Carro(
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getString("cor"),
                    rs.getString("placa"),
                    rs.getString("numMotor"),
                    rs.getString("chassi")
                );
                carros.add(carro); 
            }
        } catch (SQLException e) {
            // TODO: Tratar exceção 

        }
        return carros;
    }
    
    public List<Carro> buscarCarrosPorModelo(String modelo) {
        String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE modelo = ?";
        List<Carro> carros = new ArrayList<>();
        
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, modelo);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { 
                Carro carro = new Carro(
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getString("cor"),
                    rs.getString("placa"),
                    rs.getString("numMotor"),
                    rs.getString("chassi")
                );
                carros.add(carro); 
            }
        } catch (SQLException e) {
            // TODO: Tratar exceção 

        }
        return carros;
    }
    
    public Carro buscarCarroPorPlaca(String placa) {
        String sql = "SELECT marca, modelo, ano, kmRodados FROM carro WHERE placa = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("kmRodados"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    

    
    public Cliente buscarIdPorCpf(String cpf) {
        String sql = "SELECT id FROM cliente WHERE cpf = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(rs.getLong("id"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public Carro buscarIdPorPlaca(String placa) {
        String sql = "SELECT id FROM carro WHERE placa = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Carro(rs.getLong("id"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public Locacao buscarLocacao(String cpf, String placa) {
        String sql = "SELECT cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento FROM locacao "
        		+ " WHERE cliente_id = (SELECT id FROM cliente WHERE cpf = ?) AND carro_id = (SELECT id FROM carro WHERE placa = ?)";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setString(2, placa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	Cliente cliente = buscarIdPorCpf(rs.getString("cliente_id"));
            	Carro carro = buscarIdPorPlaca(rs.getString("carro_id"));
                return new Locacao(cliente, carro, rs.getDouble("valorDiaria"), rs.getInt("diasLocados"), rs.getDouble("valorTotal"), rs.getString("formaPagamento"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    } 

}
