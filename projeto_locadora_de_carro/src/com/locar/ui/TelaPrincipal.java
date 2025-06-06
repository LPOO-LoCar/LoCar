package com.locar.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.locar.ui.ajuda.HelpMe;
import com.locar.ui.ajuda.Sobre;
import com.locar.ui.buscar.BuscarCliente;
import com.locar.ui.buscar.BuscarFuncionario;
import com.locar.ui.buscar.BuscarLocacao;
import com.locar.ui.buscar.BuscarReserva;
import com.locar.ui.buscar.BuscarVeiculo;
import com.locar.ui.cadastro.NovaLocação;
import com.locar.ui.cadastro.NovaReserva;
import com.locar.ui.cadastro.NovoCliente;
import com.locar.ui.cadastro.NovoFuncionario;
import com.locar.ui.cadastro.NovoVeiculo;
import com.locar.ui.editar.AgendarManutencaoVeicular;
import com.locar.ui.editar.AgendarVistoriaVeicular;
import com.locar.ui.editar.EditarCliente;
import com.locar.ui.editar.EditarFuncionario;
import com.locar.ui.editar.EditarLocacao;
import com.locar.ui.editar.EditarReserva;
import com.locar.ui.editar.EditarVeiculo;
import com.locar.ui.relatorios.RelatoriosFinanceiros;
import com.locar.ui.relatorios.RelatoriosVeiculos;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal("ADMIN");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(String funcao) {
		setTitle("Locar - Locadora de Veiculos");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(1, 1, 1, 1));
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setBounds(0, 0, 784, 31);
		contentPane.add(menuBar);

		JMenu menuArquivo = new JMenu("Cadastro");
		menuArquivo.setForeground(Color.BLACK);
		menuArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuArquivo);

		JMenuItem novoClienteMenuItem = new JMenuItem("Novo Cliente");
		novoClienteMenuItem.setForeground(Color.BLACK);
		novoClienteMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(novoClienteMenuItem);

		novoClienteMenuItem.addActionListener(e -> {
			NovoCliente telaNovoCliente = new NovoCliente(funcao);
			dispose();
			telaNovoCliente.setVisible(true);
		});

		JMenuItem novoVeiculoMenuItem = new JMenuItem("Novo Veículo");
		novoVeiculoMenuItem.setForeground(Color.BLACK);
		novoVeiculoMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(novoVeiculoMenuItem);

		novoVeiculoMenuItem.addActionListener(e -> {
			if (funcao.equals("ADMIN")) {
			NovoVeiculo telaNovoVeiculo = new NovoVeiculo();
			dispose();
			telaNovoVeiculo.setVisible(true);
			} else {
	            JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
		});

		JMenuItem novoFuncionarioMenuItem = new JMenuItem("Novo Funcionário");
		novoFuncionarioMenuItem.setForeground(Color.BLACK);
		novoFuncionarioMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(novoFuncionarioMenuItem);

		novoFuncionarioMenuItem.addActionListener (e -> {
			if (funcao.equals("ADMIN")) {
			NovoFuncionario telaNovoFuncionario = new NovoFuncionario();
			dispose();
			telaNovoFuncionario.setVisible(true);
			} else {
	            JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
		});

		JMenuItem novaLocaçaoMenuItem = new JMenuItem("Nova Locação");
		novaLocaçaoMenuItem.setForeground(Color.BLACK);
		novaLocaçaoMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(novaLocaçaoMenuItem);

		novaLocaçaoMenuItem.addActionListener(e ->{
			NovaLocação telaNovaLocaçao = new NovaLocação(funcao);
			dispose();
			telaNovaLocaçao.setVisible(true);
		});

		JMenuItem novaReservaArquivo = new JMenuItem("Nova Reserva");
		novaReservaArquivo.setForeground(Color.BLACK);
		novaReservaArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(novaReservaArquivo);

		novaReservaArquivo.addActionListener(e -> {
			NovaReserva telaNovaReserva = new NovaReserva(funcao);
			dispose();
			telaNovaReserva.setVisible(true);
		});

		JMenuItem fazerLogoutMenuItem = new JMenuItem("Fazer logout");
		fazerLogoutMenuItem.setForeground(Color.BLACK);
		fazerLogoutMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuArquivo.add(fazerLogoutMenuItem);

		fazerLogoutMenuItem.addActionListener(e -> {
			int confirmacao = JOptionPane.showConfirmDialog(
					null,
					"Tem certeza que deseja encessar a sessão?",
					"Confirmar Logout",
					JOptionPane.YES_NO_OPTION
					);
			if (confirmacao == JOptionPane.YES_OPTION) {
				dispose();
				new Login().setVisible(true);
			}

		});

		JMenuItem sairMenuItem = new JMenuItem("Sair");
		sairMenuItem.setForeground(Color.BLACK);
		sairMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		sairMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			int confirmacao = JOptionPane.showConfirmDialog(
					null,
					"Tem certeza que deseja sair?",
					"Confirmar Saída",
					JOptionPane.YES_NO_OPTION);
			if (confirmacao == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

			}
		});

		menuArquivo.add(sairMenuItem);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);

		JMenu menuEditar = new JMenu("Editar");
		menuEditar.setForeground(Color.BLACK);
		menuEditar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuEditar);

		JMenu submenuVeiculo = new JMenu("Gerenciar Veículo");
		submenuVeiculo.setForeground(Color.BLACK);
		submenuVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JMenuItem editarremoverVeiculo = new JMenuItem("Editar/Remover Veículo");
		editarremoverVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submenuVeiculo.add(editarremoverVeiculo);

		editarremoverVeiculo.addActionListener(e -> {
			if (funcao.equals("ADMIN")) {
			EditarVeiculo telaEditarVeiculo = new EditarVeiculo(funcao);
			dispose();
			telaEditarVeiculo.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		JMenuItem agendarManutençao = new JMenuItem("Agendar Manutenção Veicular");
		agendarManutençao.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submenuVeiculo.add(agendarManutençao);

		agendarManutençao.addActionListener(e ->{
			if (funcao.equals("ADMIN")) {
			AgendarManutencaoVeicular telaAgendarManutençao = new AgendarManutencaoVeicular(funcao);
			dispose();
			telaAgendarManutençao.setVisible(true);
			} else {
	            JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
		});

		JMenuItem agendarVistoria = new JMenuItem("Agendar Vistoria Veicular");
		agendarVistoria.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submenuVeiculo.add(agendarVistoria);

		agendarVistoria.addActionListener(e -> {
			if (funcao.equals("ADMIN")) {
			AgendarVistoriaVeicular telaAgendarVistoria = new AgendarVistoriaVeicular(funcao);
			dispose();
			telaAgendarVistoria.setVisible(true);
			} else {
	            JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
		});

		JMenuItem editarGerenciarCliente = new JMenuItem("Gerenciar Cliente");
		editarGerenciarCliente.setForeground(Color.BLACK);
		editarGerenciarCliente.addActionListener(e -> {
			EditarCliente telaEditarCliente = new EditarCliente(funcao);
			dispose();
			telaEditarCliente.setVisible(true);
		});
		editarGerenciarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuEditar.add(editarGerenciarCliente);

		menuEditar.add(submenuVeiculo);

		JMenuItem menuLocaçoes = new JMenuItem("Gerenciar Locações");
		menuLocaçoes.setForeground(Color.BLACK);
		menuLocaçoes.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		menuLocaçoes.addActionListener(e -> {
			EditarLocacao telaEditarLocaçaoAtiva = new EditarLocacao(funcao);
			dispose();
			telaEditarLocaçaoAtiva.setVisible(true);

		});

		JMenuItem editarGerenciarFuncionario = new JMenuItem("Gerenciar Funcionario");
		editarGerenciarFuncionario.setForeground(Color.BLACK);
		editarGerenciarFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuEditar.add(editarGerenciarFuncionario);

		editarGerenciarFuncionario.addActionListener(e -> {
			if (funcao.equals("ADMIN")) {
			EditarFuncionario telaEditarFuncionario = new EditarFuncionario(funcao);
			dispose();
			telaEditarFuncionario.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Sem permissão", "Erro", JOptionPane.ERROR_MESSAGE);

			}
		});

		menuEditar.add(menuLocaçoes);

		JMenuItem menuReservas = new JMenuItem("Gerenciar Reservas");
		menuReservas.setForeground(Color.BLACK);
		menuReservas.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		menuReservas.addActionListener(e -> {
			EditarReserva telaEditarReservaAtiva = new EditarReserva(funcao);
			dispose();
			telaEditarReservaAtiva.setVisible(true);

		});

		menuEditar.add(menuReservas);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_1);


		JMenu menuBuscar = new JMenu("Buscar");
		menuBuscar.setForeground(Color.BLACK);
		menuBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuBuscar);

		JMenuItem buscarCliente = new JMenuItem("Buscar Cliente");
		buscarCliente.setForeground(Color.BLACK);
		buscarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBuscar.add(buscarCliente);

		buscarCliente.addActionListener(e -> {
			BuscarCliente telaBuscarCliente = new BuscarCliente(funcao);
			dispose();
			telaBuscarCliente.setVisible(true);
		});

		JMenuItem buscarVeiculo = new JMenuItem("Buscar Veículo");
		buscarVeiculo.setForeground(Color.BLACK);
		buscarVeiculo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBuscar.add(buscarVeiculo);

		buscarVeiculo.addActionListener(e -> {
			BuscarVeiculo telaBuscarVeiculo = new BuscarVeiculo(funcao);
			dispose();
			telaBuscarVeiculo.setVisible(true);
		});

		JMenuItem buscarFuncionario = new JMenuItem("Buscar Funcionário");
		buscarFuncionario.setForeground(Color.BLACK);
		buscarFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBuscar.add(buscarFuncionario);

		buscarFuncionario.addActionListener(e -> {
			BuscarFuncionario telaBuscarFuncionario = new BuscarFuncionario("ADMIN");
			dispose();
			telaBuscarFuncionario.setVisible(true);
		});

		JMenuItem buscarLocaçao = new JMenuItem("Buscar Locação");
		buscarLocaçao.setForeground(Color.BLACK);
		buscarLocaçao.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBuscar.add(buscarLocaçao);

		buscarLocaçao.addActionListener(e -> {
			BuscarLocacao telaBuscarLocaçao = new BuscarLocacao(funcao);
			dispose();
			telaBuscarLocaçao.setVisible(true);
		});

		JMenuItem buscarReserva = new JMenuItem("Buscar Reserva");
		buscarReserva.setForeground(Color.BLACK);
		buscarReserva.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBuscar.add(buscarReserva);

		buscarReserva.addActionListener(e ->{
			BuscarReserva telaBuscarReserva = new BuscarReserva(funcao);
			dispose();
			telaBuscarReserva.setVisible(true);
		});

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_2);

		JMenu menuPagamentos = new JMenu("Pagamentos");
		menuPagamentos.setForeground(Color.BLACK);
		menuPagamentos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuPagamentos);

		JMenuItem pagamentosPagar = new JMenuItem("Pagar");
		pagamentosPagar.setForeground(Color.BLACK);
		pagamentosPagar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuPagamentos.add(pagamentosPagar);

		JMenu submenuRegistroDePagamentos = new JMenu("Registro de Pagamentos");
		submenuRegistroDePagamentos.setForeground(Color.BLACK);
		submenuRegistroDePagamentos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuPagamentos.add(submenuRegistroDePagamentos);

		JMenuItem pagRegistroPendente = new JMenuItem("Pendentes");
		pagRegistroPendente.setForeground(Color.BLACK);
		pagRegistroPendente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submenuRegistroDePagamentos.add(pagRegistroPendente);

		JMenuItem pagRegistroQuitados = new JMenuItem("Quitados");
		pagRegistroQuitados.setForeground(Color.BLACK);
		pagRegistroQuitados.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		submenuRegistroDePagamentos.add(pagRegistroQuitados);

		JMenuItem pagamentosSimulador = new JMenuItem("Simulador de Pagamentos");
		pagamentosSimulador.setForeground(Color.BLACK);
		pagamentosSimulador.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuPagamentos.add(pagamentosSimulador);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_3);

		JMenu menuRelatorios = new JMenu("Relatórios");
		menuRelatorios.setForeground(Color.BLACK);
		menuRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuRelatorios);

		JMenuItem menuRelatóriosVeículos = new JMenuItem("Veículos");
		menuRelatóriosVeículos.setForeground(Color.BLACK);
		menuRelatóriosVeículos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuRelatorios.add(menuRelatóriosVeículos);

		menuRelatóriosVeículos.addActionListener(e ->{
			RelatoriosVeiculos telaVeiculosRelatorios = new RelatoriosVeiculos(funcao);
			dispose();
			telaVeiculosRelatorios.setVisible(true);
		});

		JMenuItem menuRelatóriosFinanceiros = new JMenuItem("Financeiros");
		menuRelatóriosFinanceiros.setForeground(Color.BLACK);
		menuRelatóriosFinanceiros.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuRelatorios.add(menuRelatóriosFinanceiros);

		menuRelatóriosFinanceiros.addActionListener(e ->{
			RelatoriosFinanceiros telaRelatoriosFinanceiros = new RelatoriosFinanceiros(funcao);
			dispose();
			telaRelatoriosFinanceiros.setVisible(true);
		});

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_4);

		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setForeground(Color.BLACK);
		menuAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuAjuda);

		JMenuItem menuHelpMe = new JMenuItem("Help-me!");
		menuHelpMe.setForeground(Color.BLACK);
		menuHelpMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAjuda.add(menuHelpMe);

		menuHelpMe.addActionListener(e ->{
			HelpMe telaHelpMe = new HelpMe(funcao);
			dispose();
			telaHelpMe.setVisible(true);
		});

		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.setForeground(Color.BLACK);
		menuSobre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAjuda.add(menuSobre);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\IMG_8419.PNG"));
		lblNewLabel.setBounds(27, 33, 730, 505);
		contentPane.add(lblNewLabel);

		menuSobre.addActionListener(e -> {
			Sobre telaAjuda = new Sobre(funcao);
			dispose();
			telaAjuda.setVisible(true);
		});

	}
}
