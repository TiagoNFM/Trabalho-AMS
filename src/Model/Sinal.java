package Model;

import java.util.ArrayList;
import java.util.List;

public class Sinal {
    private int id;
    private String termo;
    private String acepcao;
    
    private ParametrosGramaticais parametros;
    private Categoria categoria;
    
    private List<Video> videos = new ArrayList<>();
    private List<VariacaoRegional> variacoes = new ArrayList<>();

    public Sinal(int id, String termo, String acepcao, ParametrosGramaticais parametros, Categoria categoria) {
        this.id = id;
        this.termo = termo;
        this.acepcao = acepcao;
        this.parametros = parametros;
        this.categoria = categoria;
    }

    public void adicionarVideo(Video video) {
        this.videos.add(video);
    }

    public void adicionarVariacao(VariacaoRegional variacao) {
        this.variacoes.add(variacao);
    }

    public int getId() { return id; }
    public String getTermo() { return termo; }
    public void setTermo(String termo) { this.termo = termo; }
    public String getAcepcao() { return acepcao; }
    public void setAcepcao(String acepcao) { this.acepcao = acepcao; }
    public ParametrosGramaticais getParametros() { return parametros; }
    public void setParametros(ParametrosGramaticais parametros) { this.parametros = parametros; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<Video> getVideos() { return videos; }
    public List<VariacaoRegional> getVariacoes() { return variacoes; }
}