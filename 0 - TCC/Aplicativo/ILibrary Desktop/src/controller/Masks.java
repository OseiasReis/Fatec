package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public final class Masks extends JFormattedTextField {

	private final String CARACTERES = "0987654321";
	private int maximoCaracteres;

	public Masks(String masc) throws ParseException {

		super(new MaskFormatter(masc));

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!CARACTERES.contains(evt.getKeyChar() + "")) {
					evt.consume();
				}
			}

		});
	}

	public Masks(int maximo, boolean letras) {

		this.maximoCaracteres = maximo;

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (letras == false) {
					if (!CARACTERES.contains(evt.getKeyChar() + "")) {
						evt.consume();
					}
				}

				if ((getText().length() >= maximoCaracteres)) {
					evt.consume();
					setText(getText().substring(0, maximoCaracteres));
				}
			}
		});

	}

	public Masks(int maximo) {

		this.maximoCaracteres = maximo;

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {

				if ((getText().length() >= maximoCaracteres)) {
					evt.consume();
					setText(getText().substring(0, maximoCaracteres));
				}
			}
		});
	}

	public Masks(boolean letras) {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (letras == false) {
					if (!CARACTERES.contains(evt.getKeyChar() + "")) {
						evt.consume();
					}
				}
			}
		});
	}
}
