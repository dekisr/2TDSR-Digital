package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

  protected Shell shell;
  private Text txtCodigoProduto;
  private Table table;

  /**
   * Launch the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    try {
      Tela window = new Tela();
      window.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Open the window.
   */
  public void open() {
    Display display = Display.getDefault();
    createContents();
    shell.open();
    shell.layout();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents() {
    shell = new Shell();
    shell.setSize(450, 300);
    shell.setText("SWT Application");

    Label lblCdigoProduto = new Label(shell, SWT.NONE);
    lblCdigoProduto.setBounds(10, 13, 109, 15);
    lblCdigoProduto.setText("C\u00F3digo do Produto");

    txtCodigoProduto = new Text(shell, SWT.BORDER);
    txtCodigoProduto.setBounds(125, 10, 76, 21);

    Button btnPesquisar = new Button(shell, SWT.NONE);
    btnPesquisar.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        try {
          // Instanciar a classe que chama o Web Service (Stub)
          EstoqueBOStub stub = new EstoqueBOStub();
          // Ler o código
          int codigo = Integer.parseInt(txtCodigoProduto.getText());
          // Instanciar a classe que armazena o código que será enviado
          ConsultarProduto valores = new ConsultarProduto();
          valores.setCodigo(codigo);
          // Chamar o Web Service e recuperar o objeto que possui a resposta
          ConsultarProdutoResponse resp = stub.consultarProduto(valores);
          // Recupera e exibe os dados retornados pelo Web Service
          ProdutoTO produto = resp.get_return();
          table.removeAll();
          // Exibir na tabela
          TableItem item = new TableItem(table, 0);
          item.setText(new String[] {
              String.valueOf(produto.getCodigo()),
              produto.getDescricao(),
              String.valueOf(produto.getPreco()),
              String.valueOf(produto.getQuantidade())});
        } catch (Exception e2) {
//          System.out.println(e2.getMessage());
          MessageBox dialog = new MessageBox(shell);
          dialog.setMessage(e2.getMessage());
          dialog.open();
        }
      }
    });
    btnPesquisar.setBounds(126, 37, 75, 25);
    btnPesquisar.setText("PESQUISAR");

    table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
    table.setBounds(10, 82, 414, 169);
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
    tblclmnCodigo.setWidth(90);
    tblclmnCodigo.setText("C\u00D3DIGO");

    TableColumn tblclmnDescricao = new TableColumn(table, SWT.NONE);
    tblclmnDescricao.setWidth(121);
    tblclmnDescricao.setText("DESCRI\u00C7\u00C3O");

    TableColumn tblclmnPreco = new TableColumn(table, SWT.NONE);
    tblclmnPreco.setWidth(97);
    tblclmnPreco.setText("PRE\u00C7O");

    TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
    tblclmnQuantidade.setWidth(100);
    tblclmnQuantidade.setText("QUANTIDADE");

    TableItem tableItem = new TableItem(table, SWT.NONE);

  }
}
