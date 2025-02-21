package com.locar.regras_negocio;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.locar.dados.FuncionarioDAO;

public class FuncionarioRegras {
	private boolean validarEmail(String email) {
	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	private boolean validarData(String data) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    try {
	        sdf.parse(data);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	private boolean validarCPF(String cpf) {
	    String regex = "^(\\d{3}\\.){2}\\d{3}-\\d{2}$";
	    return cpf.matches(regex);
	}

    public void cadastrarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
                                    String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
                                    String rua, String numeroRua, String bairro, String cidade, String complemento,
                                    String senha, String confirmacaoSenha) {
    	
    	try {
        if (!validarSenhas(senha, confirmacaoSenha)) {
            return; // Caso as senhas não coincidam, o cadastro não é prosseguido
        }
	    // Validação de nome (não pode ser vazio)
	    if (nome == null || nome.trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome não pode ser vazio.");
	    }
	    
	    if (cpf == null || cpf.trim().isEmpty()) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }
	    
	    if (!validarCPF(cpf)) {
	        throw new IllegalArgumentException("CPF deve estar no formato xxx.xxx.xxx-xx.");
	    }

	    // Validação de email (deve ser um email válido)
	    if (!validarEmail(email)) {
	        throw new IllegalArgumentException("Email inválido.");
	    }
	    
	    if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
	        throw new IllegalArgumentException("Data de nascimento é obrigatória.");
	    }
	    
	    if (!validarData(dataNascimento)) {
	        throw new IllegalArgumentException("Formato de data de nascimento inválido. O formato correto é dd/MM/yyyy.");
	    }
	    
	    if (!validarData(validadeCNH)) {
	        throw new IllegalArgumentException("Formato de data de vencimento da CNH inválido. O formato correto é dd/MM/yyyy.");
	    }	   

	    // Validação de CNH (deve ser uma CNH válida)
	    if (cnh == null || cnh.trim().isEmpty()) {
	        throw new IllegalArgumentException("CNH não pode ser vazia.");
	    }

	    // Validação de endereço (rua, número, bairro, cidade não podem ser vazios)
	    if (rua == null || rua.trim().isEmpty() || numeroRua == null || numeroRua.trim().isEmpty() || bairro == null || bairro.trim().isEmpty() || cidade == null || cidade.trim().isEmpty()) {
	        throw new IllegalArgumentException("Endereço inválido.");
	    }

	    // Validação de senha (deve ter pelo menos 8 caracteres)
	    if (senha == null || senha.length() < 4) {
	        throw new IllegalArgumentException("Senha deve ter pelo menos 4 caracteres.");
	    } 
        // Chama a camada de acesso a dados
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserirFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);
        
        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
    	} catch (IllegalArgumentException e) {
	        // Exibir a mensagem de erro ao usuário
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }

    }
    
	public boolean validarSenhas(String senha, String confirmacaoSenha) {
	    if (!senha.equals(confirmacaoSenha)) {
	        JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;

	}
    }

