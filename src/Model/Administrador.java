package Model;

public class Administrador extends Usuario {
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    
    public void aprovarSugestao(Sugestao sugestao) {
        sugestao.setStatus("Aprovada");
    }
}