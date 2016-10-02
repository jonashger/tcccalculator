package br.edu.unuesc.edi.tccalculator.util;

import java.util.ArrayList;

import br.edu.unuesc.edi.tccalculator.db.LerProperties;

public class LoginPass {
	public static boolean login(String usr,String senha) {

		ArrayList<String> list = new ArrayList<>();
		list = LerProperties.lerPropriedades();
		if ((usr.equals(list.get(0)))&&(senha.equals(list.get(1)))) {
			return true;
		}else{
			return false;
		}
	}
}
