package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class InterfaceClientes {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientes window = new InterfaceClientes();
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
	public InterfaceClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
        JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
        lblNewLabel.setBounds(131, -20, 422, 97);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nome completo:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 96, 173, 20);
        frame.getContentPane().add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(243, 178, 154, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("CPF:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(243, 156, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 125, 567, 20);
        frame.getContentPane().add(textField_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Telefone:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(10, 436, 85, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 178, 205, 20);
        frame.getContentPane().add(textField_2);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Email:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(325, 436, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(10, 291, 374, 20);
        frame.getContentPane().add(textField_3);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sexo:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1_1.setBounds(427, 157, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
        comboBox.setBounds(423, 178, 154, 22);
        frame.getContentPane().add(comboBox);
        
        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Data de Nascimento:");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_1_1.setBounds(10, 153, 166, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(427, 291, 150, 20);
        frame.getContentPane().add(textField_4);
        
        JLabel lblNewLabel_2 = new JLabel("Dados");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_2.setBounds(10, 55, 116, 29);
        frame.getContentPane().add(lblNewLabel_2);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBounds(0, 87, 684, 1);
        frame.getContentPane().add(separator);
        
        JLabel lblNewLabel_3 = new JLabel("Endereço");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_3.setBounds(10, 209, 154, 29);
        frame.getContentPane().add(lblNewLabel_3);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLACK);
        separator_1.setBounds(0, 246, 684, 1);
        frame.getContentPane().add(separator_1);
        
        JLabel lblNewLabel_4 = new JLabel("Bairro e rua:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(10, 261, 116, 14);
        frame.getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Número:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(423, 261, 91, 14);
        frame.getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Contato");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_6.setBounds(10, 378, 116, 29);
        frame.getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("CEP:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7.setBounds(10, 322, 46, 14);
        frame.getContentPane().add(lblNewLabel_7);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(10, 347, 205, 20);
        frame.getContentPane().add(textField_5);
        
        JLabel lblNewLabel_7_1 = new JLabel("Cidade:");
        lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7_1.setBounds(242, 322, 91, 14);
        frame.getContentPane().add(lblNewLabel_7_1);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(243, 347, 154, 20);
        frame.getContentPane().add(textField_6);
        
        JLabel lblNewLabel_7_1_1 = new JLabel("Estado:");
        lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7_1_1.setBounds(423, 322, 91, 14);
        frame.getContentPane().add(lblNewLabel_7_1_1);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(423, 347, 154, 20);
        frame.getContentPane().add(textField_7);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(Color.BLACK);
        separator_1_1.setBounds(0, 413, 694, 1);
        frame.getContentPane().add(separator_1_1);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(92, 436, 205, 20);
        frame.getContentPane().add(textField_8);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(385, 435, 192, 20);
        frame.getContentPane().add(textField_9);
        
        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(407, 470, 122, 34);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Limpar");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton_1.setBounds(552, 471, 122, 34);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Voltar");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_2.setBounds(10, 11, 97, 33);
        frame.getContentPane().add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
			InterfaceInicial interfaceInicial = new InterfaceInicial();
			frame.dispose();
			interfaceInicial.setVisible(true);
        }
	});
	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
    
