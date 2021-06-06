package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class botoes {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, 
				SWT.CLOSE | SWT.TITLE | SWT.MIN |
				SWT.MAX | SWT.RESIZE);
		shell.setLayout(new RowLayout());
		shell.setText("Botões SWT");

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Botão simples");
		
		Button checkBox = new Button(shell, SWT.CHECK);
		checkBox.setText("Checkbox");
		
		Button radio1 = new Button(shell, SWT.RADIO);
		radio1.setText("Radio 1");

		Button radio2 = new Button(shell, SWT.RADIO);
		radio2.setText("Radio 2");
		
		Button toggle = new Button(shell, SWT.TOGGLE);
		toggle.setText("Toggle Button");

		Button arrowUp = new Button(shell, SWT.ARROW | SWT.UP);
		Button arrowDown = new Button(shell, SWT.ARROW | SWT.DOWN);

		shell.setSize(300, 300);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	} 

}
