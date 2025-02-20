package com.locar.regras_negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.mifmif.common.regex.Generex;

public class Cob {
    
    public String doCob(String token) {
        String payload;
        payload = "{\r\n"
                + "  \"calendario\": {\r\n"
                + "    \"expiracao\": 3600\r\n"
                + "  },\r\n"
                + "  \"devedor\": {\r\n"
                + "    \"cnpj\": \"98765432000199\",\r\n"
                + "    \"nome\": \"Locadora de Veículos LTDA\"\r\n"
                + "  },\r\n"
                + "  \"valor\": {\r\n"
                + "    \"original\": \"0.01\"\r\n"
                + "  },\r\n"
                + "  \"chave\": \"chavePixLocadora\",\r\n"
                + "  \"solicitacaoPagador\": \"Pagamento de aluguel de veículo.\",\r\n"
                + "  \"infoAdicionais\": [\r\n"
                + "    {\r\n"
                + "      \"nome\": \"Placa do Veículo\",\r\n"
                + "      \"valor\": \"ABC-1234\"\r\n"
                + "    },\r\n"
                + "    {\r\n"
                + "      \"nome\": \"Período de Locação\",\r\n"
                + "      \"valor\": \"1 dia\"\r\n"
                + "    }\r\n"
                + "  ]\r\n"
                + "}";

        // Cobrança
        StringBuilder responseBuilder = new StringBuilder();
        HttpsURLConnection conn = null;

        try {
            System.setProperty("javax.net.ssl.keyStore", "producao-707591-locar.p12"); 

            String txid;
            Generex generex = new Generex("[a-zA-Z0-9]{26,35}");
            txid = generex.random();

            // Substituindo new URL(String) por new URI(String).toURL()
            URI uri = new URI("https://api-pix.gerencianet.com.br/v2/cob/" + txid);
            URL url = uri.toURL();

            conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            OutputStream os = conn.getOutputStream();
            os.write(payload.getBytes());
            os.flush();   

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(reader);

            String response;        
            while ((response = br.readLine()) != null) {
                responseBuilder.append(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();    
    }

    public int getIdCob(String cob) {
        int id = 0;
        try {
            JSONObject jsonObject = new JSONObject(cob);
            JSONObject loc = (JSONObject) jsonObject.get("loc");
            id = loc.getInt("id");
        } catch (Exception e) {
            System.out.println("Erro na obtenção do id da Cobrança");
            e.printStackTrace();
        }
        return id;
    }
}