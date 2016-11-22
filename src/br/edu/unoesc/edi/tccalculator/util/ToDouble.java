package br.edu.unoesc.edi.tccalculator.util;

import javax.swing.JTextField;
/**
 * Esta classe tem a função de transformar um JTextField em um valor Double
 * @author jonas
 *
 */
public class ToDouble {
	/**
	 * 
	 * @param field JTextField que passara a ser Double
	 * @return valor retorna o valor do double
	 */
	public static double init(JTextField field){
		double valor = Double.parseDouble(field.getText());
		return valor;
	}
}
