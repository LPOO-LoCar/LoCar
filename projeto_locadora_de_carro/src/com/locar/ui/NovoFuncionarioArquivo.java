package com.locar.ui;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoFuncionarioArquivo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FunNome_textField;
	private JTextField funCPF_textField;
	private JTextField funRG_textField;
	private JTextField funOrgExp_textField;
	private JTextField funTelefone_textField;
	private JTextField funEmail_textField;
	private JTextField funDataN_textField;
	private JTextField funDataDeExp_textField;
	private JTextField funCNH_textField;
	private JTextField funValidadeCNH_textField;
	private JTextField funCep_textField;
	private JTextField funRua_textField;
	private JTextField funNumeroRua_textField;
	private JTextField funBairro_textField;
	private JTextField funCidade_textField;
	private JTextField funComplemento_textField;
	private JTextField funSenha_textField;
	private JTextField funConfirmacaoSenha_textField;

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
		setSize(600,520);
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
		funTitulo_Label.setBounds(153, 11, 280, 35);
		contentPane.add(funTitulo_Label);
		
		JLabel funNome_Label = new JLabel("Nome:");
		funNome_Label.setForeground(new Color(0, 0, 0));
		funNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funNome_Label.setBounds(168, 81, 51, 23);
		contentPane.add(funNome_Label);
		
		FunNome_textField = new JTextField();
		FunNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FunNome_textField.setForeground(new Color(0, 0, 0));
		FunNome_textField.setBounds(217, 83, 357, 23);
		contentPane.add(FunNome_textField);
		FunNome_textField.setColumns(10);
		
		JLabel funCPF_Label = new JLabel("CPF:");
		funCPF_Label.setForeground(Color.BLACK);
		funCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCPF_Label.setBounds(20, 81, 33, 23);
		contentPane.add(funCPF_Label);
		
		funCPF_textField = new JTextField();
		funCPF_textField.setForeground(Color.BLACK);
		funCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCPF_textField.setColumns(10);
		funCPF_textField.setBounds(56, 83, 109, 23);
		contentPane.add(funCPF_textField);
		
		JLabel funRG_Label = new JLabel("RG:");
		funRG_Label.setForeground(Color.BLACK);
		funRG_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funRG_Label.setBounds(42, 141, 33, 28);
		contentPane.add(funRG_Label);
		
		funRG_textField = new JTextField();
		funRG_textField.setForeground(Color.BLACK);
		funRG_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funRG_textField.setColumns(10);
		funRG_textField.setBounds(69, 144, 109, 23);
		contentPane.add(funRG_textField);
		
		JLabel funOrgExp_Label = new JLabel("Org. Exp:");
		funOrgExp_Label.setForeground(Color.BLACK);
		funOrgExp_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funOrgExp_Label.setBounds(199, 141, 69, 28);
		contentPane.add(funOrgExp_Label);
		
		funOrgExp_textField = new JTextField();
		funOrgExp_textField.setForeground(Color.BLACK);
		funOrgExp_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funOrgExp_textField.setColumns(10);
		funOrgExp_textField.setBounds(278, 144, 74, 23);
		contentPane.add(funOrgExp_textField);
		
		JLabel funTelefone_Label = new JLabel("Telefone:");
		funTelefone_Label.setForeground(Color.BLACK);
		funTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funTelefone_Label.setBounds(20, 322, 69, 28);
		contentPane.add(funTelefone_Label);
		
		funTelefone_textField = new JTextField();
		funTelefone_textField.setForeground(Color.BLACK);
		funTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funTelefone_textField.setColumns(10);
		funTelefone_textField.setBounds(87, 325, 118, 23);
		contentPane.add(funTelefone_textField);
		
		JLabel funEmail_Label = new JLabel("E-mail:");
		funEmail_Label.setForeground(Color.BLACK);
		funEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funEmail_Label.setBounds(217, 322, 51, 28);
		contentPane.add(funEmail_Label);
		
		funEmail_textField = new JTextField();
		funEmail_textField.setForeground(Color.BLACK);
		funEmail_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEmail_textField.setColumns(10);
		funEmail_textField.setBounds(268, 325, 306, 23);
		contentPane.add(funEmail_textField);
		
		JLabel funSexo_Label = new JLabel("Sexo:");
		funSexo_Label.setForeground(Color.BLACK);
		funSexo_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funSexo_Label.setBounds(227, 111, 40, 28);
		contentPane.add(funSexo_Label);
		
		JComboBox funSexo_comboBox = new JComboBox <> (new String [] {"Masculino", "Feminino", "Outro"});
		funSexo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funSexo_comboBox.setBounds(268, 114, 96, 23);
		contentPane.add(funSexo_comboBox);
		
		JLabel funDataN_Label = new JLabel("Data de Nasc.:");
		funDataN_Label.setForeground(Color.BLACK);
		funDataN_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funDataN_Label.setBounds(20, 111, 109, 28);
		contentPane.add(funDataN_Label);
		
		funDataN_textField = new JTextField();
		funDataN_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = funDataN_textField.getText();
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
                funDataN_textField.setText(texto);
				
			}
		});
		funDataN_textField.setForeground(Color.BLACK);
		funDataN_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funDataN_textField.setColumns(10);
		funDataN_textField.setBounds(127, 114, 92, 23);
		contentPane.add(funDataN_textField);
		
		JLabel funEstadoCivil_Label = new JLabel("Estado Civil:");
		funEstadoCivil_Label.setForeground(Color.BLACK);
		funEstadoCivil_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funEstadoCivil_Label.setBounds(374, 111, 88, 28);
		contentPane.add(funEstadoCivil_Label);
		
		JComboBox funEstadoCivil_comboBox = new JComboBox <> (new String [] {"Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)"});
		funEstadoCivil_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEstadoCivil_comboBox.setBounds(466, 114, 108, 23);
		contentPane.add(funEstadoCivil_comboBox);
		
		JLabel funStatusF_Label = new JLabel("Status do Funcionario:");
		funStatusF_Label.setForeground(Color.BLACK);
		funStatusF_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funStatusF_Label.setBounds(192, 376, 159, 28);
		contentPane.add(funStatusF_Label);
		
		JComboBox funStatusF_comboBox = new JComboBox <> (new String [] {"Ativo", "Invativo"});
		funStatusF_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funStatusF_comboBox.setBounds(359, 379, 120, 23);
		contentPane.add(funStatusF_comboBox);
		
		JButton funCadastrar_Button = new JButton("Cadastrar");
		funCadastrar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCadastrar_Button.setBounds(456, 437, 121, 35);
		contentPane.add(funCadastrar_Button);
		
		JLabel funDados_Label = new JLabel("Dados do Funcionario");
		funDados_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		funDados_Label.setBounds(10, 58, 179, 24);
		contentPane.add(funDados_Label);
		
		JLabel funDataDeExp_Label = new JLabel("Data de Exp:");
		funDataDeExp_Label.setForeground(Color.BLACK);
		funDataDeExp_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funDataDeExp_Label.setBounds(359, 141, 92, 28);
		contentPane.add(funDataDeExp_Label);
		
		funDataDeExp_textField = new JTextField();
		funDataDeExp_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = funDataDeExp_textField.getText();
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
                funDataDeExp_textField.setText(texto);				
			}
		});
		
		funDataDeExp_textField.setForeground(Color.BLACK);
		funDataDeExp_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funDataDeExp_textField.setColumns(10);
		funDataDeExp_textField.setBounds(456, 144, 92, 23);
		contentPane.add(funDataDeExp_textField);
		
		JLabel funCNH_Label = new JLabel("CNH:");
		funCNH_Label.setForeground(Color.BLACK);
		funCNH_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCNH_Label.setBounds(71, 171, 40, 28);
		contentPane.add(funCNH_Label);
		
		funCNH_textField = new JTextField();
		funCNH_textField.setForeground(Color.BLACK);
		funCNH_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCNH_textField.setColumns(10);
		funCNH_textField.setBounds(110, 174, 109, 23);
		contentPane.add(funCNH_textField);
		
		JLabel funValidadeCNH_Label = new JLabel("Data de Validade:");
		funValidadeCNH_Label.setForeground(Color.BLACK);
		funValidadeCNH_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funValidadeCNH_Label.setBounds(227, 171, 130, 28);
		contentPane.add(funValidadeCNH_Label);
		
		funValidadeCNH_textField = new JTextField();
		funValidadeCNH_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = funValidadeCNH_textField.getText();
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
                funValidadeCNH_textField.setText(texto);
				
			}
		});
		funValidadeCNH_textField.setForeground(Color.BLACK);
		funValidadeCNH_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funValidadeCNH_textField.setColumns(10);
		funValidadeCNH_textField.setBounds(359, 174, 92, 23);
		contentPane.add(funValidadeCNH_textField);
		
		JLabel funEndereço_Label = new JLabel("Endereço");
		funEndereço_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		funEndereço_Label.setBounds(10, 199, 82, 24);
		contentPane.add(funEndereço_Label);
		
		JLabel funCEP_Label = new JLabel("CEP:");
		funCEP_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCEP_Label.setBounds(20, 223, 39, 26);
		contentPane.add(funCEP_Label);
		
		funCep_textField = new JTextField();
		funCep_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCep_textField.setColumns(10);
		funCep_textField.setBounds(56, 224, 126, 23);
		contentPane.add(funCep_textField);
		
		JLabel funRua_Label = new JLabel("Rua:");
		funRua_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funRua_Label.setBounds(192, 223, 39, 26);
		contentPane.add(funRua_Label);
		
		funRua_textField = new JTextField();
		funRua_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funRua_textField.setColumns(10);
		funRua_textField.setBounds(227, 224, 221, 23);
		contentPane.add(funRua_textField);
		
		JLabel funNumeroRua_Label = new JLabel("Nº:");
		funNumeroRua_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funNumeroRua_Label.setBounds(453, 222, 27, 26);
		contentPane.add(funNumeroRua_Label);
		
		funNumeroRua_textField = new JTextField();
		funNumeroRua_textField.setColumns(10);
		funNumeroRua_textField.setBounds(482, 224, 55, 23);
		contentPane.add(funNumeroRua_textField);
		
		JLabel funBairro_Label = new JLabel("Bairro:");
		funBairro_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funBairro_Label.setBounds(41, 253, 51, 26);
		contentPane.add(funBairro_Label);
		
		funBairro_textField = new JTextField();
		funBairro_textField.setColumns(10);
		funBairro_textField.setBounds(95, 255, 124, 23);
		contentPane.add(funBairro_textField);
		
		JLabel funCidade_Label = new JLabel("Cidade:");
		funCidade_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funCidade_Label.setBounds(225, 253, 55, 26);
		contentPane.add(funCidade_Label);
		
		funCidade_textField = new JTextField();
		funCidade_textField.setColumns(10);
		funCidade_textField.setBounds(287, 255, 124, 23);
		contentPane.add(funCidade_textField);
		
		JLabel funEstado_Label = new JLabel("Estado:");
		funEstado_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funEstado_Label.setBounds(421, 253, 55, 26);
		contentPane.add(funEstado_Label);
		
		JComboBox funEstado_comboBox = new JComboBox <> (new String [] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RR", "RO", "SC", "SP", "SE", "TO"});
		funEstado_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEstado_comboBox.setBounds(482, 255, 55, 22);
		contentPane.add(funEstado_comboBox);
		
		JLabel complemento_Label = new JLabel("Complemento:");
		complemento_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		complemento_Label.setBounds(137, 283, 108, 26);
		contentPane.add(complemento_Label);
		
		funComplemento_textField = new JTextField();
		funComplemento_textField.setColumns(10);
		funComplemento_textField.setBounds(246, 285, 176, 23);
		contentPane.add(funComplemento_textField);
		
		JLabel funContatos_Label = new JLabel("Contatos");
		funContatos_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		funContatos_Label.setBounds(10, 303, 82, 24);
		contentPane.add(funContatos_Label);
		
		JLabel funStatus_Label = new JLabel("Status");
		funStatus_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		funStatus_Label.setBounds(10, 359, 55, 24);
		contentPane.add(funStatus_Label);
		
		JLabel funFuncao_Label = new JLabel("Função:");
		funFuncao_Label.setForeground(Color.BLACK);
		funFuncao_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funFuncao_Label.setBounds(20, 376, 62, 28);
		contentPane.add(funFuncao_Label);
		
		JComboBox funFuncao_comboBox = new JComboBox <> (new String [] {"Gerente", "Funcionário"});
		funFuncao_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funFuncao_comboBox.setBounds(82, 379, 96, 23);
		contentPane.add(funFuncao_comboBox);
		
		JLabel funSenha_Label = new JLabel("Senha:");
		funSenha_Label.setForeground(Color.BLACK);
		funSenha_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funSenha_Label.setBounds(20, 406, 51, 28);
		contentPane.add(funSenha_Label);
		
		funSenha_textField = new JTextField();
		funSenha_textField.setForeground(Color.BLACK);
		funSenha_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funSenha_textField.setColumns(10);
		funSenha_textField.setBounds(69, 409, 96, 23);
		contentPane.add(funSenha_textField);
		
		JLabel funConfirmacaoSenha_Label = new JLabel("Confirmação de Senha:");
		funConfirmacaoSenha_Label.setForeground(Color.BLACK);
		funConfirmacaoSenha_Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funConfirmacaoSenha_Label.setBounds(168, 406, 165, 28);
		contentPane.add(funConfirmacaoSenha_Label);
		
		funConfirmacaoSenha_textField = new JTextField();
		funConfirmacaoSenha_textField.setForeground(Color.BLACK);
		funConfirmacaoSenha_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funConfirmacaoSenha_textField.setColumns(10);
		funConfirmacaoSenha_textField.setBounds(337, 409, 96, 23);
		contentPane.add(funConfirmacaoSenha_textField);
		
		JButton funLimpar_Button = new JButton("Limpar");
		funLimpar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funLimpar_Button.setBounds(10, 437, 121, 35);
		contentPane.add(funLimpar_Button);
		
		JButton funVoltar_Button = new JButton("Voltar");
		funVoltar_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		funVoltar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		funVoltar_Button.setBounds(10, 11, 92, 23);
		contentPane.add(funVoltar_Button);
	}
}
