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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import com.locar.dados.Repositorio;
import com.locar.ui.TelaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatoriosVeiculos {

    private JFrame frame;
    private String funcao;

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

    public RelatoriosVeiculos(String funcao) {
        this.funcao = funcao;
        initialize();
    }

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
        
        JLabel lblNewLabel_1 = new JLabel("Relatórios de Veículos");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblNewLabel_1.setBounds(171, 7, 356, 35);
        frame.getContentPane().add(lblNewLabel_1);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBounds(-10, 85, 694, 2);
        frame.getContentPane().add(separator);

        DefaultCategoryDataset datasetMarcas = new DefaultCategoryDataset();
        Repositorio repositorio = new Repositorio();
        Map<String, Integer> dados = repositorio.obterDadosRelatorioMarca();

        for (Map.Entry<String, Integer> entry : dados.entrySet()) {
            datasetMarcas.addValue(entry.getValue(), "Marcas", entry.getKey());
        }

        JFreeChart chartMarcas = ChartFactory.createBarChart(null, null, "Total de locações", datasetMarcas, PlotOrientation.VERTICAL, true, false, false);
        chartMarcas.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chartMarcas.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.2);
        renderer.setMinimumBarLength(0.15);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(new Font("Tahoma", Font.BOLD, 14));
        renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.TOP_LEFT));

        ChartPanel chartPanel = new ChartPanel(chartMarcas);
        chartPanel.setBounds(44, 98, 583, 245);
        frame.getContentPane().add(chartPanel);
        
        JLabel lblModelosDeVeculos = new JLabel("Modelos de veículos mais utilizados");
        lblModelosDeVeculos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblModelosDeVeculos.setBounds(10, 351, 438, 30);
        frame.getContentPane().add(lblModelosDeVeculos);
      
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.BLACK);
        separator_1.setBounds(-1, 382, 694, 2);
        frame.getContentPane().add(separator_1);
        
        DefaultCategoryDataset datasetModelos = new DefaultCategoryDataset();
        Map<String, Integer> dadosModelos = repositorio.obterDadosRelatorioModelo();

        for (Map.Entry<String, Integer> entry : dadosModelos.entrySet()) {
            datasetModelos.addValue(entry.getValue(), "Modelos", entry.getKey());
        }

        JFreeChart chartModelos = ChartFactory.createBarChart(null, null, "Total de locações", datasetModelos, PlotOrientation.VERTICAL, true, false, false);
        chartModelos.setBackgroundPaint(Color.white);

        CategoryPlot plotModelos = (CategoryPlot) chartModelos.getPlot();
        NumberAxis rangeAxisModelos = (NumberAxis) plotModelos.getRangeAxis();
        rangeAxisModelos.setTickUnit(new org.jfree.chart.axis.NumberTickUnit(1));

        BarRenderer rendererModelos = (BarRenderer) plotModelos.getRenderer();
        rendererModelos.setMaximumBarWidth(0.2);
        rendererModelos.setMinimumBarLength(0.15);
        rendererModelos.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        rendererModelos.setDefaultItemLabelsVisible(true);
        rendererModelos.setDefaultItemLabelFont(new Font("Tahoma", Font.BOLD, 14));
        rendererModelos.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.TOP_LEFT));

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
