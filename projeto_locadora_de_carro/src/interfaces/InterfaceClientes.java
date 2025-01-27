package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

import dados.Cliente;

public class InterfaceClientes {

	private JFrame frame;
	private JTextField campoTextoCpf;
	private JTextField campoTextoNomeCompleto;
	private JTextField campoTextoDataNascimento;
	private JTextField campoTextoBairroRua;
	private JTextField campoTextoNumero;
	private JTextField campoTextoCep;
	private JTextField campoTextoCidade;
	private JTextField campoTextoEstado;
	private JTextField campoTextoTelefone;
	private JTextField campoTextoEmail;

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
		
		
        JLabel textoCadastroClientes = new JLabel("Cadastro de Clientes");
        textoCadastroClientes.setFont(new Font("Tahoma", Font.PLAIN, 44));
        textoCadastroClientes.setBounds(131, -20, 422, 97);
        frame.getContentPane().add(textoCadastroClientes);
        
        JLabel textoNomeCompleto = new JLabel("Nome completo:");
        textoNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoNomeCompleto.setBounds(10, 96, 173, 20);
        frame.getContentPane().add(textoNomeCompleto);
        
        campoTextoCpf = new JTextField();
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
        textoTelefone.setBounds(10, 436, 85, 14);
        frame.getContentPane().add(textoTelefone);
        
        campoTextoDataNascimento = new JTextField();
        campoTextoDataNascimento.setColumns(10);
        campoTextoDataNascimento.setBounds(10, 178, 205, 20);
        frame.getContentPane().add(campoTextoDataNascimento);
        
        JLabel TextoEmail = new JLabel("Email:");
        TextoEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoEmail.setBounds(325, 436, 67, 14);
        frame.getContentPane().add(TextoEmail);
        
        campoTextoBairroRua = new JTextField();
        campoTextoBairroRua.setColumns(10);
        campoTextoBairroRua.setBounds(10, 291, 374, 20);
        frame.getContentPane().add(campoTextoBairroRua);
        
        JLabel textoSexo = new JLabel("Sexo:");
        textoSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoSexo.setBounds(427, 157, 67, 14);
        frame.getContentPane().add(textoSexo);
        
        JComboBox campoTextoSexo = new JComboBox();
        campoTextoSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        campoTextoSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
        campoTextoSexo.setBounds(423, 178, 154, 22);
        frame.getContentPane().add(campoTextoSexo);
        
        JLabel textoDataNascimento = new JLabel("Data de Nascimento:");
        textoDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoDataNascimento.setBounds(10, 153, 166, 14);
        frame.getContentPane().add(textoDataNascimento);
        
        campoTextoNumero = new JTextField();
        campoTextoNumero.setColumns(10);
        campoTextoNumero.setBounds(427, 291, 150, 20);
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
        textoEndereco.setBounds(10, 209, 154, 29);
        frame.getContentPane().add(textoEndereco);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLACK);
        separator_1.setBounds(0, 246, 684, 1);
        frame.getContentPane().add(separator_1);
        
        JLabel TextoBairroRua = new JLabel("Bairro e rua:");
        TextoBairroRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoBairroRua.setBounds(10, 261, 116, 14);
        frame.getContentPane().add(TextoBairroRua);
        
        JLabel TextoNumero = new JLabel("Número:");
        TextoNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextoNumero.setBounds(423, 261, 91, 14);
        frame.getContentPane().add(TextoNumero);
        
        JLabel textoContato = new JLabel("Contato");
        textoContato.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textoContato.setBounds(10, 378, 116, 29);
        frame.getContentPane().add(textoContato);
        
        JLabel textoCep = new JLabel("CEP:");
        textoCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCep.setBounds(10, 322, 46, 14);
        frame.getContentPane().add(textoCep);
        
        campoTextoCep = new JTextField();
        campoTextoCep.setColumns(10);
        campoTextoCep.setBounds(10, 347, 205, 20);
        frame.getContentPane().add(campoTextoCep);
        
        JLabel textoCidade = new JLabel("Cidade:");
        textoCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoCidade.setBounds(242, 322, 91, 14);
        frame.getContentPane().add(textoCidade);
        
        campoTextoCidade = new JTextField();
        campoTextoCidade.setColumns(10);
        campoTextoCidade.setBounds(243, 347, 154, 20);
        frame.getContentPane().add(campoTextoCidade);
        
        JLabel textoEstado = new JLabel("Estado:");
        textoEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textoEstado.setBounds(423, 322, 91, 14);
        frame.getContentPane().add(textoEstado);
        
        campoTextoEstado = new JTextField();
        campoTextoEstado.setColumns(10);
        campoTextoEstado.setBounds(423, 347, 154, 20);
        frame.getContentPane().add(campoTextoEstado);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(Color.BLACK);
        separator_1_1.setBounds(0, 413, 694, 1);
        frame.getContentPane().add(separator_1_1);
        
        campoTextoTelefone = new JTextField();
        campoTextoTelefone.setColumns(10);
        campoTextoTelefone.setBounds(92, 436, 205, 20);
        frame.getContentPane().add(campoTextoTelefone);
        
        campoTextoEmail = new JTextField();
        campoTextoEmail.setColumns(10);
        campoTextoEmail.setBounds(385, 435, 192, 20);
        frame.getContentPane().add(campoTextoEmail);
        
        JButton butaoCadastrar = new JButton("Cadastrar");
        butaoCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cliente cliente = new Cliente();
        		cliente.setId(1);
        		cliente.setNome(campoTextoNomeCompleto.getText());
        		cliente.setDataNascimento(campoTextoDataNascimento.getText());
        		cliente.setCpf(campoTextoCpf.getText());
        		cliente.setSexo(campoTextoSexo.getSelectedItem().toString());
        		cliente.setBairroRua(campoTextoBairroRua.getText());
        		cliente.setNumero(Integer.parseInt(campoTextoNumero.getText()));
        		cliente.setCep(campoTextoCep.getText());
        		cliente.setCidade(campoTextoCidade.getText());
        		cliente.setEstado(campoTextoEstado.getText());
        		cliente.setTelefone(campoTextoTelefone.getText());
        		cliente.setEmail(campoTextoEmail.getText());
        		
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/locadora_de_carro", "root", "192815Math@");
        			String sql = "INSERT INTO cliente (id, nome, dataNascimento, cpf, sexo, bairroRua, numero, cep, cidade, estado, telefone, email) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        			PreparedStatement pstmt = connection.prepareStatement(sql);
        			
                    pstmt.setInt(1, cliente.getId());
                    pstmt.setString(2, cliente.getNome());
                    pstmt.setString(3, cliente.getDataNascimento());
                    pstmt.setString(4, cliente.getCpf());
                    pstmt.setString(5, cliente.getSexo());
                    pstmt.setString(6, cliente.getBairroRua());
                    pstmt.setInt(7, cliente.getNumero());
                    pstmt.setString(8, cliente.getCep());
                    pstmt.setString(9, cliente.getCidade());
                    pstmt.setString(10, cliente.getEstado());
                    pstmt.setString(11, cliente.getTelefone());
                    pstmt.setString(12, cliente.getEmail());
                    
                    int rowsAffected = pstmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente.");
                    }
                    

        		} catch (Exception e1){
        			// A fazer	
        		}    		
        	}
        });
        butaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        butaoCadastrar.setBounds(407, 470, 122, 34);
        frame.getContentPane().add(butaoCadastrar);
        
        JButton butaoLimpar = new JButton("Limpar");
        butaoLimpar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        butaoLimpar.setBounds(552, 471, 122, 34);
        frame.getContentPane().add(butaoLimpar);
        
        JButton butaoVoltar = new JButton("Voltar");
        butaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        butaoVoltar.setBounds(10, 11, 97, 33);
        frame.getContentPane().add(butaoVoltar);
        butaoVoltar.addActionListener(new ActionListener() {
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
    
