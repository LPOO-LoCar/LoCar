package com.locar.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class InterfaceCarro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCarro window = new InterfaceCarro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceCarro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de veículos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(148, 11, 422, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(373, 150, 77, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(373, 172, 185, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 94, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 119, 285, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(320, 94, 107, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(320, 119, 238, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cor:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(225, 150, 107, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 172, 123, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 172, 184, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ano:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(10, 150, 53, 14);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Combustível:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1.setBounds(10, 260, 107, 14);
		frame.getContentPane().add(lblNewLabel_3_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gasolina", "Diesel"}));
		comboBox.setBounds(122, 256, 107, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1.setBounds(10, 345, 107, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sedan", "SUV", "Hatch"}));
		comboBox_1.setBounds(108, 344, 86, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Transmissão:");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1_1.setBounds(337, 257, 113, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automático"}));
		comboBox_1_1.setBounds(453, 257, 105, 22);
		frame.getContentPane().add(comboBox_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Estado de Conservação:");
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(299, 347, 213, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Novo", "Seminovo", "Usado"}));
		comboBox_1_1_1.setBounds(499, 347, 86, 22);
		frame.getContentPane().add(comboBox_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Dados");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(10, 53, 107, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 85, 684, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("Especificações");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4_1.setBounds(10, 205, 238, 30);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(-10, 246, 694, 0);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 240, 684, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Características");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4_1_1.setBounds(10, 298, 238, 30);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(0, 332, 684, 2);
		frame.getContentPane().add(separator_2_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(421, 414, 123, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(567, 414, 107, 36);
		frame.getContentPane().add(btnNewButton_1);
		
        JButton btnNewButton_2 = new JButton("Voltar");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_2.setBounds(10, 11, 97, 33);
        frame.getContentPane().add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
//			InterfaceInicial interfaceInicial = new InterfaceInicial();
			frame.dispose();
//			interfaceInicial.setVisible(true);
        }
        });
	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
      
}
