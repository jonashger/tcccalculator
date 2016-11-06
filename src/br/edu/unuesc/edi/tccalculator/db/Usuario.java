package br.edu.unuesc.edi.tccalculator.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe que reprenta um USUARIO MASTER
 * 
 * @author 
 * @since 31/08/2016
 *
 */

@DatabaseTable(tableName = "usuario")
public class Usuario {
	public Integer getnUsuario() {
		return nUsuario;
	}
	public void setnUsuario(Integer nUsuario) {
		this.nUsuario = nUsuario;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@DatabaseField(generatedId = true)
	private Integer nUsuario;

	@DatabaseField
	private String userName;
	@DatabaseField
	private String userPass;

	// private String tipoSilo;


}
