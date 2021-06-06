package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class proj_final {
	private static int selecoes = 0;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, 
				SWT.CLOSE | SWT.TITLE | SWT.MIN |
				SWT.MAX | SWT.RESIZE);
		shell.setLayout(null);
		shell.setText("SWT final");
		shell.setImage(new Image(Display.getCurrent(), 
				"images/ti.PNG") );
		//shell.setBackground(new Color( Display.getCurrent(), 
		//172, 189, 208 ) );

		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);

		MenuItem subMenuItemOp = new MenuItem(menuBar, SWT.CASCADE);
		subMenuItemOp.setText("Opções");

		Menu submenu = new Menu(shell, SWT.DROP_DOWN);
		subMenuItemOp.setMenu(submenu);

		MenuItem abrirItem = new MenuItem(submenu, SWT.PUSH);
		abrirItem.setText("Abrir");

		MenuItem salvarItem = new MenuItem(submenu, SWT.PUSH);
		salvarItem.setText("Salvar");

		MenuItem mI = new MenuItem(menuBar, SWT.PUSH);
		mI.setText("Info");
		mI.addSelectionListener(new org.eclipse.swt.events.
				SelectionAdapter(){
			public void widgetSelected(org.eclipse.swt.events.
					SelectionEvent e)
			{
				mensagem();
			}
		});

		MenuItem exit = new MenuItem(menuBar, SWT.PUSH);
		exit.setText("&Exit");
		exit.addListener(SWT.Selection, event-> {
			shell.getDisplay().dispose();
			System.exit(0);
		});


		Label lbl1 = new Label(shell, SWT.BORDER);
		lbl1.setText("Nome:");
		lbl1.setBounds(20, 80, 40, 20);

		Label lbl2 = new Label(shell, SWT.NULL);
		lbl2.setText("Email:");
		lbl2.setBounds(20, 120, 40, 20);

		Label lbl3 = new Label(shell, SWT.NULL);
		lbl3.setText("Senha:");
		lbl3.setBounds(20, 170, 40, 20);

		Label lbl4 = new Label(shell, SWT.NULL);
		lbl4.setText("Descrição:");
		lbl4.setBounds(20, 210, 55, 20);
		
		Label lbl5 = new Label(shell, SWT.NULL);
		lbl5.setText("Oculto:");
		lbl5.setBounds(20, 350, 55, 20);
		//lbl5.setVisible(false);

		Text txt1 = new Text(shell, SWT.BORDER);
		txt1.setBounds(80, 80, 180, 20);

		Text txt2 = new Text(shell, SWT.RIGHT | SWT.BORDER);
		txt2.setBounds(80, 120, 220, 30);

		Text txt3 = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		txt3.setBounds(80, 170, 120, 20);

		Text txt4 = new Text(shell, SWT.MULTI | 
				SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txt4.setLayoutData(new GridData(GridData.FILL_BOTH));
		txt4.setBounds(80, 210, 150, 100);

		Combo cb = new Combo(shell, SWT.READ_ONLY);
		cb.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		cb.add("Opção 5");
		cb.add("Opção 4");
		cb.add("Opção 3");
		cb.add("Opção 2");
		cb.add("Opção 1");
		cb.setBounds(380, 20, 100, 20);

		Button btn1 = new Button(shell, SWT.PUSH);
		btn1.setText("Clique Aqui Agora!!!");
		btn1.setBounds(20, 20, 120, 40);
		//x=20, y =20, largura=120, altura=40
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				Button buttonClicked = (Button) 
						event.getSource();
				selecoes += 1;
				buttonClicked.setText(String.format(
						"Fui clicado %s vezes!", selecoes));
				if(selecoes == 1) {
					txt1.setText("Oséias");
				}else 
					if(selecoes == 2){
						txt2.setText("oseias@teste.com");
					}else
						if(selecoes == 3) {
							txt3.setText("12345");
						}else				
							txt4.setText(txt4.getText() + 
									" teste " + selecoes);
			}
		});

		Image imagem1 = new Image(display,
				"images/Info.png");
		Label lbl6 = new Label(shell, SWT.NULL);
		lbl6.setBounds(430, 60, 350, 350);
		lbl6.setImage(imagem1);

		Image imagem2 = new Image(display,
				"images/Info2.png");
		Button btnImagem = new Button(shell,SWT.PUSH);
		btnImagem.setImage(imagem2);
		btnImagem.setBounds(380, 80, 50, 50);
		btnImagem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				mensagem();
			}
		});

		shell.setSize(800, 600);
		shell.setLocation(570, 220);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static void mensagem() {
		MessageBox msg = new MessageBox(new Shell(), 
				SWT.CHECK | SWT.OK);
		msg.setText("Informações");
		msg.setMessage("Desenvolvido por:\n"
				+ "Oséias Pereira Reis 2019");
		msg.open();
	}
}
