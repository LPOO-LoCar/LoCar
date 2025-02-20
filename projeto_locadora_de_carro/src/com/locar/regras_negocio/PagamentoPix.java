package com.locar.regras_negocio;

import java.util.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PagamentoPix {
    // 1. URLs atualizadas com subdomínio correto
    private static final String API_URL = "https://api-pix.gerencianet.com.br/v1/pix";
    private static final String TOKEN_URL = "https://api-pix.gerencianet.com.br/oauth/token";
    
    private static final String CLIENT_ID = "Client_Id_84c9e11ffc7f73bfca3f6573dedbe1e5acf3d07a";
    private static final String CLIENT_SECRET = "Client_Secret_ef783d43c9c3bc3843bd4cc2c048197394b7a6de";

    public static String gerarQrCode(double valor, String chavePix) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            // 2. Obter token primeiro
            String token = obterToken();
            if (token == null) {
                System.err.println("Falha na autenticação: Token não obtido");
                return null;
            }

            HttpPost post = new HttpPost(API_URL);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Authorization", "Bearer " + token);

            JSONObject json = new JSONObject();
            json.put("valor", String.format("%.2f", valor)); // 3. Formato correto do valor
            json.put("chave", chavePix);
            json.put("descricao", "Pagamento via PIX");

            post.setEntity(new StringEntity(json.toString()));

            try (CloseableHttpResponse response = client.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String resposta = EntityUtils.toString(response.getEntity());
                
                if (statusCode != 200) {
                    System.err.println("Erro na API PIX (" + statusCode + "): " + resposta);
                    return null;
                }
                
                JSONObject jsonResponse = new JSONObject(resposta);
                return jsonResponse.optString("qrcode", null);
            }
        } catch (Exception e) {
            System.err.println("Erro na geração do QR Code: " + e.getMessage());
            return null;
        }
    }
    
    public static String obterToken() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            // 4. Usar URL correta do endpoint de autenticação
            HttpPost post = new HttpPost(TOKEN_URL);
            
            // 5. Configurar headers corretamente
            String auth = CLIENT_ID + ":" + CLIENT_SECRET;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            post.setHeader("Authorization", "Basic " + encodedAuth);
            
            // 6. Parâmetros no formato x-www-form-urlencoded
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));
            post.setEntity(new UrlEncodedFormEntity(params));

            try (CloseableHttpResponse response = client.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String resposta = EntityUtils.toString(response.getEntity());
                
                // Melhorar captura de erro com a resposta detalhada
                if (statusCode != 200) {
                    System.err.println("Erro na autenticação (" + statusCode + "): " + resposta);
                    return null;
                }
                
                JSONObject jsonResponse = new JSONObject(resposta);
                return jsonResponse.getString("access_token");
            }
        } catch (Exception e) {
            System.err.println("Erro crítico na autenticação: " + e.getMessage());
        }
        return null;
    }
}
