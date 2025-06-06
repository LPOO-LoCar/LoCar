package com.locar.ui.buscar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.locar.dados.CarroRepositorio;
import com.locar.entidades.Carro;
import com.locar.ui.TelaPrincipal;

public class BuscarVeiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoTextoPlaca;
	private JTextField campoTextoMarca;
	private JTextField campoTextoModelo;
	private JTable tabela;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BuscarVeiculo frame = new BuscarVeiculo("ADMIN");
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
	public BuscarVeiculo(String funcao) {
		setTitle("Buscar Veiculo");
		setSize(800,600);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 92, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Busca de veículo");
		lblNewLabel.setBounds(259, 10, 293, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblNewLabel);

		campoTextoPlaca = new JTextField();
		campoTextoPlaca.setBounds(10, 117, 207, 20);
		contentPane.add(campoTextoPlaca);
		campoTextoPlaca.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(286, 92, 94, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Modelo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(567, 92, 70, 14);
		contentPane.add(lblNewLabel_1_1_1);

		campoTextoMarca = new JTextField();
		campoTextoMarca.setColumns(10);
		campoTextoMarca.setBounds(286, 117, 207, 20);
		contentPane.add(campoTextoMarca);

		campoTextoModelo = new JTextField();
		campoTextoModelo.setColumns(10);
		campoTextoModelo.setBounds(567, 117, 207, 20);
		contentPane.add(campoTextoModelo);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        String marca = campoTextoMarca.getText();
		        String modelo = campoTextoModelo.getText();
		        String placa = campoTextoPlaca.getText();

		        if (!placa.isEmpty() && marca.isEmpty() && modelo.isEmpty()) {
		        	buscarCarroPorPlaca();
		        }
		        else if (!marca.isEmpty() && modelo.isEmpty() && placa.isEmpty()) {
		            buscarCarroPorMarca();
		        }
		        else if (!modelo.isEmpty() && marca.isEmpty() && placa.isEmpty()) {
		        	buscarCarroPorModelo();
		        }
		        else {
		            buscarTodosCarros();
		        }

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(327, 148, 146, 35);
		contentPane.add(btnNewButton);

        modelo = new DefaultTableModel();
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Ano");
        modelo.addColumn("Cor");
        modelo.addColumn("Placa");
        modelo.addColumn("Número do Motor");
        modelo.addColumn("Chassi");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 191, 764, 359);
        contentPane.add(scrollPane);

        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
    			TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
    			dispose();
    			telaPrincipal.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(10, 10, 89, 35);
        contentPane.add(btnNewButton_1);

        buscarTodosCarros();
	}

    private void buscarTodosCarros() {
        CarroRepositorio carroRepositorio = new CarroRepositorio();
        List<Carro> carros = carroRepositorio.buscarTodosCarros();

        modelo.setRowCount(0);

        for (Carro carro : carros) {
                modelo.addRow(new Object[]{
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.getCor(),
                    carro.getPlaca(),
                    carro.getNumMotor(),
                    carro.getChassi()
                });
            }
        }

    private void buscarCarroPorPlaca() {
        String placa = campoTextoPlaca.getText();
        CarroRepositorio carroRepositorio = new CarroRepositorio();
        Carro carro = carroRepositorio.buscarCarroPorPlacaParaConsulta(placa);

        modelo.setRowCount(0);
        if (carro != null) {
            modelo.addRow(new Object[]{carro.getMarca(),carro.getModelo(), carro.getAno(), carro.getCor(),
            		carro.getPlaca(), carro.getNumMotor(), carro.getChassi()});
        } else {
            JOptionPane.showMessageDialog(this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCarroPorMarca() {
        String marca = campoTextoMarca.getText();
        CarroRepositorio carroRepositorio = new CarroRepositorio();
        List<Carro> carros = carroRepositorio.buscarCarrosPorMarca(marca);

        modelo.setRowCount(0);

        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Carro carro : carros) {
                modelo.addRow(new Object[]{
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.getCor(),
                    carro.getPlaca(),
                    carro.getNumMotor(),
                    carro.getChassi()
                });
            }
        }
    }

    private void buscarCarroPorModelo() {
        String modeloCarro = campoTextoModelo.getText();
        CarroRepositorio carroRepositorio = new CarroRepositorio();
        List<Carro> carros = carroRepositorio.buscarCarrosPorModelo(modeloCarro);

        modelo.setRowCount(0);

        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Carro carro : carros) {
                modelo.addRow(new Object[]{
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.getCor(),
                    carro.getPlaca(),
                    carro.getNumMotor(),
                    carro.getChassi()
                });
            }
        }
    }

}
