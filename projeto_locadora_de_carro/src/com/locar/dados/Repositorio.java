package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void EditarCliente (Cliente cliente) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("UPDATE cliente SET " +
                    "nomeCompleto = '" + cliente.getNomeCompleto() + "', " +
                    "dataNascimento = '" + cliente.getDataNascimento() + "', " +
                    "sexo = '" + cliente.getSexo() + "', " +
                    "cnh = '" + cliente.getCnh() + "', " +
                    "vencimentoCnh = '" + cliente.getVencimentoCnh() + "', " +
                    "bairroRua = '" + cliente.getBairroRua() + "', " +
                    "numero = '" + cliente.getNumero() + "', " +
                    "cep = '" + cliente.getCep() + "', " +
                    "cidade = '" + cliente.getCidade() + "', " +
                    "estado = '" + cliente.getEstado() + "', " +
                    "telefone = '" + cliente.getTelefone() + "', " +
                    "email = '" + cliente.getEmail() + "' " +
                    "WHERE cpf = '" + cliente.getCpf() + "'");
			
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
	
	public void excluirCliente (String cpf) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("DELETE FROM cliente WHERE cpf = '" + cpf + "'");
			
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
	
	public Carro buscarDadosCarro(String placa) {
	    String sql = "SELECT marca, modelo, ano, cor, numMotor, chassi, combustivel, transmissao, categoria, " +
	                 "conservacao, direcao, kmRodados, numLugares, numPortas FROM carro WHERE placa = ?";
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, placa);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("cor"),
	                             rs.getString("numMotor"), rs.getString("chassi"), rs.getString("combustivel"),
	                             rs.getString("transmissao"), rs.getString("categoria"), rs.getString("conservacao"),
	                             rs.getString("direcao"), rs.getString("kmRodados"), rs.getInt("numLugares"),
	                             rs.getInt("numPortas"));
	        }
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    }
	    return null;
	}
	
	public void editarCarro(Carro carro) {
	    Connection connection = estabelecerConexao();
	    Statement statement = null;
	    try {
	        statement = connection.createStatement();
	        statement.execute("UPDATE carro SET " +
	                "marca = '" + carro.getMarca() + "', " +
	                "modelo = '" + carro.getModelo() + "', " +
	                "ano = '" + carro.getAno() + "', " +
	                "cor = '" + carro.getCor() + "', " +
	                "numMotor = '" + carro.getNumMotor() + "', " +
	                "chassi = '" + carro.getChassi() + "', " +
	                "combustivel = '" + carro.getCombustivel() + "', " +
	                "transmissao = '" + carro.getTransmissao() + "', " +
	                "categoria = '" + carro.getCategoria() + "', " +
	                "conservacao = '" + carro.getConservacao() + "', " +
	                "direcao = '" + carro.getDirecao() + "', " +
	                "kmRodados = '" + carro.getKmRodados() + "', " +
	                "numLugares = '" + carro.getNumLugares() + "', " +
	                "numPortas = '" + carro.getNumPortas() + "' " +
	                "WHERE placa = '" + carro.getPlaca() + "'");
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    } finally {
	        try {
	            statement.close();
	            connection.close();
	        } catch (Exception e) {
	            // TODO tratar exceção
	        }
	    }
	}
	
	public void excluirCarro (String placa) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("DELETE FROM carro WHERE placa = '" + placa + "'");
			
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
	
	public void editarFuncionario(Funcionario funcionario) {
	    Connection connection = estabelecerConexao();
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        String sql = "UPDATE funcionario SET nome = ?, rg = ?, org_exp = ?, telefone = ?, email = ?, " +
	                     "data_nascimento = ?, data_exp = ?, cnh = ?, validade_cnh = ?, cep = ?, rua = ?, " +
	                     "numero_rua = ?, bairro = ?, cidade = ?, complemento = ?, senha = ? WHERE cpf = ?";
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, funcionario.getNome());
	        preparedStatement.setString(2, funcionario.getRg());
	        preparedStatement.setString(3, funcionario.getOrgExp());
	        preparedStatement.setString(4, funcionario.getTelefone());
	        preparedStatement.setString(5, funcionario.getEmail());
	        preparedStatement.setString(6, funcionario.getDataNascimento());
	        preparedStatement.setString(7, funcionario.getDataExp());
	        preparedStatement.setString(8, funcionario.getCnh());
	        preparedStatement.setString(9, funcionario.getValidadeCNH());
	        preparedStatement.setString(10, funcionario.getCep());
	        preparedStatement.setString(11, funcionario.getRua());
	        preparedStatement.setString(12, funcionario.getNumeroRua());
	        preparedStatement.setString(13, funcionario.getBairro());
	        preparedStatement.setString(14, funcionario.getCidade());
	        preparedStatement.setString(15, funcionario.getComplemento());
	        preparedStatement.setString(16, funcionario.getSenha());
	        preparedStatement.setString(17, funcionario.getCpf());
	        
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Tratar exceção corretamente
	    } finally {
	        try {
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); // TODO: Tratar exceção corretamente
	        }
	    }
	}
	
	public void excluirFuncionario (String cpf) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("DELETE FROM funcionario WHERE cpf = '" + cpf + "'");
			
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
	
	public void editarLocacao(Locacao locacao) {
	    Connection connection = estabelecerConexao();
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        String sql = "UPDATE locacao SET cliente_id = ?, carro_id = ?, valorDiaria = ?, diasLocados = ?, " +
	                     "valorTotal = ?, formaPagamento = ?, status = ? WHERE cliente_id = ? AND carro_id = ?";
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setLong(1, locacao.getCliente().getId()); 
	        preparedStatement.setLong(2, locacao.getCarro().getId()); 
	        preparedStatement.setDouble(3, locacao.getValorDiaria());
	        preparedStatement.setInt(4, locacao.getDiasLocados());
	        preparedStatement.setDouble(5, locacao.getValorTotal());
	        preparedStatement.setString(6, locacao.getFormaPagamento());
	        preparedStatement.setString(7, locacao.getStatus());
	        preparedStatement.setLong(8, locacao.getCliente().getId()); 
	        preparedStatement.setLong(9, locacao.getCarro().getId());
	        
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Tratar exceção corretamente
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // TODO: Tratar exceção corretamente
	        }
	    }
	}
	
    public Map<String, Integer> obterDadosRelatorioMarca() {
        Connection connection = estabelecerConexao();
        Map<String, Integer> contagemMarcas = new HashMap<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();

            // Passo 1: Buscar todos os carro_id na tabela locacao
            rs = stmt.executeQuery("SELECT carro_id FROM locacao");
            while (rs.next()) {
                Long carroId = rs.getLong("carro_id");

                // Passo 2: Buscar a marca do carro pelo ID
                Statement stmtCarro = connection.createStatement();
                ResultSet rsCarro = stmtCarro.executeQuery("SELECT marca FROM carro WHERE id = " + carroId);
                if (rsCarro.next()) {
                    String marca = rsCarro.getString("marca");
                    contagemMarcas.put(marca, contagemMarcas.getOrDefault(marca, 0) + 1);
                }
                rsCarro.close();
                stmtCarro.close();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar erro corretamente
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contagemMarcas;
    }
    
    public Map<String, Integer> obterDadosRelatorioModelo() {
        Connection connection = estabelecerConexao();
        Map<String, Integer> contagemModelos = new HashMap<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();

            // Passo 1: Buscar todos os carro_id na tabela locacao
            rs = stmt.executeQuery("SELECT carro_id FROM locacao");
            while (rs.next()) {
                Long carroId = rs.getLong("carro_id");

                // Passo 2: Buscar o modelo do carro pelo ID
                Statement stmtCarro = connection.createStatement();
                ResultSet rsCarro = stmtCarro.executeQuery("SELECT modelo FROM carro WHERE id = " + carroId);
                if (rsCarro.next()) {
                    String modelo = rsCarro.getString("modelo");
                    contagemModelos.put(modelo, contagemModelos.getOrDefault(modelo, 0) + 1);
                }
                rsCarro.close();
                stmtCarro.close();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Tratar erro corretamente
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contagemModelos;
    }

	
	public void editarReserva(Reserva reserva) {
	    Connection connection = estabelecerConexao();
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        String sql = "UPDATE reserva SET cliente_id = ?, carro_id = ?, dataRetirada = ?, horaRetirada = ?, " +
	                     "dataEntrega = ?, horaEntrega = ? WHERE cliente_id = ? AND carro_id = ?";
	        
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setLong(1, reserva.getCliente().getId()); 
	        preparedStatement.setLong(2, reserva.getCarro().getId()); 
	        preparedStatement.setDate(3, java.sql.Date.valueOf(reserva.getDataRetirada()));
	        preparedStatement.setString(4, reserva.getHoraRetirada());
	        preparedStatement.setDate(5, java.sql.Date.valueOf(reserva.getDataEntrega()));
	        preparedStatement.setString(6, reserva.getHoraEntrega());
	        preparedStatement.setLong(7, reserva.getCliente().getId()); 
	        preparedStatement.setLong(8, reserva.getCarro().getId());
	        
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Tratar exceção corretamente
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // TODO: Tratar exceção corretamente
	        }
	    }
	}

	
	public void excluirLocacao(String cpf, String placa) {
	    Connection connection = estabelecerConexao();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        // Primeiro, buscar o cliente_id com base no cpf
	        String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	        preparedStatement = connection.prepareStatement(sqlCliente);
	        preparedStatement.setString(1, cpf);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            Long clienteId = resultSet.getLong("id");

	            // Agora, buscar o carro_id com base na placa
	            String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	            preparedStatement = connection.prepareStatement(sqlCarro);
	            preparedStatement.setString(1, placa);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                Long carroId = resultSet.getLong("id");

	                // Agora, excluir a locação com base no cliente_id e carro_id
	                String sqlExcluir = "DELETE FROM locacao WHERE cliente_id = ? AND carro_id = ?";
	                preparedStatement = connection.prepareStatement(sqlExcluir);
	                preparedStatement.setLong(1, clienteId);
	                preparedStatement.setLong(2, carroId);
	                preparedStatement.executeUpdate();
	            } else {
	                System.out.println("Carro não encontrado com a placa: " + placa);
	            }
	        } else {
	            System.out.println("Cliente não encontrado com o CPF: " + cpf);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Tratar exceção adequadamente
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // TODO: Tratar exceção adequadamente
	        }
	    }
	}
	
	public void excluirReserva(String cpf, String placa) {
	    Connection connection = estabelecerConexao();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        // Primeiro, buscar o cliente_id com base no cpf
	        String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	        preparedStatement = connection.prepareStatement(sqlCliente);
	        preparedStatement.setString(1, cpf);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            Long clienteId = resultSet.getLong("id");

	            // Agora, buscar o carro_id com base na placa
	            String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	            preparedStatement = connection.prepareStatement(sqlCarro);
	            preparedStatement.setString(1, placa);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                Long carroId = resultSet.getLong("id");

	                // Agora, excluir a reserva com base no cliente_id e carro_id
	                String sqlExcluir = "DELETE FROM reserva WHERE cliente_id = ? AND carro_id = ?";
	                preparedStatement = connection.prepareStatement(sqlExcluir);
	                preparedStatement.setLong(1, clienteId);
	                preparedStatement.setLong(2, carroId);
	                preparedStatement.executeUpdate();
	            } else {
	                System.out.println("Carro não encontrado com a placa: " + placa);
	            }
	        } else {
	            System.out.println("Cliente não encontrado com o CPF: " + cpf);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Tratar exceção adequadamente
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // TODO: Tratar exceção adequadamente
	        }
	    }
	}


	public Funcionario buscarDadosFuncionario(String cpf) {
	    String sql = "SELECT nome, rg, org_exp, telefone, email, data_nascimento, data_exp, cnh, validade_cnh, cep, rua, " +
	                 "numero_rua, bairro, cidade, complemento, senha FROM funcionario WHERE cpf = ?";
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            return new Funcionario(rs.getString("nome"), rs.getString("rg"), rs.getString("org_exp"),
	                                   rs.getString("telefone"), rs.getString("email"), rs.getString("data_nascimento"),
	                                   rs.getString("data_exp"), rs.getString("cnh"), rs.getString("validade_cnh"),
	                                   rs.getString("cep"), rs.getString("rua"), rs.getString("numero_rua"),
	                                   rs.getString("bairro"), rs.getString("cidade"), rs.getString("complemento"),
	                                   rs.getString("senha"));
	        }
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    }
	    return null;
	}
	
	public Locacao buscarDadosLocacao(String cpf, String placa) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlLocacao = "SELECT valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE cliente_id = ? AND carro_id = ?";
	    
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente);
	         PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {
	        
	        stmtCliente.setString(1, cpf);
	        ResultSet rsCliente = stmtCliente.executeQuery();
	        
	        if (!rsCliente.next()) {
	            return null;
	        }
	        int clienteId = rsCliente.getInt("id");
	        
	        stmtCarro.setString(1, placa);
	        ResultSet rsCarro = stmtCarro.executeQuery();
	        
	        if (!rsCarro.next()) {
	            return null;
	        }
	        int carroId = rsCarro.getInt("id");
	        
	        try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
	            stmtLocacao.setInt(1, clienteId);
	            stmtLocacao.setInt(2, carroId);
	            ResultSet rsLocacao = stmtLocacao.executeQuery();
	            
	            if (rsLocacao.next()) {
	                return new Locacao(rsLocacao.getDouble("valorDiaria"), rsLocacao.getInt("diasLocados"),
	                                   rsLocacao.getDouble("valorTotal"), rsLocacao.getString("formaPagamento"),
	                                   rsLocacao.getString("status"));
	            }
	        }
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    }
	    return null;
	}
	
	public Reserva buscarDadosReserva(String cpf, String placa) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlReserva = "SELECT dataRetirada, horaRetirada, dataEntrega, horaEntrega FROM reserva WHERE cliente_id = ? AND carro_id = ?";
	    
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente);
	         PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {
	        
	        stmtCliente.setString(1, cpf);
	        ResultSet rsCliente = stmtCliente.executeQuery();
	        
	        if (!rsCliente.next()) {
	            return null;
	        }
	        int clienteId = rsCliente.getInt("id");
	        
	        stmtCarro.setString(1, placa);
	        ResultSet rsCarro = stmtCarro.executeQuery();
	        
	        if (!rsCarro.next()) {
	            return null;
	        }
	        int carroId = rsCarro.getInt("id");
	        
	        try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
	            stmtReserva.setInt(1, clienteId);
	            stmtReserva.setInt(2, carroId);
	            ResultSet rsReserva = stmtReserva.executeQuery();
	            
	            if (rsReserva.next()) {
	                // Supondo que a classe Reserva tenha um construtor adequado para os parâmetros
	                return new Reserva(rsReserva.getString("dataRetirada"), rsReserva.getString("horaRetirada"),
	                                   rsReserva.getString("dataEntrega"), rsReserva.getString("horaEntrega"));
	            }
	        }
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    }
	    return null;
	}

	public void registrarLocacao (Locacao locacao) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO locacao (cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status) "
					+ " VALUES ('" + locacao.getCliente().getId() + "', '" + locacao.getCarro().getId() + "', '" 
					+ locacao.getValorDiaria() + "', '" + locacao.getDiasLocados() + "', '" + locacao.getValorTotal() 
					+ "', '" + locacao.getFormaPagamento() + "', '" + locacao.getStatus() + "')");
			
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
	
	public double calcularReceitaTotal() {
	    Connection connection = estabelecerConexao();
	    Statement statement = null;
	    ResultSet resultSet = null;
	    double soma = 0.0;
	    
	    try {
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery("SELECT SUM(valorTotal) FROM locacao");
	        
	        if (resultSet.next()) {
	            soma = resultSet.getDouble(1);
	        }
	        
	    } catch (SQLException e) {
	        // TODO tratar exceção
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            // TODO tratar exceção
	        }
	    }
	    
	    return soma;
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
	
	public void registrarAgendamentoManuntencao (AgendamentoManuntencao agendamentoManuntencao) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO agendamentomanuntencao (id_carro, tipoManuntencao, dataManuntencao,hora, observacao) "
					+ " VALUES ('" + agendamentoManuntencao.getCarro().getId() + "', '" 
					+ agendamentoManuntencao.getTipoManuntencao() + "', '" + agendamentoManuntencao.getDataManuntencao() + "', '"
					+ agendamentoManuntencao.getHora() + "', '" + agendamentoManuntencao.getObservacao() + "')");
			
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
	
	public void registrarAgendamentoVistoria (AgendamentoVistoria agendamentoVistoria) {
		Connection connection = estabelecerConexao();
		
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			statement.execute("INSERT INTO agendamentovistoria (id_carro, tipoManuntencao, dataManuntencao,hora, observacao) "
					+ " VALUES ('" + agendamentoVistoria.getCarro().getId() + "', '" 
					+ agendamentoVistoria.getTipoManuntencao() + "', '" + agendamentoVistoria.getDataManuntencao() + "', '"
					+ agendamentoVistoria.getHora() + "', '" + agendamentoVistoria.getObservacao() + "')");
			
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
	
    public List<AgendamentoManuntencao> buscarTodosAgendamentosManuntencao() {
        String sqlAgendamentoManuntencao = "SELECT id_carro, tipoManuntencao, dataManuntencao, hora, observacao FROM agendamentomanuntencao";
        List<AgendamentoManuntencao> agendamentosManuntencao = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtAgendamentoManuntencao = conn.prepareStatement(sqlAgendamentoManuntencao);
             ResultSet rsAgendamentoManuntencao = stmtAgendamentoManuntencao.executeQuery()) {

            while (rsAgendamentoManuntencao.next()) { 

                long carroId = rsAgendamentoManuntencao.getLong("id_carro");
                Carro carro = buscarCarroPorId(carroId);

                AgendamentoManuntencao agendamentoManuntencao = new AgendamentoManuntencao( 
                        carro, 
                        rsAgendamentoManuntencao.getString("tipoManuntencao"), 
                        rsAgendamentoManuntencao.getString("dataManuntencao"), 
                        rsAgendamentoManuntencao.getString("hora"), 
                        rsAgendamentoManuntencao.getString("observacao")
                );
                agendamentosManuntencao.add(agendamentoManuntencao);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return agendamentosManuntencao;
    }
    
    public List<AgendamentoVistoria> buscarTodosAgendamentosVistoria() {
        String sqlAgendamentoVistoria = "SELECT id_carro, tipoManuntencao, dataManuntencao, hora, observacao FROM agendamentovistoria";
        List<AgendamentoVistoria> agendamentosVistoria = new ArrayList<>();

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmtAgendamentoVistoria = conn.prepareStatement(sqlAgendamentoVistoria);
             ResultSet rsAgendamentoVistoria = stmtAgendamentoVistoria.executeQuery()) {

            while (rsAgendamentoVistoria.next()) { 

                long carroId = rsAgendamentoVistoria.getLong("id_carro");
                Carro carro = buscarCarroPorId(carroId);

                AgendamentoVistoria agendamentoVistoria = new AgendamentoVistoria( 
                        carro, 
                        rsAgendamentoVistoria.getString("tipoManuntencao"), 
                        rsAgendamentoVistoria.getString("dataManuntencao"), 
                        rsAgendamentoVistoria.getString("hora"), 
                        rsAgendamentoVistoria.getString("observacao")
                );
                agendamentosVistoria.add(agendamentoVistoria);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return agendamentosVistoria;
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
    
    public List<Funcionario> buscarTodosFuncionarios() {
        String sql = "SELECT SELECT nome, rg, telefone, email , data_nascimento, cnh, validade_cnh, cep FROM funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { 
                Funcionario funcionario = new Funcionario(
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cnh"),
                    rs.getString("cnh"),
                    rs.getString("validade_cnh"),
                    rs.getString("cep")
                );
                funcionarios.add(funcionario); 
            }
        } catch (SQLException e) {
            // TODO: Tratar exceção 

        }
        return funcionarios;
    }
    public Cliente buscarDadosCliente(String cpf) {
        String sql = "SELECT nomeCompleto, dataNascimento, sexo, cnh, vencimentoCnh, bairroRua, numero, "
        		+ " cep, cidade, estado, telefone, email FROM cliente WHERE cpf = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(rs.getString("nomeCompleto"),rs.getString("dataNascimento"), rs.getString("sexo"),
                		rs.getString("cnh"), rs.getString("vencimentoCnh"), rs.getString("bairroRua"), rs.getInt("numero"),
                		rs.getString("cep"), rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone")
                		,rs.getString("email"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
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
    
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        String sql = "SELECT nome, rg, telefone, email , data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE cpf = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Funcionario(rs.getString("nome"),rs.getString("rg"), rs.getString("telefone"),
                		rs.getString("email"), rs.getString("data_nascimento"), rs.getString("cnh"), rs.getString("validade_cnh")
                		, rs.getString("cep"));
            }
        } catch (SQLException e) {
            // TODO tratar exeção
        }
        return null;
    }
    
    public Funcionario buscarFuncionarioPorNome(String nome) {
        String sql = "SELECT nome, rg, telefone, email , data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE nome = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Funcionario(rs.getString("nome"),rs.getString("rg"), rs.getString("telefone"),
                		rs.getString("email"), rs.getString("data_nascimento"), rs.getString("cnh"), rs.getString("validade_cnh")
                		, rs.getString("cep"));
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
        String sql = "SELECT marca, modelo, ano, kmRodados, categoria FROM carro WHERE placa = ?";
        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("kmRodados"),
                		rs.getString("categoria"));
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
        String sqlLocacao = "SELECT cliente_id, carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao";
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
                        rsLocacao.getString("formaPagamento"),
                        rsLocacao.getString("status")
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
        String sqlLocacao = "SELECT carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE cliente_id = ?";
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
                                rsLocacao.getString("formaPagamento"),
                                rsLocacao.getString("status")
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
        String sqlLocacao = "SELECT cliente_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE carro_id = ?";
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
                                rsLocacao.getString("formaPagamento"),
                                rsLocacao.getString("status")
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

    public boolean autenticarFuncionario(String cpf, String senha) {
        String sql = "SELECT senha FROM funcionario WHERE cpf = ?";

        try (Connection conn = estabelecerConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaCorreta = rs.getString("senha");
                return senha.equals(senhaCorreta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }


}
