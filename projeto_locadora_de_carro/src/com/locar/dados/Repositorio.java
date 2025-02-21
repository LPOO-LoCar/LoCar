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
	
	private Connection estabelecerConexao() throws SQLException {
	    Connection connection = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/locadora_de_carro", "root", "192815Math@");
	    } catch (ClassNotFoundException e) {
	        throw new SQLException("Driver JDBC não encontrado. Verifique se o driver foi adicionado ao classpath.", e);
	    } catch (SQLException e) {
	        throw new SQLException("Erro ao estabelecer conexão com o banco de dados. Verifique as credenciais e a URL.", e);
	    }
	    return connection;
	}
	
	public void registrarCliente(Cliente cliente) {
	    Connection connection = null;
	    Statement statement = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();

	        String sql = "INSERT INTO cliente (nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh, bairroRua, " +
	                     "numero, cep, cidade, estado, telefone, email) VALUES ('" +
	                     cliente.getNomeCompleto() + "', '" + cliente.getDataNascimento() + "', '" + cliente.getCpf() + "', '" +
	                     cliente.getSexo() + "', '" + cliente.getCnh() + "', '" + cliente.getVencimentoCnh() + "', '" +
	                     cliente.getBairroRua() + "', '" + cliente.getNumero() + "', '" + cliente.getCep() + "', '" +
	                     cliente.getCidade() + "', '" + cliente.getEstado() + "', '" + cliente.getTelefone() + "', '" +
	                     cliente.getEmail() + "')";

	        statement.executeUpdate(sql);
	        System.out.println("Cliente registrado com sucesso.");

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar cliente: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}
	
	public void EditarCliente(Cliente cliente) {
	    Connection connection = null;
	    Statement statement = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();

	        String sql = "UPDATE cliente SET " +
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
	                     "WHERE cpf = '" + cliente.getCpf() + "'";

	        int linhasAfetadas = statement.executeUpdate(sql);
	        
	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente atualizado com sucesso.");
	        } else {
	            System.out.println("Nenhum cliente encontrado com o CPF informado.");
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao editar cliente: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}
	
	public void excluirCliente(String cpf) {
	    Connection connection = null;
	    Statement statement = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();

	        String sql = "DELETE FROM cliente WHERE cpf = '" + cpf + "'";
	        int linhasAfetadas = statement.executeUpdate(sql);

	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente com CPF " + cpf + " excluído com sucesso.");
	        } else {
	            System.out.println("Nenhum cliente encontrado com o CPF informado.");
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir cliente: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}
	
	public void registrarCarro(Carro carro) {
	    Connection connection = null;
	    Statement statement = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();

	        String sql = "INSERT INTO carro (marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria, " +
	                     "conservacao, direcao, kmRodados, numLugares, numPortas) VALUES ('" + 
	                     carro.getMarca() + "', '" + carro.getModelo() + "', '" + carro.getAno() + "', '" + 
	                     carro.getCor() + "', '" + carro.getPlaca() + "', '" + carro.getNumMotor() + "', '" + 
	                     carro.getChassi() + "', '" + carro.getCombustivel() + "', '" + carro.getTransmissao() + "', '" + 
	                     carro.getCategoria() + "', '" + carro.getConservacao() + "', '" + carro.getDirecao() + "', '" + 
	                     carro.getKmRodados() + "', '" + carro.getNumLugares() + "', '" + carro.getNumPortas() + "')";

	        int linhasAfetadas = statement.executeUpdate(sql);

	        if (linhasAfetadas > 0) {
	            System.out.println("Carro registrado com sucesso.");
	        } else {
	            System.out.println("Falha ao registrar o carro.");
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar carro: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}
	
	public Cliente buscarDadosCliente(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, sexo, cnh, vencimentoCnh, bairroRua, numero, "
	               + "cep, cidade, estado, telefone, email FROM cliente WHERE cpf = ?";
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            return new Cliente(
	                    rs.getString("nomeCompleto"),
	                    rs.getString("dataNascimento"),
	                    rs.getString("sexo"),
	                    rs.getString("cnh"),
	                    rs.getString("vencimentoCnh"),
	                    rs.getString("bairroRua"),
	                    rs.getInt("numero"),
	                    rs.getString("cep"),
	                    rs.getString("cidade"),
	                    rs.getString("estado"),
	                    rs.getString("telefone"),
	                    rs.getString("email")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  // Exibindo o erro no console
	    }
	    return null;
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

	public Carro buscarDadosCarro(String placa) {
	    String sql = "SELECT marca, modelo, ano, cor, numMotor, chassi, combustivel, transmissao, categoria, " +
	                 "conservacao, direcao, kmRodados, numLugares, numPortas FROM carro WHERE placa = ?";
	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, placa);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("cor"),
	                                 rs.getString("numMotor"), rs.getString("chassi"), rs.getString("combustivel"),
	                                 rs.getString("transmissao"), rs.getString("categoria"), rs.getString("conservacao"),
	                                 rs.getString("direcao"), rs.getString("kmRodados"), rs.getInt("numLugares"),
	                                 rs.getInt("numPortas"));
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados do carro: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}

	public void editarCarro(Carro carro) {
	    Connection connection = null;
	    Statement statement = null;
	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        String sql = "UPDATE carro SET " +
	                     "marca = '" + carro.getMarca() + "', " +
	                     "modelo = '" + carro.getModelo() + "', " +
	                     "ano = " + carro.getAno() + ", " +
	                     "cor = '" + carro.getCor() + "', " +
	                     "numMotor = '" + carro.getNumMotor() + "', " +
	                     "chassi = '" + carro.getChassi() + "', " +
	                     "combustivel = '" + carro.getCombustivel() + "', " +
	                     "transmissao = '" + carro.getTransmissao() + "', " +
	                     "categoria = '" + carro.getCategoria() + "', " +
	                     "conservacao = '" + carro.getConservacao() + "', " +
	                     "direcao = '" + carro.getDirecao() + "', " +
	                     "kmRodados = " + carro.getKmRodados() + ", " +
	                     "numLugares = " + carro.getNumLugares() + ", " +
	                     "numPortas = " + carro.getNumPortas() + " " +
	                     "WHERE placa = '" + carro.getPlaca() + "'";
	        statement.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.err.println("Erro ao editar carro: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}

	public void excluirCarro(String placa) {
	    try (Connection connection = estabelecerConexao();
	         Statement statement = connection.createStatement()) {
	        String sql = "DELETE FROM carro WHERE placa = '" + placa + "'";
	        statement.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir carro: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void editarFuncionario(Funcionario funcionario) {
	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(
	                 "UPDATE funcionario SET nome = ?, rg = ?, org_exp = ?, telefone = ?, email = ?, " +
	                         "data_nascimento = ?, data_exp = ?, cnh = ?, validade_cnh = ?, cep = ?, rua = ?, " +
	                         "numero_rua = ?, bairro = ?, cidade = ?, complemento = ?, senha = ? WHERE cpf = ?")) {

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
	        System.err.println("Erro ao editar funcionário: " + e.getMessage());
	    }
	}

	public void excluirFuncionario(String cpf) {
	    String sql = "DELETE FROM funcionario WHERE cpf = ?";
	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        
	        preparedStatement.setString(1, cpf);
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir funcionário: " + e.getMessage());
	    }
	}

	public void editarLocacao(Locacao locacao) {
	    String sql = "UPDATE locacao SET cliente_id = ?, carro_id = ?, valorDiaria = ?, diasLocados = ?, " +
	                 "valorTotal = ?, formaPagamento = ?, status = ? WHERE cliente_id = ? AND carro_id = ?";
	    
	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        
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
	        System.err.println("Erro ao editar locação: " + e.getMessage());
	    }
	}
	
	public Map<String, Integer> obterDadosRelatorioMarca() {
	    Map<String, Integer> contagemMarcas = new HashMap<>();
	    
	    // Usando try-with-resources para garantir fechamento correto
	    try (Connection connection = estabelecerConexao();
	         Statement stmt = connection.createStatement()) {

	        // Passo 1: Buscar todos os carro_id na tabela locacao
	        try (ResultSet rs = stmt.executeQuery("SELECT carro_id FROM locacao")) {
	            while (rs.next()) {
	                Long carroId = rs.getLong("carro_id");

	                // Passo 2: Buscar a marca do carro pelo ID
	                try (Statement stmtCarro = connection.createStatement();
	                     ResultSet rsCarro = stmtCarro.executeQuery("SELECT marca FROM carro WHERE id = " + carroId)) {
	                    if (rsCarro.next()) {
	                        String marca = rsCarro.getString("marca");
	                        contagemMarcas.put(marca, contagemMarcas.getOrDefault(marca, 0) + 1);
	                    }
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

	    // Usando try-with-resources para garantir fechamento correto
	    try (Connection connection = estabelecerConexao();
	         Statement stmt = connection.createStatement()) {

	        // Passo 1: Buscar todos os carro_id na tabela locacao
	        try (ResultSet rs = stmt.executeQuery("SELECT carro_id FROM locacao")) {
	            while (rs.next()) {
	                Long carroId = rs.getLong("carro_id");

	                // Passo 2: Buscar o modelo do carro pelo ID
	                try (Statement stmtCarro = connection.createStatement();
	                     ResultSet rsCarro = stmtCarro.executeQuery("SELECT modelo FROM carro WHERE id = " + carroId)) {
	                    if (rsCarro.next()) {
	                        String modelo = rsCarro.getString("modelo");
	                        contagemModelos.put(modelo, contagemModelos.getOrDefault(modelo, 0) + 1);
	                    }
	                }
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao obter dados do relatório de modelos: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return contagemModelos;
	}
	
	public void editarReserva(Reserva reserva) {
	    String sql = "UPDATE reserva SET cliente_id = ?, carro_id = ?, dataRetirada = ?, horaRetirada = ?, " +
	                 "dataEntrega = ?, horaEntrega = ? WHERE cliente_id = ? AND carro_id = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

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
	        System.err.println("Erro ao editar reserva: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void excluirLocacao(String cpf, String placa) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlExcluir = "DELETE FROM locacao WHERE cliente_id = ? AND carro_id = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatementCliente = connection.prepareStatement(sqlCliente);
	         PreparedStatement preparedStatementCarro = connection.prepareStatement(sqlCarro);
	         PreparedStatement preparedStatementExcluir = connection.prepareStatement(sqlExcluir)) {

	        // Buscar o cliente_id com base no cpf
	        preparedStatementCliente.setString(1, cpf);
	        try (ResultSet resultSet = preparedStatementCliente.executeQuery()) {
	            if (resultSet.next()) {
	                Long clienteId = resultSet.getLong("id");

	                // Buscar o carro_id com base na placa
	                preparedStatementCarro.setString(1, placa);
	                try (ResultSet rsCarro = preparedStatementCarro.executeQuery()) {
	                    if (rsCarro.next()) {
	                        Long carroId = rsCarro.getLong("id");

	                        // Excluir a locação
	                        preparedStatementExcluir.setLong(1, clienteId);
	                        preparedStatementExcluir.setLong(2, carroId);
	                        preparedStatementExcluir.executeUpdate();
	                    } else {
	                        System.out.println("Carro não encontrado com a placa: " + placa);
	                    }
	                }
	            } else {
	                System.out.println("Cliente não encontrado com o CPF: " + cpf);
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir locação: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void excluirReserva(String cpf, String placa) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = ?";
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlExcluir = "DELETE FROM reserva WHERE cliente_id = ? AND carro_id = ?";

	    try (Connection connection = estabelecerConexao();
	         PreparedStatement preparedStatementCliente = connection.prepareStatement(sqlCliente);
	         PreparedStatement preparedStatementCarro = connection.prepareStatement(sqlCarro);
	         PreparedStatement preparedStatementExcluir = connection.prepareStatement(sqlExcluir)) {

	        // Buscar o cliente_id com base no cpf
	        preparedStatementCliente.setString(1, cpf);
	        try (ResultSet resultSet = preparedStatementCliente.executeQuery()) {
	            if (resultSet.next()) {
	                Long clienteId = resultSet.getLong("id");

	                // Buscar o carro_id com base na placa
	                preparedStatementCarro.setString(1, placa);
	                try (ResultSet rsCarro = preparedStatementCarro.executeQuery()) {
	                    if (rsCarro.next()) {
	                        Long carroId = rsCarro.getLong("id");

	                        // Excluir a reserva
	                        preparedStatementExcluir.setLong(1, clienteId);
	                        preparedStatementExcluir.setLong(2, carroId);
	                        preparedStatementExcluir.executeUpdate();
	                    } else {
	                        System.out.println("Carro não encontrado com a placa: " + placa);
	                    }
	                }
	            } else {
	                System.out.println("Cliente não encontrado com o CPF: " + cpf);
	            }
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir reserva: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public Funcionario buscarDadosFuncionario(String cpf) {
	    String sql = "SELECT nome, rg, org_exp, telefone, email, data_nascimento, data_exp, cnh, validade_cnh, cep, rua, " +
	                 "numero_rua, bairro, cidade, complemento, senha FROM funcionario WHERE cpf = ?";

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, cpf);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Funcionario(rs.getString("nome"), rs.getString("rg"), rs.getString("org_exp"),
	                                       rs.getString("telefone"), rs.getString("email"), rs.getString("data_nascimento"),
	                                       rs.getString("data_exp"), rs.getString("cnh"), rs.getString("validade_cnh"),
	                                       rs.getString("cep"), rs.getString("rua"), rs.getString("numero_rua"),
	                                       rs.getString("bairro"), rs.getString("cidade"), rs.getString("complemento"),
	                                       rs.getString("senha"));
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados do funcionário: " + e.getMessage());
	        e.printStackTrace();
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
	        try (ResultSet rsCliente = stmtCliente.executeQuery()) {
	            if (!rsCliente.next()) {
	                return null;
	            }
	            int clienteId = rsCliente.getInt("id");

	            stmtCarro.setString(1, placa);
	            try (ResultSet rsCarro = stmtCarro.executeQuery()) {
	                if (!rsCarro.next()) {
	                    return null;
	                }
	                int carroId = rsCarro.getInt("id");

	                try (PreparedStatement stmtLocacao = conn.prepareStatement(sqlLocacao)) {
	                    stmtLocacao.setInt(1, clienteId);
	                    stmtLocacao.setInt(2, carroId);
	                    try (ResultSet rsLocacao = stmtLocacao.executeQuery()) {
	                        if (rsLocacao.next()) {
	                            return new Locacao(rsLocacao.getDouble("valorDiaria"), rsLocacao.getInt("diasLocados"),
	                                               rsLocacao.getDouble("valorTotal"), rsLocacao.getString("formaPagamento"),
	                                               rsLocacao.getString("status"));
	                        }
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados da locação: " + e.getMessage());
	        e.printStackTrace();
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
	        try (ResultSet rsCliente = stmtCliente.executeQuery()) {
	            if (!rsCliente.next()) {
	                return null;
	            }
	            int clienteId = rsCliente.getInt("id");

	            stmtCarro.setString(1, placa);
	            try (ResultSet rsCarro = stmtCarro.executeQuery()) {
	                if (!rsCarro.next()) {
	                    return null;
	                }
	                int carroId = rsCarro.getInt("id");

	                try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
	                    stmtReserva.setInt(1, clienteId);
	                    stmtReserva.setInt(2, carroId);
	                    try (ResultSet rsReserva = stmtReserva.executeQuery()) {
	                        if (rsReserva.next()) {
	                            return new Reserva(rsReserva.getString("dataRetirada"), rsReserva.getString("horaRetirada"),
	                                               rsReserva.getString("dataEntrega"), rsReserva.getString("horaEntrega"));
	                        }
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar dados da reserva: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}
	
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
	        
	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar locação: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public double calcularReceitaTotal() {
	    String sql = "SELECT SUM(valorTotal) FROM locacao";
	    try (Connection connection = estabelecerConexao();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

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
	    return calcularReceita("WHERE STR_TO_DATE(dataLocacao, '%d/%m/%Y') >= DATE_FORMAT(NOW() - INTERVAL (MONTH(NOW())-1) MONTH, '%Y-01-01')");
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
	
	public void registrarReserva(Reserva reserva) {
	    String sql = "INSERT INTO reserva (cliente_id, carro_id, dataRetirada, horaRetirada, dataEntrega, horaEntrega) "
	               + "VALUES ('" + reserva.getCliente().getId() + "', '" + reserva.getCarro().getId() + "', '" 
	               + reserva.getDataRetirada() + "', '" + reserva.getHoraRetirada() + "', '" + reserva.getDataEntrega() 
	               + "', '" + reserva.getHoraEntrega() + "')";

	    Connection connection = null;
	    Statement statement = null;
	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        statement.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar reserva: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public void registrarAgendamentoManuntencao(AgendamentoManuntencao agendamentoManuntencao) {
	    String sql = "INSERT INTO agendamentomanuntencao (id_carro, tipoManuntencao, dataManuntencao, hora, observacao) "
	               + "VALUES ('" + agendamentoManuntencao.getCarro().getId() + "', '" 
	               + agendamentoManuntencao.getTipoManuntencao() + "', '" + agendamentoManuntencao.getDataManuntencao() + "', '"
	               + agendamentoManuntencao.getHora() + "', '" + agendamentoManuntencao.getObservacao() + "')";

	    Connection connection = null;
	    Statement statement = null;
	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        statement.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar agendamento de manutenção: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public void registrarAgendamentoVistoria(AgendamentoVistoria agendamentoVistoria) {
	    String sql = "INSERT INTO agendamentovistoria (id_carro, tipoVistoria, dataVistoria, hora, observacao) "
	               + "VALUES ('" + agendamentoVistoria.getCarro().getId() + "', '" 
	               + agendamentoVistoria.getTipoVistoria() + "', '" + agendamentoVistoria.getDataVistoria() + "', '"
	               + agendamentoVistoria.getHora() + "', '" + agendamentoVistoria.getObservacao() + "')";

	    Connection connection = null;
	    Statement statement = null;
	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        statement.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.err.println("Erro ao registrar agendamento de vistoria: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

	public List<AgendamentoManuntencao> buscarTodosAgendamentosManuntencao() {
	    String sql = "SELECT id_carro, tipoManuntencao, dataManuntencao, hora, observacao FROM agendamentomanuntencao";
	    List<AgendamentoManuntencao> agendamentosManuntencao = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        while (rs.next()) {
	            long carroId = rs.getLong("id_carro");
	            Carro carro = buscarCarroPorId(carroId);

	            AgendamentoManuntencao agendamentoManuntencao = new AgendamentoManuntencao(
	                    carro,
	                    rs.getString("tipoManuntencao"),
	                    rs.getString("dataManuntencao"),
	                    rs.getString("hora"),
	                    rs.getString("observacao")
	            );
	            agendamentosManuntencao.add(agendamentoManuntencao);
	        }

	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar agendamentos de manutenção: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    return agendamentosManuntencao;
	}
	
	public List<AgendamentoVistoria> buscarTodosAgendamentosVistoria() {
	    String sqlAgendamentoVistoria = "SELECT id_carro, tipoVistoria, dataVistoria, hora, observacao FROM agendamentovistoria";
	    List<AgendamentoVistoria> agendamentosVistoria = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sqlAgendamentoVistoria);

	        while (rs.next()) { 
	            long carroId = rs.getLong("id_carro");
	            Carro carro = buscarCarroPorId(carroId);

	            AgendamentoVistoria agendamentoVistoria = new AgendamentoVistoria( 
	                    carro, 
	                    rs.getString("tipoVistoria"), 
	                    rs.getString("dataVistoria"), 
	                    rs.getString("hora"), 
	                    rs.getString("observacao")
	            );
	            agendamentosVistoria.add(agendamentoVistoria);
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar agendamentos de vistoria: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    return agendamentosVistoria;
	}

	public List<Cliente> buscarTodosClientes() {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email , sexo, cnh, vencimentoCnh FROM cliente";
	    List<Cliente> clientes = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

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
	        System.err.println("Erro ao buscar clientes: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return clientes;
	}

	public List<Funcionario> buscarTodosFuncionarios() {
	    String sql = "SELECT nome, rg, telefone, email , data_nascimento, cnh, validade_cnh, cep FROM funcionario";
	    List<Funcionario> funcionarios = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

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
	        System.err.println("Erro ao buscar funcionários: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return funcionarios;
	}
	
	public Cliente buscarClientePorCpf(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE cpf LIKE '" + cpf + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Cliente(
	                rs.getString("nomeCompleto"),
	                rs.getString("dataNascimento"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("sexo"),
	                rs.getString("cnh"),
	                rs.getString("vencimentoCnh")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar cliente por CPF: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

	public List<Cliente> buscarClientesPorCpf(String cpf) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE cpf LIKE '" + cpf + "'";
	    List<Cliente> clientes = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        while (rs.next()) {
	            clientes.add(new Cliente(
	                rs.getString("nomeCompleto"),
	                rs.getString("dataNascimento"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("sexo"),
	                rs.getString("cnh"),
	                rs.getString("vencimentoCnh")
	            ));
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar clientes por CPF: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return clientes;
	}

	public Funcionario buscarFuncionarioPorCpf(String cpf) {
	    String sql = "SELECT nome, rg, telefone, email, data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE cpf = '" + cpf + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Funcionario(
	                rs.getString("nome"),
	                rs.getString("rg"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("data_nascimento"),
	                rs.getString("cnh"),
	                rs.getString("validade_cnh"),
	                rs.getString("cep")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar funcionário por CPF: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

	public Funcionario buscarFuncionarioPorNome(String nome) {
	    String sql = "SELECT nome, rg, telefone, email, data_nascimento, cnh, validade_cnh, cep FROM funcionario WHERE nome = '" + nome + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Funcionario(
	                rs.getString("nome"),
	                rs.getString("rg"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("data_nascimento"),
	                rs.getString("cnh"),
	                rs.getString("validade_cnh"),
	                rs.getString("cep")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar funcionário por nome: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	public List<Cliente> buscarClientesPorNomeCompleto(String nomeCompleto) {
	    String sql = "SELECT nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh FROM cliente WHERE nomeCompleto LIKE '%" + nomeCompleto + "%'";
	    List<Cliente> clientes = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        while (rs.next()) {
	            clientes.add(new Cliente(
	                rs.getString("nomeCompleto"),
	                rs.getString("dataNascimento"),
	                rs.getString("telefone"),
	                rs.getString("email"),
	                rs.getString("sexo"),
	                rs.getString("cnh"),
	                rs.getString("vencimentoCnh")
	            ));
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar clientes por nome completo: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return clientes;
	}

	public List<Carro> buscarTodosCarros() {
	    String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro";
	    List<Carro> carros = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

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
	        System.err.println("Erro ao buscar todos os carros: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return carros;
	}

	public Carro buscarCarro(String placa) {
	    String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE placa = '" + placa + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Carro(
	                rs.getString("marca"),
	                rs.getString("modelo"),
	                rs.getInt("ano"),
	                rs.getString("cor"),
	                rs.getString("placa"),
	                rs.getString("numMotor"),
	                rs.getString("chassi")
	            );
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	public List<Carro> buscarCarrosPorMarca(String marca) {
	    String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE marca LIKE '%" + marca + "%'";
	    List<Carro> carros = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

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
	        System.err.println("Erro ao buscar carros por marca: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return carros;
	}

	public List<Carro> buscarCarrosPorModelo(String modelo) {
	    String sql = "SELECT marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE modelo LIKE '%" + modelo + "%'";
	    List<Carro> carros = new ArrayList<>();
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

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
	        System.err.println("Erro ao buscar carros por modelo: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return carros;
	}

	public Carro buscarCarroPorPlaca(String placa) {
	    String sql = "SELECT marca, modelo, ano, kmRodados, categoria FROM carro WHERE placa = '" + placa + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("kmRodados"),
	                    rs.getString("categoria"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

	public Cliente buscarIdPorCpf(String cpf) {
	    String sql = "SELECT id FROM cliente WHERE cpf = '" + cpf + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Cliente(rs.getLong("id"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar ID de cliente por CPF: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

	public Carro buscarIdPorPlaca(String placa) {
	    String sql = "SELECT id FROM carro WHERE placa = '" + placa + "'";
	    Connection connection = null;
	    Statement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = estabelecerConexao();
	        statement = connection.createStatement();
	        rs = statement.executeQuery(sql);

	        if (rs.next()) {
	            return new Carro(rs.getLong("id"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar ID de carro por placa: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            System.err.println("Erro ao fechar recursos: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return null;
	}
	
	public Cliente buscarClientePorId(long id) {
	    String sql = "SELECT id , nomeCompleto, dataNascimento, telefone, email, sexo, cnh, vencimentoCnh " +
	                 "FROM cliente WHERE id = " + id;
	    try (Connection conn = estabelecerConexao();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

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
	    String sql = "SELECT id, marca, modelo, ano, cor, placa, numMotor, chassi FROM carro WHERE id = " + id;
	    try (Connection conn = estabelecerConexao();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

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
	    Connection conn = null;
	    Statement stmtLocacao = null;
	    ResultSet rsLocacao = null;

	    try {
	        conn = estabelecerConexao();
	        stmtLocacao = conn.createStatement();
	        rsLocacao = stmtLocacao.executeQuery(sqlLocacao);

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
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rsLocacao != null) rsLocacao.close();
	            if (stmtLocacao != null) stmtLocacao.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return locacoes;
	}

	public List<Locacao> buscarLocacaoPorCpf(String cpf) {
	    String sqlCliente = "SELECT id FROM cliente WHERE cpf = '" + cpf + "'";
	    String sqlLocacao = "SELECT carro_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE cliente_id = ?";
	    List<Locacao> locacoes = new ArrayList<>();

	    try (Connection conn = estabelecerConexao();
	         Statement stmtCliente = conn.createStatement()) {

	        ResultSet rsCliente = stmtCliente.executeQuery(sqlCliente);

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
	        e.printStackTrace(); 
	    }

	    return locacoes;
	}

	public List<Locacao> buscarLocacaoPorPlaca(String placa) {
	    String sqlCarro = "SELECT id FROM carro WHERE placa = '" + placa + "'";
	    String sqlLocacao = "SELECT cliente_id, valorDiaria, diasLocados, valorTotal, formaPagamento, status FROM locacao WHERE carro_id = ?";
	    List<Locacao> locacoes = new ArrayList<>();

	    try (Connection conn = estabelecerConexao();
	         Statement stmtCarro = conn.createStatement()) {

	        ResultSet rsCarro = stmtCarro.executeQuery(sqlCarro);

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
	        e.printStackTrace(); 
	    }

	    return locacoes;
	}

	public List<Reserva> buscarTodasReservas() {
	    String sqlReserva = "SELECT cliente_id, carro_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva";
	    List<Reserva> reservas = new ArrayList<>();
	    Connection conn = null;
	    Statement stmtReserva = null;
	    ResultSet rsReserva = null;

	    try {
	        conn = estabelecerConexao();
	        stmtReserva = conn.createStatement();
	        rsReserva = stmtReserva.executeQuery(sqlReserva);

	        while (rsReserva.next()) {
	            long clienteId = rsReserva.getLong("cliente_id");
	            Cliente cliente = buscarClientePorId(clienteId);

	            long carroId = rsReserva.getLong("carro_id");
	            Carro carro = buscarCarroPorId(carroId);

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
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rsReserva != null) rsReserva.close();
	            if (stmtReserva != null) stmtReserva.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return reservas;
	}
	
	public List<Reserva> buscarReservaPorPlaca(String placa) {
	    String sqlCarro = "SELECT id FROM carro WHERE placa = ?";
	    String sqlReserva = "SELECT cliente_id, dataRetirada, HoraRetirada, dataEntrega, horaEntrega FROM reserva WHERE carro_id = ?";
	    List<Reserva> reservas = new ArrayList<>();

	    try (Connection conn = estabelecerConexao();
	         PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {

	        stmtCarro.setString(1, placa);
	        ResultSet rsCarro = stmtCarro.executeQuery();

	        if (rsCarro.next()) {
	            long carroId = rsCarro.getLong("id");
	            Carro carro = buscarCarroPorId(carroId);  // Buscar carro

	            try (PreparedStatement stmtReserva = conn.prepareStatement(sqlReserva)) {
	                stmtReserva.setLong(1, carroId);
	                ResultSet rsReserva = stmtReserva.executeQuery();

	                while (rsReserva.next()) {
	                    long clienteId = rsReserva.getLong("cliente_id");
	                    Cliente cliente = buscarClientePorId(clienteId);  // Buscar cliente

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
	    } catch (SQLException e) {
	        e.printStackTrace();  // Exibindo erro no console
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
	        ex.printStackTrace();  // Exibindo erro no console
	    }

	    return false;
	}


}
