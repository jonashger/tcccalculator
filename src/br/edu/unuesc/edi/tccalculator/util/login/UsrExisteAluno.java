package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;
import java.util.List;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
import br.edu.unuesc.edi.tccalculator.db.Usuario;

public class UsrExisteAluno {

	public static boolean login(String usuario,String senha) throws SQLException {

		List<Aluno> a = DAOManager.alunoDAO.queryForAll();
		
		
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).getAluno().equals(usuario)) {
						return true;
				}
		}
		return false;
	}


}
