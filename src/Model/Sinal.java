package Model;

import java.util.ArrayList;
import java.util.List;

public class Sinal {
 private int id;
 private String termo;
 private String acepcao;
 private String pontoArticulacao;
 private String configuracaoMao;
 private String urlVideoSinal;
 private String urlVideoExemplo;

 public Sinal(int id, String termo, String acepcao, String pontoArticulacao, String configuracaoMao) {
     this.id = id;
     this.termo = termo;
     this.acepcao = acepcao;
     this.pontoArticulacao = pontoArticulacao;
     this.configuracaoMao = configuracaoMao;
 }

 public int getId() { return id; }
 public String getTermo() { return termo; }
 public void setTermo(String termo) { this.termo = termo; }
 
 public String getAcepcao() { return acepcao; }
 public String getPontoArticulacao() { return pontoArticulacao; }
 
 public String getUrlVideoSinal() { return urlVideoSinal; }
 public void setUrlVideoSinal(String url) { this.urlVideoSinal = url; }
 
 @Override
 public String toString() {
     return "ID: " + id + " | Sinal: " + termo + " | Articulação: " + pontoArticulacao;
 }
}