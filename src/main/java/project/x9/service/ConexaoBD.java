package project.x9.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConexaoBD {
    public static void main(String[] args) {
        String url = "https://api.armcorporation.com.br/auth";
        String apiToken = "";

        // 1. Carregar o token do arquivo .properties
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);
            apiToken = prop.getProperty("API_AUTH_TOKEN");
        } catch (IOException e) {
            System.err.println("Erro: Arquivo config.properties não encontrado na raiz.");
            return;
        }

        if (apiToken == null || apiToken.isEmpty()) {
            System.err.println("Erro: Chave API_AUTH_TOKEN não definida no arquivo.");
            return;
        }

        try {
            HttpClient client = HttpClient.newHttpClient();

            // 2. Requisição com o Header de Autorização
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + apiToken)
                    .GET()
                    .build();

            System.out.println("A ligar à API (Autenticação por ficheiro)...");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Sucesso! Resposta: " + response.body());
            } else {
                System.out.println("Erro " + response.statusCode() + ": " + response.body());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}