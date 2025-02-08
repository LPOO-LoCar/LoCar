package com.locar.ui.cadastro;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class NovaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField resCPF_textField;
	private JTextField resNome_textField;
	private JTextField resTelefone_textField;
	private JTextField resEmail_textField;
	private JTextField resModelo_textField;
	private JTextField resMarca_textField;
	private JTextField resPlaca_textField;
	private JTextField resDatadeRetirada_textField;
	private JTextField resHoradeRetirada_textField;
	private JTextField resDatadeEntrega_textField;
	private JTextField resHoradeEntrega_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaReserva frame = new NovaReserva();
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
	public NovaReserva() {
		setTitle("Nova Reserva");
		setSize(600,430);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel resTitulo_Label = new JLabel("Nova Reserva");
		resTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		resTitulo_Label.setBounds(198, 11, 182, 37);
		contentPane.add(resTitulo_Label);
		
		JLabel resCPF_Label = new JLabel("CPF:");
		resCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resCPF_Label.setBounds(35, 84, 33, 28);
		contentPane.add(resCPF_Label);
		
		resCPF_textField = new JTextField();
		resCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resCPF_textField.setBounds(70, 86, 119, 24);
		contentPane.add(resCPF_textField);
		resCPF_textField.setColumns(10);
		
		JLabel resNome_Label = new JLabel("Nome:");
		resNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resNome_Label.setBounds(193, 84, 48, 28);
		contentPane.add(resNome_Label);
		
		resNome_textField = new JTextField();
		resNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resNome_textField.setColumns(10);
		resNome_textField.setBounds(240, 86, 324, 24);
		contentPane.add(resNome_textField);
		
		JLabel resTelefone_Label = new JLabel("Telefone:");
		resTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resTelefone_Label.setBounds(35, 118, 67, 28);
		contentPane.add(resTelefone_Label);
		
		resTelefone_textField = new JTextField();
		resTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resTelefone_textField.setColumns(10);
		resTelefone_textField.setBounds(103, 121, 119, 24);
		contentPane.add(resTelefone_textField);
		
		JLabel resEmail_Label = new JLabel("E-mail:");
		resEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resEmail_Label.setBounds(224, 118, 51, 28);
		contentPane.add(resEmail_Label);
		
		resEmail_textField = new JTextField();
		resEmail_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resEmail_textField.setColumns(10);
		resEmail_textField.setBounds(275, 121, 289, 24);
		contentPane.add(resEmail_textField);
		
		JLabel resClienteTitulo_Label = new JLabel("Cliente");
		resClienteTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resClienteTitulo_Label.setBounds(25, 56, 54, 28);
		contentPane.add(resClienteTitulo_Label);
		
		JLabel resVeiculoTitulo_Label = new JLabel("Veículo");
		resVeiculoTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resVeiculoTitulo_Label.setBounds(25, 143, 77, 28);
		contentPane.add(resVeiculoTitulo_Label);
		
		JLabel resModelo_Label = new JLabel("Modelo:");
		resModelo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resModelo_Label.setBounds(218, 169, 57, 28);
		contentPane.add(resModelo_Label);
		
		resModelo_textField = new JTextField();
		resModelo_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resModelo_textField.setColumns(10);
		resModelo_textField.setBounds(275, 169, 119, 24);
		contentPane.add(resModelo_textField);
		
		JLabel resMarca_Label = new JLabel("Marca:");
		resMarca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resMarca_Label.setBounds(397, 169, 48, 28);
		contentPane.add(resMarca_Label);
		
		resMarca_textField = new JTextField();
		resMarca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resMarca_textField.setColumns(10);
		resMarca_textField.setBounds(445, 169, 119, 24);
		contentPane.add(resMarca_textField);
		
		JLabel resPlaca_Label = new JLabel("Placa:");
		resPlaca_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resPlaca_Label.setBounds(45, 169, 48, 28);
		contentPane.add(resPlaca_Label);
		
		resPlaca_textField = new JTextField();
		resPlaca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resPlaca_textField.setColumns(10);
		resPlaca_textField.setBounds(90, 169, 119, 24);
		contentPane.add(resPlaca_textField);
		
		JLabel resTipo_Label = new JLabel("Tipo:");
		resTipo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resTipo_Label.setBounds(45, 202, 38, 28);
		contentPane.add(resTipo_Label);
		
		JComboBox resTipo_comboBox = new JComboBox <> (new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		resTipo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resTipo_comboBox.setBounds(84, 205, 125, 24);
		contentPane.add(resTipo_comboBox);
		
		JLabel resTempoTitulo_Label = new JLabel("Periodo de Reserva");
		resTempoTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resTempoTitulo_Label.setBounds(25, 228, 151, 28);
		contentPane.add(resTempoTitulo_Label);
		
		JLabel resDatadeRetirada_Label = new JLabel("Data de Retirada:");
		resDatadeRetirada_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resDatadeRetirada_Label.setBounds(45, 251, 124, 28);
		contentPane.add(resDatadeRetirada_Label);
		
		resDatadeRetirada_textField = new JTextField();
		resDatadeRetirada_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resDatadeRetirada_textField.setColumns(10);
		resDatadeRetirada_textField.setBounds(170, 253, 119, 24);
		contentPane.add(resDatadeRetirada_textField);
		
		JLabel resHoradeRetirada_Label = new JLabel("Hora de Retirada:");
		resHoradeRetirada_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resHoradeRetirada_Label.setBounds(299, 251, 130, 28);
		contentPane.add(resHoradeRetirada_Label);
		
		resHoradeRetirada_textField = new JTextField();
		resHoradeRetirada_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resHoradeRetirada_textField.setColumns(10);
		resHoradeRetirada_textField.setBounds(426, 253, 125, 24);
		contentPane.add(resHoradeRetirada_textField);
		
		JLabel resDatadeEntrega_Label = new JLabel("Data de Entrega:");
		resDatadeEntrega_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resDatadeEntrega_Label.setBounds(45, 278, 119, 28);
		contentPane.add(resDatadeEntrega_Label);
		
		resDatadeEntrega_textField = new JTextField();
		resDatadeEntrega_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resDatadeEntrega_textField.setColumns(10);
		resDatadeEntrega_textField.setBounds(164, 282, 125, 24);
		contentPane.add(resDatadeEntrega_textField);
		
		JLabel resHoradeEntrega_Label = new JLabel("Hora de Entrega:");
		resHoradeEntrega_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resHoradeEntrega_Label.setBounds(299, 278, 124, 28);
		contentPane.add(resHoradeEntrega_Label);
		
		resHoradeEntrega_textField = new JTextField();
		resHoradeEntrega_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resHoradeEntrega_textField.setColumns(10);
		resHoradeEntrega_textField.setBounds(421, 282, 130, 24);
		contentPane.add(resHoradeEntrega_textField);
		
		JLabel resStatusTitulo_Label = new JLabel("Status de Reserva");
		resStatusTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resStatusTitulo_Label.setBounds(25, 310, 151, 28);
		contentPane.add(resStatusTitulo_Label);
		
		JLabel resStatusdeReserva_Label = new JLabel("Status de Reserva:");
		resStatusdeReserva_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resStatusdeReserva_Label.setBounds(45, 337, 131, 28);
		contentPane.add(resStatusdeReserva_Label);
		
		JComboBox resStatusdeReserva_comboBox = new JComboBox <> (new String [] {"Ativa", "Cancelada", "Concluida"});
		resStatusdeReserva_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resStatusdeReserva_comboBox.setBounds(182, 342, 93, 24);
		contentPane.add(resStatusdeReserva_comboBox);
		
		JButton reservar_Button = new JButton("Reservar");
		reservar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reservar_Button.setBounds(445, 337, 119, 43);
		contentPane.add(reservar_Button);
	}
}
