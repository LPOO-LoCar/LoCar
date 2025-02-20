package com.locar.ui.cadastro;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.locar.dados.Repositorio;
import com.locar.entidades.*;
import com.locar.regras_negocio.Auth;
import com.locar.regras_negocio.Cob;
import com.locar.regras_negocio.ControladorControleAcesso;
import com.locar.regras_negocio.GerarPdf;
import com.locar.ui.TelaPrincipal;
import com.locar.ui.pagamento.Pagar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NovaLocação extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField locCPF_textField;
	private JTextField locNome_textField;
	private JTextField locTelefone_textField;
	private JTextField locEmail_textField;
	private JTextField locPlaca_textField;
	private JTextField locModelo_textField;
	private JTextField locMarca_textField;
	private JTextField locAno_textField;
	private JTextField locKM_textField;
	private JTextField locValorDaDiaria_textField;
	private JTextField locDiasLocados_textField;
	private JTextField locValorTotal_textField;
	private String funcao;
	private double valorTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaLocação frame = new NovaLocação("ADMIN");
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
	public NovaLocação(String funcao) {
		this.funcao = funcao;
		setTitle("Novo Locação");
		setSize(650,550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Locação");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(183, 11, 248, 32);
		contentPane.add(lblNewLabel);
		
		JLabel locClienteTitulo_Label = new JLabel("Cliente");
		locClienteTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		locClienteTitulo_Label.setBounds(10, 50, 100, 28);
		contentPane.add(locClienteTitulo_Label);
		
		JLabel locCPF_Label = new JLabel("CPF:");
		locCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locCPF_Label.setBounds(10, 86, 67, 28);
		contentPane.add(locCPF_Label);
		
		locCPF_textField = new JTextField();
		locCPF_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
        		String textoCpf = locCPF_textField.getText();
        		textoCpf = textoCpf.replaceAll("[^0-9]", ""); 
        		
        		if (textoCpf.length() >= 3) {
        			textoCpf = textoCpf.substring(0,3) + "." + textoCpf.substring(3);
        		}
        		if (textoCpf.length() >= 7) {
        			textoCpf = textoCpf.substring(0,7) + "." + textoCpf.substring(7);
        		}
        		if (textoCpf.length() >= 11) {
        			textoCpf = textoCpf.substring(0,11) + "-" + textoCpf.substring(11);
        		}
        		
        		if (textoCpf.length() >= 14) {
        			textoCpf = textoCpf.substring(0,14);
        		}
        		
        		locCPF_textField.setText(textoCpf);
			}
		});
		locCPF_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String cpf = locCPF_textField.getText();
		        Repositorio repositorio = new Repositorio();
		        Cliente cliente = repositorio.buscarClientePorCpf(cpf);
		            
		        locNome_textField.setText(cliente.getNomeCompleto());
		        locTelefone_textField.setText(cliente.getTelefone());
		        locEmail_textField.setText(cliente.getEmail());
			}
		});
		locCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locCPF_textField.setColumns(10);
		locCPF_textField.setBounds(10, 115, 213, 20);
		contentPane.add(locCPF_textField);
		
		JLabel locNome_Label = new JLabel("Nome:");
		locNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locNome_Label.setBounds(276, 86, 67, 28);
		contentPane.add(locNome_Label);
		
		locNome_textField = new JTextField();
		locNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locNome_textField.setColumns(10);
		locNome_textField.setBounds(276, 115, 253, 20);
		contentPane.add(locNome_textField);
		
		JLabel locTelefone_Label = new JLabel("Telefone:");
		locTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locTelefone_Label.setBounds(10, 141, 79, 28);
		contentPane.add(locTelefone_Label);
		
		locTelefone_textField = new JTextField();
		locTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locTelefone_textField.setColumns(10);
		locTelefone_textField.setBounds(10, 170, 213, 20);
		contentPane.add(locTelefone_textField);
		
		JLabel locEmail_Label = new JLabel("E-mail:");
		locEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locEmail_Label.setBounds(276, 141, 68, 28);
		contentPane.add(locEmail_Label);
		
		locEmail_textField = new JTextField();
		locEmail_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locEmail_textField.setColumns(10);
		locEmail_textField.setBounds(276, 168, 253, 20);
		contentPane.add(locEmail_textField);
		
		JLabel locVeiculoTitulo_Label = new JLabel("Veículo");
		locVeiculoTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		locVeiculoTitulo_Label.setBounds(10, 199, 121, 28);
		contentPane.add(locVeiculoTitulo_Label);
		
		JLabel locPlaca_Label = new JLabel("Placa:");
		locPlaca_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locPlaca_Label.setBounds(10, 235, 48, 28);
		contentPane.add(locPlaca_Label);
		
		JComboBox locTipo_comboBox = new JComboBox <> (new String [] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		locTipo_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"}));
		locTipo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locTipo_comboBox.setBounds(10, 320, 165, 20);
		contentPane.add(locTipo_comboBox);
		
		locPlaca_textField = new JTextField();
		locPlaca_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String placa = locPlaca_textField.getText();
		        Repositorio repositorio = new Repositorio();
		        Carro carro = repositorio.buscarCarroPorPlaca(placa);
		            
		        locMarca_textField.setText(carro.getMarca());
		        locModelo_textField.setText(carro.getModelo());
		        locAno_textField.setText(String.valueOf(carro.getAno()));
		        locKM_textField.setText(carro.getKmRodados());
		        locTipo_comboBox.setSelectedItem(carro.getCategoria());
			}
		});
		locPlaca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locPlaca_textField.setColumns(10);
		locPlaca_textField.setBounds(10, 265, 165, 20);
		contentPane.add(locPlaca_textField);
		
		JLabel locModelo_Label = new JLabel("Marca:");
		locModelo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locModelo_Label.setBounds(209, 235, 83, 28);
		contentPane.add(locModelo_Label);
		
		locModelo_textField = new JTextField();
		locModelo_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locModelo_textField.setColumns(10);
		locModelo_textField.setBounds(364, 265, 165, 20);
		contentPane.add(locModelo_textField);
		
		JLabel locMarca_Label = new JLabel("Modelo:");
		locMarca_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locMarca_Label.setBounds(364, 235, 80, 28);
		contentPane.add(locMarca_Label);
		
		locMarca_textField = new JTextField();
		locMarca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locMarca_textField.setColumns(10);
		locMarca_textField.setBounds(209, 265, 131, 20);
		contentPane.add(locMarca_textField);
		
		JLabel locTipo_Label = new JLabel("Categoria:");
		locTipo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locTipo_Label.setBounds(10, 291, 100, 28);
		contentPane.add(locTipo_Label);
		
		JLabel locAno_Label = new JLabel("Ano:");
		locAno_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locAno_Label.setBounds(209, 291, 38, 28);
		contentPane.add(locAno_Label);
		
		locAno_textField = new JTextField();
		locAno_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locAno_textField.setColumns(10);
		locAno_textField.setBounds(209, 320, 131, 20);
		contentPane.add(locAno_textField);
		
		JLabel locKM_Label = new JLabel("Kilometragem atual:");
		locKM_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locKM_Label.setBounds(364, 291, 165, 28);
		contentPane.add(locKM_Label);
		
		locKM_textField = new JTextField();
		locKM_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locKM_textField.setColumns(10);
		locKM_textField.setBounds(364, 320, 165, 20);
		contentPane.add(locKM_textField);
		
		JLabel locDetalhes_Label = new JLabel("Dados financeiros");
		locDetalhes_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		locDetalhes_Label.setBounds(10, 349, 237, 28);
		contentPane.add(locDetalhes_Label);
		
		JLabel locValorDaDiaria_Label = new JLabel("Valor da Diária:");
		locValorDaDiaria_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locValorDaDiaria_Label.setBounds(10, 385, 131, 28);
		contentPane.add(locValorDaDiaria_Label);
		
		locValorDaDiaria_textField = new JTextField();
		locValorDaDiaria_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularValorTotal();
			}
		});
		locValorDaDiaria_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locValorDaDiaria_textField.setColumns(10);
		locValorDaDiaria_textField.setBounds(12, 415, 163, 20);
		contentPane.add(locValorDaDiaria_textField);
		
		JLabel locDiasLocados_Label = new JLabel("Dias Locados:");
		locDiasLocados_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locDiasLocados_Label.setBounds(209, 385, 121, 28);
		contentPane.add(locDiasLocados_Label);
		
		locDiasLocados_textField = new JTextField();
		locDiasLocados_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularValorTotal();
			}
		});
		locDiasLocados_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locDiasLocados_textField.setColumns(10);
		locDiasLocados_textField.setBounds(209, 413, 131, 20);
		contentPane.add(locDiasLocados_textField);
		
		JLabel locValorTotal_Label = new JLabel("Valor Total:");
		locValorTotal_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locValorTotal_Label.setBounds(364, 385, 109, 28);
		contentPane.add(locValorTotal_Label);
		
		locValorTotal_textField = new JTextField();
		locValorTotal_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularValorTotal();
			}
		});
		locValorTotal_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locValorTotal_textField.setColumns(10);
		locValorTotal_textField.setBounds(364, 413, 165, 20);
		contentPane.add(locValorTotal_textField);
		
		JLabel locFormaDePag_Label = new JLabel("Forma de Pagamento:");
		locFormaDePag_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locFormaDePag_Label.setBounds(10, 440, 179, 28);
		contentPane.add(locFormaDePag_Label);
		
		JComboBox locFormaDePag_comboBox = new JComboBox <> (new String [] {"Dinheiro", "Pix", "Cartão-Debito", "Cartão-Credito",});
		locFormaDePag_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locFormaDePag_comboBox.setBounds(10, 468, 165, 20);
		contentPane.add(locFormaDePag_comboBox);
		
		JComboBox campoTextoStatus = new JComboBox();
		campoTextoStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTextoStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativa", "Inativa"}));
		campoTextoStatus.setBounds(210, 466, 131, 22);
		contentPane.add(campoTextoStatus);
		
		JButton locLocar_Button = new JButton("LoCar!");
		locLocar_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	            String cpf = locCPF_textField.getText();
	            String placa = locPlaca_textField.getText();

	            Repositorio repositorio = new Repositorio();
	            Cliente cliente = repositorio.buscarIdPorCpf(cpf);
	            Carro carro = repositorio.buscarIdPorPlaca(placa);
	            
	            String nome = locNome_textField.getText();
	            String email = locEmail_textField.getText();
	            String telefone = locTelefone_textField.getText();
	            String marca = locMarca_textField.getText();
	            String modelo = locModelo_textField.getText();
	            String categoria = locTipo_comboBox.getSelectedItem().toString();
	            String ano = String.valueOf(locAno_textField.getText());
	            String kmRodados = locKM_textField.getText();
	             
	            double valorDiaria = Double.parseDouble(locValorDaDiaria_textField.getText());
	            int diasLocados = Integer.parseInt(locDiasLocados_textField.getText());
	            double valorTotal = valorDiaria * diasLocados;
	            String formaPagamento = locFormaDePag_comboBox.getSelectedItem().toString();
	            String status = campoTextoStatus.getSelectedItem().toString();
	            
	            LocalDate dataAtual = LocalDate.now();
	            String dataLocacao = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	            
	            ControladorControleAcesso controlador = new ControladorControleAcesso();
	            controlador.registrarLocacao(cliente, carro, valorDiaria, diasLocados, valorTotal, formaPagamento, status, dataLocacao);
	            GerarPdf gerarPdf = new GerarPdf();
	            gerarPdf.gerarPDF(nome, cpf, email, telefone, placa, marca, modelo, categoria, ano, kmRodados, valorDiaria,
	            		diasLocados, valorTotal, formaPagamento);
	            
	            Pagar telaPagar = new Pagar(valorTotal);
	            telaPagar.setVisible(true);
	            dispose();
	            
				JOptionPane.showMessageDialog(null, "Locação cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		locLocar_Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		locLocar_Button.setBounds(515, 468, 109, 35);
		contentPane.add(locLocar_Button);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 80, 634, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 229, 634, 1);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(0, 379, 634, 1);
		contentPane.add(separator_1_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 11, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locCPF_textField.setText("");	
				locNome_textField.setText("");
				locTelefone_textField.setText("");
				locEmail_textField.setText("");
				locPlaca_textField.setText("");
				locModelo_textField.setText("");
				locMarca_textField.setText("");
				locAno_textField.setText("");
				locKM_textField.setText("");
				locValorDaDiaria_textField.setText("");
				locDiasLocados_textField.setText("");
				locValorTotal_textField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(376, 468, 109, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel locFormaDePag_Label_1 = new JLabel("Status");
		locFormaDePag_Label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locFormaDePag_Label_1.setBounds(211, 440, 128, 28);
		contentPane.add(locFormaDePag_Label_1);
		
	}
	private void calcularValorTotal() {
	    try {
	        double valorDiaria = Double.parseDouble(locValorDaDiaria_textField.getText());
	        int diasLocados = Integer.parseInt(locDiasLocados_textField.getText());
	        double valorTotal = valorDiaria * diasLocados;
	        
	        locValorTotal_textField.setText(String.valueOf(valorTotal)); 
	    } catch (NumberFormatException ex) {
	        locValorTotal_textField.setText("Erro");
	    }
	}
	
}
