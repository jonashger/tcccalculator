package br.edu.unuesc.edi.tccalculator.util.login;

import java.sql.SQLException;

import br.edu.unoesc.edi.tccalculator.db.Aluno;
import br.edu.unoesc.edi.tccalculator.db.DAOManager;
/**
 * Classe que faz o cadastro do aluno no sistema
 * @author jonas
 *
 */

public class CadastroAluno {
	/**
	 * 
	 * @param usr Aluno 1
	 * @param usr2 caso existem 2 alunos no projeto
	 * @param curso curso que estaja fazendo seu tcc
	 * @param tese Tese a ser defendida
	 * @param tcc em qual tcc esta fazendo - 1, 2 ou 3
	 * @return
	 */
	public static void init(String usr,String usr2,String curso, String tese,String tcc,String orient) {
		Aluno a = new Aluno();
		a.setAluno(usr);
		a.setCurso(curso);
		a.setAluno2(usr2);
		a.setAssunto(tese);
		a.setOrientador(orient);
		a.setTcc(tcc);
		a.setNota("0");
		try {
			DAOManager.alunoDAO.create(a);
		} catch (SQLException e) {;
			e.printStackTrace();
		}
		
	}
}
