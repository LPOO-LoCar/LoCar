

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class InterfaceInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfaceInicial window = new InterfaceInicial();
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
	public InterfaceInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LoCar - Locadora de veículos");
		lblNewLabel.setBounds(140, 11, 425, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Cadastrar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				InterfaceClientes interfaceClientes = new InterfaceClientes();
				frame.dispose();
//				interfaceClientes.setVisible(true);

		        }
		});


		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(21, 372, 216, 54);
		frame.getContentPane().add(btnNewButton);

		JButton btnCadastrarCarro = new JButton("Cadastrar veículo");
		btnCadastrarCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				InterfaceCarro interfaceCarro = new InterfaceCarro();
				frame.dispose();
//				interfaceCarro.setVisible(true);
			}
		});
		btnCadastrarCarro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarCarro.setBounds(440, 372, 216, 54);
		frame.getContentPane().add(btnCadastrarCarro);

		JLabel lblNewLabel_1 = new JLabel("Gestão de Clientes e Veículos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(140, 317, 401, 29);
		frame.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 355, 700, 1);
		frame.getContentPane().add(separator);

		JLabel lblNewLabel_2 = new JLabel("Gerenciamento de Locação e Pagamentos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(118, 70, 477, 29);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnReserv = new JButton("Reservar veículo");
		btnReserv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReserv.setBounds(21, 120, 216, 54);
		frame.getContentPane().add(btnReserv);

		JButton btnPagamentos = new JButton("Pagamentos");
		btnPagamentos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPagamentos.setBounds(440, 120, 216, 54);
		frame.getContentPane().add(btnPagamentos);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(-96, 110, 787, 1);
		frame.getContentPane().add(separator_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Controle e Relatórios");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(210, 192, 285, 29);
		frame.getContentPane().add(lblNewLabel_2_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBounds(-48, 232, 787, 1);
		frame.getContentPane().add(separator_1_1_1);

		JButton btnLocaesAtivas = new JButton("Locações ativas");
		btnLocaesAtivas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLocaesAtivas.setBounds(21, 245, 216, 54);
		frame.getContentPane().add(btnLocaesAtivas);

		JButton btnPagamentos_1 = new JButton("Relatórios");
		btnPagamentos_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPagamentos_1.setBounds(440, 244, 216, 54);
		frame.getContentPane().add(btnPagamentos_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(247, 117, 64, 60);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\reserva-on-line.png"));

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\carro-compacto.png"));
		lblNewLabel_3_1.setBounds(366, 372, 64, 60);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\cliente.png"));
		lblNewLabel_3_2.setBounds(247, 372, 64, 60);
		frame.getContentPane().add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\dinheiro.png"));
		lblNewLabel_3_3.setBounds(366, 112, 80, 69);
		frame.getContentPane().add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\aluguel-de-carros.png"));
		lblNewLabel_3_4.setBounds(247, 244, 64, 60);
		frame.getContentPane().add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_4_1 = new JLabel("");
		lblNewLabel_3_4_1.setIcon(new ImageIcon("C:\\Users\\mathe\\Downloads\\relatorio-de-lucro.png"));
		lblNewLabel_3_4_1.setBounds(370, 244, 64, 60);
		frame.getContentPane().add(lblNewLabel_3_4_1);

	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}