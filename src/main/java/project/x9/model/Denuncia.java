package project.x9.model;

public class Denuncia {
    private int id;
    private String titulo;
    private String descricao;
    private String data_criacao;

    // Construtor vazio (obrigatório para o Gson)
    public Denuncia() {}

    // Construtor para criar novas denúncias
    public Denuncia(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getDataCriacao() { return data_criacao; }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}