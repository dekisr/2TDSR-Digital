package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExame;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExameResponse;

public class ConsoleViewTres {
  public static void main(String[] args) {

    Scanner tec = new Scanner(System.in);

    System.out.print("Qual é a sua média: ");
    float media = tec.nextFloat();
    
    try {
      DisciplinaBOStub stub = new DisciplinaBOStub();
      CalcularNotaExame valores = new CalcularNotaExame();
      valores.setMedia(media);
      CalcularNotaExameResponse resp = stub.calcularNotaExame(valores);
      System.out.println("Você precisa de mais " + resp.get_return() + " pontos.");
    } catch (Exception e) {
      e.printStackTrace();
    }

    tec.close();
  }
}
