package Model;

import java.time.LocalDateTime;

public class Favorito {
    private Estudante estudante;
    private Sinal sinal;
    private LocalDateTime dataFavoritado;

    public Favorito(Estudante estudante, Sinal sinal) {
        this.estudante = estudante;
        this.sinal = sinal;
        this.dataFavoritado = LocalDateTime.now();
    }

    public Sinal getSinal() { return sinal; }
}