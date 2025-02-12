package com.locar.regras_negocio;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EnviarEmail {
	
    public static void enviarEmailReserva(String destinatario, String nomeCliente, String dataRetirada, String horaRetirada) {
        final String remetente = "matheussoa1507@gmail.com";
        final String senha = "191501math"; 

        // Configuração do servidor SMTP (Gmail)
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Reserva Confirmada - LoCAR - Locadorada de Veículos");
            message.setText("Olá, " + nomeCliente + "!\n\n"
                    + "Sua reserva foi realizada com sucesso.\n"
                    + "Data de Retirada: " + dataRetirada + "\n"
                    + "Hora de Retirada: " + horaRetirada + "\n\n"
                    + "Obrigado por escolher nossa locadora!");

            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
}
