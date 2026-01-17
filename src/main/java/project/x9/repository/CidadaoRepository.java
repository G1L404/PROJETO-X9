package project.x9.repository;

public class CidadaoRepository {
    // FAKE - simulação enquanto não tem banco
    public boolean autenticar(String email, String senha) {
        return "admin@x9.com".equalsIgnoreCase(email) && "123".equals(senha);
    }
}
