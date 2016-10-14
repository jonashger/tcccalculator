package br.edu.unuesc.edi.tccalculator.util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidaNumero {
	public static boolean validaNumero(JTextField Numero) {
		double valor;
		
		if (Numero.getText().length() != 0){
		try {
		valor = Double.parseDouble(Numero.getText());
		if((valor>10)){
			return false;
		}
		}catch(NumberFormatException ex){
		return false;
		}
		}else{
			return false;
		}
		return true;
		}
}
