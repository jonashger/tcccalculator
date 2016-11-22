package br.edu.unoesc.edi.tccalculator.db;

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
	private String status;
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
	private String nt01av01AP;
	@DatabaseField
	private String nt01av02AP;
	@DatabaseField
	private String nt01av03AP;
	@DatabaseField
	private String nt02av01AP;
	@DatabaseField
	private String nt02av02AP;
	@DatabaseField
	private String nt02av03AP;
	@DatabaseField
	private String nt03av01AP;
	@DatabaseField
	private String nt03av02AP;
	@DatabaseField
	private String nt03av03AP;
	@DatabaseField
	private String nt04av01AP;
	@DatabaseField
	private String nt04av02AP;
	@DatabaseField
	private String nt04av03AP;
	@DatabaseField
	private String nt05av01AP;
	@DatabaseField
	private String nt05av02AP;
	@DatabaseField
	private String nt05av03AP;
	@DatabaseField
	private String nt01av01AA;
	@DatabaseField
	private String nt01av02AA;
	@DatabaseField
	private String nt01av03AA;
	@DatabaseField
	private String nt02av01AA;
	@DatabaseField
	private String nt02av02AA;
	@DatabaseField
	private String nt02av03AA;
	@DatabaseField
	private String nt03av01AA;
	@DatabaseField
	private String nt03av02AA;
	@DatabaseField
	private String nt03av03AA;
	@DatabaseField
	private String ntAO;
	@DatabaseField
	private String ntAAA;
	@DatabaseField
	private String ntMdE01AA;
	@DatabaseField
	private String ntMdE02AA;
	@DatabaseField
	private String ntMdE03AA;
	@DatabaseField
	private String ntMdE01AP;
	@DatabaseField
	private String ntMdE02AP;
	@DatabaseField
	private String ntMdE03AP;
	@DatabaseField
	private String ntMdE04AP;
	@DatabaseField
	private String ntMdE05AP;
	
	
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
	public String getNt01av01AP() {
		return nt01av01AP;
	}
	public void setNt01av01AP(String nt01av01ap) {
		nt01av01AP = nt01av01ap;
	}
	public String getNt01av02AP() {
		return nt01av02AP;
	}
	public void setNt01av02AP(String nt01av02ap) {
		nt01av02AP = nt01av02ap;
	}
	public String getNt01av03AP() {
		return nt01av03AP;
	}
	public void setNt01av03AP(String nt01av03ap) {
		nt01av03AP = nt01av03ap;
	}
	public String getNt02av01AP() {
		return nt02av01AP;
	}
	public void setNt02av01AP(String nt02av01ap) {
		nt02av01AP = nt02av01ap;
	}
	public String getNt02av02AP() {
		return nt02av02AP;
	}
	public void setNt02av02AP(String nt02av02ap) {
		nt02av02AP = nt02av02ap;
	}
	public String getNt02av03AP() {
		return nt02av03AP;
	}
	public void setNt02av03AP(String nt02av03ap) {
		nt02av03AP = nt02av03ap;
	}
	public String getNt03av01AP() {
		return nt03av01AP;
	}
	public void setNt03av01AP(String nt03av01ap) {
		nt03av01AP = nt03av01ap;
	}
	public String getNt03av02AP() {
		return nt03av02AP;
	}
	public void setNt03av02AP(String nt03av02ap) {
		nt03av02AP = nt03av02ap;
	}
	public String getNt03av03AP() {
		return nt03av03AP;
	}
	public void setNt03av03AP(String nt03av03ap) {
		nt03av03AP = nt03av03ap;
	}
	public String getNt04av01AP() {
		return nt04av01AP;
	}
	public void setNt04av01AP(String nt04av01ap) {
		nt04av01AP = nt04av01ap;
	}
	public String getNt04av02AP() {
		return nt04av02AP;
	}
	public void setNt04av02AP(String nt04av02ap) {
		nt04av02AP = nt04av02ap;
	}
	public String getNt04av03AP() {
		return nt04av03AP;
	}
	public void setNt04av03AP(String nt04av03ap) {
		nt04av03AP = nt04av03ap;
	}
	public String getNt01av01AA() {
		return nt01av01AA;
	}
	public void setNt01av01AA(String nt01av01aa) {
		nt01av01AA = nt01av01aa;
	}
	public String getNt01av02AA() {
		return nt01av02AA;
	}
	public void setNt01av02AA(String nt01av02aa) {
		nt01av02AA = nt01av02aa;
	}
	public String getNt01av03AA() {
		return nt01av03AA;
	}
	public void setNt01av03AA(String nt01av03aa) {
		nt01av03AA = nt01av03aa;
	}
	public String getNt02av01AA() {
		return nt02av01AA;
	}
	public void setNt02av01AA(String nt02av01aa) {
		nt02av01AA = nt02av01aa;
	}
	public String getNt02av02AA() {
		return nt02av02AA;
	}
	public void setNt02av02AA(String nt02av02aa) {
		nt02av02AA = nt02av02aa;
	}
	public String getNt02av03AA() {
		return nt02av03AA;
	}
	public void setNt02av03AA(String nt02av03aa) {
		nt02av03AA = nt02av03aa;
	}
	public String getNt03av01AA() {
		return nt03av01AA;
	}
	public void setNt03av01AA(String nt03av01aa) {
		nt03av01AA = nt03av01aa;
	}
	public String getNt03av02AA() {
		return nt03av02AA;
	}
	public void setNt03av02AA(String nt03av02aa) {
		nt03av02AA = nt03av02aa;
	}
	public String getNt03av03AA() {
		return nt03av03AA;
	}
	public void setNt03av03AA(String nt03av03aa) {
		nt03av03AA = nt03av03aa;
	}
	public String getNtAO() {
		return ntAO;
	}
	public void setNtAO(String ntAO) {
		this.ntAO = ntAO;
	}
	public String getNtAAA() {
		return ntAAA;
	}
	public void setNtAAA(String ntAAA) {
		this.ntAAA = ntAAA;
	}
	public String getNt05av01AP() {
		return nt05av01AP;
	}
	public void setNt05av01AP(String nt05av01ap) {
		nt05av01AP = nt05av01ap;
	}
	public String getNt05av02AP() {
		return nt05av02AP;
	}
	public void setNt05av02AP(String nt05av02ap) {
		nt05av02AP = nt05av02ap;
	}
	public String getNt05av03AP() {
		return nt05av03AP;
	}
	public void setNt05av03AP(String nt05av03ap) {
		nt05av03AP = nt05av03ap;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNtMdE01AA() {
		return ntMdE01AA;
	}
	public void setNtMdE01AA(String ntMdE01AA) {
		this.ntMdE01AA = ntMdE01AA;
	}
	public String getNtMdE02AA() {
		return ntMdE02AA;
	}
	public void setNtMdE02AA(String ntMdE02AA) {
		this.ntMdE02AA = ntMdE02AA;
	}
	public String getNtMdE03AA() {
		return ntMdE03AA;
	}
	public void setNtMdE03AA(String ntMdE03AA) {
		this.ntMdE03AA = ntMdE03AA;
	}
	public String getNtMdE01AP() {
		return ntMdE01AP;
	}
	public void setNtMdE01AP(String ntMdE01AP) {
		this.ntMdE01AP = ntMdE01AP;
	}
	public String getNtMdE02AP() {
		return ntMdE02AP;
	}
	public void setNtMdE02AP(String ntMdE02AP) {
		this.ntMdE02AP = ntMdE02AP;
	}
	public String getNtMdE03AP() {
		return ntMdE03AP;
	}
	public void setNtMdE03AP(String ntMdE03AP) {
		this.ntMdE03AP = ntMdE03AP;
	}
	public String getNtMdE04AP() {
		return ntMdE04AP;
	}
	public void setNtMdE04AP(String ntMdE04AP) {
		this.ntMdE04AP = ntMdE04AP;
	}
	public String getNtMdE05AP() {
		return ntMdE05AP;
	}
	public void setNtMdE05AP(String ntMdE05AP) {
		this.ntMdE05AP = ntMdE05AP;
	}
	
	
	
}
