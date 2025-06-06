package com.locar.regras_negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.locar.dados.AgendamentoManuntencaoRepositorio;
import com.locar.dados.AgendamentoVistoriaRepositorio;
import com.locar.dados.CarroRepositorio;
import com.locar.dados.ClienteRepositorio;
import com.locar.dados.FuncionarioRepositorio;
import com.locar.dados.LocacaoRepositorio;
import com.locar.dados.ReservaRepositorio;
import com.locar.entidades.AgendamentoManutencao;
import com.locar.entidades.AgendamentoVistoria;
import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;
import com.locar.entidades.Funcionario;
import com.locar.entidades.Locacao;
import com.locar.entidades.Reserva;

public class ControladorControleAcesso {

	private boolean validarEmail(String email) {
	    String regex = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+";
	    return email.matches(regex);
	}

	private boolean validarData(String data) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    try {
	        sdf.parse(data);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

	private boolean validarCPF(String cpf) {
	    String regex = "(\\d{3}\\.){2}\\d{3}-\\d{2}";
	    return cpf.matches(regex);
	}

	private boolean validarHora(String hora) {
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    sdf.setLenient(false);
	    try {
	         sdf.parse(hora);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	
	public boolean validarSenhas(String senha, String confirmacaoSenha) {
		if (!senha.equals(confirmacaoSenha)) {
			JOptionPane.showMessageDialog(null, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}

	public void registrarCliente (String nomeCompleto, String dataNascimento, String cpf, String sexo, String cnh,
			String vencimentoCnh, String bairroRua, String numeroTexto, String cep, String cidade, String estado,
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
	    
	    int numero;
	    try {
	        numero = Integer.parseInt(numeroTexto.trim());
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Número do endereço deve ser numérico.");
	    }

		Cliente cliente = new Cliente(nomeCompleto, dataNascimento, cpf, sexo, cnh, vencimentoCnh,
				bairroRua, numero, cep, cidade, estado, telefone, email);
		ClienteRepositorio clienterepositorio = new ClienteRepositorio();
		clienterepositorio.registrarCliente(cliente);

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
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		clienteRepositorio.editarCliente(cliente);

	}

	public void registrarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {

	    int anoAtual = java.time.Year.now().getValue();
	    if (ano < 1886 || ano > anoAtual) {
	        throw new IllegalArgumentException("Ano inválido. O ano deve ser entre 1886 e " + anoAtual);
	    }

	    if (!placa.matches("[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}")) {
	        throw new IllegalArgumentException("Placa inválida. O formato deve ser AAA-1A23");
	    }

	    try {
	        int km = Integer.parseInt(kmRodados);
	        if (km < 0) {
	            throw new IllegalArgumentException("Quilometragem inválida. Não pode ser negativa.");
	        }
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Quilometragem inválida. Deve ser um número.");
	    }

	    if (chassi.isEmpty() || numMotor.isEmpty()) {
	        throw new IllegalArgumentException("Chassi e número de motor não podem ser vazios.");
	    }

		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		CarroRepositorio carrorepositorio = new CarroRepositorio();
		carrorepositorio.registrarCarro(carro);
	}

	public void editarCarro ( String marca, String modelo, int ano, String cor, String placa, String numMotor,
			String chassi, String combustivel, String transmissao, String categoria,String conservacao, String direcao,
			String kmRodados, int numLugares, int numPortas) {

	    int anoAtual = java.time.Year.now().getValue();
	    if (ano < 1886 || ano > anoAtual) {
	        throw new IllegalArgumentException("Ano inválido. O ano deve ser entre 1886 e " + anoAtual);
	    }

	    if (!placa.matches("[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}")) {
	        throw new IllegalArgumentException("Placa inválida. O formato deve ser AAA-1A23");
	    }

	    try {
	        int km = Integer.parseInt(kmRodados);
	        if (km < 0) {
	            throw new IllegalArgumentException("Quilometragem inválida. Não pode ser negativa.");
	        }
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Quilometragem inválida. Deve ser um número.");
	    }

	    if (chassi.isEmpty() || numMotor.isEmpty()) {
	        throw new IllegalArgumentException("Chassi e número de motor não podem ser vazios.");
	    }

		Carro carro = new Carro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao, categoria,
				conservacao,  direcao, kmRodados, numLugares, numPortas);
		CarroRepositorio carroRepositorio = new CarroRepositorio();
		carroRepositorio.editarCarro(carro);
	}
	
	public void cadastrarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
			String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep, String rua,
			String numeroRua, String bairro, String cidade, String complemento, String senha, String confirmacaoSenha) {

		try {
			if (!validarSenhas(senha, confirmacaoSenha)) {
				return; 
			}

			if (nome == null || nome.trim().isEmpty()) {
				throw new IllegalArgumentException("Nome não pode ser vazio.");
			}

			if (cpf == null || cpf.trim().isEmpty()) {
				throw new IllegalArgumentException("CPF inválido.");
			}

			if (!validarCPF(cpf)) {
				throw new IllegalArgumentException("CPF deve estar no formato xxx.xxx.xxx-xx.");
			}

			if (!validarEmail(email)) {
				throw new IllegalArgumentException("Email inválido.");
			}

			if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
				throw new IllegalArgumentException("Data de nascimento é obrigatória.");
			}

			if (!validarData(dataNascimento)) {
				throw new IllegalArgumentException(
						"Formato de data de nascimento inválido. O formato correto é dd/MM/yyyy.");
			}

			if (!validarData(validadeCNH)) {
				throw new IllegalArgumentException(
						"Formato de data de vencimento da CNH inválido. O formato correto é dd/MM/yyyy.");
			}

			if (cnh == null || cnh.trim().isEmpty()) {
				throw new IllegalArgumentException("CNH não pode ser vazia.");
			}

			if (rua == null || rua.trim().isEmpty() || numeroRua == null || numeroRua.trim().isEmpty() || bairro == null
					|| bairro.trim().isEmpty() || cidade == null || cidade.trim().isEmpty()) {
				throw new IllegalArgumentException("Endereço inválido.");
			}

			if (senha == null || senha.length() < 4) {
				throw new IllegalArgumentException("Senha deve ter pelo menos 4 caracteres.");
			}
			FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
			funcionarioRepositorio.inserirFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
					validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);

			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void editarFuncionario(String nome, String cpf, String rg, String orgExp, String telefone, String email,
			String dataNascimento, String dataExp, String cnh, String validadeCNH, String cep, String rua,
			String numeroRua, String bairro, String cidade, String complemento, String senha) {

		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio.");
		}

		if (cpf == null || cpf.trim().isEmpty()) {
			throw new IllegalArgumentException("CPF inválido.");
		}

		if (!validarCPF(cpf)) {
			throw new IllegalArgumentException("CPF deve ter 11 dígitos numéricos.");
		}

		if (!validarEmail(email)) {
			throw new IllegalArgumentException("Email inválido.");
		}

		if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
			throw new IllegalArgumentException("Data de nascimento é obrigatória.");
		}

		if (!validarData(dataNascimento)) {
			throw new IllegalArgumentException(
					"Formato de data de nascimento inválido. O formato correto é dd/MM/yyyy.");
		}

		if (!validarData(validadeCNH) || !validarData(validadeCNH)) {
			throw new IllegalArgumentException(
					"Formato de data de vencimento da CNH inválido. O formato correto é dd/MM/yyyy.");
		}

		if (cnh == null || cnh.trim().isEmpty()) {
			throw new IllegalArgumentException("CNH é obrigatória.");
		}

		if (rua == null || rua.trim().isEmpty() || numeroRua == null || numeroRua.trim().isEmpty() || bairro == null
				|| bairro.trim().isEmpty() || cidade == null || cidade.trim().isEmpty()) {
			throw new IllegalArgumentException("Endereço inválido.");
		}

		if (senha == null || senha.length() < 4) {
			throw new IllegalArgumentException("Senha deve ter pelo menos 4 caracteres.");
		}

		Funcionario funcionario = new Funcionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
				validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);

		FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
		funcionarioRepositorio.editarFuncionario(funcionario);
	}

	public void registrarLocacao ( Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal,
			String formaPagamento, String status, String dataLocacao) {

	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente não pode ser nulo.");
	    }
	    if (carro == null) {
	        throw new IllegalArgumentException("Carro não pode ser nulo.");
	    }

	    if (valorDiaria <= 0) {
	        throw new IllegalArgumentException("O valor da diária deve ser maior que zero.");
	    }

	    if (diasLocados < 1) {
	        throw new IllegalArgumentException("O número de dias locados deve ser no mínimo 1.");
	    }

	    if (valorTotal <= 0 || valorTotal != valorDiaria * diasLocados) {
	        throw new IllegalArgumentException("O valor total está incorreto.");
	    }

		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status, dataLocacao);
		LocacaoRepositorio locacaoRepositorio = new LocacaoRepositorio();
		locacaoRepositorio.registrarLocacao(locacao);

	}

	public void editarLocacao (Cliente cliente, Carro carro, double valorDiaria, int diasLocados, double valorTotal,
			String formaPagamento, String status) {

	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente não pode ser nulo.");
	    }
	    if (carro == null) {
	        throw new IllegalArgumentException("Carro não pode ser nulo.");
	    }

	    if (valorDiaria <= 0) {
	        throw new IllegalArgumentException("O valor da diária deve ser maior que zero.");
	    }

	    if (diasLocados < 1) {
	        throw new IllegalArgumentException("O número de dias locados deve ser no mínimo 1.");
	    }
	    if (valorTotal <= 0 || valorTotal != valorDiaria * diasLocados) {
	        throw new IllegalArgumentException("O valor total está incorreto.");
	    }

		Locacao locacao = new Locacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status);
		LocacaoRepositorio locacaoRepositorio = new LocacaoRepositorio();
		locacaoRepositorio.editarLocacao(locacao);

	}

	public void registrarReserva ( Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {
		
		if (cliente == null) {
		    throw new IllegalArgumentException("Ccliente não pode ser nulo.");
		}
		if (carro == null) {
		    throw new IllegalArgumentException("Carro não pode ser nulo.");
		}
		if (dataRetirada == null) {
		    throw new IllegalArgumentException("Data de Retirada não pode ser nulo.");
		}
		if (horaRetirada == null) {
		    throw new IllegalArgumentException("Hora de Retirada não pode ser nulo.");
		}
		if (dataEntrega == null) {
		    throw new IllegalArgumentException("Data de Entrega não pode ser nulo.");
		}
		if (horaEntrega == null) {
		    throw new IllegalArgumentException("Hora de Entrega não pode ser nulo.");
		}

	    if (!validarData(dataRetirada) || !validarData(dataEntrega)) {
	        throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.");
	    }

	    if (!validarHora(horaRetirada) || !validarHora(horaEntrega)) {
	        throw new IllegalArgumentException("Formato de hora inválido. Use HH:mm.");
	    }
	    
	    if (carro == null || !carro.estaDisponivel(dataRetirada, dataEntrega)) {
	        throw new IllegalArgumentException("Carro indisponível para as datas informadas.");
	    }

		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
		reservaRepositorio.registrarReserva(reserva);

	}

	public void editarReserva (Cliente cliente, Carro carro, String dataRetirada, String horaRetirada, String dataEntrega,
			String horaEntrega) {

	    if (cliente == null) {
	        throw new IllegalArgumentException("Cliente inválido.");
	    }

	    if (carro == null || !carro.estaDisponivel(dataRetirada, dataEntrega)) {
	        throw new IllegalArgumentException("Carro indisponível para as datas informadas.");
	    }

	    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
	    formatoData.setLenient(false);
	    formatoHora.setLenient(false);
	    
	    try {
	        Date dataRetiradaDate = formatoData.parse(dataRetirada);
	        Date dataEntregaDate = formatoData.parse(dataEntrega);
	        Date horaRetiradaDate = formatoHora.parse(horaRetirada);
	        Date horaEntregaDate = formatoHora.parse(horaEntrega);

	        if (dataEntregaDate.before(dataRetiradaDate) ||
	           (dataEntregaDate.equals(dataRetiradaDate) && horaEntregaDate.before(horaRetiradaDate))) {
	            throw new IllegalArgumentException("A data e hora de entrega não podem ser anteriores à data e hora de retirada.");
	        }

	    } catch (Exception e) {
	        throw new IllegalArgumentException("Formato de data ou hora inválido.");
	    }

		Reserva reserva = new Reserva(cliente, carro, dataRetirada, horaRetirada,dataEntrega,horaEntrega);
		ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
		reservaRepositorio.editarReserva(reserva);

	}

	public void registrarAgendamentoManuntencao (Carro carro, String tipoManuntencao, String dataManuntencao,
			String hora, String observacao) {

	    if (carro == null) {
	        throw new IllegalArgumentException("O carro não pode ser nulo.");
	    }

	    if (tipoManuntencao == null || tipoManuntencao.trim().isEmpty()) {
	        throw new IllegalArgumentException("O tipo de manutenção não pode ser vazio.");
	    }

	    if (dataManuntencao == null || !validarData(dataManuntencao)) {
	        throw new IllegalArgumentException("A data de manutenção deve estar no formato DD/MM/AAAA.");
	    }

	    if (hora == null || !validarHora(hora)) {
	        throw new IllegalArgumentException("A hora de manutenção deve estar no formato HH:MM.");
	    }

	    if (observacao != null && observacao.length() > 500) {
	        throw new IllegalArgumentException("A observação não pode exceder 500 caracteres.");
	    }

		AgendamentoManutencao agendamentoManuntencao = new AgendamentoManutencao(carro, tipoManuntencao, dataManuntencao ,
				hora ,observacao);
		AgendamentoManuntencaoRepositorio agendamentoManuntencaoRepositorio = new AgendamentoManuntencaoRepositorio();
		agendamentoManuntencaoRepositorio.registrarAgendamentoManutencao(agendamentoManuntencao);

	}

	public void registrarAgendamentoVistoria (Carro carro, String tipoVistoria, String dataVistoria,
			String hora, String observacao) {

	    if (carro == null) {
	        throw new IllegalArgumentException("O carro não pode ser nulo.");
	    }

	    if (tipoVistoria == null || tipoVistoria.trim().isEmpty()) {
	        throw new IllegalArgumentException("O tipo de vistoria não pode ser vazio.");
	    }

	    if (dataVistoria == null || !validarData(dataVistoria)) {
	        throw new IllegalArgumentException("A data deve estar no formato dd/MM/AAAA.");
	    }

	    if (hora == null || !validarHora(hora)) {
	        throw new IllegalArgumentException("A hora deve estar no formato HH:mm.");
	    }

	    if (observacao != null && observacao.length() > 500) {
	        throw new IllegalArgumentException("A observação não pode ter mais de 500 caracteres.");
	    }

		AgendamentoVistoria agendamentoVistoria = new AgendamentoVistoria(carro, tipoVistoria, dataVistoria,
				hora ,observacao);
		AgendamentoVistoriaRepositorio agendamentoVistoriaRepositorio = new AgendamentoVistoriaRepositorio();
		agendamentoVistoriaRepositorio.registrarAgendamentoVistoria(agendamentoVistoria);

	}

}
