package br.edu.unoesc.edi.tccalculator.db;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
/**
 * conexao do db
 * @author jonas
 *
 */
public class Conexao {
	private static final String DB_URL = "jdbc:sqlite:src/database/tccalculator.db";
	private static ConnectionSource connectionSource = null;
	private Conexao() {

	}

	public static ConnectionSource getConexao() {
		if (connectionSource == null) {
			// create a connection source to our database
			try {
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				connectionSource = new JdbcConnectionSource(DB_URL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		return connectionSource;
	}
	

}
