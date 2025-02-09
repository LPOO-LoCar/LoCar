package com.locar.ui.cadastro;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.locar.dados.Repositorio;
import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class NovaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField locCPF_textField;
	private JTextField locNome_textField;
	private JTextField locTelefone_textField;
	private JTextField locEmail_textField;
	private JTextField locPlaca_textField;
	private JTextField locModelo_textField;
	private JTextField locMarca_textField;
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
		setSize(650,590);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel resTitulo_Label = new JLabel("Nova Reserva");
		resTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		resTitulo_Label.setBounds(193, 11, 247, 37);
		contentPane.add(resTitulo_Label);
		
		JLabel locClienteTitulo_Label = new JLabel("Cliente");
		locClienteTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		locClienteTitulo_Label.setBounds(10, 50, 100, 28);
		contentPane.add(locClienteTitulo_Label);
		
		JLabel locCPF_Label = new JLabel("CPF:");
		locCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locCPF_Label.setBounds(10, 86, 67, 28);
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
		
		locPlaca_textField = new JTextField();
		locPlaca_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String placa = locPlaca_textField.getText();
		        Repositorio repositorio = new Repositorio();
		        Carro carro = repositorio.buscarCarroPorPlaca(placa);
		            
		        locMarca_textField.setText(carro.getMarca());
		        locModelo_textField.setText(carro.getModelo());
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
		
		JComboBox locTipo_comboBox = new JComboBox <> (new String [] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"});
		locTipo_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Outro"}));
		locTipo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locTipo_comboBox.setBounds(10, 320, 165, 20);
		contentPane.add(locTipo_comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 80, 634, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 229, 634, 1);
		contentPane.add(separator_1);
		
		JLabel resTempoTitulo_Label = new JLabel("Periodo e Status de Reserva");
		resTempoTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		resTempoTitulo_Label.setBounds(10, 349, 374, 28);
		contentPane.add(resTempoTitulo_Label);
		
		JLabel resDatadeRetirada_Label = new JLabel("Data de Retirada:");
		resDatadeRetirada_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resDatadeRetirada_Label.setBounds(10, 385, 143, 28);
		contentPane.add(resDatadeRetirada_Label);
		
		resDatadeRetirada_textField = new JTextField();
		resDatadeRetirada_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resDatadeRetirada_textField.setColumns(10);
		resDatadeRetirada_textField.setBounds(10, 415, 165, 20);
		contentPane.add(resDatadeRetirada_textField);
		
		JLabel resHoradeRetirada_Label = new JLabel("Hora de Retirada:");
		resHoradeRetirada_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resHoradeRetirada_Label.setBounds(10, 440, 143, 28);
		contentPane.add(resHoradeRetirada_Label);
		
		resHoradeRetirada_textField = new JTextField();
		resHoradeRetirada_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resHoradeRetirada_textField.setColumns(10);
		resHoradeRetirada_textField.setBounds(10, 470, 165, 20);
		contentPane.add(resHoradeRetirada_textField);
		
		JLabel resDatadeEntrega_Label = new JLabel("Data de Entrega:");
		resDatadeEntrega_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resDatadeEntrega_Label.setBounds(276, 386, 143, 28);
		contentPane.add(resDatadeEntrega_Label);
		
		resDatadeEntrega_textField = new JTextField();
		resDatadeEntrega_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resDatadeEntrega_textField.setColumns(10);
		resDatadeEntrega_textField.setBounds(276, 415, 168, 20);
		contentPane.add(resDatadeEntrega_textField);
		
		JLabel resHoradeEntrega_Label = new JLabel("Hora de Entrega:");
		resHoradeEntrega_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resHoradeEntrega_Label.setBounds(276, 440, 143, 28);
		contentPane.add(resHoradeEntrega_Label);
		
		resHoradeEntrega_textField = new JTextField();
		resHoradeEntrega_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resHoradeEntrega_textField.setColumns(10);
		resHoradeEntrega_textField.setBounds(276, 470, 168, 20);
		contentPane.add(resHoradeEntrega_textField);
		
		JLabel resStatusdeReserva_Label = new JLabel("Status de Reserva:");
		resStatusdeReserva_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resStatusdeReserva_Label.setBounds(10, 512, 165, 28);
		contentPane.add(resStatusdeReserva_Label);
		
		JComboBox resStatusdeReserva_comboBox = new JComboBox <> (new String [] {"Ativa", "Cancelada", "Concluida"});
		resStatusdeReserva_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resStatusdeReserva_comboBox.setBounds(174, 514, 93, 24);
		contentPane.add(resStatusdeReserva_comboBox);
		
		JButton reservar_Button = new JButton("Reservar");
		reservar_Button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reservar_Button.setBounds(410, 501, 119, 43);
		contentPane.add(reservar_Button);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(0, 379, 634, 1);
		contentPane.add(separator_1_1);
	}
}
