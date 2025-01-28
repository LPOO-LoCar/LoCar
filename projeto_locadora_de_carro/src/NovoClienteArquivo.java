

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class NovoClienteArquivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nome_TextField;
	private JTextField CPF_TextField;
	private JTextField DatadeNascimento_textField;
	private JTextField Email_textField;
	private JTextField Telefone_textField;
	private JTextField CNH_textField;
	private JTextField VencimentoCNH_textField;
	private JLabel Sexo_Label;
	private JLabel Endereço_Label;
	private JTextField Endereço_textField;
	private JLabel CEP_Label;
	private JTextField CPF_textField;
	private JLabel Celular_Label;
	private JTextField Celular_textField;

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
		setSize(600,400);
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
		
		JLabel Nome_Label = new JLabel("Nome Completo:");
		Nome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome_Label.setBounds(48, 72, 122, 26);
		contentPane.add(Nome_Label);
		
		Nome_TextField = new JTextField();
		Nome_TextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_TextField.setBounds(171, 75, 344, 23);
		contentPane.add(Nome_TextField);
		Nome_TextField.setColumns(10);
		
		JLabel CPFLabel = new JLabel("CPF:");
		CPFLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CPFLabel.setBounds(48, 109, 39, 26);
		contentPane.add(CPFLabel);
		
		CPF_TextField = new JTextField();
		CPF_TextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CPF_TextField.setColumns(10);
		CPF_TextField.setBounds(84, 111, 123, 23);
		contentPane.add(CPF_TextField);
		
		JLabel DatadeNascimento_Label = new JLabel("Data de Nascimento:");
		DatadeNascimento_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DatadeNascimento_Label.setBounds(217, 109, 147, 26);
		contentPane.add(DatadeNascimento_Label);
		
		DatadeNascimento_textField = new JTextField();
		DatadeNascimento_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DatadeNascimento_textField.setColumns(10);
		DatadeNascimento_textField.setBounds(365, 109, 150, 23);
		contentPane.add(DatadeNascimento_textField);
		
		JLabel Email_Label = new JLabel("E-mail:");
		Email_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email_Label.setBounds(48, 257, 51, 26);
		contentPane.add(Email_Label);
		
		Email_textField = new JTextField();
		Email_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email_textField.setColumns(10);
		Email_textField.setBounds(100, 259, 278, 23);
		contentPane.add(Email_textField);
		
		JLabel Telefone_Label = new JLabel("Telefone:");
		Telefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Telefone_Label.setBounds(329, 146, 67, 26);
		contentPane.add(Telefone_Label);
		
		Telefone_textField = new JTextField();
		Telefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Telefone_textField.setColumns(10);
		Telefone_textField.setBounds(400, 148, 115, 23);
		contentPane.add(Telefone_textField);
		
		JLabel Telefone_Label_1 = new JLabel("CNH:");
		Telefone_Label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Telefone_Label_1.setBounds(48, 183, 39, 26);
		contentPane.add(Telefone_Label_1);
		
		CNH_textField = new JTextField();
		CNH_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CNH_textField.setColumns(10);
		CNH_textField.setBounds(86, 185, 122, 23);
		contentPane.add(CNH_textField);
		
		JLabel VencimentoCNH_Label = new JLabel("Vencimento da CHN:");
		VencimentoCNH_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VencimentoCNH_Label.setBounds(217, 183, 153, 26);
		contentPane.add(VencimentoCNH_Label);
		
		VencimentoCNH_textField = new JTextField();
		VencimentoCNH_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VencimentoCNH_textField.setColumns(10);
		VencimentoCNH_textField.setBounds(369, 183, 146, 23);
		contentPane.add(VencimentoCNH_textField);
		
		Sexo_Label = new JLabel("Sexo:");
		Sexo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sexo_Label.setBounds(48, 146, 45, 26);
		contentPane.add(Sexo_Label);
		
		JComboBox Sexo_comboBox = new JComboBox <> (new String[] {"Masculino", "Feminino", "Outro"});
		Sexo_comboBox.setBounds(88, 150, 84, 22);
		contentPane.add(Sexo_comboBox);
		
		Endereço_Label = new JLabel("Endereço:");
		Endereço_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Endereço_Label.setBounds(48, 220, 71, 26);
		contentPane.add(Endereço_Label);
		
		Endereço_textField = new JTextField();
		Endereço_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Endereço_textField.setColumns(10);
		Endereço_textField.setBounds(120, 222, 221, 23);
		contentPane.add(Endereço_textField);
		
		CEP_Label = new JLabel("CEP:");
		CEP_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CEP_Label.setBounds(351, 220, 39, 26);
		contentPane.add(CEP_Label);
		
		CPF_textField = new JTextField();
		CPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CPF_textField.setColumns(10);
		CPF_textField.setBounds(389, 222, 126, 23);
		contentPane.add(CPF_textField);
		
		Celular_Label = new JLabel("Celular:");
		Celular_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Celular_Label.setBounds(175, 146, 55, 26);
		contentPane.add(Celular_Label);
		
		Celular_textField = new JTextField();
		Celular_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Celular_textField.setColumns(10);
		Celular_textField.setBounds(234, 148, 92, 23);
		contentPane.add(Celular_textField);
		
		JButton Cadastrar_Button = new JButton("Cadastrar");
		Cadastrar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cadastrar_Button.setBounds(400, 315, 115, 35);
		contentPane.add(Cadastrar_Button);
	}
}
