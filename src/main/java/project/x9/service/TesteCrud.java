package project.x9.service;

import java.util.HashMap;
import java.util.Map;

public class TesteCrud {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTE DO CRUD (Tabela: teste_java) ===\n");

        // 0. GARANTIR QUE A TABELA EXISTE
        String sqlCreate = "CREATE TABLE IF NOT EXISTS teste_java (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome_teste VARCHAR(255))";
        System.out.println("0. Criar Tabela: " + ApiClient.enviar(sqlCreate, null));

        // 1. CREATE (Inserir)
        String sqlInsert = "INSERT INTO teste_java (nome_teste) VALUES (?)";
        Map<Integer, Object> paramsInsert = new HashMap<>();
        paramsInsert.put(1, "Teste Inicial");

        System.out.println("1. Inserir: " + ApiClient.enviar(sqlInsert, paramsInsert));

        // 2. READ (Listar)
        System.out.println("2. Listar Antes da Edição: " + ApiClient.enviar("SELECT * FROM teste_java", null));

        // 3. UPDATE (Atualizar - Vamos mudar o ID 1, ajuste se necessário)
        String sqlUpdate = "UPDATE teste_java SET nome_teste = ? WHERE nome_teste = ?";
        Map<Integer, Object> paramsUpdate = new HashMap<>();
        paramsUpdate.put(1, "Teste Editado com Sucesso"); // Novo valor
        paramsUpdate.put(2, "Teste Inicial");             // Valor antigo (filtro)

        System.out.println("3. Atualizar: " + ApiClient.enviar(sqlUpdate, paramsUpdate));

        // 4. READ (Listar Novamente para conferir)
        System.out.println("4. Listar Pós-Edição: " + ApiClient.enviar("SELECT * FROM teste_java", null));

        // 5. DELETE (Excluir)
//        String sqlDelete = "DELETE FROM teste_java WHERE nome_teste = ?";
//        Map<Integer, Object> paramsDelete = new HashMap<>();
//        paramsDelete.put(1, "Teste Editado com Sucesso");
//
//        System.out.println("5. Deletar: " + ApiClient.enviar(sqlDelete, paramsDelete));

        System.out.println("\n=== FIM DO TESTE ===");
    }
}