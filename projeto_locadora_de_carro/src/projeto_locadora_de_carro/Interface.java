package projeto_locadora_de_carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Panel;

public class Interface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
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
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Locadora de carros");
		lblNewLabel.setBounds(170, 11, 367, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(21, 372, 216, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCadastrarCarro = new JButton("Cadastrar Carro");
		btnCadastrarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnReserv = new JButton("Reservar Carro");
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
		
		JButton btnLocaesAtivas = new JButton("Locações Ativas");
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
		lblNewLabel_3_4_1.setBounds(382, 244, 64, 60);
		frame.getContentPane().add(lblNewLabel_3_4_1);
		
	}
}
