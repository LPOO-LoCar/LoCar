package com.locar.ui.pagamento;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.resources.payment.Payment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class TelaPagamentoPix extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private static final String ACCESS_TOKEN = "APP_USR-8578525151217591-061218-0092441ab6378af36fa6e67b488912a5-2495743088";
    
    private JLabel qrCodeLabel;
    private JLabel statusLabel;
    private Timer statusTimer;
    private String paymentId;
    private double valorTotal;
    private String nome;
    private String cpf;

    public TelaPagamentoPix(double valorTotal, String nome, String cpf) {
        this.valorTotal = valorTotal;
        this.nome = nome;
        this.cpf = cpf;
        
        initializeComponents();
        criarPagamentoPix();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Pagamento PIX - Mercado Pago");
        setSize(500, 580);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JLabel tituloLabel = new JLabel("Pagamento via PIX");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setBounds(50, 11, 400, 39);
        contentPane.add(tituloLabel);

        JLabel valorLabel = new JLabel("Valor: R$ " + String.format("%.2f", valorTotal));
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        valorLabel.setBounds(39, 61, 400, 25);
        valorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(valorLabel);

        JLabel nomeLabel = new JLabel("Cliente: " + nome);
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nomeLabel.setBounds(50, 100, 400, 20);
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(nomeLabel);

        qrCodeLabel = new JLabel("Gerando QR Code...", SwingConstants.CENTER);
        qrCodeLabel.setBounds(100, 130, 300, 300);
        qrCodeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(qrCodeLabel);

        statusLabel = new JLabel("Aguardando pagamento...", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setForeground(Color.ORANGE);
        statusLabel.setBounds(50, 440, 400, 25);
        contentPane.add(statusLabel);

        JLabel instrucaoLabel = new JLabel("Escaneie o QR Code com o app do seu banco");
        instrucaoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        instrucaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instrucaoLabel.setBounds(50, 470, 400, 20);
        contentPane.add(instrucaoLabel);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.setFont(new Font("Arial", Font.PLAIN, 14));
        fecharButton.setBounds(200, 500, 100, 30);
        fecharButton.addActionListener(e -> {
            if (statusTimer != null) {
                statusTimer.stop();
            }
            dispose();
        });
        contentPane.add(fecharButton);
    }

    private void criarPagamentoPix() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                	
                    MercadoPagoConfig.setAccessToken(ACCESS_TOKEN);
                    PaymentClient client = new PaymentClient();

                    String[] partesNome = nome.trim().split("\\s+", 2);
                    String firstName = partesNome[0];
                    String lastName = partesNome.length > 1 ? partesNome[1] : "Sobrenome";
                    String cpfLimpo = cpf.replaceAll("[^0-9]", "");
                    String email = "cliente" + cpfLimpo + "@temp.com";

                    PaymentCreateRequest request = PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(valorTotal))
                            .paymentMethodId("pix")
                            .description("Locação de veículo - " + nome)
                            .payer(PaymentPayerRequest.builder()
                                    .email(email)
                                    .firstName(firstName)
                                    .lastName(lastName)
                                    .identification(IdentificationRequest.builder()
                                            .type("CPF")
                                            .number(cpfLimpo)
                                            .build())
                                    .build())
                            .build();

                    Payment payment = client.create(request);
                    paymentId = payment.getId().toString();

                    String pixCode = payment.getPointOfInteraction()
                            .getTransactionData().getQrCode();

                    SwingUtilities.invokeLater(() -> {
                        try {
                        	
                            BufferedImage qrImage = gerarQRCode(pixCode, 340, 340);
                            qrCodeLabel.setIcon(new ImageIcon(qrImage));
                            qrCodeLabel.setText("");
                            
                            iniciarTimerVerificacao();
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(TelaPagamentoPix.this, 
                                "Erro ao gerar QR Code: " + e.getMessage(), 
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                } catch (Exception e) {
                    SwingUtilities.invokeLater(() -> {
                        String mensagem = "Erro ao criar pagamento: " + e.getMessage();
                        JOptionPane.showMessageDialog(TelaPagamentoPix.this, 
                            mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

    private BufferedImage gerarQRCode(String text, int width, int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return bufferedImage;
    }

    private void iniciarTimerVerificacao() {
        statusTimer = new Timer(10000, e -> verificarStatusPagamento());
        statusTimer.start();
    }

    private void verificarStatusPagamento() {
        if (paymentId == null) return;

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    PaymentClient client = new PaymentClient();
                    Payment payment = client.get(Long.parseLong(paymentId));
                    
                    SwingUtilities.invokeLater(() -> {
                        String status = payment.getStatus();
                        
                        switch (status) {
                            case "approved":
                                statusLabel.setText("PAGAMENTO APROVADO!");
                                statusLabel.setForeground(Color.GREEN);
                                statusTimer.stop();
                                JOptionPane.showMessageDialog(TelaPagamentoPix.this, 
                                    "Pagamento aprovado com sucesso!", 
                                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case "pending":
                                statusLabel.setText("Aguardando pagamento...");
                                statusLabel.setForeground(Color.ORANGE);
                                break;
                            case "rejected":
                                statusLabel.setText("PAGAMENTO REJEITADO");
                                statusLabel.setForeground(Color.RED);
                                statusTimer.stop();
                                JOptionPane.showMessageDialog(TelaPagamentoPix.this, 
                                    "Pagamento foi rejeitado.", 
                                    "Erro", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "cancelled":
                                statusLabel.setText("PAGAMENTO CANCELADO");
                                statusLabel.setForeground(Color.RED);
                                statusTimer.stop();
                                break;
                        }
                    });
                    
                } catch (Exception e) {
                    SwingUtilities.invokeLater(() -> {
                        statusLabel.setText("Erro ao verificar pagamento");
                        statusLabel.setForeground(Color.RED);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

    @Override
    public void dispose() {
        if (statusTimer != null) {
            statusTimer.stop();
        }
        super.dispose();
    }
}