package com.locar.ui.ajuda;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextPane;

public class Sobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setTitle("Sobre");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel carrinho = new JLabel("");
		carrinho.setIcon(new ImageIcon(getClass().getResource("/imagem/LOCARsobre.png")));
		carrinho.setBounds(250, 11, 123, 116);
		contentPane.add(carrinho);
		
		JLabel SobreLabel = new JLabel("Sobre");
		SobreLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SobreLabel.setBounds(268, 137, 47, 20);
		contentPane.add(SobreLabel);
		
		JLabel Linha1_Label = new JLabel("Programa desenvolvido em Java para o gerenciamento de locadoras de veículos");
		Linha1_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Linha1_Label.setBounds(72, 168, 466, 20);
		contentPane.add(Linha1_Label);
		
		JLabel Linha2_Label = new JLabel("com funções de cadastrar, editar e buscar clientes, veicúlos e funcionários");
		Linha2_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Linha2_Label.setBounds(92, 186, 432, 20);
		contentPane.add(Linha2_Label);
		
		JLabel Linha3_Label = new JLabel("além de fazer reservas, locadoras e gerar relatórios administrativos para a");
		Linha3_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Linha3_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Linha3_Label.setBounds(90, 202, 432, 20);
		contentPane.add(Linha3_Label);
		
		JLabel Linha4_Label = new JLabel("cadeira de LPOO 2024.2 do IFPE campus Paulista.");
		Linha4_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Linha4_Label.setBounds(159, 218, 292, 20);
		contentPane.add(Linha4_Label);
		
		JLabel DesenvolvedoresLabel = new JLabel("Desenvolvedores");
		DesenvolvedoresLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DesenvolvedoresLabel.setBounds(230, 249, 119, 20);
		contentPane.add(DesenvolvedoresLabel);
		
		JLabel lblNewLabel = new JLabel("Adriel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(183, 278, 70, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblClara = new JLabel("Ana Clara");
		lblClara.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClara.setBounds(183, 305, 70, 16);
		contentPane.add(lblClara);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ana Luiza");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(183, 334, 70, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Maria Luiza");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(337, 280, 70, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Matheus Soares");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(337, 307, 99, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblVerso = new JLabel("Versão");
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVerso.setBounds(267, 360, 48, 20);
		contentPane.add(lblVerso);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("1.0.1");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(276, 384, 35, 16);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
