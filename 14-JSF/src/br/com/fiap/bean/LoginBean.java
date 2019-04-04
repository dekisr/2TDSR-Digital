package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

  private String usuario;
  private String senha;
  private String mensagem;

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  
  public void logar( ) {
    if(usuario.contentEquals("admin") && senha.equals("admin")) {
      mensagem = "Login realizado com sucesso";
    } else {
      mensagem = "Login inválido";
    }
    System.out.println(getMensagem());
  }

}
