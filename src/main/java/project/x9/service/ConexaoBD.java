package project.x9.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConexaoBD {

    private static String apiToken;
    // URL base da sua API no CloudPanel
    private static final String URL_API = "https://api.armcorporation.com.br/";

    public static void main(String[] args) {
        carregarToken();

        // Exemplo: Criando uma tabela pelo Java
        String sql = "CREATE TABLE IF NOT EXISTS denúncias (id INT AUTO_INCREMENT PRIMARY KEY, relato TEXT)";
        String resposta = executarComando(sql, "{}"); // {} para nenhum parâmetro

        System.out.println("Resposta do Servidor: " + resposta);
    }

    private static void carregarToken() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);
            apiToken = prop.getProperty("API_AUTH_TOKEN");
        } catch (IOException e) {
            System.err.println("Erro: config.properties não encontrado.");
        }
    }

    /**
     * Método para enviar comandos SQL para a API
     */
    public static String executarComando(String sql, String jsonParams) {
        // Monta o JSON manualmente ou use a biblioteca GSON
        String jsonBody = "{\"query\": \"" + sql + "\", \"params\": " + jsonParams + "}";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .header("Authorization", "Bearer " + apiToken)
                    .header("Content-Type", "application/json")
                    // MUDANÇA: Agora é POST com o corpo do JSON
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}