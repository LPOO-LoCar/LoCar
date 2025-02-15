package com.locar.regras_negocio;

import javax.swing.JOptionPane;

import com.locar.dados.FuncionarioDAO;

public class FuncionarioRegras {

    public void cadastrarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
                                    String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
                                    String rua, String numeroRua, String bairro, String cidade, String complemento,
                                    String senha, String confirmacaoSenha) {
    	
        if (!validarSenhas(senha, confirmacaoSenha)) {
            return; // Caso as senhas não coincidam, o cadastro não é prosseguido
        }

        // Chama a camada de acesso a dados
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserirFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);
    }
    
	public boolean validarSenhas(String senha, String confirmacaoSenha) {
	    if (!senha.equals(confirmacaoSenha)) {
	        JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;

	}
    }

