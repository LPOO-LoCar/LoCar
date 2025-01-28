package com.locar.regras_negocio;

import com.locar.dados.Repositorio;
import com.locar.entidades.Cliente;

public class ControladorControleAcesso {
	
	public void registrarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String bairroRua,
			int numero, String cep, String cidade, String estado, String telefone, String email) {
		
		// TODO validações
		
		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, bairroRua, numero, cep, cidade, estado, 
				telefone, email);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarCliente(cliente);
		
		
	}
	

}
