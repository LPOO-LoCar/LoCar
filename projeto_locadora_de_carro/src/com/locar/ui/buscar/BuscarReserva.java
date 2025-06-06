package com.locar.ui.buscar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import com.locar.dados.ReservaRepositorio;
import com.locar.entidades.Reserva;
import com.locar.ui.TelaPrincipal;

public class BuscarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoTextoCpf;
	private JTextField campoTextoPlaca;
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
					BuscarReserva frame = new BuscarReserva("ADMIN");
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
	public BuscarReserva(String funcao) {
		setTitle("Buscar Reserva");
		setSize(800,600);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Busca de reserva");
		lblNewLabel.setBounds(239, 11, 301, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblNewLabel);

		campoTextoCpf = new JTextField();
		campoTextoCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
        		String textoCpf = campoTextoCpf.getText();
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

        		campoTextoCpf.setText(textoCpf);
			}
		});

		campoTextoCpf.setBounds(10, 99, 294, 20);
		contentPane.add(campoTextoCpf);
		campoTextoCpf.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Placa:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(440, 73, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		campoTextoPlaca = new JTextField();
		campoTextoPlaca.setBounds(439, 99, 335, 20);
		contentPane.add(campoTextoPlaca);
		campoTextoPlaca.setColumns(10);

        modelo = new DefaultTableModel();
        modelo.addColumn("Id do Cliente");
        modelo.addColumn("Id do carro");
        modelo.addColumn("Data de retirada");
        modelo.addColumn("Hora de retirada");
        modelo.addColumn("Data de entrega");
        modelo.addColumn("Hora de entrega");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 191, 764, 359);
        contentPane.add(scrollPane);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
				if (campoTextoCpf.getText() != null && !campoTextoCpf.getText().isEmpty()) {
					buscarReservaPorCpf();
				}
				else {
					buscarReservaPorPlaca();
			}
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(317, 130, 114, 35);
        contentPane.add(btnNewButton);

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
        btnNewButton_1.setBounds(10, 11, 89, 35);
        contentPane.add(btnNewButton_1);

        buscarTodasReservas();
	}

    private void buscarTodasReservas() {
        ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
        List<Reserva> reservas = reservaRepositorio.buscarTodasReservas();

        modelo.setRowCount(0);

        for (Reserva reserva : reservas) {
                modelo.addRow(new Object[]{
                		reserva.getCliente().getId(), reserva.getCarro().getId(), reserva.getDataRetirada(), reserva.getHoraRetirada(),
                		reserva.getDataEntrega(), reserva.getHoraEntrega()
                });
            }
        }
    private void buscarReservaPorCpf() {
        String cpf = campoTextoCpf.getText();
        ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
        List<Reserva> reservas = reservaRepositorio.buscarReservaPorCpf(cpf);

        modelo.setRowCount(0);

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reserva não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Reserva reserva : reservas) {
                modelo.addRow(new Object[]{
                		reserva.getCliente().getId(), reserva.getCarro().getId(), reserva.getDataRetirada(), reserva.getHoraRetirada(),
                		reserva.getDataEntrega(), reserva.getHoraEntrega()
                });
            }
        }
    }
    private void buscarReservaPorPlaca() {
        String placa = campoTextoPlaca.getText();
        ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
        List<Reserva> reservas = reservaRepositorio.buscarReservaPorPlaca(placa);

        modelo.setRowCount(0);

        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reserva não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Reserva reserva : reservas) {
                modelo.addRow(new Object[]{
                		reserva.getCliente().getId(), reserva.getCarro().getId(), reserva.getDataRetirada(), reserva.getHoraRetirada(),
                		reserva.getDataEntrega(), reserva.getHoraEntrega()
                });
            }
        }
    }
}
