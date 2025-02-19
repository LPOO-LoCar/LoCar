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
	
	public void EditarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
			String vencimentoCnh, String bairroRua, int numero, String cep, String cidade, String estado, 
			String telefone, String email) {
		
		// TODO validações
		
		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh,
				bairroRua, numero, cep, cidade, estado, telefone, email);
		Repositorio repositorio = new Repositorio();
		repositorio.EditarCliente(cliente);
		
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
	
	public void editarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {
		
		// TODO validações
		
		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		Repositorio repositorio = new Repositorio();
		repositorio.editarCarro(carro);
	}
	
	public void editarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
            String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
            String rua, String numeroRua, String bairro, String cidade, String complemento,
            String senha) {

// TODO: Implementar validações

Funcionario funcionario = new Funcionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                               validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);

Repositorio repositorio = new Repositorio();
repositorio.editarFuncionario(funcionario);
}

	
	public void registrarLocacao ( Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal, 
			String formaPagamento, String status, String dataLocacao) {
		
		// TODO validações
		
		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status, dataLocacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarLocacao(locacao);
		
	}
	
	public void editarLocacao (Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal, 
			String formaPagamento, String status) {
		
		// TODO validações
		
		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status);
		Repositorio repositorio = new Repositorio();
		repositorio.editarLocacao(locacao);
		
	}
	
	public void registrarReserva ( Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
		// TODO validações
		
		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarReserva(reserva);
		
	}
	
	public void editarReserva (Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
		// TODO validações
		
		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		Repositorio repositorio = new Repositorio();
		repositorio.editarReserva(reserva);
		
	}
	
	public void registrarAgendamentoManuntencao (Carro carro, String tipoManuntencao, String dataManuntencao, 
			String hora, String observacao) {
		
		// TODO validações
		
		AgendamentoManuntencao agendamentoManuntencao = new AgendamentoManuntencao(carro, tipoManuntencao, dataManuntencao , 
				hora ,observacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarAgendamentoManuntencao(agendamentoManuntencao);
		
	}
	
	public void registrarAgendamentoVistoria (Carro carro, String tipoManuntencao, String dataManuntencao, 
			String hora, String observacao) {
		
		// TODO validações
		
		AgendamentoVistoria agendamentoVistoria = new AgendamentoVistoria(carro, tipoManuntencao, dataManuntencao , 
				hora ,observacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarAgendamentoVistoria(agendamentoVistoria);
		
	}

}
