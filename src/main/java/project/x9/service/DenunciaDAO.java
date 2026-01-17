package project.x9.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import project.x9.model.Denuncia;
import project.x9.service.ApiClient;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DenunciaDAO {

    private final Gson gson = new Gson();

    // 1. Método para SALVAR (Insert)
    public void salvar(Denuncia denuncia) {
        String sql = "INSERT INTO denuncias (titulo, descricao) VALUES (?, ?)";

        Map<Integer, Object> params = new HashMap<>();
        params.put(1, denuncia.getTitulo());
        params.put(2, denuncia.getDescricao());

        String resposta = ApiClient.enviar(sql, params);
        System.out.println("Status Salvar: " + resposta);
    }

    // 2. Método para LISTAR (Select)
    public List<Denuncia> listarTodas() {
        String sql = "SELECT * FROM denuncias ORDER BY id DESC";
        String json = ApiClient.enviar(sql, null);

        if (json == null || json.contains("erro")) {
            System.err.println("Erro ao listar: " + json);
            return new ArrayList<>();
        }

        // Converte o JSON em Lista de Objetos Denuncia
        Type tipoLista = new TypeToken<ArrayList<Denuncia>>(){}.getType();
        return gson.fromJson(json, tipoLista);
    }

    // 3. Método para DELETAR
    public void excluir(int id) {
        String sql = "DELETE FROM denuncias WHERE id = ?";
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);

        ApiClient.enviar(sql, params);
        System.out.println("Denúncia " + id + " excluída.");
    }
}