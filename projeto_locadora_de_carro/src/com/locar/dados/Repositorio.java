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
	
    public List<Cliente> buscarTodosClientes() {
        String sql = "SELECT nomeCompleto, dataNascimento, telefone, email , sexo, cnh, vencimentoCnh FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
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
            // TODO: Tratar exceção 

        }
        return clientes;
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
    
    public List<Carro> buscarTodosCarros() {
        String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro ";
        List<Carro> carros = new ArrayList<>();
        
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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
    
    public Cliente buscarClientePorId(long id) {
        String sql = "SELECT id , nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh " +
                     "FROM cliente WHERE id = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
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

    public Carro buscarCarroPorId(long id) {
        String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE id = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	Carro carro = new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), 
                                 rs.getString("cor"), rs.getString("placa"), rs.getString("numMotor"), 
                                 rs.getString("chassi"));
                carro.setId(rs.getLong("id"));
                return carro;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null;
    }
    
    public List<Locacao> buscarTodasLocacoes() {
        String sqlLocacao = "SELECT cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento FROM locacao";
        List<Locacao> locacoes = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao);
             ResultSet rsLocacao = stmtLocacao.executeQuery()) {

            while (rsLocacao.next()) { 
                long clienteId = rsLocacao.getLong("cliente_id");
                Cliente cliente = buscarClientePorId(clienteId);

                long carroId = rsLocacao.getLong("carro_id");
                Carro carro = buscarCarroPorId(carroId);

                Locacao locacao = new Locacao(
                        cliente, 
                        carro, 
                        rsLocacao.getDouble("valorDiaria"), 
                        rsLocacao.getInt("diasLocados"), 
                        rsLocacao.getDouble("valorTotal"), 
                        rsLocacao.getString("formaPagamento")
                );
                locacoes.add(locacao);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Substitua por um logger em produção
        }

        return locacoes;
    }
   
    public List<Locacao> buscarLocacaoPorCpf(String cpf) {
        String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
        String sqlLocacao = "SELECT carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento FROM locacao WHERE cliente_id = ?";
        List<Locacao> locacoes = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {

            stmtCliente.setString(1, cpf);
            ResultSet rsCliente = stmtCliente.executeQuery();

            if (rsCliente.next()) {
                long clienteId = rsCliente.getLong("id");
                Cliente cliente = buscarClientePorId(clienteId);

                try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
                    stmtLocacao.setLong(1, clienteId);
                    ResultSet rsLocacao = stmtLocacao.executeQuery();

                    while (rsLocacao.next()) { 
                        long carroId = rsLocacao.getLong("carro_id");
                        Carro carro = buscarCarroPorId(carroId);

                        Locacao locacao = new Locacao(
                                cliente, 
                                carro, 
                                rsLocacao.getDouble("valorDiaria"), 
                                rsLocacao.getInt("diasLocados"), 
                                rsLocacao.getDouble("valorTotal"), 
                                rsLocacao.getString("formaPagamento")
                        );
                        locacoes.add(locacao);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ou use um Logger
        }

        return locacoes;
    }
    
    public List<Locacao> buscarLocacaoPorPlaca(String placa) {
        String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
        String sqlLocacao = "SELECT cliente_id, valorDiaria, diasLocados, valorTotal, formaPagamento FROM locacao WHERE carro_id = ?";
        List<Locacao> locacoes = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {

            stmtCarro.setString(1, placa);
            ResultSet rsCarro = stmtCarro.executeQuery();

            if (rsCarro.next()) {
                long carroId = rsCarro.getLong("id");
                Carro carro = buscarCarroPorId(carroId);

                try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
                    stmtLocacao.setLong(1, carroId);
                    ResultSet rsLocacao = stmtLocacao.executeQuery();

                    while (rsLocacao.next()) { 
                        long clienteId = rsLocacao.getLong("cliente_id");
                        Cliente cliente = buscarClientePorId(clienteId);

                        Locacao locacao = new Locacao(
                                cliente, 
                                carro, 
                                rsLocacao.getDouble("valorDiaria"), 
                                rsLocacao.getInt("diasLocados"), 
                                rsLocacao.getDouble("valorTotal"), 
                                rsLocacao.getString("formaPagamento")
                        );
                        locacoes.add(locacao);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ou use um logger
        }

        return locacoes;
    }
    
    public List<Reserva> buscarTodasReservas() {
        String sqlReserva = "SELECT cliente_id, carro_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva";
        List<Reserva> reservas = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtLocacao = conn.prepareStatement(sqlReserva);
             ResultSet rsLocacao = stmtLocacao.executeQuery()) {

            while (rsLocacao.next()) { 
                long clienteId = rsLocacao.getLong("cliente_id");
                Cliente cliente = buscarClientePorId(clienteId);

                long carroId = rsLocacao.getLong("carro_id");
                Carro carro = buscarCarroPorId(carroId);

                Reserva reserva = new Reserva(
                        cliente, 
                        carro, 
                        rsLocacao.getString("dataRetirada"), 
                        rsLocacao.getString("HoraRetirada"), 
                        rsLocacao.getString("dataEntrega"), 
                        rsLocacao.getString("horaEntrega")
                );
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Substitua por um logger em produção
        }

        return reservas;
    }
    
    public List<Reserva> buscarReservaPorCpf(String cpf) {
        String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
        String sqlLocacao = "SELECT carro_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva WHERE cliente_id = ?";
        List<Reserva> reservas = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {

            stmtCliente.setString(1, cpf);
            ResultSet rsCliente = stmtCliente.executeQuery();

            if (rsCliente.next()) {
                long clienteId = rsCliente.getLong("id");
                Cliente cliente = buscarClientePorId(clienteId);

                try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
                    stmtLocacao.setLong(1, clienteId);
                    ResultSet rsLocacao = stmtLocacao.executeQuery();

                    while (rsLocacao.next()) { 
                        long carroId = rsLocacao.getLong("carro_id");
                        Carro carro = buscarCarroPorId(carroId);

                        Reserva reserva = new Reserva(
                                cliente, 
                                carro, 
                                rsLocacao.getString("dataRetirada"), 
                                rsLocacao.getString("HoraRetirada"), 
                                rsLocacao.getString("dataEntrega"), 
                                rsLocacao.getString("horaEntrega")
                        );
                       reservas.add(reserva);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        
        return reservas;
    }
    
    public List<Reserva> buscarReservaPorPlaca(String placa) {
        String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
        String sqlLocacao = "SELECT cliente_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva WHERE carro_id = ?";
        List<Reserva> reservas = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {

            stmtCarro.setString(1, placa);
            ResultSet rsCarro = stmtCarro.executeQuery();

            if (rsCarro.next()) {
                long carroId = rsCarro.getLong("id");
                Carro carro = buscarCarroPorId(carroId);

                try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
                    stmtLocacao.setLong(1, carroId);
                    ResultSet rsLocacao = stmtLocacao.executeQuery();

                    while (rsLocacao.next()) { 
                        long clienteId = rsLocacao.getLong("cliente_id");
                        Cliente cliente = buscarClientePorId(clienteId);

                        Reserva reserva = new Reserva(
                                cliente, 
                                carro, 
                                rsLocacao.getString("dataRetirada"), 
                                rsLocacao.getString("HoraRetirada"), 
                                rsLocacao.getString("dataEntrega"), 
                                rsLocacao.getString("horaEntrega")
                        );
                        reservas.add(reserva);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

}
