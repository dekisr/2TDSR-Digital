package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.FilmeBO;
import br.com.fiap.to.Filme;

@ManagedBean
public class FilmeBean {

  private Filme filme;
  private FilmeBO bo;

  @PostConstruct
  public void iniciar() {
    filme = new Filme();
    bo = new FilmeBO();
  }

  public Filme getFilme() {
    return filme;
  }

  public void setFilme(Filme filme) {
    this.filme = filme;
  }

  public FilmeBO getBo() {
    return bo;
  }

  public void setBo(FilmeBO bo) {
    this.bo = bo;
  }

  public List<Filme> listar() {
    return bo.listar();
  }

  public void cadastrar() {
    bo.cadastrar(getFilme());

    FacesMessage msg = new FacesMessage("Cadastrado!");
    FacesContext.getCurrentInstance().addMessage(null, msg);

    System.out.println("Cadastrou o filme " + filme.getTitulo());
  }

}
