package br.com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

public class Filial {
  // 1 - Atributo est�tico que armazena o �nico objeto
  private static Properties props;

  // 2 - M�todo que retorna o �nico objeto
  public static Properties getInstance() {
    if (props == null) {
      props = new Properties();
      // carregar o objeto com as configura��es do arquivo
      try {
        props.load(Filial.class.getResourceAsStream("/filial.properties"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return props;
  }

  // 3 - Construtor privado
  private Filial() {
  }
}
