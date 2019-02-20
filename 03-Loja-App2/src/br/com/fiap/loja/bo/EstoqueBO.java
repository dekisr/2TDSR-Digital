package br.com.fiap.loja.bo;

public class EstoqueBO {
  public String consultarProduto(int codProduto) {
    String produto;
    switch (codProduto) {
    case 401:
      produto = "Camiseta Branca";
      break;
    case 402:
      produto = "Camiseta Azul";
      break;
    case 403:
      produto = "Camiseta Rosa";
      break;
    default:
      produto = "Produto não encontrado";
    }
    return produto;
  }
}
