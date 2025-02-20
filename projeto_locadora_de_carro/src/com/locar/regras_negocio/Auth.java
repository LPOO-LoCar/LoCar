package com.locar.regras_negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.json.JSONObject;

public class Auth {
    private final String client_id = "Client_Id_079aa96f1e454ab736d0c38280a256989824f8ef";
    private final String client_secret = "Client_Secret_e7369a7963de369c45d08c0cd9b0e167d437e999";
    private final String basicAuth = Base64.getEncoder().encodeToString((client_id + ':' + client_secret).getBytes());

    public String geraToken() {
        String access_token = "";
        try {
            // Diretório certificado em formato .p12 inserido
            System.setProperty("javax.net.ssl.keyStore", "producao-707591-locar.p12");
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Substituindo new URL(String) por new URI(String).toURL()
            URI uri = new URI("https://api-pix.gerencianet.com.br/oauth/token");
            URL url = uri.toURL();

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Basic " + basicAuth);
            conn.setSSLSocketFactory(sslsocketfactory);
            String input = "{\"grant_type\": \"client_credentials\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(reader);

            String response;
            StringBuilder responseBuilder = new StringBuilder();
            while ((response = br.readLine()) != null) {
                responseBuilder.append(response);
            }
            try {
                JSONObject jsonObject = new JSONObject(responseBuilder.toString());
                access_token = jsonObject.getString("access_token");
            } catch (Exception e) {
                System.out.println("Erro na conversão de " + responseBuilder);
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Erro na autenticação");
            e.printStackTrace();
        }

        return access_token;
    }
}