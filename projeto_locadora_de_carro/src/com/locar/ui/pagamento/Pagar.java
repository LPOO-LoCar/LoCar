package com.locar.ui.pagamento;

import javax.swing.*;
import java.awt.*;
import com.locar.regras_negocio.*;

public class Pagar extends JFrame {
    private JLabel labelValorTotal;
    private JLabel labelQrCode;
    private JButton btnConfirmarPagamento;
    private JButton btnImprimirRecibo;
    private JButton btnCancelar;

    public Pagar(double valorTotal) {
        // Configurações da tela
        setTitle("Tela de Pagamento");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new FlowLayout());

        // Exibir o valor total
        labelValorTotal = new JLabel("Valor Total: R$ " + valorTotal);
        add(labelValorTotal);

        // Gerar o QR Code para o pagamento
        Loc loc = new Loc();
        String qrCodeData = "QR CODE GERADO PARA O PAGAMENTO DE R$ " + valorTotal; // Você deve gerar o QR code real aqui
        String qrCodeImage = loc.getQrCode(qrCodeData);
        labelQrCode = new JLabel(new ImageIcon(qrCodeImage));
        add(labelQrCode);

        // Botão Confirmar Pagamento
        btnConfirmarPagamento = new JButton("Confirmar Pagamento");
        btnConfirmarPagamento.addActionListener(e -> confirmarPagamento(valorTotal));
        add(btnConfirmarPagamento);

        // Botão Imprimir Recibo
        btnImprimirRecibo = new JButton("Imprimir Recibo");
        btnImprimirRecibo.addActionListener(e -> imprimirRecibo());
        add(btnImprimirRecibo);

        // Botão Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> cancelar());
        add(btnCancelar);
    }

    private void confirmarPagamento(double valorTotal) {
        JOptionPane.showMessageDialog(this, "Pagamento de R$ " + valorTotal + " confirmado!", "Pagamento Confirmado", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Fechar a tela de pagamento após confirmação
    }

    private void imprimirRecibo() {
        JOptionPane.showMessageDialog(this, "Recibo impresso com sucesso!", "Imprimir Recibo", JOptionPane.INFORMATION_MESSAGE);
        // Aqui você pode adicionar a lógica para imprimir o recibo
    }

    private void cancelar() {
        JOptionPane.showMessageDialog(this, "Pagamento cancelado!", "Cancelamento", JOptionPane.WARNING_MESSAGE);
        dispose(); // Fechar a tela de pagamento após o cancelamento
    }
}