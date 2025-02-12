package com.locar.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.locar.ui.cadastro.NovoVeiculo;
import com.locar.ui.editar.AgendarManutençãoVeicular;
import com.locar.ui.editar.AgendarVistoriaVeicular;
import com.locar.ui.editar.CancelarReserva;
import com.locar.ui.editar.EditarLocAtiva;
import com.locar.ui.editar.EditarLocInativa;
import com.locar.ui.editar.EditarReservaAtiva;
import com.locar.ui.editar.EditarVeiculo;
import com.locar.ui.relatorios.LocaçoesAtivasRelatorios;
import com.locar.ui.relatorios.LocaçoesRelatorios;
import com.locar.ui.relatorios.ManutençaoVeicularRelatorios;
import com.locar.ui.relatorios.ReservasRelatorios;
import com.locar.ui.relatorios.VistoriasRelatorios;
import com.locar.ui.relatorios.VisualizarClientesRelatorios;
import com.locar.ui.relatorios.VisualizarFuncionariosRelatorios;
import com.locar.ui.relatorios.VisualizarReservasRelatorios;
import com.locar.ui.relatorios.VisualizarVeiculosRelatorios;
import com.locar.ui.cadastro.NovoCliente;
import com.locar.ui.ajuda.HelpMe;
import com.locar.ui.ajuda.Sobre;
import com.locar.ui.buscar.BuscarCliente;
import com.locar.ui.buscar.BuscarFuncionario;
import com.locar.ui.buscar.BuscarLocacao;
import com.locar.ui.buscar.BuscarReserva;
import com.locar.ui.buscar.BuscarVeiculo;
import com.locar.ui.cadastro.MudarSenha;
import com.locar.ui.cadastro.NovaLocação;
import com.locar.ui.cadastro.NovaReserva;
import com.locar.ui.cadastro.NovoFuncionario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Locar - Locadora de Veiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Barra de Menu
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(1, 1, 1, 1));
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setBounds(0, 0, 774, 31);
		contentPane.add(menuBar);
		
		//Barra de Menu - Botão Arquivo
		
		JMenu menuArquivo = new JMenu("Cadastro");
		menuArquivo.setForeground(Color.BLACK);
		menuArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuArquivo);
		
		JMenuItem novoClienteMenuItem = new JMenuItem("Novo Cliente");
		menuArquivo.add(novoClienteMenuItem);
		
		novoClienteMenuItem.addActionListener(e -> {
			NovoCliente telaNovoCliente = new NovoCliente();
			dispose();
			telaNovoCliente.setVisible(true);
		});
		
		JMenuItem novoVeiculoMenuItem = new JMenuItem("Novo Veículo");
		menuArquivo.add(novoVeiculoMenuItem);
		
		novoVeiculoMenuItem.addActionListener(e -> {
			NovoVeiculo telaNovoVeiculo = new NovoVeiculo();
			dispose();
			telaNovoVeiculo.setVisible(true);
		});
		
		JMenuItem novoFuncionarioMenuItem = new JMenuItem("Novo Funcionário");
		menuArquivo.add(novoFuncionarioMenuItem);
		
		novoFuncionarioMenuItem.addActionListener (e -> {
			NovoFuncionario telaNovoFuncionario = new NovoFuncionario();
			dispose();
			telaNovoFuncionario.setVisible(true);
			
		});
		
		JMenuItem novaLocaçaoMenuItem = new JMenuItem("Nova Locação");
		menuArquivo.add(novaLocaçaoMenuItem);
		
		novaLocaçaoMenuItem.addActionListener(e ->{
			NovaLocação telaNovaLocaçao = new NovaLocação();
			dispose();
			telaNovaLocaçao.setVisible(true);
		});
		
		JMenuItem novaReservaArquivo = new JMenuItem("Nova Reserva");
		menuArquivo.add(novaReservaArquivo);
		
		novaReservaArquivo.addActionListener(e -> {
			NovaReserva telaNovaReserva = new NovaReserva();
			dispose();
			telaNovaReserva.setVisible(true);
		});
		
		JMenuItem mudarSenhaMenuItem = new JMenuItem("Mudar Senha");
		menuArquivo.add(mudarSenhaMenuItem);
		
		mudarSenhaMenuItem.addActionListener(e -> {
			MudarSenha telaMudarSenha = new MudarSenha();
			dispose();
			telaMudarSenha.setVisible(true);
		});
		
		JMenuItem fazerLogoutMenuItem = new JMenuItem("Fazer logout");
		menuArquivo.add(fazerLogoutMenuItem);
		
		fazerLogoutMenuItem.addActionListener(e -> {
			int confirmacao = JOptionPane.showConfirmDialog(
					null,
					"Tem certeza que deseja encessar a sessão?",
					"Confirmar Logout",
					JOptionPane.YES_NO_OPTION
					);
			if (confirmacao == JOptionPane.YES_NO_OPTION) {
				dispose();
				new Login().setVisible(true);
			}
			
		});
		
		JMenuItem sairMenuItem = new JMenuItem("Sair");
		sairMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int confirmacao = JOptionPane.showConfirmDialog(
					null,
					"Tem certeza que deseja sair?",
					"Confirmar Saída",
					JOptionPane.YES_NO_OPTION);
			if (confirmacao == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			
			}
		});
				
		menuArquivo.add(sairMenuItem);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		//Barra de Menu - Botão Editar
		
		JMenu menuEditar = new JMenu("Editar");
		menuEditar.setForeground(Color.BLACK);
		menuEditar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuEditar);
		
		JMenu submenuVeiculo = new JMenu("Gerenciar Veículo");
		
		JMenuItem editarremoverVeiculo = new JMenuItem("Editar/Remover Veículo");
		submenuVeiculo.add(editarremoverVeiculo);
		
		editarremoverVeiculo.addActionListener(e -> {
			EditarVeiculo telaEditarVeiculo = new EditarVeiculo();
			dispose();
			telaEditarVeiculo.setVisible(true);
		});
		
		JMenuItem agendarManutençao = new JMenuItem("Agendar Manutenção Veicular");
		submenuVeiculo.add(agendarManutençao);
		
		agendarManutençao.addActionListener(e ->{
			AgendarManutençãoVeicular telaAgendarManutençao = new AgendarManutençãoVeicular();
			dispose();
			telaAgendarManutençao.setVisible(true);
		});
		
		JMenuItem agendarVistoria = new JMenuItem("Agendar Vistoria Veicular");
		submenuVeiculo.add(agendarVistoria);
		
		agendarVistoria.addActionListener(e -> {
			AgendarVistoriaVeicular telaAgendarVistoria = new AgendarVistoriaVeicular();
			telaAgendarVistoria.setVisible(true);
		});
		
		JMenuItem editarGerenciarCliente = new JMenuItem("Gerenciar Cliente");
		menuEditar.add(editarGerenciarCliente);
		
		menuEditar.add(submenuVeiculo);
		
		JMenu submenuLocaçoes = new JMenu("Locações");
		
		JMenuItem editarLocaçoesAt = new JMenuItem ("Editar Locações Ativas");
		submenuLocaçoes.add(editarLocaçoesAt);
		
		editarLocaçoesAt.addActionListener(e ->{
			EditarLocAtiva telaEditarLocaçaoAtiva = new EditarLocAtiva();
			telaEditarLocaçaoAtiva.setVisible(true);
		});
		
		JMenuItem editarLocaçoesIn = new JMenuItem ("Editar Locações Inativas");
		submenuLocaçoes.add(editarLocaçoesIn);
		
		editarLocaçoesIn.addActionListener(e ->{
			EditarLocInativa telaEditarLocaçaoInativa = new EditarLocInativa();
			telaEditarLocaçaoInativa.setVisible(true);
		});
		
		JMenuItem editarGerenciarFuncionario = new JMenuItem("Gerenciar Funcionario");
		menuEditar.add(editarGerenciarFuncionario);
		
		menuEditar.add(submenuLocaçoes);
		
		JMenu submenuReservas = new JMenu("Reservas");
		
		JMenuItem editarReservasAt = new JMenuItem ("Editar Reservas Ativas");
		submenuReservas.add(editarReservasAt);
		
		editarReservasAt.addActionListener(e -> {
			EditarReservaAtiva telaEditarReservaAtiva = new EditarReservaAtiva();
			telaEditarReservaAtiva.setVisible(true);
		});
		
		JMenuItem cancelarReservas = new JMenuItem ("Cancelar Reserva");
		submenuReservas.add(cancelarReservas);
		
		cancelarReservas.addActionListener(e -> {
			CancelarReserva telaCancelarReserva = new CancelarReserva();
			telaCancelarReserva.setVisible(true);
		});
		
		menuEditar.add(submenuReservas);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_1);
		
		//Barra de Menu - Botão Buscar
		
		JMenu menuBuscar = new JMenu("Buscar");
		menuBuscar.setForeground(Color.BLACK);
		menuBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuBuscar);
		
		JMenuItem buscarCliente = new JMenuItem("Buscar Cliente");
		menuBuscar.add(buscarCliente);
		
		buscarCliente.addActionListener(e -> {
			BuscarCliente telaBuscarCliente = new BuscarCliente();
			dispose();
			telaBuscarCliente.setVisible(true);
		});
		
		JMenuItem buscarVeiculo = new JMenuItem("Buscar Veículo");
		menuBuscar.add(buscarVeiculo);
		
		buscarVeiculo.addActionListener(e -> {
			BuscarVeiculo telaBuscarVeiculo = new BuscarVeiculo();
			dispose();
			telaBuscarVeiculo.setVisible(true);
		});
		
		JMenuItem buscarFuncionario = new JMenuItem("Buscar Funcionário");
		menuBuscar.add(buscarFuncionario);
		
		buscarFuncionario.addActionListener(e -> {
			BuscarFuncionario telaBuscarFuncionario = new BuscarFuncionario();
			dispose();
			telaBuscarFuncionario.setVisible(true);
		});
		
		JMenuItem buscarLocaçao = new JMenuItem("Buscar Locação");
		menuBuscar.add(buscarLocaçao);
		
		buscarLocaçao.addActionListener(e -> {
			BuscarLocacao telaBuscarLocaçao = new BuscarLocacao();
			dispose();
			telaBuscarLocaçao.setVisible(true);
		});
		
		JMenuItem buscarReserva = new JMenuItem("Buscar Reserva");
		menuBuscar.add(buscarReserva);
		
		buscarReserva.addActionListener(e ->{
			BuscarReserva telaBuscarReserva = new BuscarReserva();
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
		menuPagamentos.add(pagamentosPagar);
		
		JMenu submenuRegistroDePagamentos = new JMenu("Registro de Pagamentos");
		menuPagamentos.add(submenuRegistroDePagamentos);
		
		JMenuItem pagRegistroPendente = new JMenuItem("Pendentes");
		submenuRegistroDePagamentos.add(pagRegistroPendente);
		
		JMenuItem pagRegistroQuitados = new JMenuItem("Quitados");
		submenuRegistroDePagamentos.add(pagRegistroQuitados);
		
		JMenuItem pagamentosSimulador = new JMenuItem("Simulador de Pagamentos");
		menuPagamentos.add(pagamentosSimulador);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_3);
		
		//Barra de Menu - Botão Relatórios
		
		JMenu menuRelatorios = new JMenu("Relatórios");
		menuRelatorios.setForeground(Color.BLACK);
		menuRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuRelatorios);
		
		JMenu menuVisualizar = new JMenu("Visualizar");
		menuRelatorios.add(menuVisualizar);
		
		JMenuItem relLocaçoesAtivas = new JMenuItem("Locações Ativas");
		menuVisualizar.add(relLocaçoesAtivas);
		
		relLocaçoesAtivas.addActionListener(e -> {
			LocaçoesAtivasRelatorios telaRelatoriosLocaçoesAtivas = new LocaçoesAtivasRelatorios();
			telaRelatoriosLocaçoesAtivas.setVisible(true);
		});
		
		JMenuItem relVisualizarReservas = new JMenuItem("Reservas");
		menuVisualizar.add(relVisualizarReservas);
		
		relVisualizarReservas.addActionListener(e -> {
			VisualizarReservasRelatorios telaVisualizarRelatorios = new VisualizarReservasRelatorios();
			telaVisualizarRelatorios.setVisible(true);
		});
		
		JMenuItem relVisualizarClientes = new JMenuItem("Cadastro de Clientes");
		menuVisualizar.add(relVisualizarClientes);
		
		relVisualizarClientes.addActionListener(e -> {
			VisualizarClientesRelatorios telaVisualizarClientes = new VisualizarClientesRelatorios();
			telaVisualizarClientes.setVisible(true);
		});
		
		JMenuItem relVisualizarVeiculos = new JMenuItem("Cadastro de Veículos");
		menuVisualizar.add(relVisualizarVeiculos);
		
		relVisualizarVeiculos.addActionListener(e -> {
			VisualizarVeiculosRelatorios telaVisualizarVeiculos = new VisualizarVeiculosRelatorios();
			telaVisualizarVeiculos.setVisible(true);
		});
		
		JMenuItem relVisualizarFuncionarios = new JMenuItem("Cadastro de Funcionários");
		menuVisualizar.add(relVisualizarFuncionarios);
		
		relVisualizarFuncionarios.addActionListener(e -> {
			VisualizarFuncionariosRelatorios telaVisualizarFuncionarios = new VisualizarFuncionariosRelatorios();
			telaVisualizarFuncionarios.setVisible(true);
		});
		
		JMenu menuGerarRelatorios = new JMenu("Gerar Relatórios");
		menuRelatorios.add(menuGerarRelatorios);
		
		JMenu relReceita = new JMenu("Receita"); //Conversar sobre isso
		menuGerarRelatorios.add(relReceita);
		
		JMenuItem relReceitaDiaria = new JMenuItem("Receita Diaria");
		relReceita.add(relReceitaDiaria);
		
		JMenuItem relReceitaSemanal = new JMenuItem("Receita Semanal");
		relReceita.add(relReceitaSemanal);
		
		JMenuItem relReceitaMensal = new JMenuItem("Receita Mensal");
		relReceita.add(relReceitaMensal);
		
		JMenuItem relReceitaAnual = new JMenuItem("Receita Anual");
		relReceita.add(relReceitaAnual);
		
		JMenuItem relManutençaoVeicular = new JMenuItem("Manutenção Veícular");
		menuGerarRelatorios.add(relManutençaoVeicular);
		
		relManutençaoVeicular.addActionListener(e -> {
			ManutençaoVeicularRelatorios telaManutençaoVeicular = new ManutençaoVeicularRelatorios();
			telaManutençaoVeicular.setVisible(true);
		});
		
		JMenuItem relVistorias = new JMenuItem("Vistorias");
		menuGerarRelatorios.add(relVistorias);
		
		relVistorias.addActionListener(e -> {
			VistoriasRelatorios telaVistorias = new VistoriasRelatorios();
			telaVistorias.setVisible(true);
		});
		
		JMenuItem relLocaçoes = new JMenuItem("Locações");
		menuGerarRelatorios.add(relLocaçoes);
		
		relLocaçoes.addActionListener(e -> {
			LocaçoesRelatorios telaLocaçoes = new LocaçoesRelatorios();
			telaLocaçoes.setVisible(true);
		});
		
		JMenuItem relReservas = new JMenuItem("Reservas");
		menuGerarRelatorios.add(relReservas);
		
		relReservas.addActionListener(e ->{
			ReservasRelatorios telaReservas = new ReservasRelatorios();
			telaReservas.setVisible(true);
		});
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_4);
		
		//Barra de Menu - Botão Ajuda
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setForeground(Color.BLACK);
		menuAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuAjuda);
		
		JMenuItem menuHelpMe = new JMenuItem("Help-me!");
		menuAjuda.add(menuHelpMe);
		
		menuHelpMe.addActionListener(e ->{
			HelpMe telaHelpMe = new HelpMe();
			telaHelpMe.setVisible(true);
		});
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuAjuda.add(menuSobre);
		
				
		menuSobre.addActionListener(e -> {
			Sobre telaAjuda = new Sobre();
			telaAjuda.setVisible(true);
		});
		
		//Imagem
		
		/*JLabel carrinho = new JLabel("");
		carrinho.setIcon(new ImageIcon(getClass().getResource("/imagem/CarroNeon.jpg")));
		carrinho.setBounds(27, 33, 730, 505);
		contentPane.add(carrinho);*/
	}
}
