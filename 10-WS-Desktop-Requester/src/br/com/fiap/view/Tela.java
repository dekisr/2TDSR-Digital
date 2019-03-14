package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

  protected Shell shell;
  private Text txtNumero1;
  private Text txtNumero2;
  private Text txtResultado;
  private Text txtCepOrigem;
  private Text txtCepDestino;
  private Text txtPrazo;
  private Text txtDataMax;

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

    Label lblNum1 = new Label(shell, SWT.NONE);
    lblNum1.setBounds(10, 20, 55, 15);
    lblNum1.setText("N\u00FAmero 1");

    txtNumero1 = new Text(shell, SWT.BORDER);
    txtNumero1.setBounds(85, 17, 76, 21);

    Label lblNum2 = new Label(shell, SWT.NONE);
    lblNum2.setBounds(10, 47, 55, 15);
    lblNum2.setText("N\u00FAmero 2");

    txtNumero2 = new Text(shell, SWT.BORDER);
    txtNumero2.setBounds(85, 44, 76, 21);

    Button btnSomar = new Button(shell, SWT.NONE);
    btnSomar.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        // Executado no clique do botão
        // Capturar os dois valores
        int num1 = Integer.parseInt(txtNumero1.getText());
        int num2 = Integer.parseInt(txtNumero2.getText());
        // Somar
        int soma = num1 + num2;
        // Exibir a resposta
        txtResultado.setText(Integer.toString(soma));
      }
    });
    btnSomar.setBounds(86, 71, 75, 25);
    btnSomar.setText("SOMAR");

    Label lblResultado = new Label(shell, SWT.NONE);
    lblResultado.setBounds(10, 105, 55, 15);
    lblResultado.setText("Resultado");

    txtResultado = new Text(shell, SWT.BORDER);
    txtResultado.setBounds(85, 102, 76, 21);

    Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
    label.setBounds(210, 10, 2, 230);

    Label lblCepOrigem = new Label(shell, SWT.NONE);
    lblCepOrigem.setBounds(242, 20, 70, 15);
    lblCepOrigem.setText("CEP Origem");

    txtCepOrigem = new Text(shell, SWT.BORDER);
    txtCepOrigem.setBounds(325, 17, 76, 21);

    Label lblCepDestino = new Label(shell, SWT.NONE);
    lblCepDestino.setBounds(242, 47, 70, 15);
    lblCepDestino.setText("CEP Destino");

    txtCepDestino = new Text(shell, SWT.BORDER);
    txtCepDestino.setBounds(325, 44, 76, 21);

    Button btnCalcular = new Button(shell, SWT.NONE);
    btnCalcular.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        String cepOrigem = txtCepOrigem.getText();
        String cepDesstino = txtCepDestino.getText();
        String codigo = "40010"; // SEDEX
        try {
          // Chama o Web Service
          CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
          // Parâmetros que serão enviados ao Web Service
          CalcPrazo valores = new CalcPrazo();
          valores.setNCdServico(codigo);
          valores.setSCepOrigem(cepOrigem);
          valores.setSCepDestino(cepDesstino);
          // Chamando o Web Service e recuperando a resposta
          CalcPrazoResponse resp = stub.calcPrazo(valores);
          txtPrazo.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
          txtDataMax.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnCalcular.setBounds(326, 71, 75, 25);
    btnCalcular.setText("CALCULAR");

    txtPrazo = new Text(shell, SWT.BORDER);
    txtPrazo.setBounds(325, 102, 76, 21);

    txtDataMax = new Text(shell, SWT.BORDER);
    txtDataMax.setBounds(325, 129, 76, 21);

    Label lblDataMx = new Label(shell, SWT.NONE);
    lblDataMx.setBounds(242, 132, 70, 15);
    lblDataMx.setText("Data M\u00E1xima");

    Label lblPrazo = new Label(shell, SWT.NONE);
    lblPrazo.setBounds(242, 105, 55, 15);
    lblPrazo.setText("Prazo");

  }
}
