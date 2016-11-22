package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unoesc.edi.tccalculator.db.DAOManager;
import br.edu.unoesc.edi.tccalculator.db.Usuario;
/**
 * classe para validadação da senha e usuário para realizar o login
 * @author jonas
 *
 */
public class LoginPass {
	/**
	 * 
	 * @param usr Nome do usuário informado
	 * @param senha senha informada tranformada em sha-256 e que for 
	  		transformada tambem em Hexadecimal
	 * @return verdadeiro se as informações estão salvas no Banco de Dados. falso não está
	 * @throws SQLException
	 */
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
