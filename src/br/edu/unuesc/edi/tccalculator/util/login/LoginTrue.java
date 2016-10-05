package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.db.Usuario;

public class LoginTrue {
	public static String init(String usr,String senha) {
		Usuario a = new Usuario();
		a.setUserName(usr);
		a.setUserPass(senha);
		try {
			DAOManager.usuarioDAO.create(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
