package br.edu.unuesc.edi.tccalculator.tcc;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

public class CadastroNotaTCC {
	
	public static boolean cadastroTCC(String nota) throws SQLException{
		Aluno aluno = new Aluno();
		aluno.setNota(nota);
		DAOManager.alunoDAO.createOrUpdate(aluno).equals(2);
		return false;
	}
}
