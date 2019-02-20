package br.com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

public class Filial {
  // 1 - Atributo estático que armazena o único objeto
  private static Properties props;

  // 2 - Método que retorna o único objeto
  public static Properties getInstance() {
    if (props == null) {
      props = new Properties();
      // carregar o objeto com as configurações do arquivo
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
