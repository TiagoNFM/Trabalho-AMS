package Model;

import java.time.LocalDateTime;

public class Historico {
    private Estudante estudante;
    private Sinal sinalVisualizado;
    private LocalDateTime dataAcesso;

    public Historico(Estudante estudante, Sinal sinalVisualizado) {
        this.estudante = estudante;
        this.sinalVisualizado = sinalVisualizado;
        this.dataAcesso = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Visto em: " + dataAcesso + " | Sinal: " + sinalVisualizado.getTermo();
    }
}
