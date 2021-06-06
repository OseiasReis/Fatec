package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class radio {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, 
				SWT.CLOSE | SWT.TITLE | SWT.MIN |
				SWT.MAX | SWT.RESIZE);
		shell.setLayout(new RowLayout());
		shell.setText("Radios SWT");

        Group gp = new Group(shell, SWT.NONE);
        gp.setLayout(new RowLayout(SWT.VERTICAL));
        gp.setText("Selecione um");
 
        Button buttonMr = new Button(gp, SWT.RADIO);
        buttonMr.setText("Escolha 1");
 
        Button buttonMrs = new Button(gp, SWT.RADIO);
        buttonMrs.setText("Escolha 2");
 
        Button buttonMs = new Button(gp, SWT.RADIO);
        buttonMs.setText("Escolha 3");

		shell.setSize(200, 200);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
