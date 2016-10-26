package br.edu.unuesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "usuarioAluno")

public class Aluno {
	@DatabaseField(generatedId = true)
	private Integer nUsuario;
	@DatabaseField
	private String aluno;
	@DatabaseField
	private String aluno2;
	@DatabaseField
	private String nota;
	@DatabaseField
	private String curso;
	@DatabaseField
	private String assunto;
	@DatabaseField
	private String tcc;
	
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public Integer getnUsuario() {
		return nUsuario;
	}
	public void setnUsuario(Integer nUsuario) {
		this.nUsuario = nUsuario;
	}
	public String getTcc() {
		return tcc;
	}
	public void setTcc(String tcc) {
		this.tcc = tcc;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAluno2() {
		return aluno2;
	}
	public void setAluno2(String aluno2) {
		this.aluno2 = aluno2;
	}
	
}
