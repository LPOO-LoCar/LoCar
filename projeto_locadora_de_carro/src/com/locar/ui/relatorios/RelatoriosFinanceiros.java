package com.locar.ui.relatorios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import com.locar.dados.FinanceiroRepositorio;
import com.locar.ui.TelaPrincipal;

public class RelatoriosFinanceiros {

	private JFrame frame;
	private String funcao;
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset;
	private FinanceiroRepositorio financeiroRepositorio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	public RelatoriosFinanceiros(String funcao) {
		this.funcao = funcao;
		financeiroRepositorio = new FinanceiroRepositorio();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

		dataset = new DefaultCategoryDataset();
		dataset.addValue(financeiroRepositorio.calcularReceitaTotal(), "Total Receitas", "Total Receitas");

		JFreeChart chart = ChartFactory.createBarChart(null, null, "Valor de Receita", dataset,
				org.jfree.chart.plot.PlotOrientation.VERTICAL, true, false, false);

		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setMaximumBarWidth(0.2);
		renderer.setMinimumBarLength(0.15);

		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setTickLabelsVisible(false);
		categoryAxis.setLabel("");
		renderer.setSeriesPaint(0, new Color(255, 165, 0));

		chartPanel = new ChartPanel(chart);
		chartPanel.setMinimumDrawWidth(500);
		chartPanel.setBounds(20, 92, 654, 327);
		frame.getContentPane().add(chartPanel);

		renderer.setDefaultItemLabelGenerator(
				new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getCurrencyInstance()));
		renderer.setDefaultItemLabelsVisible(true);

		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.TOP_LEFT);
		renderer.setDefaultPositiveItemLabelPosition(position);

		renderer.setDefaultItemLabelPaint(Color.BLACK);
		renderer.setDefaultItemLabelFont(new Font("Tahoma", Font.BOLD, 18));

		JButton btnMensal = new JButton("Receita Mensal");
		btnMensal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMensal.setBounds(50, 440, 170, 40);
		frame.getContentPane().add(btnMensal);
		btnMensal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarGrafico("Receita Mensal", financeiroRepositorio.calcularReceitaMesAtual());
			}
		});

		JButton btnTrimestral = new JButton("Receita Semestral");
		btnTrimestral.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTrimestral.setBounds(250, 440, 170, 40);
		frame.getContentPane().add(btnTrimestral);
		btnTrimestral.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarGrafico("Receita Semestral", financeiroRepositorio.calcularReceitaSemestreAtual());
			}
		});

		JButton btnAnual = new JButton("Receita Anual");
		btnAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnual.setBounds(450, 440, 170, 40);
		frame.getContentPane().add(btnAnual);
		btnAnual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarGrafico("Receita Anual", financeiroRepositorio.calcularReceitaAnoAtual());
			}
		});

		JButton btnValorTotal = new JButton("Valor Total");
		btnValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnValorTotal.setBounds(223, 499, 221, 40);
		frame.getContentPane().add(btnValorTotal);
		btnValorTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarGrafico("Total Receitas", financeiroRepositorio.calcularReceitaTotal());
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(10, 6, 89, 35);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
				frame.dispose();
				telaPrincipal.setVisible(true);
			}
		});
	}

	private void atualizarGrafico(String titulo, double valor) {
		dataset.clear();
		dataset.addValue(valor, titulo, titulo);

		JFreeChart chart = chartPanel.getChart();
		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setTickLabelsVisible(false);
		categoryAxis.setLabel("");

		if (titulo.equals("Receita Mensal")) {
			renderer.setSeriesPaint(0, new Color(78, 154, 255));
		} else if (titulo.equals("Receita Semestral")) {
			renderer.setSeriesPaint(0, new Color(76, 175, 80));
		} else if (titulo.equals("Receita Anual")) {
			renderer.setSeriesPaint(0, new Color(244, 67, 54));
		} else {
			renderer.setSeriesPaint(0, new Color(255, 165, 0));
		}

		renderer.setDefaultItemLabelGenerator(
				new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getCurrencyInstance()));
		renderer.setDefaultItemLabelsVisible(true);

		// Define a posição correta do rótulo
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.TOP_LEFT);
		renderer.setDefaultPositiveItemLabelPosition(position);

		renderer.setDefaultItemLabelPaint(Color.BLACK);
		renderer.setDefaultItemLabelFont(new Font("Tahoma", Font.BOLD, 18));

		chartPanel.repaint();
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
