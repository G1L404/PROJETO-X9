package project.x9.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class conexaoBD {
    public static void main(String[] args) {
        // O endpoint 'auth' que configuramos para retornar o status da conexão
        String url = "https://api.armcorporation.com.br/auth";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET() // O endpoint atual aceita requisições simples
                    .build();

            System.out.println("A ligar à API em: " + url + "...");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Sucesso!");
                System.out.println("Resposta da API: " + response.body());
            } else {
                System.out.println("Erro no servidor. Código: " + response.statusCode());
                System.out.println("Corpo do erro: " + response.body());
            }

        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
