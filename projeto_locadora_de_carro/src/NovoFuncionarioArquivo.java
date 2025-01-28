package test5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class NovoFuncionarioArquivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FunNome_textField;
	private JTextField funCPF_textField;
	private JTextField funRG_textField;
	private JTextField funOrgExp_textField;
	private JTextField funTelefone_textField;
	private JTextField textField;
	private JTextField funDataN_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoFuncionarioArquivo frame = new NovoFuncionarioArquivo();
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
	public NovoFuncionarioArquivo() {
		setTitle("Novo Funcionário");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel funTitulo_Label = new JLabel("Cadastro de Funcionário");
		funTitulo_Label.setForeground(new Color(0, 0, 0));
		funTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		funTitulo_Label.setBounds(139, 12, 280, 35);
		contentPane.add(funTitulo_Label);
		
		JLabel funNome_Label = new JLabel("Nome Completo:");
		funNome_Label.setForeground(new Color(0, 0, 0));
		funNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funNome_Label.setBounds(45, 82, 121, 35);
		contentPane.add(funNome_Label);
		
		FunNome_textField = new JTextField();
		FunNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FunNome_textField.setForeground(new Color(0, 0, 0));
		FunNome_textField.setBounds(173, 88, 357, 23);
		contentPane.add(FunNome_textField);
		FunNome_textField.setColumns(10);
		
		JLabel funCPF_Label = new JLabel("CPF:");
		funCPF_Label.setForeground(Color.BLACK);
		funCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCPF_Label.setBounds(45, 129, 33, 28);
		contentPane.add(funCPF_Label);
		
		funCPF_textField = new JTextField();
		funCPF_textField.setForeground(Color.BLACK);
		funCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCPF_textField.setColumns(10);
		funCPF_textField.setBounds(80, 134, 109, 23);
		contentPane.add(funCPF_textField);
		
		JLabel funRG_Label = new JLabel("RG:");
		funRG_Label.setForeground(Color.BLACK);
		funRG_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funRG_Label.setBounds(197, 129, 33, 28);
		contentPane.add(funRG_Label);
		
		funRG_textField = new JTextField();
		funRG_textField.setForeground(Color.BLACK);
		funRG_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funRG_textField.setColumns(10);
		funRG_textField.setBounds(230, 132, 109, 23);
		contentPane.add(funRG_textField);
		
		JLabel funOrgExp_Label = new JLabel("Org. Exp:");
		funOrgExp_Label.setForeground(Color.BLACK);
		funOrgExp_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funOrgExp_Label.setBounds(349, 129, 69, 28);
		contentPane.add(funOrgExp_Label);
		
		funOrgExp_textField = new JTextField();
		funOrgExp_textField.setForeground(Color.BLACK);
		funOrgExp_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funOrgExp_textField.setColumns(10);
		funOrgExp_textField.setBounds(421, 132, 109, 23);
		contentPane.add(funOrgExp_textField);
		
		JLabel funTelefone_Label = new JLabel("Telefone:");
		funTelefone_Label.setForeground(Color.BLACK);
		funTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funTelefone_Label.setBounds(45, 168, 69, 28);
		contentPane.add(funTelefone_Label);
		
		funTelefone_textField = new JTextField();
		funTelefone_textField.setForeground(Color.BLACK);
		funTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funTelefone_textField.setColumns(10);
		funTelefone_textField.setBounds(112, 172, 118, 23);
		contentPane.add(funTelefone_textField);
		
		JLabel funEmail_Label = new JLabel("E-mail:");
		funEmail_Label.setForeground(Color.BLACK);
		funEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funEmail_Label.setBounds(240, 168, 51, 28);
		contentPane.add(funEmail_Label);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(292, 172, 238, 23);
		contentPane.add(textField);
		
		JLabel funSexo_Label = new JLabel("Sexo:");
		funSexo_Label.setForeground(Color.BLACK);
		funSexo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funSexo_Label.setBounds(45, 207, 40, 28);
		contentPane.add(funSexo_Label);
		
		JComboBox funSexo_comboBox = new JComboBox <> (new String [] {"Masculino", "Feminino", "Outro"});
		funSexo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funSexo_comboBox.setBounds(86, 210, 96, 23);
		contentPane.add(funSexo_comboBox);
		
		JLabel funDataN_Label = new JLabel("Data de Nascimento:");
		funDataN_Label.setForeground(Color.BLACK);
		funDataN_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funDataN_Label.setBounds(192, 206, 147, 28);
		contentPane.add(funDataN_Label);
		
		funDataN_textField = new JTextField();
		funDataN_textField.setForeground(Color.BLACK);
		funDataN_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funDataN_textField.setColumns(10);
		funDataN_textField.setBounds(342, 210, 118, 23);
		contentPane.add(funDataN_textField);
		
		JLabel funEstadoCivil_Label = new JLabel("Estado Civil:");
		funEstadoCivil_Label.setForeground(Color.BLACK);
		funEstadoCivil_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funEstadoCivil_Label.setBounds(45, 246, 88, 28);
		contentPane.add(funEstadoCivil_Label);
		
		JComboBox funEstadoCivil_comboBox = new JComboBox <> (new String [] {"Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)"});
		funEstadoCivil_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEstadoCivil_comboBox.setBounds(139, 248, 108, 23);
		contentPane.add(funEstadoCivil_comboBox);
		
		JLabel funStatusF_Label = new JLabel("Status do Funcionario:");
		funStatusF_Label.setForeground(Color.BLACK);
		funStatusF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funStatusF_Label.setBounds(251, 246, 159, 28);
		contentPane.add(funStatusF_Label);
		
		JComboBox funStatusF_comboBox = new JComboBox <> (new String [] {"Ativo", "Invativo"});
		funStatusF_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funStatusF_comboBox.setBounds(410, 248, 120, 23);
		contentPane.add(funStatusF_comboBox);
		
		JButton funCadastrar_Button = new JButton("Cadastrar");
		funCadastrar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCadastrar_Button.setBounds(453, 315, 121, 35);
		contentPane.add(funCadastrar_Button);
	}
}
