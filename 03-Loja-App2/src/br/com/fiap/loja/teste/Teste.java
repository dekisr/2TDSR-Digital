package br.com.fiap.loja.teste;

import br.com.fiap.loja.singleton.Filial;

public class Teste {
  public static void main(String[] args) {
    String nomeFilial = Filial.getInstance().getProperty("nome");
    System.out.println(nomeFilial);
  }
}