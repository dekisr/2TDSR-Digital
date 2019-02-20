package br.com.fiap.bean;

public class Produto {
  private int codigo;

  public Produto() {
    super();
  }

  public Produto(int codigo) {
    super();
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

}
