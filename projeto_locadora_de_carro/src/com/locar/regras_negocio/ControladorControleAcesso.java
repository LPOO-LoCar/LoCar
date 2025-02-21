package com.locar.regras_negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.locar.dados.Repositorio;
import com.locar.entidades.*;

public class ControladorControleAcesso {
	
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
	
	private boolean validarHora(String hora) {
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    sdf.setLenient(false);
	    try {
	        Date time = sdf.parse(hora);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	

	public void registrarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
			String vencimentoCnh, String bairroRua, int numero, String cep, String cidade, String estado, 
			String telefone, String email) {
		
	
	    if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome completo é obrigatório.");
	    }
	    if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
	        throw new IllegalArgumentException("Data de nascimento é obrigatória.");
	    }
	    
	    if (!validarData(dataNascimento)) {
	        throw new IllegalArgumentException("Formato de data de nascimento inválido. O formato correto é dd/MM/yyyy.");
	    }
	    
	    if (cpf == null || cpf.trim().isEmpty()) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }
	    
	    if (!validarCPF(cpf)) {
	        throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos.");
	    }
	    
	    if (cnh == null || cnh.trim().isEmpty()) {
	        throw new IllegalArgumentException("CNH é obrigatória.");
	    }
	    if (vencimentoCnh == null || vencimentoCnh.trim().isEmpty()) {
	        throw new IllegalArgumentException("Data de vencimento da CNH é obrigatória.");
	    }
	    
	    if (!validarData(vencimentoCnh)) {
	        throw new IllegalArgumentException("Formato de data de vencimento da CNH inválido. O formato correto é dd/MM/yyyy.");
	    }
	    
	    if (bairroRua == null || bairroRua.trim().isEmpty()) {
	        throw new IllegalArgumentException("Endereço é obrigatório.");
	    }
	    if (cep == null || cep.trim().isEmpty()) {
	        throw new IllegalArgumentException("CEP é obrigatório.");
	    }
	    if (cidade == null || cidade.trim().isEmpty()) {
	        throw new IllegalArgumentException("Cidade é obrigatória.");
	    }
	    if (estado == null || estado.trim().isEmpty()) {
	        throw new IllegalArgumentException("Estado é obrigatório.");
	    }
	    if (telefone == null || telefone.trim().isEmpty()) {
	        throw new IllegalArgumentException("Telefone é obrigatório.");
	    }
	    if (email == null || !validarEmail(email)) {
	        throw new IllegalArgumentException("E-mail inválido.");
	    }
		
		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh,
				bairroRua, numero, cep, cidade, estado, telefone, email);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarCliente(cliente);
		
	}
	
	public void EditarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
			String vencimentoCnh, String bairroRua, int numero, String cep, String cidade, String estado, 
			String telefone, String email) {
		
	    if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome completo é obrigatório.");
	    }
	    if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
	        throw new IllegalArgumentException("Data de nascimento é obrigatória.");
	    }
	    
	    if (!validarData(dataNascimento)) {
	        throw new IllegalArgumentException("Formato de data de nascimento inválido. O formato correto é dd/MM/yyyy.");
	    }
	    
	    if (cpf == null || cpf.trim().isEmpty()) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }
	    
	    if (!validarCPF(cpf)) {
	        throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos.");
	    }
	    
	    if (sexo == null || (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F"))) {
	        throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
	    }
	    if (cnh == null || cnh.trim().isEmpty()) {
	        throw new IllegalArgumentException("CNH é obrigatória.");
	    }
	    if (vencimentoCnh == null || vencimentoCnh.trim().isEmpty()) {
	        throw new IllegalArgumentException("Data de vencimento da CNH é obrigatória.");
	    }
	    
	    if (!validarData(vencimentoCnh)) {
	        throw new IllegalArgumentException("Formato de data de vencimento da CNH inválido. O formato correto é dd/MM/yyyy.");
	    }
	    
	    if (bairroRua == null || bairroRua.trim().isEmpty()) {
	        throw new IllegalArgumentException("Endereço é obrigatório.");
	    }
	    if (cep == null || cep.trim().isEmpty()) {
	        throw new IllegalArgumentException("CEP é obrigatório.");
	    }
	    if (cidade == null || cidade.trim().isEmpty()) {
	        throw new IllegalArgumentException("Cidade é obrigatória.");
	    }
	    if (estado == null || estado.trim().isEmpty()) {
	        throw new IllegalArgumentException("Estado é obrigatório.");
	    }
	    if (telefone == null || telefone.trim().isEmpty()) {
	        throw new IllegalArgumentException("Telefone é obrigatório.");
	    }
	    if (email == null || !validarEmail(email)) {
	        throw new IllegalArgumentException("E-mail inválido.");
	    }
		
		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh,
				bairroRua, numero, cep, cidade, estado, telefone, email);
		Repositorio repositorio = new Repositorio();
		repositorio.EditarCliente(cliente);
		
	}
	
	public void registrarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {
		
	    int anoAtual = java.time.Year.now().getValue();
	    if (ano < 1886 || ano > anoAtual) {
	        throw new IllegalArgumentException("Ano inválido. O ano deve ser entre 1886 e " + anoAtual);
	    }

	    // Validação de placa
	    if (!placa.matches("[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}")) {
	        throw new IllegalArgumentException("Placa inválida. O formato deve ser AAA-1A23");
	    }

	    // Validação de quilometragem
	    try {
	        int km = Integer.parseInt(kmRodados);
	        if (km < 0) {
	            throw new IllegalArgumentException("Quilometragem inválida. Não pode ser negativa.");
	        }
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Quilometragem inválida. Deve ser um número.");
	    }

	    // Validação de chassi e número de motor
	    if (chassi.isEmpty() || numMotor.isEmpty()) {
	        throw new IllegalArgumentException("Chassi e número de motor não podem ser vazios.");
	    }
		
		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarCarro(carro);
	}
	
	public void editarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {
		
	    int anoAtual = java.time.Year.now().getValue();
	    if (ano < 1886 || ano > anoAtual) {
	        throw new IllegalArgumentException("Ano inválido. O ano deve ser entre 1886 e " + anoAtual);
	    }

	    // Validação de placa
	    if (!placa.matches("[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}")) {
	        throw new IllegalArgumentException("Placa inválida. O formato deve ser AAA-1A23");
	    }

	    // Validação de quilometragem
	    try {
	        int km = Integer.parseInt(kmRodados);
	        if (km < 0) {
	            throw new IllegalArgumentException("Quilometragem inválida. Não pode ser negativa.");
	        }
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Quilometragem inválida. Deve ser um número.");
	    }

	    // Validação de chassi e número de motor
	    if (chassi.isEmpty() || numMotor.isEmpty()) {
	        throw new IllegalArgumentException("Chassi e número de motor não podem ser vazios.");
	    }
		
		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		Repositorio repositorio = new Repositorio();
		repositorio.editarCarro(carro);
	}
	
	public void editarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
            String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep,
            String rua, String numeroRua, String bairro, String cidade, String complemento,
            String senha) {
		
	    // Validação de nome (não pode ser vazio)
	    if (nome == null || nome.trim().isEmpty()) {
	        throw new IllegalArgumentException("Nome não pode ser vazio.");
	    }
	    
	    if (cpf == null || cpf.trim().isEmpty()) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }
	    
	    if (!validarCPF(cpf)) {
	        throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos.");
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
	    }	    if (!validarData(validadeCNH)) {
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

Funcionario funcionario = new Funcionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                               validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);

Repositorio repositorio = new Repositorio();
repositorio.editarFuncionario(funcionario);
}

	public void registrarLocacao ( Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal, 
			String formaPagamento, String status, String dataLocacao) {
		
	    // Validação de cliente e carro
	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente não pode ser nulo.");
	    }
	    if (carro == null) {
	        throw new IllegalArgumentException("Carro não pode ser nulo.");
	    }

	    // Validação do valor da diária
	    if (valorDiaria <= 0) {
	        throw new IllegalArgumentException("O valor da diária deve ser maior que zero.");
	    }

	    // Validação dos dias locados
	    if (diasLocados < 1) {
	        throw new IllegalArgumentException("O número de dias locados deve ser no mínimo 1.");
	    }

	    // Validação do valor total
	    if (valorTotal <= 0 || valorTotal != valorDiaria * diasLocados) {
	        throw new IllegalArgumentException("O valor total está incorreto.");
	    }
		
		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status, dataLocacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarLocacao(locacao);
		
	}
	
	public void editarLocacao (Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal, 
			String formaPagamento, String status) {
		
	    // Validação de cliente e carro
	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente não pode ser nulo.");
	    }
	    if (carro == null) {
	        throw new IllegalArgumentException("Carro não pode ser nulo.");
	    }

	    // Validação do valor da diária
	    if (valorDiaria <= 0) {
	        throw new IllegalArgumentException("O valor da diária deve ser maior que zero.");
	    }

	    // Validação dos dias locados
	    if (diasLocados < 1) {
	        throw new IllegalArgumentException("O número de dias locados deve ser no mínimo 1.");
	    }

	    // Validação do valor total
	    if (valorTotal <= 0 || valorTotal != valorDiaria * diasLocados) {
	        throw new IllegalArgumentException("O valor total está incorreto.");
	    }
		
		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status);
		Repositorio repositorio = new Repositorio();
		repositorio.editarLocacao(locacao);
		
	}
	
	public void registrarReserva ( Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
	    if (cliente == null || carro == null || dataRetirada == null || horaRetirada == null || dataEntrega == null || horaEntrega == null) {
	        throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
	    }
	    
	    if (!validarData(dataRetirada) || !validarData(dataEntrega)) {
	        throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.");
	    }
	    
	    if (!validarHora(horaRetirada) || !validarHora(horaEntrega)) {
	        throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm.");
	    }
	    
		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarReserva(reserva);
		
	}
	
	public void editarReserva (Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
	    // Validação do cliente
	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente inválido.");
	    }

	    // Validação do carro
	    if (carro == null || !carro.estaDisponivel(dataRetirada, dataEntrega)) {
	        throw new IllegalArgumentException("Carro indisponível para as datas informadas.");
	    }

	    // Validação das datas e horas (formato)
	    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

	    try {
	        Date dataRetiradaDate = formatoData.parse(dataRetirada);
	        Date dataEntregaDate = formatoData.parse(dataEntrega);
	        Date horaRetiradaDate = formatoHora.parse(horaRetirada);
	        Date horaEntregaDate = formatoHora.parse(horaEntrega);

	        // Validação da data de entrega ser posterior à data de retirada
	        if (dataEntregaDate.before(dataRetiradaDate) || 
	           (dataEntregaDate.equals(dataRetiradaDate) && horaEntregaDate.before(horaRetiradaDate))) {
	            throw new IllegalArgumentException("A data e hora de entrega não podem ser anteriores à data e hora de retirada.");
	        }

	    } catch (Exception e) {
	        throw new IllegalArgumentException("Formato de data ou hora inválido.");
	    }
		
		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		Repositorio repositorio = new Repositorio();
		repositorio.editarReserva(reserva);
		
	}
	
	public void registrarAgendamentoManuntencao (Carro carro, String tipoManuntencao, String dataManuntencao, 
			String hora, String observacao) {
		
	    // Validação do carro
	    if (carro == null) {
	        throw new IllegalArgumentException("O carro não pode ser nulo.");
	    }
	    
	    // Validação do tipo de manutenção
	    if (tipoManuntencao == null || tipoManuntencao.trim().isEmpty()) {
	        throw new IllegalArgumentException("O tipo de manutenção não pode ser vazio.");
	    }
	    
	    // Validação da data de manutenção (formato DD/MM/YYYY)
	    if (dataManuntencao == null || !dataManuntencao.matches("\\d{2}/\\d{2}/\\d{4}")) {
	        throw new IllegalArgumentException("A data de manutenção deve estar no formato DD/MM/AAAA.");
	    }
	    
	    // Validação da hora de manutenção (formato HH:MM)
	    if (hora == null || !hora.matches("\\d{2}:\\d{2}")) {
	        throw new IllegalArgumentException("A hora de manutenção deve estar no formato HH:MM.");
	    }
	    
	    // Validação da observação (opcional, mas não pode ser excessivamente longa)
	    if (observacao != null && observacao.length() > 500) {
	        throw new IllegalArgumentException("A observação não pode exceder 500 caracteres.");
	    }
		
		AgendamentoManuntencao agendamentoManuntencao = new AgendamentoManuntencao(carro, tipoManuntencao, dataManuntencao , 
				hora ,observacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarAgendamentoManuntencao(agendamentoManuntencao);
		
	}
	
	public void registrarAgendamentoVistoria (Carro carro, String tipoVistoria, String dataVistoria, 
			String hora, String observacao) {
		
	    // Validação do carro
	    if (carro == null) {
	        throw new IllegalArgumentException("O carro não pode ser nulo.");
	    }

	    // Validação do tipo de vistoria
	    if (tipoVistoria == null || tipoVistoria.trim().isEmpty()) {
	        throw new IllegalArgumentException("O tipo de vistoria não pode ser vazio.");
	    }

	    // Validação da data
	    if (dataVistoria == null || !dataVistoria.matches("\\d{2}/\\d{2}/\\d{4}")) {
	        throw new IllegalArgumentException("A data deve estar no formato dd/MM/AAAA.");
	    }

	    // Validação da hora
	    if (hora == null || !hora.matches("\\d{2}:\\d{2}")) {
	        throw new IllegalArgumentException("A hora deve estar no formato HH:mm.");
	    }

	    // Validação da observação (opcional, mas se fornecida não pode ser muito longa)
	    if (observacao != null && observacao.length() > 500) {
	        throw new IllegalArgumentException("A observação não pode ter mais de 500 caracteres.");
	    }
		
		AgendamentoVistoria agendamentoVistoria = new AgendamentoVistoria(carro, tipoVistoria, dataVistoria, 
				hora ,observacao);
		Repositorio repositorio = new Repositorio();
		repositorio.registrarAgendamentoVistoria(agendamentoVistoria);
		
	}

}
