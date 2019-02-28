package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.RetidoFalta;
import br.com.fiap.bo.DisciplinaBOStub.RetidoFaltaResponse;

public class ConsoleViewDois {
  public static void main(String[] args) {

    Scanner tec = new Scanner(System.in);

    System.out.print("Número de aulas: ");
    int aulas = tec.nextInt();
    System.out.print("Número de faltas: ");
    int faltas = tec.nextInt();
    try {
      DisciplinaBOStub stub = new DisciplinaBOStub();
      RetidoFalta valores = new RetidoFalta();
      valores.setAulas(aulas);
      valores.setFaltas(faltas);
      RetidoFaltaResponse resp = stub.retidoFalta(valores);
      boolean retido = resp.get_return();
      System.out.println("Retido por faltas? " + retido);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    tec.close();
  }
}
