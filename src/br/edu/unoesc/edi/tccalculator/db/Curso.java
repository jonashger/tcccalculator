package br.edu.unoesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Classe que reprenta um tabela de cursos
 * @author jonas
 *
 */
@DatabaseTable(tableName = "curso")
public class Curso {

	/**
	 * @DatabaseField Campos da classe que corresponde a uma coluna no banco de dados. 
	 */
	@DatabaseField(generatedId = true)
	private Integer nCurso;
	@DatabaseField
	private String curso;
	

	/**
	 * Criação dos Getters and Setters
	 */
	
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
