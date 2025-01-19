package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfaceClientes {

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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
        JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
        lblNewLabel.setBounds(131, 0, 422, 97);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nome:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 98, 67, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(83, 97, 154, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("CPF:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(10, 133, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(83, 132, 154, 20);
        frame.getContentPane().add(textField_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Telefone:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1.setBounds(10, 171, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(83, 170, 154, 20);
        frame.getContentPane().add(textField_2);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Email:");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1.setBounds(10, 212, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(83, 211, 154, 20);
        frame.getContentPane().add(textField_3);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sexo:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_1.setBounds(10, 250, 67, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
        comboBox.setBounds(83, 246, 154, 22);
        frame.getContentPane().add(comboBox);
        
        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Data de Nasc.:");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1_1_1_1_1.setBounds(380, 99, 108, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(498, 98, 154, 20);
        frame.getContentPane().add(textField_4);
	}
}
    
