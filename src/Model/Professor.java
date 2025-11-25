package Model;

public class Professor extends Usuario {
    private String instituicao;

    public Professor(String nome, String email, String senha, String instituicao) {
        super(nome, email, senha);
        this.instituicao = instituicao;
    }
    
    public String getInstituicao() { return instituicao; }
}