package com.locar.ui.buscar;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.locar.dados.Repositorio;
import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;
import com.locar.entidades.Locacao;
import com.locar.ui.TelaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class BuscarLocacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField locCPF_textField;
	private JTextField locPlaca_textField;
	private JTable tabela;
	private DefaultTableModel modelo;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarLocacao frame = new BuscarLocacao();
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
	public BuscarLocacao() {
		setTitle("Buscar Locaçao");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busca de locação");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 11, 371, 55);
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
		
		JLabel locPlaca_Label = new JLabel("Placa:");
		locPlaca_Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locPlaca_Label.setBounds(467, 86, 67, 28);
		contentPane.add(locPlaca_Label);
		
		locPlaca_textField = new JTextField();
		locPlaca_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		locPlaca_textField.setColumns(10);
		locPlaca_textField.setBounds(467, 115, 307, 20);
		contentPane.add(locPlaca_textField);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (locCPF_textField.getText() != null && !locCPF_textField.getText().isEmpty()) {
					buscarLocacaoPorCpf();
				}
				else {
					buscarLocacaoPorPlaca();
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(309, 145, 140, 35);
		contentPane.add(btnNewButton);
		
        modelo = new DefaultTableModel();
        modelo.addColumn("Id do Cliente");
        modelo.addColumn("Id do carro");
        modelo.addColumn("Valor da diária");
        modelo.addColumn("Dias locados");
        modelo.addColumn("Valor total");
        modelo.addColumn("Forma de pagamento");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 191, 764, 359);
        contentPane.add(scrollPane);
        
        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			TelaPrincipal telaPrincipal = new TelaPrincipal();
    			dispose();
    			telaPrincipal.setVisible(true);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(10, 11, 89, 35);
        contentPane.add(btnNewButton_1);
        
        buscarTodasLocacoes();
        
	}
	
    private void buscarTodasLocacoes() {
        Repositorio repositorio = new Repositorio();
        List<Locacao> locacoes = repositorio.buscarTodasLocacoes();
        
        modelo.setRowCount(0);
        
        if (locacoes.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Locação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Locacao locacao : locacoes) { 
                modelo.addRow(new Object[]{
                		locacao.getCliente().getId(), locacao.getCarro().getId(), locacao.getValorDiaria(), locacao.getDiasLocados(),
                		locacao.getValorTotal(), locacao.getFormaPagamento()
                });
            }
        }
    }
    private void buscarLocacaoPorCpf() {
        String cpf = locCPF_textField.getText();
        Repositorio repositorio = new Repositorio();
        List<Locacao> locacoes = repositorio.buscarLocacaoPorCpf(cpf);
        
        modelo.setRowCount(0);
        
        if (locacoes.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Locação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Locacao locacao : locacoes) { 
                modelo.addRow(new Object[]{
                		locacao.getCliente().getId(), locacao.getCarro().getId(), locacao.getValorDiaria(), locacao.getDiasLocados(),
                		locacao.getValorTotal(), locacao.getFormaPagamento()
                });
            }
        }
    }
    
    private void buscarLocacaoPorPlaca() {
        String placa = locPlaca_textField.getText();
        Repositorio repositorio = new Repositorio();
        List<Locacao> locacoes = repositorio.buscarLocacaoPorPlaca(placa);
        
        modelo.setRowCount(0); 
        
        if (locacoes.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Locação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Locacao locacao : locacoes) { 
                modelo.addRow(new Object[]{
                		locacao.getCliente().getId(), locacao.getCarro().getId(), locacao.getValorDiaria(), locacao.getDiasLocados(),
                		locacao.getValorTotal(), locacao.getFormaPagamento()
                });
            }
        }
    }
}
