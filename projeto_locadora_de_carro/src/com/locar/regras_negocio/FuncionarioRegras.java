package com.locar.regras_negocio;

import com.locar.dados.FuncionarioDAO;

public class FuncionarioRegras {

    public void cadastrarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
                                    String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
                                    String rua, String numeroRua, String bairro, String cidade, String complemento,
                                    String senha, String confirmacaoSenha) {
        // Validações
        if (!senha.equals(confirmacaoSenha)) {
            System.out.println("Erro: As senhas não coincidem.");
            return;
        }

        // Chama a camada de acesso a dados
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserirFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);
    }
}
