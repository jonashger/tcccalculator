package br.edu.unuesc.edi.tccalculator.tcc;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.unuesc.edi.tccalculator.db.Aluno;
import br.edu.unuesc.edi.tccalculator.db.Avaliador;
import br.edu.unuesc.edi.tccalculator.db.DAOManager;
/**
 * Classe que cadastra as notas no DB AlunoDAO
 * @author jonas
 *
 */
public class CadastroNotaTCC {

	public static boolean cadastroTCC(String nota,int id,ArrayList<Integer> lista,ArrayList<String> list,ArrayList<String> listAluno) throws SQLException{
	
		System.out.println(lista);
		Aluno aluno = DAOManager.alunoDAO.queryForId(id);
		aluno.setNota(nota);
		Avaliador aval = DAOManager.avaliadorDAO.queryForId(lista.get(0));
		aluno.setAvaliador1(aval.getAvaliador());
		aval = DAOManager.avaliadorDAO.queryForId(lista.get(1));
		aluno.setAvaliador2(aval.getAvaliador());
		aval = DAOManager.avaliadorDAO.queryForId(lista.get(2));
		aluno.setAvaliador3(aval.getAvaliador());
		aluno.setNt01av01AP((String) list.get(0));	
		aluno.setNt01av02AP((String) list.get(1));	
		aluno.setNt01av03AP((String) list.get(2));
		aluno.setNt02av01AP((String) list.get(3));	
		aluno.setNt02av02AP((String) list.get(4));	
		aluno.setNt02av03AP((String) list.get(5));	
		aluno.setNt03av01AP((String) list.get(6));	
		aluno.setNt03av02AP((String) list.get(7));	
		aluno.setNt03av03AP((String) list.get(8));	
		aluno.setNt04av01AP((String) list.get(9));	
		aluno.setNt04av02AP((String) list.get(10));	
		aluno.setNt04av03AP((String) list.get(11));		
		aluno.setNt05av01AP((String) list.get(12));		
		aluno.setNt05av02AP((String) list.get(13));		
		aluno.setNt05av03AP((String) list.get(14));	
		aluno.setNt01av01AA((String) list.get(15));	
		aluno.setNt01av02AA((String) list.get(16));	
		aluno.setNt01av03AA((String) list.get(17));	
		aluno.setNt02av01AA((String) list.get(18));	
		aluno.setNt02av02AA((String) list.get(19));	
		aluno.setNt02av03AA((String) list.get(20));	
		aluno.setNt03av01AA((String) list.get(21));	
		aluno.setNt03av02AA((String) list.get(22));	
		aluno.setNt03av03AA((String) list.get(23));	
		aluno.setNtAAA((String) list.get(25));
		aluno.setNtAO((String) list.get(24));	
		aluno.setNtMdE01AA((String)listAluno.get(0));
		aluno.setNtMdE02AA((String)listAluno.get(1));
		aluno.setNtMdE03AA((String)listAluno.get(2));
		aluno.setNtMdE01AP((String)listAluno.get(3));
		aluno.setNtMdE02AP((String)listAluno.get(4));
		aluno.setNtMdE03AP((String)listAluno.get(5));
		aluno.setNtMdE04AP((String)listAluno.get(6));
		aluno.setNtMdE05AP((String)listAluno.get(7));
		double sta = Double.parseDouble(nota);
		if(sta>=7){
			aluno.setStatus("Aprovado");
		}else{
			aluno.setStatus("Desaprovado");
		}
		DAOManager.alunoDAO.createOrUpdate(aluno);
		return false;
	}
}
