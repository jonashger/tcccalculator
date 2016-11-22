package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unoesc.edi.tccalculator.db.Usuario;
/**
 * Classe para realizar o cadastro de novo super user no sistema
 * @author jonas
 *
 */
public class CadastroUserEspecial {
	/**
	 * 
	 * @param usr Novo user para realizar o cadastro
	 * @param senha Nova senha em sha-256 do usr
	 */
	public static void init(String usr,String senha) {
		Usuario a = new Usuario();
		a.setUserName(usr);
		a.setUserPass(senha);
		try {
			DAOManager.usuarioDAO.create(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
