package br.com.fiap.loja.bean;

public class Produto {
  private int codigo;
  private float pre�o;
  private int quantidade;
  private String descricao;

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

  public float getPre�o() {
    return pre�o;
  }

  public void setPre�o(float pre�o) {
    this.pre�o = pre�o;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
