package br.com.fiap.bo;

public class CambioBO {
  public double converterRealDolar(double real) {
    return real/0.373;
  }

  public double converterDolarReal(double dolar) {
    return dolar*3.73;
  }
  public double converterBitCoinReal(double bitcoin) {
    return bitcoin*14600;
  }
}