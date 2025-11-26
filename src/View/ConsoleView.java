package View;

import Model.ParametrosGramaticais;
import Model.Categoria;
import Model.Video;
import Model.Usuario;
import Model.Administrador;
import Model.Professor;
import Model.Sinal;
import Model.Estudante;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMensagem(String msg) {
        System.out.println("\n[SISTEMA]: " + msg);
    }

    public void exibirTitulo(String titulo) {
        System.out.println("\n=== " + titulo + " ===");
    }

    public String[] mostrarTelaLogin() {
        exibirTitulo("LOGIN - DICIONÁRIO DE LIBRAS");
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        return new String[]{email, senha};
    }

    public int mostrarMenuPrincipal(Usuario usuarioLogado) {
        exibirTitulo("MENU PRINCIPAL - Bem-vindo, " + usuarioLogado.getNome());
        
        System.out.println("1. Listar todos os Sinais");
        System.out.println("2. Buscar Sinal por Termo");

        if (usuarioLogado instanceof Administrador) {
            System.out.println("3. [ADMIN] Cadastrar Novo Sinal");
            System.out.println("4. [ADMIN] Excluir Sinal");
        } else if (usuarioLogado instanceof Professor) {
            System.out.println("3. [PROF] Sugerir Novo Sinal");
        } else if (usuarioLogado instanceof Estudante) {
            System.out.println("3. [ALUNO] Ver Meus Favoritos");
        }

        System.out.println("0. Sair / Logout");
        System.out.print("Escolha uma opção: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Sinal capturarDadosSinal() {
        exibirTitulo("CADASTRAR NOVO SINAL");
        
        System.out.print("Termo (Palavra em Português): ");
        String termo = scanner.nextLine();
        
        System.out.print("Acepção (Significado/Definição): ");
        String acepcao = scanner.nextLine();

        System.out.print("Categoria (ex: Família, Animais): ");
        String nomeCat = scanner.nextLine();
        Categoria categoria = new Categoria(nomeCat);

        System.out.print("Ponto de Articulação (ex: Testa, Queixo): ");
        String ponto = scanner.nextLine();
        
        System.out.print("Configuração de Mão (ex: Mão em 'A'): ");
        String configMao = scanner.nextLine();
        ParametrosGramaticais params = new ParametrosGramaticais(ponto, configMao);

        Sinal novoSinal = new Sinal(0, termo, acepcao, params, categoria);

        System.out.print("URL do Vídeo do Sinal: ");
        String urlSinal = scanner.nextLine();
        novoSinal.adicionarVideo(new Video(urlSinal, "Sinal", 10));

        System.out.print("URL do Vídeo de Exemplo (Frase): ");
        String urlExemplo = scanner.nextLine();
        if (!urlExemplo.isEmpty()) {
            novoSinal.adicionarVideo(new Video(urlExemplo, "Exemplo", 15));
        }

        return novoSinal;
    }

    public void listarSinais(List<Sinal> sinais) {
        exibirTitulo("LISTA DE SINAIS");
        if (sinais.isEmpty()) {
            System.out.println("Nenhum sinal encontrado no dicionário.");
        } else {
            for (Sinal s : sinais) {
                System.out.println("------------------------------------------------");
                System.out.println("ID: " + s.getId() + " | Termo: " + s.getTermo().toUpperCase());
                System.out.println("Categoria: " + s.getCategoria().getNomeCategoria());
                System.out.println("Gramática: " + s.getParametros().getConfiguracaoMao() + " na " + s.getParametros().getPontoArticulacao());
                System.out.println("Vídeos: " + s.getVideos().size() + " anexado(s)");
            }
            System.out.println("------------------------------------------------");
        }
    }

    public void detalharSinal(Sinal s) {
        if (s == null) {
            exibirMensagem("Sinal não encontrado.");
            return;
        }
        exibirTitulo("DETALHES DO SINAL: " + s.getTermo().toUpperCase());
        System.out.println("Significado: " + s.getAcepcao());
        System.out.println("--- GRAMÁTICA ---");
        System.out.println("Ponto de Articulação: " + s.getParametros().getPontoArticulacao());
        System.out.println("Configuração de Mão: " + s.getParametros().getConfiguracaoMao());
        System.out.println("--- MÍDIA ---");
        for (Video v : s.getVideos()) {
            System.out.println("[" + v.getTipo() + "]: " + v.getUrl());
        }
    }
    
    public String pedirTermoBusca() {
        System.out.print("Digite o termo para buscar: ");
        return scanner.nextLine();
    }
    
    public int pedirIdParaExcluir() {
        System.out.print("Digite o ID do sinal para excluir: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}