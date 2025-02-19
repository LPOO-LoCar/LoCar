package com.locar.ui.ajuda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.locar.ui.TelaPrincipal;

public class Sobre extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String funcao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sobre frame = new Sobre("ADMIN");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Sobre(String funcao) {
        this.funcao = funcao;
        setTitle("Sobre");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        JLabel carrinho = new JLabel(new ImageIcon("C:\\Users\\mathe\\Downloads\\logo-locar 2.jpg"));
        carrinho.setBounds(248, -3, 191, 178);
        contentPane.add(carrinho);
        
        JLabel sobreLabel = new JLabel("Sobre");
        sobreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        sobreLabel.setBounds(310, 150, 100, 25);
        contentPane.add(sobreLabel);
        
        JLabel descricao = new JLabel("Programa desenvolvido em Java para gerenciamento de locadoras de veículos");
        descricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
        descricao.setBounds(50, 180, 600, 20);
        contentPane.add(descricao);
        
        JLabel descricao2 = new JLabel("Com funções de cadastro, edição e busca de clientes, veículos e funcionários");
        descricao2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        descricao2.setBounds(50, 200, 600, 20);
        contentPane.add(descricao2);
        
        JLabel descricao3 = new JLabel("além de fazer reservas, locações e gerar relatórios administrativos para a");
        descricao3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        descricao3.setBounds(50, 220, 600, 20);
        contentPane.add(descricao3);
        
        JLabel descricao4 = new JLabel("cadeira de LPOO 2024.2 do IFPE campus Paulista.");
        descricao4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        descricao4.setBounds(50, 240, 500, 20);
        contentPane.add(descricao4);
        
        JLabel devsLabel = new JLabel("Desenvolvedores");
        devsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        devsLabel.setBounds(280, 270, 200, 25);
        contentPane.add(devsLabel);
        
        String[] devs = {"Adriel", "Ana Clara", "Ana Luiza", "Maria Luiza", "Matheus Soares"};
        int yPosition = 300;
        for (String dev : devs) {
            JLabel devLabel = new JLabel(dev);
            devLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            devLabel.setBounds(300, yPosition, 200, 20);
            contentPane.add(devLabel);
            yPosition += 25;
        }
        
        JLabel lblVersao = new JLabel("Versão 1.0.1");
        lblVersao.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblVersao.setBounds(280, 425, 150, 25);
        contentPane.add(lblVersao);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnVoltar.setBounds(20, 20, 100, 35);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal(funcao);
                dispose();
                telaPrincipal.setVisible(true);
            }
        });
        contentPane.add(btnVoltar);
    }
}

