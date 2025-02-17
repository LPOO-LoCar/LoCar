package com.locar.ui.relatorios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.locar.dados.Repositorio;
import com.locar.ui.TelaPrincipal;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RelatoriosFinanceiros {

	private JFrame frame;
	private String funcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatoriosFinanceiros window = new RelatoriosFinanceiros("ADMIN");
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
	public RelatoriosFinanceiros(String funcao) {
		this.funcao = funcao;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Relatórios Financeiros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(151, 6, 422, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Receitas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 54, 208, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		Repositorio repositorio = new Repositorio();
        double somaReceitaTotal = repositorio.calcularReceitaTotal();

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Total Receitas", somaReceitaTotal);

        JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(91, 92, 518, 278);
        frame.getContentPane().add(chartPanel);
        
        JButton btnNewButton = new JButton("Voltar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
    			frame.dispose();
    			telaPrincipal.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(10, 6, 89, 35);
        frame.getContentPane().add(btnNewButton);
    }
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
	}
