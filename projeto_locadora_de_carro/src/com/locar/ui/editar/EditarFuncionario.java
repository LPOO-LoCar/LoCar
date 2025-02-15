package com.locar.ui.editar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.locar.dados.Repositorio;
import com.locar.entidades.Funcionario;
import com.locar.regras_negocio.ControladorControleAcesso;
import com.locar.regras_negocio.FuncionarioRegras;
import com.locar.ui.TelaPrincipal;
import javax.swing.JSeparator;

public class EditarFuncionario extends JFrame {

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
					EditarFuncionario frame = new EditarFuncionario();
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
	public EditarFuncionario() {
		setTitle("Novo Funcionário");
		setSize(700,710);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel funTitulo_Label = new JLabel("Gerenciamento de Funcionários");
		funTitulo_Label.setForeground(new Color(0, 0, 0));
		funTitulo_Label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		funTitulo_Label.setBounds(132, 9, 423, 35);
		contentPane.add(funTitulo_Label);
		
		JLabel funNome_Label = new JLabel("Nome Completo:");
		funNome_Label.setForeground(new Color(0, 0, 0));
		funNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funNome_Label.setBounds(10, 96, 168, 23);
		contentPane.add(funNome_Label);
		
		FunNome_textField = new JTextField();
		FunNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FunNome_textField.setForeground(new Color(0, 0, 0));
		FunNome_textField.setBounds(10, 125, 253, 20);
		contentPane.add(FunNome_textField);
		FunNome_textField.setColumns(10);
		
		JLabel funCPF_Label = new JLabel("CPF:");
		funCPF_Label.setForeground(Color.BLACK);
		funCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funCPF_Label.setBounds(300, 97, 52, 23);
		contentPane.add(funCPF_Label);
		
		funCPF_textField = new JTextField();
		funCPF_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = funCPF_textField.getText();
				Repositorio repositorio = new Repositorio();
				Funcionario funcionario = repositorio.buscarDadosFuncionario(cpf);
				
			    FunNome_textField.setText(funcionario.getNome());
			    funRG_textField.setText(funcionario.getRg());
			    funOrgExp_textField.setText(funcionario.getOrgExp());
			    funTelefone_textField.setText(funcionario.getTelefone());
			    funEmail_textField.setText(funcionario.getEmail());
			    funDataN_textField.setText(funcionario.getDataNascimento());
			    funDataDeExp_textField.setText(funcionario.getDataExp());
			    funCNH_textField.setText(funcionario.getCnh());
			    funValidadeCNH_textField.setText(funcionario.getValidadeCNH());
			    funCep_textField.setText(funcionario.getCep());
			    funRua_textField.setText(funcionario.getRua());
			    funNumeroRua_textField.setText(funcionario.getNumeroRua());
			    funBairro_textField.setText(funcionario.getBairro());
			    funCidade_textField.setText(funcionario.getCidade());
			    funComplemento_textField.setText(funcionario.getComplemento());
			    funSenha_textField.setText(funcionario.getSenha());
			    funConfirmacaoSenha_textField.setText(funcionario.getSenha());
				
			}
		});
		funCPF_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String textoCpf = funCPF_textField.getText();
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
        		
        		funCPF_textField.setText(textoCpf);
			}
		});
		funCPF_textField.setForeground(Color.BLACK);
		funCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCPF_textField.setColumns(10);
		funCPF_textField.setBounds(300, 125, 242, 20);
		contentPane.add(funCPF_textField);
		
		JLabel funRG_Label = new JLabel("RG:");
		funRG_Label.setForeground(Color.BLACK);
		funRG_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funRG_Label.setBounds(10, 205, 33, 28);
		contentPane.add(funRG_Label);
		
		funRG_textField = new JTextField();
		funRG_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String textoRg = funRG_textField.getText();
        		textoRg = textoRg.replaceAll("[^0-9]", ""); 
        		
        		if (textoRg.length() >= 2) {
        			textoRg = textoRg.substring(0,2) + "." + textoRg.substring(2);
        		}
        		if (textoRg.length() >= 6) {
        			textoRg = textoRg.substring(0,6) + "." + textoRg.substring(6);
        		}
        		
        		if (textoRg.length() >= 10) {
        			textoRg = textoRg.substring(0,10);
        		}
        		
        		funRG_textField.setText(textoRg);
				
			}
		});
		funRG_textField.setForeground(Color.BLACK);
		funRG_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funRG_textField.setColumns(10);
		funRG_textField.setBounds(10, 235, 152, 20);
		contentPane.add(funRG_textField);
		
		JLabel funOrgExp_Label = new JLabel("Org. Exp:");
		funOrgExp_Label.setForeground(Color.BLACK);
		funOrgExp_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funOrgExp_Label.setBounds(199, 205, 82, 28);
		contentPane.add(funOrgExp_Label);
		
		funOrgExp_textField = new JTextField();
		funOrgExp_textField.setForeground(Color.BLACK);
		funOrgExp_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funOrgExp_textField.setColumns(10);
		funOrgExp_textField.setBounds(199, 235, 153, 20);
		contentPane.add(funOrgExp_textField);
		
		JLabel funTelefone_Label = new JLabel("Telefone:");
		funTelefone_Label.setForeground(Color.BLACK);
		funTelefone_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funTelefone_Label.setBounds(10, 490, 90, 28);
		contentPane.add(funTelefone_Label);
		
		funTelefone_textField = new JTextField();
		funTelefone_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
        		String textoTelefone = funTelefone_textField.getText();
        		textoTelefone = textoTelefone.replaceAll("[^0-9]", "");
        		
        		if (textoTelefone.length() >=1) {
        			textoTelefone = "(" + textoTelefone.substring(0);
        		}
        		if (textoTelefone.length() >=3) {
        			textoTelefone = textoTelefone.substring(0, 3) + ")" + textoTelefone.substring(3);
        		}
        		
        		if (textoTelefone.length() >=4) {
        			textoTelefone = textoTelefone.substring(0, 4) + " " + textoTelefone.substring(4);
        		}
        		
        		if (textoTelefone.length() >=10) {
        			textoTelefone = textoTelefone.substring(0, 10) + "-" + textoTelefone.substring(10);
        		}
        		
        		if (textoTelefone.length() >=15) {
        			textoTelefone = textoTelefone.substring(0, 15);
        		}
        		
        		funTelefone_textField.setText(textoTelefone);
			}
		});
		funTelefone_textField.setForeground(Color.BLACK);
		funTelefone_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funTelefone_textField.setColumns(10);
		funTelefone_textField.setBounds(10, 520, 244, 20);
		contentPane.add(funTelefone_textField);
		
		JLabel funEmail_Label = new JLabel("E-mail:");
		funEmail_Label.setForeground(Color.BLACK);
		funEmail_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funEmail_Label.setBounds(300, 490, 69, 28);
		contentPane.add(funEmail_Label);
		
		funEmail_textField = new JTextField();
		funEmail_textField.setForeground(Color.BLACK);
		funEmail_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEmail_textField.setColumns(10);
		funEmail_textField.setBounds(300, 520, 242, 20);
		contentPane.add(funEmail_textField);
		
		JLabel funSexo_Label = new JLabel("Sexo:");
		funSexo_Label.setForeground(Color.BLACK);
		funSexo_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funSexo_Label.setBounds(199, 150, 55, 28);
		contentPane.add(funSexo_Label);
		
		JComboBox funSexo_comboBox = new JComboBox <> (new String [] {"Masculino", "Feminino", "Outro"});
		funSexo_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funSexo_comboBox.setBounds(199, 180, 153, 20);
		contentPane.add(funSexo_comboBox);
		
		JLabel funDataN_Label = new JLabel("Data de Nasc.:");
		funDataN_Label.setForeground(Color.BLACK);
		funDataN_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funDataN_Label.setBounds(10, 150, 137, 28);
		contentPane.add(funDataN_Label);
		
		funDataN_textField = new JTextField();
		funDataN_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = funDataN_textField.getText();
                texto = texto.replaceAll("[^0-9]", ""); 

                
                if (texto.length() >= 2) {
                    texto = texto.substring(0, 2) + "/" + texto.substring(2);
                }
                if (texto.length() >= 5) {
                    texto = texto.substring(0, 5) + "/" + texto.substring(5);
                }
     
                if (texto.length() >= 10) {
                    texto = texto.substring(0, 10);
                }
                funDataN_textField.setText(texto);
				
			}
		});
		funDataN_textField.setForeground(Color.BLACK);
		funDataN_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funDataN_textField.setColumns(10);
		funDataN_textField.setBounds(10, 178, 152, 20);
		contentPane.add(funDataN_textField);
		
		JLabel funEstadoCivil_Label = new JLabel("Estado Civil:");
		funEstadoCivil_Label.setForeground(Color.BLACK);
		funEstadoCivil_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funEstadoCivil_Label.setBounds(393, 150, 111, 28);
		contentPane.add(funEstadoCivil_Label);
		
		JComboBox funEstadoCivil_comboBox = new JComboBox <> (new String [] {"Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)"});
		funEstadoCivil_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funEstadoCivil_comboBox.setBounds(393, 180, 149, 20);
		contentPane.add(funEstadoCivil_comboBox);
		
		JLabel funStatusF_Label = new JLabel("Status:");
		funStatusF_Label.setForeground(Color.BLACK);
		funStatusF_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funStatusF_Label.setBounds(300, 545, 62, 28);
		contentPane.add(funStatusF_Label);
		
		JComboBox funStatusF_comboBox = new JComboBox <> (new String [] {"Ativo", "Invativo"});
		funStatusF_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funStatusF_comboBox.setBounds(370, 551, 120, 23);
		contentPane.add(funStatusF_comboBox);
		
		JButton funCadastrar_Button = new JButton("Editar");
		funCadastrar_Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		funCadastrar_Button.setBounds(553, 625, 121, 35);
		funCadastrar_Button.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				try {
			        String nome = FunNome_textField.getText();
			        String cpf = funCPF_textField.getText();
			        String rg = funRG_textField.getText();
			        String orgExp = funOrgExp_textField.getText();
			        String telefone = funTelefone_textField.getText();
			        String email = funEmail_textField.getText();
			        String dataNascimento = funDataN_textField.getText();
			        String dataExp = funDataDeExp_textField.getText();
			        String cnh = funCNH_textField.getText();
			        String validadeCNH = funValidadeCNH_textField.getText();
			        String cep = funCep_textField.getText();
			        String rua = funRua_textField.getText();
			        String numeroRua = funNumeroRua_textField.getText();
			        String bairro = funBairro_textField.getText();
			        String cidade = funCidade_textField.getText();
			        String complemento = funComplemento_textField.getText();
			        String senha = funSenha_textField.getText();
			        
			        ControladorControleAcesso controlador = new ControladorControleAcesso();
			        controlador.editarFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh,
                validadeCNH, cep, rua, numeroRua, bairro, cidade, complemento, senha);
			        
				JOptionPane.showMessageDialog(null, "Funcionario editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1){
					JOptionPane.showMessageDialog(null, "Erro ao editar", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(funCadastrar_Button);
		
		JLabel funDados_Label = new JLabel("Dados ");
		funDados_Label.setFont(new Font("Tahoma", Font.BOLD, 30));
		funDados_Label.setBounds(10, 55, 179, 24);
		contentPane.add(funDados_Label);
		
		JLabel funDataDeExp_Label = new JLabel("Data de Exp:");
		funDataDeExp_Label.setForeground(Color.BLACK);
		funDataDeExp_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funDataDeExp_Label.setBounds(393, 205, 111, 28);
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
		funDataDeExp_textField.setBounds(393, 235, 149, 20);
		contentPane.add(funDataDeExp_textField);
		
		JLabel funCNH_Label = new JLabel("CNH:");
		funCNH_Label.setForeground(Color.BLACK);
		funCNH_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funCNH_Label.setBounds(10, 260, 51, 28);
		contentPane.add(funCNH_Label);
		
		funCNH_textField = new JTextField();
		funCNH_textField.setForeground(Color.BLACK);
		funCNH_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCNH_textField.setColumns(10);
		funCNH_textField.setBounds(10, 290, 152, 20);
		contentPane.add(funCNH_textField);
		
		JLabel funValidadeCNH_Label = new JLabel("Data de Validade:");
		funValidadeCNH_Label.setForeground(Color.BLACK);
		funValidadeCNH_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funValidadeCNH_Label.setBounds(199, 260, 153, 28);
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
		funValidadeCNH_textField.setBounds(199, 290, 153, 20);
		contentPane.add(funValidadeCNH_textField);
		
		JLabel funEndereço_Label = new JLabel("Endereço");
		funEndereço_Label.setFont(new Font("Tahoma", Font.BOLD, 30));
		funEndereço_Label.setBounds(10, 311, 190, 35);
		contentPane.add(funEndereço_Label);
		
		JLabel funCEP_Label = new JLabel("CEP:");
		funCEP_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funCEP_Label.setBounds(10, 346, 39, 26);
		contentPane.add(funCEP_Label);
		
		funCep_textField = new JTextField();
		funCep_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
        		String textoCep = funCep_textField.getText();
        		textoCep = textoCep.replaceAll("[^0-9]", ""); 
        		
        		if(textoCep.length() >=6) {
        			textoCep = textoCep.substring(0,6) + "-" + textoCep.substring(6);
        		}
        		
        		if(textoCep.length() >=9) {
        			textoCep = textoCep.substring(0,9);
        		}
        		
        		funCep_textField.setText(textoCep);
			}
		});
		funCep_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funCep_textField.setColumns(10);
		funCep_textField.setBounds(10, 375, 152, 20);
		contentPane.add(funCep_textField);
		
		JLabel funRua_Label = new JLabel("Rua:");
		funRua_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funRua_Label.setBounds(199, 346, 39, 26);
		contentPane.add(funRua_Label);
		
		funRua_textField = new JTextField();
		funRua_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funRua_textField.setColumns(10);
		funRua_textField.setBounds(199, 375, 153, 20);
		contentPane.add(funRua_textField);
		
		JLabel funNumeroRua_Label = new JLabel("Nº:");
		funNumeroRua_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funNumeroRua_Label.setBounds(393, 346, 27, 26);
		contentPane.add(funNumeroRua_Label);
		
		funNumeroRua_textField = new JTextField();
		funNumeroRua_textField.setColumns(10);
		funNumeroRua_textField.setBounds(393, 375, 149, 20);
		contentPane.add(funNumeroRua_textField);
		
		JLabel funBairro_Label = new JLabel("Bairro:");
		funBairro_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funBairro_Label.setBounds(10, 405, 69, 26);
		contentPane.add(funBairro_Label);
		
		funBairro_textField = new JTextField();
		funBairro_textField.setColumns(10);
		funBairro_textField.setBounds(10, 435, 124, 20);
		contentPane.add(funBairro_textField);
		
		JLabel funCidade_Label = new JLabel("Cidade:");
		funCidade_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funCidade_Label.setBounds(199, 405, 82, 26);
		contentPane.add(funCidade_Label);
		
		funCidade_textField = new JTextField();
		funCidade_textField.setColumns(10);
		funCidade_textField.setBounds(199, 435, 124, 20);
		contentPane.add(funCidade_textField);
		
		JLabel funEstado_Label = new JLabel("Estado:");
		funEstado_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funEstado_Label.setBounds(393, 405, 81, 26);
		contentPane.add(funEstado_Label);
		
		JComboBox funEstado_comboBox = new JComboBox <> (new String [] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RR", "RO", "SC", "SP", "SE", "TO"});
		funEstado_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funEstado_comboBox.setBounds(393, 435, 55, 20);
		contentPane.add(funEstado_comboBox);
		
		JLabel complemento_Label = new JLabel("Complemento:");
		complemento_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		complemento_Label.setBounds(484, 406, 137, 26);
		contentPane.add(complemento_Label);
		
		funComplemento_textField = new JTextField();
		funComplemento_textField.setColumns(10);
		funComplemento_textField.setBounds(484, 435, 168, 20);
		contentPane.add(funComplemento_textField);
		
		JLabel funContatos_Label = new JLabel("Contatos e Status");
		funContatos_Label.setFont(new Font("Tahoma", Font.BOLD, 30));
		funContatos_Label.setBounds(10, 460, 302, 24);
		contentPane.add(funContatos_Label);
		
		JLabel funFuncao_Label = new JLabel("Função:");
		funFuncao_Label.setForeground(Color.BLACK);
		funFuncao_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funFuncao_Label.setBounds(10, 545, 62, 28);
		contentPane.add(funFuncao_Label);
		
		JComboBox funFuncao_comboBox = new JComboBox <> (new String [] {"Gerente", "Funcionário"});
		funFuncao_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funFuncao_comboBox.setBounds(82, 551, 96, 23);
		contentPane.add(funFuncao_comboBox);
		
		JLabel funSenha_Label = new JLabel("Senha:");
		funSenha_Label.setForeground(Color.BLACK);
		funSenha_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funSenha_Label.setBounds(10, 584, 69, 28);
		contentPane.add(funSenha_Label);
		
		funSenha_textField = new JTextField();
		funSenha_textField.setForeground(Color.BLACK);
		funSenha_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funSenha_textField.setColumns(10);
		funSenha_textField.setBounds(82, 590, 149, 20);
		contentPane.add(funSenha_textField);
		
		JLabel funConfirmacaoSenha_Label = new JLabel("Confirmação de Senha:");
		funConfirmacaoSenha_Label.setForeground(Color.BLACK);
		funConfirmacaoSenha_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		funConfirmacaoSenha_Label.setBounds(300, 584, 190, 28);
		contentPane.add(funConfirmacaoSenha_Label);
		
		funConfirmacaoSenha_textField = new JTextField();
		funConfirmacaoSenha_textField.setForeground(Color.BLACK);
		funConfirmacaoSenha_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		funConfirmacaoSenha_textField.setColumns(10);
		funConfirmacaoSenha_textField.setBounds(491, 589, 161, 20);
		contentPane.add(funConfirmacaoSenha_textField);
		
		JButton funLimpar_Button = new JButton("Limpar");
		funLimpar_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        FunNome_textField.setText("");
		        funCPF_textField.setText("");
		        funRG_textField.setText("");
		        funOrgExp_textField.setText("");
		        funTelefone_textField.setText("");
		        funEmail_textField.setText("");
		        funDataN_textField.setText("");
		        funDataDeExp_textField.setText("");
		        funCNH_textField.setText("");
		        funValidadeCNH_textField.setText("");
		        funCep_textField.setText("");
		        funRua_textField.setText("");
		        funNumeroRua_textField.setText("");
		        funBairro_textField.setText("");
		        funCidade_textField.setText("");
		        funComplemento_textField.setText("");
		        funSenha_textField.setText("");
		        funConfirmacaoSenha_textField.setText("");
				
			}
		});
		funLimpar_Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		funLimpar_Button.setBounds(289, 625, 121, 35);
		contentPane.add(funLimpar_Button);
		
		JButton funVoltar_Button = new JButton("Voltar");
		funVoltar_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		funVoltar_Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		funVoltar_Button.setBounds(10, 12, 103, 35);
		contentPane.add(funVoltar_Button);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 85, 684, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(-10, 346, 694, 1);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(0, 489, 694, 1);
		contentPane.add(separator_1_1);
		
		JButton funCadastrar_Button_1 = new JButton("Remover");
		funCadastrar_Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		try {
        		String cpf = funCPF_textField.getText();
        		Repositorio repositorio = new Repositorio();
        		repositorio.excluirFuncionario(cpf);
        		
        		JOptionPane.showMessageDialog(null, "Funcionario excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    		} catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro", JOptionPane.ERROR_MESSAGE);
            }
			}
		});
		funCadastrar_Button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		funCadastrar_Button_1.setBounds(421, 624, 121, 35);
		contentPane.add(funCadastrar_Button_1);
	}
	
	private void cadastrarFuncionario() {
        // Captura os dados dos campos
        String nome = FunNome_textField.getText();
        String cpf = funCPF_textField.getText();
        String rg = funRG_textField.getText();
        String orgExp = funOrgExp_textField.getText();
        String telefone = funTelefone_textField.getText();
        String email = funEmail_textField.getText();
        String dataNascimento = funDataN_textField.getText();
        String dataExp = funDataDeExp_textField.getText();
        String cnh = funCNH_textField.getText();
        String validadeCNH = funValidadeCNH_textField.getText();
        String cep = funCep_textField.getText();
        String rua = funRua_textField.getText();
        String numeroRua = funNumeroRua_textField.getText();
        String bairro = funBairro_textField.getText();
        String cidade = funCidade_textField.getText();
        String complemento = funComplemento_textField.getText();
        String senha = funSenha_textField.getText();
        String confirmacaoSenha = funConfirmacaoSenha_textField.getText();

        // Chama a camada de regras de negócio
        FuncionarioRegras regras = new FuncionarioRegras();
        regras.cadastrarFuncionario(nome, cpf, rg, orgExp, telefone, email, dataNascimento, dataExp, cnh, validadeCNH,
                cep, rua, numeroRua, bairro, cidade, complemento, senha, confirmacaoSenha);
    }
}
