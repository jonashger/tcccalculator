package br.edu.unuesc.edi.tccalculator.util;

import javax.swing.JTextField;

public class ToDouble {
	public static double init(JTextField field){
		double valor = Double.parseDouble(field.getText());
		return valor;
	}
}
