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
	private String senha;
	@DatabaseField
	private String assunto;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getnUsuario() {
		return nUsuario;
	}
	public void setnUsuario(Integer nUsuario) {
		this.nUsuario = nUsuario;
	}
	
	
}
