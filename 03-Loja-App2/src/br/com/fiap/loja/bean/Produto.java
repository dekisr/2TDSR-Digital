package br.com.fiap.loja.bean;

public class Produto {
  private int codigo;
  private float preço;
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

  public float getPreço() {
    return preço;
  }

  public void setPreço(float preço) {
    this.preço = preço;
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
