package br.edu.unuesc.edi.tccalculator.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;

public class DAOManager {
	
	public static Dao<Usuario, Integer> usuarioDAO;
	public static Dao<Aluno, Integer> alunoDAO;
	
	static {
		try {	
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Usuario.class);
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Aluno.class);
			
			usuarioDAO = DaoManager.createDao(Conexao.getConexao(), Usuario.class);
			alunoDAO = DaoManager.createDao(Conexao.getConexao(), Aluno.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
