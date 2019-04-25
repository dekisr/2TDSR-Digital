package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

@ViewScoped
@ManagedBean
public class EmpresaBean implements Serializable {
  private Empresa empresa;
  private EmpresaRepository repo;

  @PostConstruct
  public void iniciar() {
    empresa = new Empresa();
    repo = new EmpresaRepository();
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public List<Empresa> listar() {
    try {
      return repo.listar();
    } catch (ResponseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void cadastrar() {
    System.out.println("Empresa " + getEmpresa().getNome() + " cadastrada!");
    try {
      if(empresa.getCodigo() == 0) {        
        repo.cadastrar(empresa);
        exibirMensagem("Cadastrado!");
      } else {
        repo.atualizar(empresa);
        exibirMensagem("Atualizado!");
      }
    } catch (ResponseException e) {
      e.printStackTrace();
      exibirMensagem("Erro...");
    }
  }
  
  public void atualizar() {
    System.out.println("Teste");
  }

  public void excluir(int codigo) {
    try {
      repo.remover(codigo);
      exibirMensagem("Removido com sucesso!");
    } catch (ResponseException e) {
      e.printStackTrace();
      exibirMensagem("Erro...");
    }
  }
  
  private void exibirMensagem(String mensagem) {
    FacesMessage msg = new FacesMessage(mensagem);
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

}
