package com.locar.ui.relatorios;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.data.category.DefaultCategoryDataset;

import com.locar.dados.Repositorio;
import com.locar.ui.TelaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatoriosVeiculos {

    private JFrame frame;
    private String funcao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RelatoriosVeiculos window = new RelatoriosVeiculos("ADMIN");
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
    public RelatoriosVeiculos(String funcao) {
    	this.funcao = funcao;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Marcas de veículos mais utilizadas");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(10, 57, 385, 30);
        frame.getContentPane().add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBounds(-10, 85, 694, 2);
        frame.getContentPane().add(separator);

        // Criar o conjunto de dados para o gráfico
        DefaultCategoryDataset datasetMarcas = new DefaultCategoryDataset();

        // Obter dados do relatório
        Repositorio repositorio = new Repositorio();
        Map<String, Integer> dados = repositorio.obterDadosRelatorioMarca();

        // Adicionar os dados ao dataset
        for (Map.Entry<String, Integer> entry : dados.entrySet()) {
            datasetMarcas.addValue(entry.getValue(), "Marcas", entry.getKey());
        }

        // Criar gráfico de barras sem título
        JFreeChart chartMarcas = ChartFactory.createBarChart(
                null, // Sem título
                null, // Eixo X
                "Total de locações", // Eixo Y
                datasetMarcas, // Dados
                PlotOrientation.VERTICAL, // Orientação vertical
                true, // Sem legenda
                false, // Sem tooltips
                false // Sem URLs
        );

        // Customizar o gráfico
        chartMarcas.setBackgroundPaint(Color.white);

        // Ajustar intervalo de 1 em 1 no eixo Y
        CategoryPlot plot = (CategoryPlot) chartMarcas.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1)); // Intervalo de 1 em 1

        // Customizar a cor das barras e a fonte do eixo X
        plot.getDomainAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 18));
        plot.getDomainAxis().setTickLabelFont(new Font("Tahoma", Font.PLAIN, 18));

        // Exibir o gráfico em um painel
        ChartPanel chartPanel = new ChartPanel(chartMarcas);
        chartPanel.setBounds(44, 98, 583, 245);
        frame.getContentPane().add(chartPanel);
        
        JLabel lblNewLabel_1 = new JLabel("Relatórios de Veículos");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblNewLabel_1.setBounds(171, 7, 356, 35);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblModelosDeVeculos = new JLabel("Modelos de veículos mais utilizados");
        lblModelosDeVeculos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblModelosDeVeculos.setBounds(10, 351, 438, 30);
        frame.getContentPane().add(lblModelosDeVeculos);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLACK);
        separator_1.setBounds(-1, 382, 694, 2);
        frame.getContentPane().add(separator_1);
        
        // Criar o conjunto de dados para o gráfico de Modelos
        DefaultCategoryDataset datasetModelos = new DefaultCategoryDataset();

        // Obter dados do relatório para Modelos
        Map<String, Integer> dadosModelos = repositorio.obterDadosRelatorioModelo();

        // Adicionar os dados ao dataset de Modelos
        for (Map.Entry<String, Integer> entry : dadosModelos.entrySet()) {
            datasetModelos.addValue(entry.getValue(), "Modelos", entry.getKey());
        }

        // Criar gráfico de barras para Modelos
        JFreeChart chartModelos = ChartFactory.createBarChart(
                null, // Sem título
                null, // Eixo X
                "Total de locações", // Eixo Y
                datasetModelos, // Dados
                PlotOrientation.VERTICAL, // Orientação vertical
                true, // Com legenda
                false, // Sem tooltips
                false // Sem URLs
        );

        // Customizar o gráfico de Modelos
        chartModelos.setBackgroundPaint(Color.white);
        CategoryPlot plotModelos = (CategoryPlot) chartModelos.getPlot();
        NumberAxis rangeAxisModelos = (NumberAxis) plotModelos.getRangeAxis();
        rangeAxisModelos.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1)); // Intervalo de 1 em 1

        // Customizar a cor das barras e a fonte do eixo X no gráfico de Modelos
        plotModelos.getDomainAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 18));
        plotModelos.getDomainAxis().setTickLabelFont(new Font("Tahoma", Font.PLAIN, 18));

        // Exibir o gráfico de Modelos em um painel
        ChartPanel chartPanelModelos = new ChartPanel(chartModelos);
        chartPanelModelos.setBounds(49, 398, 583, 245);
        frame.getContentPane().add(chartPanelModelos);
        
        JButton btnNewButton = new JButton("Voltar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
    			frame.dispose();
    			telaPrincipal.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(10, 11, 89, 35);
        frame.getContentPane().add(btnNewButton);
    }
    
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}

