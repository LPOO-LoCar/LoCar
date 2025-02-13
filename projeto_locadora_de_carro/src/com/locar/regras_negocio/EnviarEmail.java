package com.locar.regras_negocio;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class EnviarEmail {
    private static final String REMETENTE = "matheussoa1507@gmail.com";
    private static final String SENHA = "buvp vnlq jwcz ceuk"; 
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void enviarEmailReserva(String destinatario, String nomeCliente, String dataRetirada, String horaRetirada) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMETENTE, SENHA);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(REMETENTE));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Reserva confirmada - LoCar - Locadora de veículos");
            message.setText("Olá, " + nomeCliente + "!\n\n"
                    + "Sua reserva foi realizada com sucesso.\n"
                    + "Data de Retirada: " + dataRetirada + "\n"
                    + "Hora de Retirada: " + horaRetirada + "\n\n"
                    + "Obrigado por escolher nossa locadora!");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static void enviarEmailAgendado(String destinatario, String nomeCliente, String dataRetirada, String horaRetirada) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMETENTE, SENHA);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(REMETENTE));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Lembrete de locação - LoCar - Locadora de veículos");
            message.setText("Olá, " + nomeCliente + "!\n\n"
                    + "Sua reserva está agendada para amanhã.\n"
                    + "Data de Retirada: " + dataRetirada + "\n"
                    + "Hora de Retirada: " + horaRetirada + "\n\n"
                    + "Obrigado por escolher nossa locadora!");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void agendarEmailLembrete(String destinatario, String nomeCliente, String dataRetirada, String horaRetirada) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date retirada = inputFormat.parse(dataRetirada + " " + horaRetirada);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(retirada);
            calendar.add(Calendar.DAY_OF_YEAR, -1); 
            Date lembrete = calendar.getTime();
            long delay = lembrete.getTime() - System.currentTimeMillis();

            if (delay > 0) {
                scheduler.schedule(() -> enviarEmailLembrete(destinatario, nomeCliente, dataRetirada, horaRetirada), delay, TimeUnit.MILLISECONDS);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void enviarEmailLembrete(String destinatario, String nomeCliente, String dataRetirada, String horaRetirada) {
        enviarEmailAgendado(destinatario, nomeCliente, dataRetirada, horaRetirada);
    }
}


