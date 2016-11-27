package br.edu.unoesc.edi.tccalculator.util;

import javax.swing.JTextField;

/**
 * Classe para validar o n�mero vindo atrav�s de um JtextField
 * 
 * @author jonas
 *
 */
public class ValidaNumero {
	public static boolean validaNumero(JTextField Numero) {
		double valor;

		//faz valida��o do numero
		if (Numero.getText().length() != 0) {
			try {
				valor = Double.parseDouble(Numero.getText().replace(",", "."));
				if ((valor > 10)) {
					return false;
				}
			} catch (NumberFormatException ex) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
