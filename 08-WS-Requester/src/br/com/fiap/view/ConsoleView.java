package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMediaResponse;

public class ConsoleView {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Ler os valores de NAC, PS e AM
    System.out.print("NAC: ");
    float nac = sc.nextFloat();
    System.out.print("PS: ");
    float ps = sc.nextFloat();
    System.out.print("AM: ");
    float am = sc.nextFloat();

    try {
      // Instanciar o stub para acessar o Web Service
      DisciplinaBOStub stub = new DisciplinaBOStub();
      CalcularMedia valores = new CalcularMedia();
      valores.setNac(nac);
      valores.setPs(ps);
      valores.setAm(am);
      // Chamando o Web Service
      CalcularMediaResponse resp = stub.calcularMedia(valores);
      // Recuperar o valor retornado pelo Web Service
      double media = resp.get_return();
      System.out.println("Sua média é: " + media);
    } catch (Exception e) {
      e.printStackTrace();
    }

    sc.close();
  }
}