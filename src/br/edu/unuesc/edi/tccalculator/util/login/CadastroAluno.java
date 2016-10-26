package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;


public class CadastroAluno {
	public static String init(String usr,String usr2,String curso, String tese,String tcc) {
		Aluno a = new Aluno();
		a.setAluno(usr);
		a.setCurso(curso);
		a.setAluno2(usr2);
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
