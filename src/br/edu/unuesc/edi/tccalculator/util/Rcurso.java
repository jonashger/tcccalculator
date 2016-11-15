package br.edu.unuesc.edi.tccalculator.util;

import java.sql.SQLException;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.Avaliador;
import br.edu.unuesc.edi.tccalculator.db.Curso;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

public class Rcurso {
		
		public static void removeTrabalho(int id) throws SQLException {
			Aluno trabalho = DAOManager.alunoDAO.queryForId(id);
			DAOManager.alunoDAO.delete(trabalho);
		}
		public static void removeAvaliador(int id) throws SQLException {
			Avaliador aval = DAOManager.avaliadorDAO.queryForId(id);
			DAOManager.avaliadorDAO.delete(aval);
		}
		public static void removeCurso(int id) throws SQLException {
			Curso curso = DAOManager.cursoDAO.queryForId(id);
			DAOManager.cursoDAO.delete(curso);
		}
	}

