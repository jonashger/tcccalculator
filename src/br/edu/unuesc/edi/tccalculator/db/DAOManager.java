package br.edu.unuesc.edi.tccalculator.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;

public class DAOManager {
	
	public static Dao<Usuario, Integer> usuarioDAO;
	
	static {
		try {	
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Usuario.class);
			
			
			usuarioDAO = DaoManager.createDao(Conexao.getConexao(), Usuario.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
