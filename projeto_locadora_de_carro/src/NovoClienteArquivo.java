

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NovoClienteArquivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nome_TextField;
	private JTextField CPF_TextField;
	private JTextField DatadeNascimento_textField;
	private JTextField Email_textField;
	private JLabel Sexo_Label;
	private JLabel CEP_Label;
	private JTextField CEP_textField;
	private JLabel Celular_Label;
	private JTextField Celular_textField;
	private JLabel dadosDoClienteLabel;
	private JTextField rg_textField;
	private JTextField dataDeExp_textField;
	private JTextField orgExpedidor_textField;
	private JTextField cnh_textField;
	private JLabel dataDeVencimento_Label;
	private JTextField dataDeVencimento_textField;
	private JLabel endereco_Label;
	private JLabel rua_Label;
	private JTextField rua_textField;
	private JTextField numeroRua_textField;
	private JTextField bairro_textField;
	private JTextField cidade_textField;
	private JLabel complemento_Label;
	private JTextField Complemento_textField;
	private JLabel contato_Label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoClienteArquivo frame = new NovoClienteArquivo();
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
	public NovoClienteArquivo() {
		setTitle("Novo Cliente");
		setSize(560,475);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo_Label = new JLabel("Cadastro de Cliente");
		Titulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Titulo_Label.setBounds(168, 11, 236, 35);
		contentPane.add(Titulo_Label);
		
		JLabel Nome_Label = new JLabel("Nome:");
		Nome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome_Label.setBounds(170, 77, 51, 26);
		contentPane.add(Nome_Label);
		
		Nome_TextField = new JTextField();
		Nome_TextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_TextField.setBounds(217, 79, 318, 23);
		contentPane.add(Nome_TextField);
		Nome_TextField.setColumns(10);
		
		JLabel CPFLabel = new JLabel("CPF:");
		CPFLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CPFLabel.setBounds(20, 77, 39, 26);
		contentPane.add(CPFLabel);
		
		CPF_TextField = new JTextField();
		CPF_TextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CPF_TextField.setColumns(10);
		CPF_TextField.setBounds(58, 79, 108, 23);
		contentPane.add(CPF_TextField);
		
		JLabel DatadeNascimento_Label = new JLabel("Data de Nascimento:");
		DatadeNascimento_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DatadeNascimento_Label.setBounds(20, 107, 147, 26);
		contentPane.add(DatadeNascimento_Label);
		
		DatadeNascimento_textField = new JTextField();
		DatadeNascimento_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 String texto = DatadeNascimento_textField.getText();
	                texto = texto.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos

	                // Adiciona as barras automaticamente
	                if (texto.length() >= 2) {
	                    texto = texto.substring(0, 2) + "/" + texto.substring(2);
	                }
	                if (texto.length() >= 5) {
	                    texto = texto.substring(0, 5) + "/" + texto.substring(5);
	                }
	                // Limita o texto a 10 caracteres
	                if (texto.length() >= 10) {
	                    texto = texto.substring(0, 10);
	                }
	                DatadeNascimento_textField.setText(texto);	
			}
		});
		DatadeNascimento_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DatadeNascimento_textField.setColumns(10);
		DatadeNascimento_textField.setBounds(170, 109, 92, 23);
		contentPane.add(DatadeNascimento_textField);
		
		JLabel Email_Label = new JLabel("E-mail:");
		Email_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email_Label.setBounds(170, 345, 51, 26);
		contentPane.add(Email_Label);
		
		Email_textField = new JTextField();
		Email_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email_textField.setColumns(10);
		Email_textField.setBounds(226, 347, 278, 23);
		contentPane.add(Email_textField);
		
		Sexo_Label = new JLabel("Sexo:");
		Sexo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sexo_Label.setBounds(272, 107, 45, 26);
		contentPane.add(Sexo_Label);
		
		JComboBox Sexo_comboBox = new JComboBox <> (new String[] {"Masculino", "Feminino", "Outro"});
		Sexo_comboBox.setBounds(320, 109, 84, 22);
		contentPane.add(Sexo_comboBox);
		
		CEP_Label = new JLabel("CEP:");
		CEP_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CEP_Label.setBounds(20, 234, 39, 26);
		contentPane.add(CEP_Label);
		
		CEP_textField = new JTextField();
		CEP_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CEP_textField.setColumns(10);
		CEP_textField.setBounds(58, 236, 126, 23);
		contentPane.add(CEP_textField);
		
		Celular_Label = new JLabel("Celular:");
		Celular_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Celular_Label.setBounds(20, 345, 55, 26);
		contentPane.add(Celular_Label);
		
		Celular_textField = new JTextField();
		Celular_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Celular_textField.setColumns(10);
		Celular_textField.setBounds(75, 347, 92, 23);
		contentPane.add(Celular_textField);
		
		JButton Cadastrar_Button = new JButton("Cadastrar");
		Cadastrar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cadastrar_Button.setBounds(414, 389, 115, 35);
		contentPane.add(Cadastrar_Button);
		
		dadosDoClienteLabel = new JLabel("Dados do Cliente");
		dadosDoClienteLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		dadosDoClienteLabel.setBounds(10, 54, 156, 26);
		contentPane.add(dadosDoClienteLabel);
		
		JLabel rgLabel = new JLabel("RG:");
		rgLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rgLabel.setBounds(414, 107, 27, 26);
		contentPane.add(rgLabel);
		
		rg_textField = new JTextField();
		rg_textField.setBounds(446, 109, 89, 23);
		contentPane.add(rg_textField);
		rg_textField.setColumns(10);
		
		JLabel dataDeExpLabel = new JLabel("Data de Exp.:");
		dataDeExpLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dataDeExpLabel.setBounds(75, 137, 96, 26);
		contentPane.add(dataDeExpLabel);
		
		dataDeExp_textField = new JTextField();
		dataDeExp_textField.setColumns(10);
		dataDeExp_textField.setBounds(174, 139, 86, 23);
		contentPane.add(dataDeExp_textField);
		
		JLabel orgExpedidor_Label = new JLabel("Orgão Expedidor:");
		orgExpedidor_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		orgExpedidor_Label.setBounds(261, 137, 132, 26);
		contentPane.add(orgExpedidor_Label);
		
		orgExpedidor_textField = new JTextField();
		orgExpedidor_textField.setColumns(10);
		orgExpedidor_textField.setBounds(393, 139, 86, 23);
		contentPane.add(orgExpedidor_textField);
		
		JLabel cnh_Label = new JLabel("CNH:");
		cnh_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cnh_Label.setBounds(85, 167, 39, 26);
		contentPane.add(cnh_Label);
		
		cnh_textField = new JTextField();
		cnh_textField.setColumns(10);
		cnh_textField.setBounds(124, 169, 86, 23);
		contentPane.add(cnh_textField);
		
		dataDeVencimento_Label = new JLabel("Vencimento da CNH:");
		dataDeVencimento_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dataDeVencimento_Label.setBounds(220, 167, 153, 26);
		contentPane.add(dataDeVencimento_Label);
		
		dataDeVencimento_textField = new JTextField();
		dataDeVencimento_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
						
	                String texto = dataDeVencimento_textField.getText();
	                texto = texto.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos

	                // Adiciona as barras automaticamente
	                if (texto.length() >= 2) {
	                    texto = texto.substring(0, 2) + "/" + texto.substring(2);
	                }
	                if (texto.length() >= 5) {
	                    texto = texto.substring(0, 5) + "/" + texto.substring(5);
	                }
	                // Limita o texto a 10 caracteres
	                if (texto.length() >= 10) {
	                    texto = texto.substring(0, 10);
	                }
	                dataDeVencimento_textField.setText(texto);
			}
		});
		dataDeVencimento_textField.setColumns(10);
		dataDeVencimento_textField.setBounds(374, 169, 86, 23);
		contentPane.add(dataDeVencimento_textField);
		
		endereco_Label = new JLabel("Endereço");
		endereco_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		endereco_Label.setBounds(10, 204, 92, 26);
		contentPane.add(endereco_Label);
		
		rua_Label = new JLabel("Rua:");
		rua_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rua_Label.setBounds(193, 234, 39, 26);
		contentPane.add(rua_Label);
		
		rua_textField = new JTextField();
		rua_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rua_textField.setColumns(10);
		rua_textField.setBounds(227, 236, 221, 23);
		contentPane.add(rua_textField);
		
		JLabel numeroRua_Label = new JLabel("Nº:");
		numeroRua_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numeroRua_Label.setBounds(452, 234, 27, 26);
		contentPane.add(numeroRua_Label);
		
		numeroRua_textField = new JTextField();
		numeroRua_textField.setColumns(10);
		numeroRua_textField.setBounds(480, 238, 55, 23);
		contentPane.add(numeroRua_textField);
		
		JLabel bairro_Label = new JLabel("Bairro:");
		bairro_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bairro_Label.setBounds(30, 264, 51, 26);
		contentPane.add(bairro_Label);
		
		bairro_textField = new JTextField();
		bairro_textField.setColumns(10);
		bairro_textField.setBounds(77, 266, 124, 23);
		contentPane.add(bairro_textField);
		
		JLabel cidade_Label = new JLabel("Cidade:");
		cidade_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cidade_Label.setBounds(207, 264, 55, 26);
		contentPane.add(cidade_Label);
		
		cidade_textField = new JTextField();
		cidade_textField.setColumns(10);
		cidade_textField.setBounds(269, 268, 124, 23);
		contentPane.add(cidade_textField);
		
		JLabel estado_Label = new JLabel("Estado:");
		estado_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		estado_Label.setBounds(405, 264, 55, 26);
		contentPane.add(estado_Label);
		
		JComboBox estado_comboBox = new JComboBox <> (new String [] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RR", "RO", "SC", "SP", "SE", "TO"});
		estado_comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RR", "RO", "SC", "SP", "SE", "TO"}));
		estado_comboBox.setBounds(462, 266, 67, 23);
		contentPane.add(estado_comboBox);
		
		complemento_Label = new JLabel("Complemento:");
		complemento_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		complemento_Label.setBounds(113, 294, 108, 26);
		contentPane.add(complemento_Label);
		
		Complemento_textField = new JTextField();
		Complemento_textField.setColumns(10);
		Complemento_textField.setBounds(220, 296, 176, 23);
		contentPane.add(Complemento_textField);
		
		contato_Label = new JLabel("Contato");
		contato_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		contato_Label.setBounds(10, 318, 77, 26);
		contentPane.add(contato_Label);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 77, 23);
		contentPane.add(btnNewButton);
	}
}
