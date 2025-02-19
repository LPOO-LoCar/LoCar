package com.locar.ui.buscar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.locar.dados.Repositorio;
import com.locar.entidades.*;
import com.locar.ui.TelaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;

public class BuscarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField locCPF_textField;
	private JTextField locNome_textField;
	private JTable tabela;
	private DefaultTableModel modelo;
	private JPanel contentPane;
	private String funcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente frame = new BuscarCliente("ADMIN");
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
	public BuscarFuncionario(String funcao) {
		this.funcao = funcao;
		setTitle("Buscar Cliente");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busca de funcionários");
		lblNewLabel.setBounds(162, 11, 408, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblNewLabel);
		
		JLabel locCPF_Label = new JLabel("CPF:");
		locCPF_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locCPF_Label.setBounds(10, 86, 67, 28);
		contentPane.add(locCPF_Label);
		
		locCPF_textField = new JTextField();
		locCPF_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
        		String textoCpf = locCPF_textField.getText();
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
        		
        		locCPF_textField.setText(textoCpf);
			}
		});
		locCPF_textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		locCPF_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locCPF_textField.setColumns(10);
		locCPF_textField.setBounds(10, 115, 284, 20);
		contentPane.add(locCPF_textField);
		
		JLabel locNome_Label = new JLabel("Nome:");
		locNome_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locNome_Label.setBounds(467, 86, 67, 28);
		contentPane.add(locNome_Label);
		
		locNome_textField = new JTextField();
		locNome_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locNome_textField.setColumns(10);
		locNome_textField.setBounds(467, 115, 307, 20);
		contentPane.add(locNome_textField);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String cpf = locCPF_textField.getText().trim();
		        String nome = locNome_textField.getText().trim();
		        
		        if (!cpf.isEmpty()) {
		            buscarFuncionarioPorCpf();
		        } else if (!nome.isEmpty()) {
		            buscarFuncionarioPorNome();
		        } else {
		            buscarTodosFuncionarios(); 
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(309, 145, 140, 35);
		contentPane.add(btnNewButton);
		
        modelo = new DefaultTableModel();
        modelo.addColumn("Nome Completo");
        modelo.addColumn("RG");
        modelo.addColumn("Telefone");
        modelo.addColumn("Email");
        modelo.addColumn("Data de Nascimento");
        modelo.addColumn("CNH");
        modelo.addColumn("Vencimento do CNH");
        modelo.addColumn("CEP");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 191, 764, 359);
        contentPane.add(scrollPane);
        
        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
    			dispose();
    			telaPrincipal.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(10, 11, 89, 35);
        contentPane.add(btnNewButton_1);
        
        buscarTodosFuncionarios();
        
	}
	
    private void buscarTodosFuncionarios() {
        Repositorio repositorio = new Repositorio();
        List<Funcionario> funcionarios = repositorio.buscarTodosFuncionarios();
        
        modelo.setRowCount(0); 
        for (Funcionario funcionario : funcionarios) {
            modelo.addRow(new Object[]{funcionario.getNome(),funcionario.getRg(), funcionario.getTelefone(), funcionario.getEmail(),
            		funcionario.getDataNascimento(), funcionario.getCnh(), funcionario.getValidadeCNH(), funcionario.getCep()});
        }
    }
    private void buscarFuncionarioPorCpf() {
        String cpf = locCPF_textField.getText();
        Repositorio repositorio = new Repositorio();
        Funcionario funcionario = repositorio.buscarFuncionarioPorCpf(cpf);
        
        modelo.setRowCount(0); 
        if (funcionario != null) {
            modelo.addRow(new Object[]{funcionario.getNome(),funcionario.getRg(), funcionario.getTelefone(), funcionario.getEmail(),
            		funcionario.getDataNascimento(), funcionario.getCnh(), funcionario.getValidadeCNH(), funcionario.getCep()});
        } else {
            JOptionPane.showMessageDialog(this, "Funcionario não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void buscarFuncionarioPorNome() {
        String nome = locNome_textField.getText();
        Repositorio repositorio = new Repositorio();
        Funcionario funcionario = repositorio.buscarFuncionarioPorCpf(nome);
        
        modelo.setRowCount(0); 
        if (funcionario != null) {
            modelo.addRow(new Object[]{funcionario.getNome(),funcionario.getRg(), funcionario.getTelefone(), funcionario.getEmail(),
            		funcionario.getDataNascimento(), funcionario.getCnh(), funcionario.getValidadeCNH(), funcionario.getCep()});
        } else {
            JOptionPane.showMessageDialog(this, "Funcionario não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
