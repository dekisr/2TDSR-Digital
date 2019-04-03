package br.com.fiap.view;

import java.util.Scanner;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreioView {
  public static void main(String[] args) {
    //Calcular o prazo de entrega:
    Scanner tec = new Scanner(System.in);
    
    System.out.print("Digite o código do serviço: ");
    String codigo = tec.nextLine();
    System.out.print("Digite o CEP da origem: ");
    String cepOrigem = tec.nextLine();
    System.out.print("Digite o CEP do destino: ");
    String cepDestino = tec.nextLine();
    
    try {
      CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
      CalcPrazo valores = new CalcPrazo();
      valores.setNCdServico(codigo);
      valores.setSCepOrigem(cepOrigem);
      valores.setSCepDestino(cepDestino);
      CalcPrazoResponse resp = stub.calcPrazo(valores);
      System.out.println("Prazo de entrega: " +
      resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
      System.out.println("Data Máxima: " +
          resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    tec.close();
    
  }
}