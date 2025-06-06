package com.locar.ui.editar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.locar.dados.ClienteRepositorio;
import com.locar.entidades.Cliente;
import com.locar.regras_negocio.ControladorControleAcesso;
import com.locar.ui.TelaPrincipal;

public class EditarCliente {

	private JFrame frame;
	private JTextField campoTextoCpf;
	private JTextField campoTextoNomeCompleto;
	private JTextField campoTextoDataNascimento;
	private JTextField campoTextoBairroRua;
	private JTextField campoTextoNumero;
	private JTextField campoTextoCep;
	private JTextField campoTextoCidade;
	private JTextField campoTextoTelefone;
	private JTextField campoTextoEmail;
	private JTextField campoTextoCnh;
	private JTextField campoTextoVencimentoCnh;
	private String funcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditarCliente window = new EditarCliente("ADMIN");
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
	public EditarCliente(String funcao) {
		this.funcao = funcao;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);


        JLabel textoCadastroClientes = new JLabel("Gerenciamento de Clientes");
        textoCadastroClientes.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textoCadastroClientes.setBounds(105, 0, 485, 54);
        frame.getContentPane().add(textoCadastroClientes);

        JLabel textoNomeCompleto = new JLabel("Nome completo:");
        textoNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoNomeCompleto.setBounds(10, 96, 173, 20);
        frame.getContentPane().add(textoNomeCompleto);

        JComboBox<String> campoTextoSexo = new JComboBox<>();
        campoTextoSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        campoTextoSexo.setModel(new DefaultComboBoxModel<>(new String[] {"Masculino", "Feminino", "Outro"}));
        campoTextoSexo.setBounds(423, 178, 154, 22);
        frame.getContentPane().add(campoTextoSexo);

        JComboBox<String> campoTextoEstado = new JComboBox<>();
        campoTextoEstado.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RR", "RO", "SC", "SP", "SE", "TO"}));
        campoTextoEstado.setBounds(427, 384, 150, 22);
        frame.getContentPane().add(campoTextoEstado);

        campoTextoCpf = new JTextField();
        campoTextoCpf.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
		        String cpf = campoTextoCpf.getText();
		        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		        Cliente cliente = clienteRepositorio.buscarDadosCliente(cpf);

		        campoTextoNomeCompleto.setText(cliente.getNomeCompleto());
		        campoTextoEmail.setText(cliente.getEmail());
		        campoTextoDataNascimento.setText(cliente.getDataNascimento());
		        campoTextoSexo.setSelectedItem(cliente.getSexo());
		        campoTextoCnh.setText(cliente.getCnh());
		        campoTextoVencimentoCnh.setText(cliente.getVencimentoCnh());
		        campoTextoBairroRua.setText(cliente.getBairroRua());
		        campoTextoNumero.setText(String.valueOf(cliente.getNumero()));
		        campoTextoCep.setText(cliente.getCep());
		        campoTextoCidade.setText(cliente.getCidade());
		        campoTextoEstado.setSelectedItem(cliente.getEstado());
		        campoTextoTelefone.setText(cliente.getTelefone());
		        campoTextoEmail.setText(cliente.getEmail());

        	}
        });
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
        campoTextoCpf.setBounds(243, 178, 154, 20);
        frame.getContentPane().add(campoTextoCpf);
        campoTextoCpf.setColumns(10);

        JLabel textoCpf = new JLabel("CPF:");
        textoCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCpf.setBounds(243, 156, 67, 14);
        frame.getContentPane().add(textoCpf);

        campoTextoNomeCompleto = new JTextField();
        campoTextoNomeCompleto.setColumns(10);
        campoTextoNomeCompleto.setBounds(10, 125, 567, 20);
        frame.getContentPane().add(campoTextoNomeCompleto);

        JLabel textoTelefone = new JLabel("Telefone:");
        textoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoTelefone.setBounds(10, 481, 85, 14);
        frame.getContentPane().add(textoTelefone);

        campoTextoDataNascimento = new JTextField();
        campoTextoDataNascimento.setColumns(10);
        campoTextoDataNascimento.setBounds(10, 178, 205, 20);
        frame.getContentPane().add(campoTextoDataNascimento);
        campoTextoDataNascimento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String textoDataNascimento = campoTextoDataNascimento.getText();
                textoDataNascimento = textoDataNascimento.replaceAll("[^0-9]", "");

                if (textoDataNascimento.length() >= 2) {
                    textoDataNascimento = textoDataNascimento.substring(0, 2) + "/" + textoDataNascimento.substring(2);
                }
                if (textoDataNascimento.length() >= 5) {
                    textoDataNascimento = textoDataNascimento.substring(0, 5) + "/" + textoDataNascimento.substring(5);
                }
                if (textoDataNascimento.length() >= 10) {
                    textoDataNascimento = textoDataNascimento.substring(0, 10);
                }

                campoTextoDataNascimento.setText(textoDataNascimento);
            }
        });

        JLabel TextoEmail = new JLabel("Email:");
        TextoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoEmail.setBounds(330, 481, 67, 14);
        frame.getContentPane().add(TextoEmail);

        campoTextoBairroRua = new JTextField();
        campoTextoBairroRua.setColumns(10);
        campoTextoBairroRua.setBounds(10, 329, 374, 20);
        frame.getContentPane().add(campoTextoBairroRua);

        JLabel textoSexo = new JLabel("Sexo:");
        textoSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoSexo.setBounds(427, 157, 67, 14);
        frame.getContentPane().add(textoSexo);

        JLabel textoDataNascimento = new JLabel("Data de Nascimento:");
        textoDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoDataNascimento.setBounds(10, 153, 166, 14);
        frame.getContentPane().add(textoDataNascimento);

        campoTextoNumero = new JTextField();
        campoTextoNumero.setColumns(10);
        campoTextoNumero.setBounds(427, 329, 150, 20);
        frame.getContentPane().add(campoTextoNumero);

        JLabel textoDados = new JLabel("Dados");
        textoDados.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textoDados.setBounds(10, 55, 116, 29);
        frame.getContentPane().add(textoDados);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBounds(0, 87, 684, 1);
        frame.getContentPane().add(separator);

        JLabel textoEndereco = new JLabel("Endereço");
        textoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textoEndereco.setBounds(10, 254, 154, 39);
        frame.getContentPane().add(textoEndereco);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLACK);
        separator_1.setBounds(0, 292, 684, 1);
        frame.getContentPane().add(separator_1);

        JLabel TextoBairroRua = new JLabel("Bairro e rua:");
        TextoBairroRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoBairroRua.setBounds(10, 304, 116, 14);
        frame.getContentPane().add(TextoBairroRua);

        JLabel TextoNumero = new JLabel("Número:");
        TextoNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoNumero.setBounds(427, 304, 91, 14);
        frame.getContentPane().add(TextoNumero);

        JLabel textoContato = new JLabel("Contato");
        textoContato.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textoContato.setBounds(10, 416, 116, 29);
        frame.getContentPane().add(textoContato);

        JLabel textoCep = new JLabel("CEP:");
        textoCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCep.setBounds(10, 360, 46, 14);
        frame.getContentPane().add(textoCep);

        campoTextoCep = new JTextField();
        campoTextoCep.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		String textoCep = campoTextoCep.getText();
        		textoCep = textoCep.replaceAll("[^0-9]", "");

        		if(textoCep.length() >=6) {
        			textoCep = textoCep.substring(0,6) + "-" + textoCep.substring(6);
        		}

        		if(textoCep.length() >=9) {
        			textoCep = textoCep.substring(0,9);
        		}

        		campoTextoCep.setText(textoCep);
        	}
        });
        campoTextoCep.setColumns(10);
        campoTextoCep.setBounds(10, 385, 205, 20);
        frame.getContentPane().add(campoTextoCep);

        JLabel textoCidade = new JLabel("Cidade:");
        textoCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCidade.setBounds(243, 360, 91, 14);
        frame.getContentPane().add(textoCidade);

        campoTextoCidade = new JTextField();
        campoTextoCidade.setColumns(10);
        campoTextoCidade.setBounds(243, 385, 154, 20);
        frame.getContentPane().add(campoTextoCidade);

        JLabel textoEstado = new JLabel("Estado:");
        textoEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoEstado.setBounds(427, 360, 91, 14);
        frame.getContentPane().add(textoEstado);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(Color.BLACK);
        separator_1_1.setBounds(0, 456, 694, 1);
        frame.getContentPane().add(separator_1_1);

        campoTextoTelefone = new JTextField();
        campoTextoTelefone.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		String textoTelefone = campoTextoTelefone.getText();
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

        		campoTextoTelefone.setText(textoTelefone);

        		}
        });
        campoTextoTelefone.setColumns(10);
        campoTextoTelefone.setBounds(89, 481, 205, 20);
        frame.getContentPane().add(campoTextoTelefone);

        campoTextoEmail = new JTextField();
        campoTextoEmail.setColumns(10);
        campoTextoEmail.setBounds(385, 481, 192, 20);
        frame.getContentPane().add(campoTextoEmail);

        JButton botaoCadastrar = new JButton("Editar");
        botaoCadastrar.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			String nomeCompleto = campoTextoNomeCompleto.getText();
            		String dataNascimento = campoTextoDataNascimento.getText();
            		String cpf = campoTextoCpf.getText();
            		String sexo = campoTextoSexo.getSelectedItem().toString();
            		String cnh = campoTextoCnh.getText();
            		String vencimentoCnh = campoTextoVencimentoCnh.getText();
            		String bairroRua = campoTextoBairroRua.getText();
            		int numero = Integer.parseInt(campoTextoNumero.getText());
            		String cep = campoTextoCep.getText();
            		String cidade = campoTextoCidade.getText();
            		String estado = campoTextoEstado.getSelectedItem().toString();
            		String telefone = campoTextoTelefone.getText();
            		String email = campoTextoEmail.getText();

            		ControladorControleAcesso controlador = new ControladorControleAcesso();
            		controlador.EditarCliente(nomeCompleto,dataNascimento, cpf, sexo, cnh, vencimentoCnh, bairroRua, numero, cep, cidade, estado, telefone, email);

            		JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        		} catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Erro ao editar o cliente. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

        	}
        });
        botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoCadastrar.setBounds(552, 520, 122, 34);
        frame.getContentPane().add(botaoCadastrar);

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		campoTextoNomeCompleto.setText("");
        		campoTextoDataNascimento.setText("");
        		campoTextoCpf.setText("");
        		campoTextoCnh.setText("");
        		campoTextoVencimentoCnh.setText("");
        		campoTextoBairroRua.setText("");
        		campoTextoNumero.setText("");
        		campoTextoCep.setText("");
        		campoTextoCidade.setText("");
        		campoTextoTelefone.setText("");
        		campoTextoEmail.setText("");
        	}
        });
        botaoLimpar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoLimpar.setBounds(288, 520, 122, 34);
        frame.getContentPane().add(botaoLimpar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        botaoVoltar.setBounds(10, 11, 85, 35);
        frame.getContentPane().add(botaoVoltar);

        JLabel textoCnh = new JLabel("CNH:");
        textoCnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCnh.setBounds(10, 209, 46, 14);
        frame.getContentPane().add(textoCnh);

        campoTextoCnh = new JTextField();
        campoTextoCnh.setColumns(10);
        campoTextoCnh.setBounds(10, 234, 252, 20);
        frame.getContentPane().add(campoTextoCnh);

        JLabel textoVencimentoCnh = new JLabel("Vencimento da CNH:");
        textoVencimentoCnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoVencimentoCnh.setBounds(305, 211, 180, 14);
        frame.getContentPane().add(textoVencimentoCnh);

        campoTextoVencimentoCnh = new JTextField();
        campoTextoVencimentoCnh.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		String textoVencimentoCnh = campoTextoVencimentoCnh.getText();
        		textoVencimentoCnh = textoVencimentoCnh.replaceAll("[^0-9]", "");

                if (textoVencimentoCnh.length() >= 2) {
                    textoVencimentoCnh = textoVencimentoCnh.substring(0, 2) + "/" + textoVencimentoCnh.substring(2);
                }
                if (textoVencimentoCnh.length() >= 5) {
                    textoVencimentoCnh = textoVencimentoCnh.substring(0, 5) + "/" + textoVencimentoCnh.substring(5);
                }
                if (textoVencimentoCnh.length() >= 10) {
                    textoVencimentoCnh = textoVencimentoCnh.substring(0, 10);
                }

                campoTextoVencimentoCnh.setText(textoVencimentoCnh);

        	}
        });
        campoTextoVencimentoCnh.setColumns(10);
        campoTextoVencimentoCnh.setBounds(305, 234, 272, 20);
        frame.getContentPane().add(campoTextoVencimentoCnh);

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        		String cpf = campoTextoCpf.getText();
        		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        		clienteRepositorio.excluirCliente(cpf);

        		JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    		} catch (Exception e3) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        	}
        });
        btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRemover.setBounds(420, 520, 122, 34);
        frame.getContentPane().add(btnRemover);


        botaoVoltar.addActionListener(new ActionListener() {
         @Override
		public void actionPerformed(ActionEvent e) {
			TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
			frame.dispose();
			telaPrincipal.setVisible(true);
        }
	});
	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}


}
