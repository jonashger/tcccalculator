package br.edu.unoesc.edi.tccalculator.util;

/*
 * Esta classe limita o n�mero de caracteres inseridos em um JTextField
 * 
 */
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/**
 *
 * @author m/j
 */
public class FixedLenghtDocument extends DocumentFilter {
    private int iMaxLength;  
    public FixedLenghtDocument(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;  
        // aceitara qualquer n�mero de caracteres
    if (iMaxLength <= 0) {                   
        fb.insertString(offset, str, attr);  
        return;  
    }
    
    int ilen = (fb.getDocument().getLength() + str.length());
    
    // se o comprimento final for menor, aceita str
    if (ilen <= iMaxLength) {
        fb.insertString(offset, str, attr); 
    } else {
        // se o comprimento for igual ao m�ximo, n�o faz nada
        if (fb.getDocument().getLength() == iMaxLength) return;
        
        // se ainda resta espa�o na String, pega os caracteres aceitos
        String newStr = str.substring(0, (iMaxLength - fb.getDocument().getLength()));  

        fb.insertString(offset, newStr, attr);  
    }
}

@Override
public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {
    if (str == null) return;  

    // aceitara qualquer n�mero de caracteres
    if (iMaxLength <= 0) {                   
        fb.insertString(offset, str, attr);  
        return;  
    }
    
    int ilen = (fb.getDocument().getLength() + str.length());
    
    // se o comprimento final for menor, aceita str
    if (ilen <= iMaxLength) {
        fb.insertString(offset, str, attr); 
    } else {
        // se o comprimento for igual ao m�ximo, n�o faz nada
        if (fb.getDocument().getLength() == iMaxLength) return;
        
        // se ainda resta espa�o na String, pega os caracteres aceitos
        String newStr = str.substring(0, (iMaxLength - fb.getDocument().getLength()));  

        fb.insertString(offset, newStr, attr);  
    }
}
}
