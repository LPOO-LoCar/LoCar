package com.locar.regras_negocio; //colocar na pasta de regras de controle

import java.util.HashMap;
import java.util.Map;

public class MudarSenhaController {
	private Map<String, String> usuarios = new HashMap<>();
	
	public MudarSenhaController() {
		usuarios.put("admin", "1234");
		usuarios.put("user", "senha");
	}
	
	public boolean validarSenhaAtual(String usuario, String senhaAtual) {
		return usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senhaAtual);
	}
	
	public boolean mudarSenha (String usuario, String senhaAtual, String novaSenha, String confirmarSenha) {
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuário não encontrado!");
		}
		if (!validarSenhaAtual(usuario, senhaAtual)) {
			throw new IllegalArgumentException("Senha atual incorreta!");
		}
		if (novaSenha.length() < 4) {
			throw new IllegalArgumentException ("A nova senha deve ter pelo menos 4 caracteres");
		}
		if (!novaSenha.equals(confirmarSenha)) {
			throw new IllegalArgumentException("As senhas diferente!");
		}
		
		usuarios.put(usuario, novaSenha);
		return true;
	}
}
