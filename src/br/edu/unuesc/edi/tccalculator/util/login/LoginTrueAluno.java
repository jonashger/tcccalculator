package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;


public class LoginTrueAluno {
	public static String init(String usr,String curso, String tese,String tcc) {
		Aluno a = new Aluno();
		a.setAluno(usr);
		a.setCurso(curso);
		a.setAssunto(tese);
		a.setTcc(tcc);
		try {
			DAOManager.alunoDAO.create(a);
		} catch (SQLException e) {;
			e.printStackTrace();
		}
		return null;
		
	}
}
