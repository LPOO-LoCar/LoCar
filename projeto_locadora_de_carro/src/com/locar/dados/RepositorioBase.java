package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositorioBase {

	protected Connection estabelecerConexao() throws SQLException {
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

}
