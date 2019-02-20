package br.com.fiap.loja;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class TerminalConsulta {
  public static void main(String[] args) {
    Scanner tec = new Scanner(System.in);
    System.out.println("FIAPStore 11/02/2019");
    System.out.print("Digite o código do produto: ");
    int codigo = tec.nextInt();
    String cor;

    if (codigo == 401) {
      cor = "Camiseta Branca";
    } else if (codigo == 402) {
      cor = "Camiseta Azul";
    } else if (codigo == 403) {
      cor = "Camiseta Rosa";
    } else {
      cor = "Não encontrada";
    }

    System.out.println("Produto: " + cor);
  }
}
