package br.edu.unuesc.edi.tccalculator.util;
/*
 * Esta classe permite que apenas n�meros sejam inseridos em um JTextField
 */

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
/**
 *
 * @author Paulo Alonso
 */
public class IeValidator extends FixedLenghtDocument {
    public IeValidator(int maxLenght) {
        super(maxLenght);
    }
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
        char c;
        byte n = 1;
        // percorre a string
        for (byte i=0;i<str.length();i++){
            // armazena o caracter
            c = str.charAt(i);
            // se n�o for n�mero ou ponto
            if(!Character.isDigit(c) & c != '.')
                    n = 0;
        }
        // se n n�o for igual a zero, todos os caracteres s�o num�ricos
        if(n != 0)
            super.insertString(fb, offset, str, attr);
    }
    @Override
public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {
    char c;
    byte n = 1;
    
    // percorre a string
    for (byte i=0;i<str.length();i++){
        
        // armazena o caracter
        c = str.charAt(i);
        
        // se n�o for n�mero ou ponto
        if(!Character.isDigit(c) & c != '.')
                n = 0;
    }
    
    // se n n�o for igual a zero, todos os caracteres s�o num�ricos
    if(n != 0)
        super.insertString(fb, offset, str, attr);
}
}