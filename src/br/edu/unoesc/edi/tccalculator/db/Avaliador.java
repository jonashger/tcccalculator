package br.edu.unoesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Classe Que reprensenta um Avaliador
 * @author jonas
 *
 */
@DatabaseTable(tableName = "avaliador")
public class Avaliador {

	/**
	 * @DatabaseField Campos da classe que corresponde a uma coluna no banco de dados. 
	 */
	@DatabaseField(generatedId = true)
	private Integer nAvaliador;
	@DatabaseField
	private String avaliador;
	
	/**
	 * Criação dos Getters and Setters
	 * @return gets das variaveis
	 */
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