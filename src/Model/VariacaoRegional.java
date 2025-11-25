package Model;

public class VariacaoRegional {
 private String regiao;
 private String descricao;

 public VariacaoRegional(String regiao, String descricao) {
     this.regiao = regiao;
     this.descricao = descricao;
 }

 public String getRegiao() { return regiao; }
 public void setRegiao(String regiao) { this.regiao = regiao; }
 public String getDescricao() { return descricao; }
 public void setDescricao(String descricao) { this.descricao = descricao; }
}