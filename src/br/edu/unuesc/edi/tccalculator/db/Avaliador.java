package br.edu.unuesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Classe Que reprensenta um Avaliador
 * @author jonas
 *
 */
@DatabaseTable(tableName = "avaliador")
public class Avaliador {

	@DatabaseField(generatedId = true)
	private Integer nAvaliador;
	@DatabaseField
	private String avaliador;
	public Integer getnAvaliador() {
		return nAvaliador;
	}
	public void setnAvaliador(Integer nAvaliador) {
		this.nAvaliador = nAvaliador;
	}
	public String getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(String avaliador) {
		this.avaliador = avaliador;
	}
	
	
	
}