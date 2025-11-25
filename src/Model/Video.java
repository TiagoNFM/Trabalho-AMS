package Model;
 
public class Video {
 private String url;
 private String tipo; //"Sinal" ou "Exemplo"
 private int duracaoSegundos;

 public Video(String url, String tipo, int duracaoSegundos) {
     this.url = url;
     this.tipo = tipo;
     this.duracaoSegundos = duracaoSegundos;
 }

 public String getUrl() { return url; }
 public void setUrl(String url) { this.url = url; }
 public String getTipo() { return tipo; }
 public void setTipo(String tipo) { this.tipo = tipo; }
 public int getDuracaoSegundos() { return duracaoSegundos; }
 public void setDuracaoSegundos(int duracaoSegundos) { this.duracaoSegundos = duracaoSegundos; }
}