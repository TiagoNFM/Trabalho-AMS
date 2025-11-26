package Model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> bancoDeUsuarios = new ArrayList<>();

    public UsuarioRepository() {
        inicializarDadosTeste();
    }

    private void inicializarDadosTeste() {
        bancoDeUsuarios.add(new Administrador("Admin Chefe", "admin@ines.gov.br", "admin123"));
        
        bancoDeUsuarios.add(new Professor("Prof. Silva", "silva@universidade.br", "123456", "UFRJ"));
        
        bancoDeUsuarios.add(new Estudante("João Aluno", "joao@gmail.com", "aluno123"));
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : bancoDeUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = buscarPorEmail(email);
        if (usuario != null && usuario.validarSenha(senha)) {
            return usuario;
        }
        return null;
    }
}