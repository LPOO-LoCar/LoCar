package com.locar.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.locar.dados.Repositorio;
import com.locar.entidades.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovaLocaçãoArquivo extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaLocaçãoArquivo frame = new NovaLocaçãoArquivo();
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
	public NovaLocaçãoArquivo() {
		setTitle("Novo Locação");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Locação");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(195, 11, 159, 32);
		contentPane.add(lblNewLabel);
		
		JLabel locClienteTitulo_Label = new JLabel("Cliente");
		locClienteTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locClienteTitulo_Label.setBounds(25, 48, 54, 28);
		contentPane.add(locClienteTitulo_Label);
		
		JLabel locCPF_Label = new JLabel("CPF:");
		locCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locCPF_Label.setBounds(35, 74, 33, 28);
		contentPane.add(locCPF_Label);
		
		locCPF_textField = new JTextField();
		locCPF_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String cpf = locCPF_textField.getText();
		        Repositorio repositorio = new Repositorio();
		        Cliente cliente = repositorio.buscarClientePorCPF(cpf);
		            
		        locNome_textField.setText(cliente.getNomeCompleto());
		        locTelefone_textField.setText(cliente.getTelefone());
		        locEmail_textField.setText(cliente.getEmail());
			}
		});
		locCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locCPF_textField.setColumns(10);
		locCPF_textField.setBounds(70, 76, 119, 24);
		contentPane.add(locCPF_textField);
		
		JLabel locNome_Label = new JLabel("Nome:");
		locNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locNome_Label.setBounds(193, 74, 48, 28);
		contentPane.add(locNome_Label);
		
		locNome_textField = new JTextField();
		locNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locNome_textField.setColumns(10);
		locNome_textField.setBounds(242, 76, 324, 24);
		contentPane.add(locNome_textField);
		
		JLabel locTelefone_Label = new JLabel("Telefone:");
		locTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locTelefone_Label.setBounds(35, 106, 67, 28);
		contentPane.add(locTelefone_Label);
		
		locTelefone_textField = new JTextField();
		locTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locTelefone_textField.setColumns(10);
		locTelefone_textField.setBounds(104, 108, 119, 24);
		contentPane.add(locTelefone_textField);
		
		JLabel locEmail_Label = new JLabel("E-mail:");
		locEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locEmail_Label.setBounds(227, 106, 51, 28);
		contentPane.add(locEmail_Label);
		
		locEmail_textField = new JTextField();
		locEmail_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locEmail_textField.setColumns(10);
		locEmail_textField.setBounds(277, 108, 289, 24);
		contentPane.add(locEmail_textField);
		
		JLabel locVeiculoTitulo_Label = new JLabel("Veículo");
		locVeiculoTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locVeiculoTitulo_Label.setBounds(25, 131, 57, 28);
		contentPane.add(locVeiculoTitulo_Label);
		
		JLabel locPlaca_Label = new JLabel("Placa:");
		locPlaca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locPlaca_Label.setBounds(35, 159, 48, 28);
		contentPane.add(locPlaca_Label);
		
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
			}
		});
		locPlaca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locPlaca_textField.setColumns(10);
		locPlaca_textField.setBounds(79, 161, 119, 24);
		contentPane.add(locPlaca_textField);
		
		JLabel locModelo_Label = new JLabel("Modelo:");
		locModelo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locModelo_Label.setBounds(202, 159, 57, 28);
		contentPane.add(locModelo_Label);
		
		locModelo_textField = new JTextField();
		locModelo_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locModelo_textField.setColumns(10);
		locModelo_textField.setBounds(261, 161, 119, 24);
		contentPane.add(locModelo_textField);
		
		JLabel locMarca_Label = new JLabel("Marca:");
		locMarca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locMarca_Label.setBounds(383, 159, 48, 28);
		contentPane.add(locMarca_Label);
		
		locMarca_textField = new JTextField();
		locMarca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locMarca_textField.setColumns(10);
		locMarca_textField.setBounds(435, 161, 131, 24);
		contentPane.add(locMarca_textField);
		
		JLabel locTipo_Label = new JLabel("Tipo:");
		locTipo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locTipo_Label.setBounds(35, 191, 38, 28);
		contentPane.add(locTipo_Label);
		
		JComboBox locTipo_comboBox = new JComboBox <> (new String [] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		locTipo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locTipo_comboBox.setBounds(74, 195, 100, 25);
		contentPane.add(locTipo_comboBox);
		
		JLabel locAno_Label = new JLabel("Ano:");
		locAno_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locAno_Label.setBounds(180, 191, 38, 28);
		contentPane.add(locAno_Label);
		
		locAno_textField = new JTextField();
		locAno_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locAno_textField.setColumns(10);
		locAno_textField.setBounds(218, 195, 77, 24);
		contentPane.add(locAno_textField);
		
		JLabel locKM_Label = new JLabel("Kilometragem atual:");
		locKM_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locKM_Label.setBounds(300, 191, 143, 28);
		contentPane.add(locKM_Label);
		
		locKM_textField = new JTextField();
		locKM_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locKM_textField.setColumns(10);
		locKM_textField.setBounds(445, 196, 121, 24);
		contentPane.add(locKM_textField);
		
		JLabel locDetalhes_Label = new JLabel("Detalhes");
		locDetalhes_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locDetalhes_Label.setBounds(25, 219, 67, 28);
		contentPane.add(locDetalhes_Label);
		
		JLabel locValorDaDiaria_Label = new JLabel("Valor da Diária:");
		locValorDaDiaria_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locValorDaDiaria_Label.setBounds(35, 243, 111, 28);
		contentPane.add(locValorDaDiaria_Label);
		
		locValorDaDiaria_textField = new JTextField();
		locValorDaDiaria_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locValorDaDiaria_textField.setColumns(10);
		locValorDaDiaria_textField.setBounds(146, 245, 77, 24);
		contentPane.add(locValorDaDiaria_textField);
		
		JLabel locDiasLocados_Label = new JLabel("Dias Locados:");
		locDiasLocados_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locDiasLocados_Label.setBounds(227, 243, 100, 28);
		contentPane.add(locDiasLocados_Label);
		
		locDiasLocados_textField = new JTextField();
		locDiasLocados_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locDiasLocados_textField.setColumns(10);
		locDiasLocados_textField.setBounds(327, 245, 38, 24);
		contentPane.add(locDiasLocados_textField);
		
		JLabel locValorTotal_Label = new JLabel("Valor Total:");
		locValorTotal_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locValorTotal_Label.setBounds(375, 243, 84, 28);
		contentPane.add(locValorTotal_Label);
		
		locValorTotal_textField = new JTextField();
		locValorTotal_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locValorTotal_textField.setColumns(10);
		locValorTotal_textField.setBounds(461, 245, 105, 24);
		contentPane.add(locValorTotal_textField);
		
		JLabel locFormaDePag_Label = new JLabel("Forma de Pagamento:");
		locFormaDePag_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locFormaDePag_Label.setBounds(35, 275, 159, 28);
		contentPane.add(locFormaDePag_Label);
		
		JComboBox locFormaDePag_comboBox = new JComboBox <> (new String [] {"Dinheiro", "Pix", "Cartão-Debito", "Cartão-Credito",});
		locFormaDePag_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locFormaDePag_comboBox.setBounds(192, 277, 94, 25);
		contentPane.add(locFormaDePag_comboBox);
		
		JButton locLocar_Button = new JButton("LoCar!");
		locLocar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		locLocar_Button.setBounds(435, 312, 131, 38);
		contentPane.add(locLocar_Button);
	}
}
