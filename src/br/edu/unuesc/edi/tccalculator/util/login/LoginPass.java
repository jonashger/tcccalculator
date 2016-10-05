package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.db.Usuario;

public class LoginPass {
	public static boolean login(String usr,String senha) throws SQLException {

		java.util.List<Usuario> a = DAOManager.usuarioDAO.queryForAll();
		
		
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).getUserName().equals(usr)) {
					if (a.get(i).getUserPass().equals(senha)) {
						return true;
				}}
		}
		return false;
	}
}
