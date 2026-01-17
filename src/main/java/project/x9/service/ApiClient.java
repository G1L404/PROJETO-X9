package project.x9.service;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApiClient {

    private static final String URL_API = "https://api.armcorporation.com.br/"; // Sua URL
    private static String token;
    private static final Gson gson = new Gson();

    static {
        // Carrega o token automaticamente ao iniciar
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            token = prop.getProperty("API_AUTH_TOKEN");
        } catch (Exception e) {
            System.err.println("ERRO: Arquivo config.properties não encontrado na raiz!");
        }
    }

    public static String enviar(String sql, Map<Integer, Object> params) {
        Map<String, Object> body = new HashMap<>();
        body.put("query", sql);
        body.put("params", params != null ? params : new HashMap<>());

        String jsonBody = gson.toJson(body);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return "{\"erro\": \"" + e.getMessage() + "\"}";
        }
    }
}