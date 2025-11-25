package Model;

import java.util.ArrayList;
import java.util.List;

public class SinalRepository {
 private List<Sinal> bancoDeDados = new ArrayList<>();
 private int contadorId = 1;

 public void salvar(Sinal sinal) {
     bancoDeDados.add(sinal);
 }

 public List<Sinal> listarTodos() {
     return bancoDeDados;
 }

 public Sinal buscarPorTermo(String termoBusca) {
     for (Sinal s : bancoDeDados) {
         if (s.getTermo().equalsIgnoreCase(termoBusca)) {
             return s;
         }
     }
     return null;
 }
 
 public int proximoId() {
     return contadorId++;
 }
}