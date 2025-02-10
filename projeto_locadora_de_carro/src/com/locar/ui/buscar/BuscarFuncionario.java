package com.locar.ui.buscar;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import acesso_dados.DadosFuncionarioBuscar;
import entidades.Funcionario;
import regras_negocio.BuscarFuncionarioRegras;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarFuncionarioBuscar extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCPF;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTable tabelaFuncionarios;
    private DefaultTableModel modeloTabela;
    private BuscarFuncionarioRegras regras;
    
    public BuscarFuncionarioBuscar() {
        setTitle("Buscar Funcionários");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regras = new BuscarFuncionarioRegras();
        
        JPanel painelBusca = new JPanel();
        painelBusca.setBounds(0, 52, 774, 87);
        painelBusca.setLayout(null);
        
        txtCPF = new JTextField();
        txtCPF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String textoCpf = txtCPF.getText();
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
                
                txtCPF.setText(textoCpf);
            }	
        });
        
        txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtCPF.setBounds(44, 17, 126, 24);
        txtNome = new JTextField();
        txtNome.setBounds(230, 17, 303, 24);
        txtTelefone = new JTextField();
        txtTelefone.setBounds(614, 17, 135, 24);
        
        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCPF.setBounds(10, 14, 33, 30);
        painelBusca.add(lblCPF);
        painelBusca.add(txtCPF);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNome.setBounds(180, 14, 48, 24);
        painelBusca.add(lblNome);
        painelBusca.add(txtNome);
        
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblTelefone.setBounds(543, 14, 67, 24);
        painelBusca.add(lblTelefone);
        painelBusca.add(txtTelefone);
        
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("CPF");
        modeloTabela.addColumn("Nome do Funcionário");
        modeloTabela.addColumn("Data de Nascimento");
        modeloTabela.addColumn("Telefone");
        modeloTabela.addColumn("Email");
        modeloTabela.addColumn("CNH");
        
        tabelaFuncionarios = new JTable(modeloTabela); // Usa o modeloTabela na JTable
        tabelaFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(tabelaFuncionarios);
        scrollPane.setBounds(10, 150, 764, 400);
        getContentPane().add(scrollPane);
        
        getContentPane().setLayout(null);
        getContentPane().add(painelBusca);
        
        JButton Buscar_Button = new JButton("Buscar");
        Buscar_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarFuncionario();
            }

            private void buscarFuncionario() {
                String cpf = txtCPF.getText().replaceAll("[^0-9]", ""); // Remove formatação do CPF
                String nome = txtNome.getText();
                String telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
                DadosFuncionarioBuscar buscarFuncionarioDados = new DadosFuncionarioBuscar();
                Funcionario funcionario = buscarFuncionarioDados.buscarPorCPF(cpf); // Passa o CPF como parâmetro
                
                modeloTabela.setRowCount(0); // Limpa a tabela antes de adicionar novos dados
                if (funcionario != null) {
                    modeloTabela.addRow(new Object[] {
                        funcionario.getCpf(),
                        funcionario.getNome(),
                        funcionario.getDataNascimento(),
                        funcionario.getTelefone(),
                        funcionario.getEmail(),
                        funcionario.getCnh()
                    });
                } else {
                    JOptionPane.showMessageDialog(BuscarFuncionarioBuscar.this, "Funcionário não cadastrado...", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Buscar_Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Buscar_Button.setBounds(351, 53, 89, 23);
        painelBusca.add(Buscar_Button);
        
        JLabel lblTitulo = new JLabel("Buscar Funcionário");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(318, 11, 174, 30);
        getContentPane().add(lblTitulo);
        
        tabelaFuncionarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int linha = tabelaFuncionarios.getSelectedRow();
                    if (linha != -1) {
                        String cpf = (String) modeloTabela.getValueAt(linha, 0);
                        abrirTelaEdicao(cpf);
                    }
                }
            }
        });
        
        setVisible(true); // Torna a janela visível
    }
    
    private void abrirTelaEdicao(String cpf) {
        JOptionPane.showMessageDialog(this, "Abrindo edição para: " + cpf);
    }
    
    public static void main(String[] args) {
        new BuscarFuncionarioBuscar();
    }
}
