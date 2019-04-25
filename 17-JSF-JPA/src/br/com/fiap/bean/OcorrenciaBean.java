package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.OcorrenciaDAO;
import br.com.fiap.dao.impl.OcorrenciaDAOImpl;
import br.com.fiap.entity.Ocorrencia;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class OcorrenciaBean implements Serializable {
  private Ocorrencia ocorrencia;
  private OcorrenciaDAO dao;

  @PostConstruct
  public void init() {
    ocorrencia = new Ocorrencia();
    ocorrencia.setData(Calendar.getInstance());
    dao = new OcorrenciaDAOImpl(EntityManagerFactorySingleton
        .getInstance().createEntityManager());
  }
  
  public List<Ocorrencia> listar() {
    return dao.listar();
  }

  public String cadastrar() {
    try {
      dao.cadastrar(ocorrencia);
      dao.commit();
      adicionarMensagem("Cadastrado!");
      return "lista-ocorrencia?faces-redirect=true";
    } catch (CommitException e) {
      e.printStackTrace();
      adicionarMensagem("Erro...");
      return "ocorrencia?faces-redirect=true"; //nome da página
    }
  }

  private void adicionarMensagem(String mensagem) {
    FacesMessage msg = new FacesMessage(mensagem);
    FacesContext.getCurrentInstance().addMessage(null, msg);
    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
  }

  public Ocorrencia getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(Ocorrencia ocorrencia) {
    this.ocorrencia = ocorrencia;
  }

  public OcorrenciaDAO getDao() {
    return dao;
  }

  public void setDao(OcorrenciaDAO dao) {
    this.dao = dao;
  }
}