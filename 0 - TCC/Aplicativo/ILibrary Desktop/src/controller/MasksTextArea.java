package controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class MasksTextArea extends PlainDocument {
	
	private int maxCaracteres;
    public MasksTextArea (int maxCaracteres)
    {
        super();
        this.maxCaracteres = maxCaracteres;
    }
    
    @Override
    public void insertString(int valor, String string, AttributeSet atributo) throws BadLocationException {
        if (string == null)
            return;
        if (maxCaracteres <= 0)
        {
            super.insertString(valor, string, atributo);
            return;
        }
        int ilen = (getLength() + string.length());
        if (ilen <= maxCaracteres)
            super.insertString(valor, string, atributo);
        else
        {
            if (getLength() == maxCaracteres)
                return;
            String novaString = string.substring(0, (maxCaracteres - getLength()));
            super.insertString(valor, novaString, atributo);
        }
    }
}

