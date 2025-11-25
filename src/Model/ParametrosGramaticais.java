package Model;
 
public class ParametrosGramaticais {
 private String pontoArticulacao;
 private String configuracaoMao;

 public ParametrosGramaticais(String pontoArticulacao, String configuracaoMao) {
     this.pontoArticulacao = pontoArticulacao;
     this.configuracaoMao = configuracaoMao;
 }
 
 public String getPontoArticulacao() { return pontoArticulacao; }
 public void setPontoArticulacao(String pontoArticulacao) { this.pontoArticulacao = pontoArticulacao; }
 public String getConfiguracaoMao() { return configuracaoMao; }
 public void setConfiguracaoMao(String configuracaoMao) { this.configuracaoMao = configuracaoMao; }
}