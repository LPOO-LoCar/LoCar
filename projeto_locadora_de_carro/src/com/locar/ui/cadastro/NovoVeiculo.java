package com.locar.ui.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.locar.regras_negocio.ControladorControleAcesso;
import com.locar.ui.TelaPrincipal;

public class NovoVeiculo {

	private JFrame frame;
	private JTextField campoTextoPlaca;
	private JTextField campoTextoMarca;
	private JTextField campoTextoModelo;
	private JTextField campoTextoCor;
	private JTextField campoTextoAno;
	private JTextField campoTextoNumMotor;
	private JTextField campoTextoChassi;
	private JTextField campoTextoKmRodados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NovoVeiculo window = new NovoVeiculo();
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
	public NovoVeiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de veículos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel.setBounds(148, 11, 422, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(373, 150, 77, 14);
		frame.getContentPane().add(lblNewLabel_1);

		campoTextoPlaca = new JTextField();
		campoTextoPlaca.setBounds(373, 172, 185, 20);
		frame.getContentPane().add(campoTextoPlaca);
		campoTextoPlaca.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 94, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);

		campoTextoMarca = new JTextField();
		campoTextoMarca.setBounds(10, 119, 285, 20);
		frame.getContentPane().add(campoTextoMarca);
		campoTextoMarca.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(320, 94, 107, 14);
		frame.getContentPane().add(lblNewLabel_3);

		campoTextoModelo = new JTextField();
		campoTextoModelo.setBounds(320, 119, 238, 20);
		frame.getContentPane().add(campoTextoModelo);
		campoTextoModelo.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Cor:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(225, 150, 107, 14);
		frame.getContentPane().add(lblNewLabel_3_1);

		campoTextoCor = new JTextField();
		campoTextoCor.setColumns(10);
		campoTextoCor.setBounds(225, 172, 123, 20);
		frame.getContentPane().add(campoTextoCor);

		campoTextoAno = new JTextField();
		campoTextoAno.setColumns(10);
		campoTextoAno.setBounds(10, 172, 184, 20);
		frame.getContentPane().add(campoTextoAno);

		JLabel lblNewLabel_3_1_1 = new JLabel("Ano:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(10, 150, 53, 14);
		frame.getContentPane().add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Combustível:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1.setBounds(10, 296, 107, 14);
		frame.getContentPane().add(lblNewLabel_3_1_1_1);

		JComboBox<String> campoTextoCombustivel = new JComboBox<>();
		campoTextoCombustivel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTextoCombustivel.setModel(new DefaultComboBoxModel<>(new String[] {"Gasolina", "Diesel", "Flex"}));
		campoTextoCombustivel.setBounds(122, 290, 107, 22);
		frame.getContentPane().add(campoTextoCombustivel);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1.setBounds(10, 321, 107, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1);

		JComboBox<String> campoTextoCategoria = new JComboBox<>();
		campoTextoCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTextoCategoria.setModel(new DefaultComboBoxModel<>(new String[] {"Hatch", "Sedan", "SUV", "Picape", "Minivan", "Hatchback", "Esportivo"}));
		campoTextoCategoria.setBounds(122, 321, 107, 22);
		frame.getContentPane().add(campoTextoCategoria);

		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Transmissão:");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1_1.setBounds(337, 293, 113, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1_1);

		JComboBox<String> campoTextoTransmissao = new JComboBox<>();
		campoTextoTransmissao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTextoTransmissao.setModel(new DefaultComboBoxModel<>(new String[] {"Manual", "Automática"}));
		campoTextoTransmissao.setBounds(453, 290, 105, 22);
		frame.getContentPane().add(campoTextoTransmissao);

		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Estado de Conservação:");
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(252, 321, 213, 21);
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1_1_1);

		JComboBox<String> campoTextoConservacao = new JComboBox<>();
		campoTextoConservacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		campoTextoConservacao.setModel(new DefaultComboBoxModel<>(new String[] {"Bom", "Ótimo", "Excelente", "Seminovo", "Usado", "Novo"}));
		campoTextoConservacao.setBounds(453, 320, 105, 22);
		frame.getContentPane().add(campoTextoConservacao);

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
		lblNewLabel_4_1.setBounds(10, 245, 238, 30);
		frame.getContentPane().add(lblNewLabel_4_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(-10, 246, 694, 0);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 280, 684, 2);
		frame.getContentPane().add(separator_2);

        JComboBox<String> campoTextoDirecao = new JComboBox<>();
        campoTextoDirecao.setModel(new DefaultComboBoxModel<>(new String[] {"Manual", "Hidráulica", "Elétrica"}));
        campoTextoDirecao.setFont(new Font("Tahoma", Font.PLAIN, 18));
        campoTextoDirecao.setBounds(122, 353, 107, 22);
        frame.getContentPane().add(campoTextoDirecao);

        JSpinner campoTextoNumLugares = new JSpinner();
        campoTextoNumLugares.setFont(new Font("Tahoma", Font.PLAIN, 18));
        campoTextoNumLugares.setBounds(176, 386, 53, 20);
        frame.getContentPane().add(campoTextoNumLugares);

        JSpinner campoTextoNumPortas = new JSpinner();
        campoTextoNumPortas.setFont(new Font("Tahoma", Font.PLAIN, 18));
        campoTextoNumPortas.setBounds(505, 384, 53, 20);
        frame.getContentPane().add(campoTextoNumPortas);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String marca = campoTextoMarca.getText();
				String modelo = campoTextoModelo.getText();
				int ano = Integer.parseInt(campoTextoAno.getText());
				String cor = campoTextoCor.getText();
				String placa = campoTextoPlaca.getText();
				String numMotor = campoTextoNumMotor.getText();
				String chassi = campoTextoChassi.getText();
				String combustivel = campoTextoCombustivel.getSelectedItem().toString();
				String transmissao = campoTextoTransmissao.getSelectedItem().toString();
				String categoria = campoTextoCategoria.getSelectedItem().toString();
				String conservacao = campoTextoConservacao.getSelectedItem().toString();
				String direcao = campoTextoDirecao.getSelectedItem().toString();
				String kmRodados = campoTextoKmRodados.getText();
				int numLugares = Integer.parseInt(campoTextoNumLugares.getValue().toString());
				int numPortas = Integer.parseInt(campoTextoNumPortas.getValue().toString());

				ControladorControleAcesso controlador = new ControladorControleAcesso();
				controlador.registrarCarro(marca, modelo, ano, cor, placa, numMotor, chassi, combustivel, transmissao,
						categoria, conservacao, direcao, kmRodados, numLugares, numPortas);

				JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} catch (IllegalArgumentException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o veículo. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(421, 414, 123, 36);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoTextoMarca.setText("");
				campoTextoModelo.setText("");
				campoTextoAno.setText("");
				campoTextoCor.setText("");
				campoTextoPlaca.setText("");
				campoTextoNumMotor.setText("");
				campoTextoChassi.setText("");
				campoTextoKmRodados.setText("");

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(567, 414, 107, 36);
		frame.getContentPane().add(btnNewButton_1);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        botaoVoltar.setBounds(10, 11, 97, 33);
        frame.getContentPane().add(botaoVoltar);

        JLabel lblNewLabel_3_1_1_2 = new JLabel("Nº do Motor:");
        lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_2.setBounds(10, 195, 128, 24);
        frame.getContentPane().add(lblNewLabel_3_1_1_2);

        campoTextoNumMotor = new JTextField();
        campoTextoNumMotor.setColumns(10);
        campoTextoNumMotor.setBounds(10, 222, 285, 20);
        frame.getContentPane().add(campoTextoNumMotor);

        JLabel lblNewLabel_3_1_1_2_1 = new JLabel("Chassi:");
        lblNewLabel_3_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_2_1.setBounds(320, 200, 128, 14);
        frame.getContentPane().add(lblNewLabel_3_1_1_2_1);

        campoTextoChassi = new JTextField();
        campoTextoChassi.setColumns(10);
        campoTextoChassi.setBounds(320, 222, 238, 20);
        frame.getContentPane().add(campoTextoChassi);

        JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Direção:");
        lblNewLabel_3_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_1_1_2.setBounds(10, 353, 107, 21);
        frame.getContentPane().add(lblNewLabel_3_1_1_1_1_2);

        JLabel lblNewLabel_3_1_1_1_1_2_1 = new JLabel("Km rodados:");
        lblNewLabel_3_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_1_1_2_1.setBounds(343, 353, 107, 21);
        frame.getContentPane().add(lblNewLabel_3_1_1_1_1_2_1);

        campoTextoKmRodados = new JTextField();
        campoTextoKmRodados.setColumns(10);
        campoTextoKmRodados.setBounds(453, 353, 105, 20);
        frame.getContentPane().add(campoTextoKmRodados);

        JLabel lblNewLabel_3_1_1_1_1_2_2 = new JLabel("Nº de Lugares:");
        lblNewLabel_3_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_1_1_2_2.setBounds(10, 383, 128, 21);
        frame.getContentPane().add(lblNewLabel_3_1_1_1_1_2_2);

        JLabel lblNewLabel_3_1_1_1_1_2_1_1 = new JLabel("Nº de Portas:");
        lblNewLabel_3_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3_1_1_1_1_2_1_1.setBounds(337, 385, 107, 21);
        frame.getContentPane().add(lblNewLabel_3_1_1_1_1_2_1_1);
        botaoVoltar.addActionListener(new ActionListener() {
         @Override
		public void actionPerformed(ActionEvent e) {
        	TelaPrincipal telaPrincipal = new TelaPrincipal("ADMIN");
			frame.dispose();
		    telaPrincipal.setVisible(true);
        }
        });
	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
