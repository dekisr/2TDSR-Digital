package br.com.fiap.to;

public class Filme {

  private String titulo;
  private String classificacao;
  private int duracao;
  private String estudio;
  private boolean nacional;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(String classificacao) {
    this.classificacao = classificacao;
  }

  public int getDuracao() {
    return duracao;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public String getEstudio() {
    return estudio;
  }

  public void setEstudio(String estudio) {
    this.estudio = estudio;
  }

  public boolean isNacional() {
    return nacional;
  }

  public void setNacional(boolean nacional) {
    this.nacional = nacional;
  }

}
