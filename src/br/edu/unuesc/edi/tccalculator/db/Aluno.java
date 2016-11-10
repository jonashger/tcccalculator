package br.edu.unuesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Classe que reprenta um Usuario Aluno
 * @author jonas
 *
 */
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
	@DatabaseField
	private String avaliador1;
	@DatabaseField
	private String avaliador2;
	@DatabaseField
	private String avaliador3;
	@DatabaseField
	private String orientador;
	@DatabaseField
	private String ntMdAv02AP;
	@DatabaseField
	private String ntMdAv02AA;
	@DatabaseField
	private String ntMdAv01AP;
	@DatabaseField
	private String ntMdAv01AA;
	@DatabaseField
	private String ntMdAv03AP;
	@DatabaseField
	private String ntMdAv03AA;
	@DatabaseField
	private String ntMdAO;
	@DatabaseField
	private String ntMdAAA;

	
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
	public String getAvaliador1() {
		return avaliador1;
	}
	public void setAvaliador1(String avaliador1) {
		this.avaliador1 = avaliador1;
	}
	public String getAvaliador2() {
		return avaliador2;
	}
	public void setAvaliador2(String avaliador2) {
		this.avaliador2 = avaliador2;
	}
	public String getAvaliador3() {
		return avaliador3;
	}
	public void setAvaliador3(String avaliador3) {
		this.avaliador3 = avaliador3;
	}
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	public String getNtMdAv02AP() {
		return ntMdAv02AP;
	}
	public void setNtMdAv02AP(String ntMdAv02AP) {
		this.ntMdAv02AP = ntMdAv02AP;
	}
	public String getNtMdAv02AA() {
		return ntMdAv02AA;
	}
	public void setNtMdAv02AA(String ntMdAv02AA) {
		this.ntMdAv02AA = ntMdAv02AA;
	}
	public String getNtMdAv01AP() {
		return ntMdAv01AP;
	}
	public void setNtMdAv01AP(String ntMdAv01AP) {
		this.ntMdAv01AP = ntMdAv01AP;
	}
	public String getNtMdAv01AA() {
		return ntMdAv01AA;
	}
	public void setNtMdAv01AA(String ntMdAv01AA) {
		this.ntMdAv01AA = ntMdAv01AA;
	}
	public String getNtMdAv03AP() {
		return ntMdAv03AP;
	}
	public void setNtMdAv03AP(String ntMdAv03AP) {
		this.ntMdAv03AP = ntMdAv03AP;
	}
	public String getNtMdAv03AA() {
		return ntMdAv03AA;
	}
	public void setNtMdAv03AA(String ntMdAv03AA) {
		this.ntMdAv03AA = ntMdAv03AA;
	}
	public String getNtMdAO() {
		return ntMdAO;
	}
	public void setNtMdAO(String ntMdAO) {
		this.ntMdAO = ntMdAO;
	}
	public String getNtMdAAA() {
		return ntMdAAA;
	}
	public void setNtMdAAA(String ntMdAAA) {
		this.ntMdAAA = ntMdAAA;
	}
	
}
