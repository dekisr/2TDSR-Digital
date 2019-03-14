package br.com.fiap.loja.view;

import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {
  public static void main(String[] args) {
    try {
      // Instanciar a classe que chama o Web Service (Stub)
      EstoqueBOStub stub =  new EstoqueBOStub();
      // Ler o código
      Scanner tec = new Scanner(System.in);
      System.out.print("Digite o código do produto: ");
      int codigo = tec.nextInt();
      tec.close();
      // Instanciar a classe que armazena o código que será enviado
      ConsultarProduto valores = new ConsultarProduto();
      valores.setCodigo(codigo);
      // Chamar o Web Service e recuperar o objeto que possui a resposta
      ConsultarProdutoResponse resp = stub.consultarProduto(valores);
      // Recupera e exibe os dados retornados pelo Web Service
      ProdutoTO produto = resp.get_return();
      System.out.println(produto.getDescricao());
      System.out.println("Preço: " + produto.getPreco());
      System.out.println("Quantidade: " + produto.getQuantidade());
    } catch (Exception e) {
//      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}