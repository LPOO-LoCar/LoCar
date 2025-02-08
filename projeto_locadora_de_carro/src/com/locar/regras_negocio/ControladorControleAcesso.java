package com.locar.regras_negocio;

import com.locar.dados.Repositorio;
import com.locar.entidades.*;

public class ControladorControleAcesso {
	
	public void registrarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
			String vencimentoCnh, String bairroRua, int numero, String cep, String cidade, String estado, 
			String telefone, String email) {
		
		// TODO validações
		
		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh,
				bairroRua, numero, cep, cidade, estado, telefone, email);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarCliente(cliente);
		
	}
	
	public void registrarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {
		
		// TODO validações
		
		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarCarro(carro);
	}
	
	
	

}
