package br.edu.unuesc.edi.tccalculator.tcc;

import java.sql.SQLException;

import com.j256.ormlite.dao.DaoManager;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

public class CadastroNotaTCC {
	
	public static boolean cadastroTCC(String nota,int id) throws SQLException{
		
		Aluno aluno = DAOManager.alunoDAO.queryForId(id);
		aluno.setNota(nota);
		DAOManager.alunoDAO.createOrUpdate(aluno);
		return false;
	}
}
