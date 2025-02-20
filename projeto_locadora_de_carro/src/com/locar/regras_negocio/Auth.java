package com.locar.regras_negocio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.json.JSONObject;

public class Auth {
	private final String client_id = "Client_Id_84c9e11ffc7f73bfca3f6573dedbe1e5acf3d07a";
	private final String client_secret = "Client_Secret_ef783d43c9c3bc3843bd4cc2c048197394b7a6de";
	private final String basicAuth = Base64.getEncoder().encodeToString(((client_id+':'+client_secret).getBytes()));
	
	public String geraToken() {
		String access_token="";
		try {
			//Diretório em que seu certificado em formato .p12 deve ser inserido
	        System.setProperty("javax.net.ssl.keyStore", "homologacao-712869-LoCar.p12"); 
	        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
	       
	        URL url = new URL("https://api.sandbox.gerencianet.com.br/oauth/token");             
	        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Authorization", "Basic "+ basicAuth);
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
	          //System.out.println(response);
	          responseBuilder.append(response);
	        }
	        try {
				JSONObject jsonObject = new JSONObject(responseBuilder.toString());
				access_token = jsonObject.getString("access_token");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro na conversão de "+responseBuilder);
				e.printStackTrace();
			}
	        conn.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na autenticação de ");
			e.printStackTrace();
		}
        
		return access_token;
	}

}
