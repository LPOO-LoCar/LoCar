package com.locar.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.locar.dados.Repositorio;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoTextoUsuario;
	private JPasswordField campoTextoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	private void abrirTelaPrincipal(String funcao) {
		JFrame telaPrincipal = new TelaPrincipal(funcao);
		telaPrincipal.setSize(800,600);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.setVisible(true);
	}
	
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LoCar");
		lblNewLabel_1.setBounds(226, 11, 164, 36);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Locadora de Veículos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(143, 62, 322, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuário:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(241, 137, 91, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fazer Login");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(207, 96, 147, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Senha:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(246, 206, 73, 20);
		contentPane.add(lblNewLabel_5);
		
		campoTextoUsuario = new JTextField();
		campoTextoUsuario.setColumns(10);
		campoTextoUsuario.setBounds(143, 175, 276, 20);
		contentPane.add(campoTextoUsuario);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = campoTextoUsuario.getText();
				String senha = String.valueOf(campoTextoSenha.getPassword());
				Repositorio repositorio = new Repositorio();
				
				if (usuario.equals("admin") && senha.equals("1234")) {
					dispose();
					abrirTelaPrincipal("ADMIN");
				} else if (repositorio.autenticarFuncionario(usuario, senha)) {
		            dispose();
		            abrirTelaPrincipal("USER");

				} else {
					JOptionPane.showMessageDialog(Login.this, "Usuário ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(207, 278, 136, 36);
		contentPane.add(btnNewButton);
		
		campoTextoSenha = new JPasswordField();
		campoTextoSenha.setBounds(143, 236, 276, 20);
		contentPane.add(campoTextoSenha);
	}
}
