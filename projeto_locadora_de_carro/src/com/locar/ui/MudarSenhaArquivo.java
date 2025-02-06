package com.locar.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import com.locar.regras_negocio.MudarSenhaController; // Importando a classe de regras de negócio, tem que mudar para o nome do package onde tá o Controller

public class MudarSenhaArquivo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usuariotextField;
    private JPasswordField senhaAtualTextField;
    private JPasswordField novaSenhaTextField;
    private JPasswordField confirmarNovaSenhatextField;
    private MudarSenhaController mudarSenhaController = new MudarSenhaController(); // Criando o controlador

    public MudarSenhaArquivo() {
        setTitle("Mudar Senha");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 375);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel mudarSenhaLabel = new JLabel("Mudar Senha");
        mudarSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        mudarSenhaLabel.setBounds(146, 11, 116, 25);
        contentPane.add(mudarSenhaLabel);

        JLabel usuarioLabel = new JLabel("Usuário");
        usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usuarioLabel.setBounds(178, 47, 54, 20);
        contentPane.add(usuarioLabel);

        usuariotextField = new JTextField();
        usuariotextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usuariotextField.setBounds(146, 70, 116, 20);
        contentPane.add(usuariotextField);
        usuariotextField.setColumns(10);

        JLabel SenhaAtualLabel = new JLabel("Senha Atual");
        SenhaAtualLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        SenhaAtualLabel.setBounds(166, 101, 85, 20);
        contentPane.add(SenhaAtualLabel);

        senhaAtualTextField = new JPasswordField();
        senhaAtualTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        senhaAtualTextField.setBounds(146, 132, 116, 20);
        contentPane.add(senhaAtualTextField);
        senhaAtualTextField.setColumns(10);

        JLabel NovaSenhaLabel = new JLabel("Nova Senha");
        NovaSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        NovaSenhaLabel.setBounds(166, 163, 85, 20);
        contentPane.add(NovaSenhaLabel);

        novaSenhaTextField = new JPasswordField();
        novaSenhaTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        novaSenhaTextField.setColumns(10);
        novaSenhaTextField.setBounds(146, 188, 116, 20);
        contentPane.add(novaSenhaTextField);

        JLabel ConfirmarNovaSenhaLabel = new JLabel("Confirmar Nova Senha");
        ConfirmarNovaSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ConfirmarNovaSenhaLabel.setBounds(119, 219, 169, 20);
        contentPane.add(ConfirmarNovaSenhaLabel);

        confirmarNovaSenhatextField = new JPasswordField();
        confirmarNovaSenhatextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmarNovaSenhatextField.setColumns(10);
        confirmarNovaSenhatextField.setBounds(146, 250, 116, 20);
        contentPane.add(confirmarNovaSenhatextField);

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        confirmarButton.setBounds(146, 297, 116, 35);
        contentPane.add(confirmarButton);

        confirmarButton.addActionListener(e -> mudarSenha());

        setVisible(true);
    }

    private void mudarSenha() {
        String usuario = usuariotextField.getText();
        String senhaAtual = new String(senhaAtualTextField.getPassword());
        String novaSenha = new String(novaSenhaTextField.getPassword());
        String confirmarSenha = new String(confirmarNovaSenhatextField.getPassword());

        try {
            boolean sucesso = mudarSenhaController.mudarSenha(usuario, senhaAtual, novaSenha, confirmarSenha);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Senha Alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MudarSenhaArquivo();
    }
}
