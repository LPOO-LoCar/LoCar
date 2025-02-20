package com.locar.ui.pagamento;

import javax.swing.*;
import com.locar.entidades.Carro;
import com.locar.entidades.Cliente;
import com.locar.ui.*;
import com.locar.ui.cadastro.*;
import com.locar.regras_negocio.Loc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Pagar extends JFrame {

    private JLabel lblValorTotal;
    private JLabel lblQRCode;
    private Cliente cliente;
    private Carro carro;
    private Loc loc;

    public Pagar(double valorTotal, Cliente cliente, Carro carro, String access_token, int idCob) {
        this.cliente = cliente;
        this.carro = carro;
        this.loc = new Loc();

        setTitle("Pagamento");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        lblValorTotal = new JLabel("Valor Total: R$ " + String.format("%.2f", valorTotal));
        lblValorTotal.setBounds(89, 66, 322, 90);
        lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
        getContentPane().add(lblValorTotal);

        lblQRCode = new JLabel("QR Code", SwingConstants.CENTER);
        lblQRCode.setBounds(130, 148, 200, 200);
        getContentPane().add(lblQRCode);

        JButton btnConfirmar = new JButton("Confirmar Pagamento");
        btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnConfirmar.setBounds(109, 370, 245, 35);
        btnConfirmar.addActionListener(e -> {
            JOptionPane.showMessageDialog(Pagar.this, "Pagamento confirmado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            TelaPrincipal telaPrincipal = new TelaPrincipal("ADMIN");
            telaPrincipal.setVisible(true);
        });
        getContentPane().add(btnConfirmar);

        JButton btnImprimir = new JButton("Imprimir Recibo");
        btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnImprimir.setBounds(109, 417, 245, 35);
        btnImprimir.addActionListener(e -> imprimirRecibo(valorTotal));
        getContentPane().add(btnImprimir);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCancelar.setBounds(109, 464, 245, 35);
        btnCancelar.addActionListener(e -> {
        dispose();
        NovaLocação novaLocacao = new NovaLocação("ADMIN");
        novaLocacao.setVisible(true);
        });
        getContentPane().add(btnCancelar);

        JLabel lblTitulo = new JLabel("Pagamento", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblTitulo.setBounds(93, 11, 300, 50);
        getContentPane().add(lblTitulo);

        gerarQRCode(idCob, access_token);
    }

    private void gerarQRCode(int idCob, String access_token) {
        try {
            String locJson = loc.genQrCode(idCob, access_token);
            String qrcode = loc.getQrCode(locJson);
            if (qrcode != null && !qrcode.isEmpty()) {
                String imageFile = loc.saveImage(qrcode);
                if (!imageFile.isEmpty()) {
                    ImageIcon qrImage = new ImageIcon(imageFile);
                    lblQRCode.setIcon(qrImage);
                }
            }
        } catch (Exception e) {
            lblQRCode.setText("Erro ao carregar QR Code");
        }
    }

    private void imprimirRecibo(double valorTotal) {
        JOptionPane.showMessageDialog(this, 
                "RECIBO DE PAGAMENTO\n\n" +
                "Cliente: " + cliente.getNomeCompleto() + "\n" +
                "Veículo: " + carro.getMarca() + " " + carro.getModelo() + "\n" +
                "Placa: " + carro.getPlaca() + "\n" +
                "Valor Total: R$ " + String.format("%.2f", valorTotal) + "\n" +
                "Forma de Pagamento: Confirmada\n\n" +
                "Obrigado pela preferência!", 
                "Recibo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pagar(100.0, new Cliente(), new Carro(), "seuAccessTokenAqui", 12345).setVisible(true));
    }
}

