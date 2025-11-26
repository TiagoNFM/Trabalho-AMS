package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinalRepository {
    private List<Sinal> bancoDeSinais = new ArrayList<>();
    private int contadorId = 1;

    public void salvar(Sinal sinal) {
        if (sinal.getId() == 0) {
            bancoDeSinais.add(sinal);
        } else {
            remover(sinal.getId());
            bancoDeSinais.add(sinal);
        }
    }

    public List<Sinal> listarTodos() {
        return new ArrayList<>(bancoDeSinais);
    }

    public List<Sinal> buscarPorTermo(String termo) {
        return bancoDeSinais.stream()
                .filter(s -> s.getTermo().toLowerCase().contains(termo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Sinal buscarPorId(int id) {
        return bancoDeSinais.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public boolean remover(int id) {
        return bancoDeSinais.removeIf(s -> s.getId() == id);
    }

    public int gerarProximoId() {
        return contadorId++;
    }
}