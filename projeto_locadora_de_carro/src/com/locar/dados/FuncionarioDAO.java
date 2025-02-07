package com.locar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/locadora_de_carro";
    private static final String USER = "root";
    private static final String PASSWORD = "192815Math@";

    public void inserirFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
                                   String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
                                   String rua, String numeroRua, String bairro, String cidade, String complemento,
                                   String senha) {
        String sql = "INSERT INTO funcionario (nome, cpf, rg, org_exp, telefone, email, data_nascimento, data_exp, " +
                "cnh, validade_cnh, cep, rua, numero_rua, bairro, cidade, complemento, senha) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, orgExp);
            stmt.setString(5, telefone);
            stmt.setString(6, email);
            stmt.setString(7, dataNascimento);
            stmt.setString(8, dataExp);
            stmt.setString(9, cnh);
            stmt.setString(10, validadeCNH);
            stmt.setString(11, cep);
            stmt.setString(12, rua);
            stmt.setString(13, numeroRua);
            stmt.setString(14, bairro);
            stmt.setString(15, cidade);
            stmt.setString(16, complemento);
            stmt.setString(17, senha);

            stmt.executeUpdate();
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }
}