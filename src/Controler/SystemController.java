package Controler;

import Model.Sinal;
import Model.Usuario;
import Model.Administrador;
import Model.Estudante;
import Model.Professor;
import Model.SinalRepository;
import Model.UsuarioRepository;
import View.ConsoleView;

import java.util.List;

public class SystemController {
    private SinalRepository sinalRepo;
    private UsuarioRepository usuarioRepo;
    private ConsoleView view;
    
    private Usuario usuarioLogado;

    public SystemController(SinalRepository sinalRepo, UsuarioRepository usuarioRepo, ConsoleView view) {
        this.sinalRepo = sinalRepo;
        this.usuarioRepo = usuarioRepo;
        this.view = view;
    }

    public void iniciar() {
        boolean sistemaRodando = true;

        while (sistemaRodando) {
            if (usuarioLogado == null) {
                fazerLogin();
            } else {
                int opcao = view.mostrarMenuPrincipal(usuarioLogado);
                processarOpcaoMenu(opcao);
                
                if (opcao == 0) {
                    usuarioLogado = null;
                }
            }
        }
    }

    private void fazerLogin() {
        String[] credenciais = view.mostrarTelaLogin();
        Usuario user = usuarioRepo.autenticar(credenciais[0], credenciais[1]);
        
        if (user != null) {
            this.usuarioLogado = user;
            view.exibirMensagem("Login realizado com sucesso! Bem-vindo, " + user.getNome());
        } else {
            view.exibirMensagem("Erro: E-mail ou senha inválidos.");
        }
    }

    private void processarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                listarSinais();
                break;
            case 2:
                buscarSinal();
                break;
            case 3:
                if (usuarioLogado instanceof Administrador) {
                    cadastrarSinal();
                } else if (usuarioLogado instanceof Estudante) {
                    view.exibirMensagem("Função de Favoritos ainda não implementada.");
                } else if (usuarioLogado instanceof Professor) {
                    view.exibirMensagem("Função de Sugestão ainda não implementada.");
                }
                break;
            case 4:
                if (usuarioLogado instanceof Administrador) {
                    excluirSinal();
                } else {
                    view.exibirMensagem("Opção inválida.");
                }
                break;
            case 0:
                view.exibirMensagem("Fazendo logout...");
                break;
            default:
                view.exibirMensagem("Opção inválida.");
        }
    }

    private void cadastrarSinal() {
        Sinal novoSinal = view.capturarDadosSinal();
        
        int id = sinalRepo.gerarProximoId();
        
        Sinal sinalComId = new Sinal(id, novoSinal.getTermo(), novoSinal.getAcepcao(), 
                                     novoSinal.getParametros(), novoSinal.getCategoria());
        sinalComId.getVideos().addAll(novoSinal.getVideos());

        sinalRepo.salvar(sinalComId);
        view.exibirMensagem("Sinal cadastrado com sucesso! ID: " + id);
    }

    private void listarSinais() {
        List<Sinal> lista = sinalRepo.listarTodos();
        view.listarSinais(lista);
    }

    private void buscarSinal() {
        String termo = view.pedirTermoBusca();
        List<Sinal> resultados = sinalRepo.buscarPorTermo(termo);
        
        if (resultados.isEmpty()) {
            view.exibirMensagem("Nenhum sinal encontrado com esse termo.");
        } else {
            for (Sinal s : resultados) {
                view.detalharSinal(s);
            }
        }
    }
    
    private void excluirSinal() {
        int id = view.pedirIdParaExcluir();
        boolean sucesso = sinalRepo.remover(id);
        if (sucesso) {
            view.exibirMensagem("Sinal removido com sucesso.");
        } else {
            view.exibirMensagem("Erro: ID não encontrado.");
        }
    }
}