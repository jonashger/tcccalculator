package br.edu.unuesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "curso")
public class Curso {

	@DatabaseField(generatedId = true)
	private Integer nCurso;
	@DatabaseField
	private String curso;
	
	public Integer getnCurso() {
		return nCurso;
	}
	public void setnCurso(Integer nCurso) {
		this.nCurso = nCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
