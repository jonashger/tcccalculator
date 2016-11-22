package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unoesc.edi.tccalculator.db.Usuario;
/**
 * Classe para ver se o usuario admin existe, se não ele da erro na validação
 * @author jonas
 *
 */
public class UsrExiste {
	/**
	 * 
	 * @param usr nome do usuário para verificar se existe
	 * @return verdadeiro para usuário existente e falso ao contrário
	 * @throws SQLException
	 */
	public static boolean login(String usr) throws SQLException {

		java.util.List<Usuario> a = DAOManager.usuarioDAO.queryForAll();
		
		
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).getUserName().equals(usr)) {
						return true;
				}
		}
		return false;
	}
}
