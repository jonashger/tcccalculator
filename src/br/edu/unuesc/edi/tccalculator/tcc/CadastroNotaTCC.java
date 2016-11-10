package br.edu.unuesc.edi.tccalculator.tcc;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;

public class CadastroNotaTCC {

	public static boolean cadastroTCC(String nota,int id,String av1,String av2,String av3,String ntMdAv01AA,String ntMdAv02AA,String ntMdAv03AA,String ntMdAv01AP,String ntMdAv02AP,String ntMdAv03AP,String ntMdAO,String ntMdAAA) throws SQLException{
		ArrayList<String> list = new ArrayList<>();
		list.add(nota);
		list.add(av1);
		list.add(av2);
		list.add(av3);
		list.add(ntMdAv01AA);
		list.add(ntMdAv02AA);
		list.add(ntMdAv03AA);
		list.add(ntMdAv01AP);
		list.add(ntMdAv02AP);
		list.add(ntMdAv03AP);
		list.add(ntMdAO);
		list.add(ntMdAAA);
		System.out.println(list);
		
		
		
		Aluno aluno = DAOManager.alunoDAO.queryForId(id);
		aluno.setNota(nota);
		aluno.setAvaliador1(av1);
		aluno.setAvaliador2(av2);
		aluno.setAvaliador3(av3);
		aluno.setNtMdAv01AA(ntMdAv01AA);
		aluno.setNtMdAv02AA(ntMdAv02AA);
		aluno.setNtMdAv03AA(ntMdAv03AA);
		aluno.setNtMdAv01AP(ntMdAv01AP);
		aluno.setNtMdAv02AP(ntMdAv02AP);
		aluno.setNtMdAv03AP(ntMdAv03AP);
		aluno.setNtMdAO(ntMdAO);
		aluno.setNtMdAAA(ntMdAAA);
		DAOManager.alunoDAO.createOrUpdate(aluno);
		return false;
	}
}
