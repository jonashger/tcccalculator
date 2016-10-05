package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;


public class LoginTrueAluno {
	public static String init(String usr,String senha) {
		Aluno a = new Aluno();
		a.setAluno(usr);
		a.setSenha(senha);
		try {
			DAOManager.alunoDAO.create(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
