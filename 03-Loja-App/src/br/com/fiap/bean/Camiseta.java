package br.com.fiap.bean;

public class Camiseta extends Produto {

  private TipoCamiseta tipo;

  public Camiseta() {
    super();
  }

  public Camiseta(int codigo, TipoCamiseta tipo) {
    super(codigo);
    this.tipo = tipo;
  }

  public TipoCamiseta getTipo() {
    return tipo;
  }

  public void setTipo(TipoCamiseta tipo) {
    this.tipo = tipo;
  }

}
