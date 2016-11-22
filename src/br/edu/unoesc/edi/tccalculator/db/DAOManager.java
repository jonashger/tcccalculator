package br.edu.unoesc.edi.tccalculator.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
/**
 * Classe que reprenta um Banco de Dados
 * @author jonas
 *
 */
public class DAOManager {
	
	public static Dao<Usuario, Integer> usuarioDAO;
	public static Dao<Aluno, Integer> alunoDAO;
	public static Dao<Curso, Integer> cursoDAO;
	public static Dao<Avaliador, Integer> avaliadorDAO;
	
	static {
		try {	
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Usuario.class);
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Aluno.class);
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Curso.class);
			TableUtils.createTableIfNotExists(Conexao.getConexao(), Avaliador.class);
			cursoDAO = DaoManager.createDao(Conexao.getConexao(), Curso.class);
			usuarioDAO = DaoManager.createDao(Conexao.getConexao(), Usuario.class);
			alunoDAO = DaoManager.createDao(Conexao.getConexao(), Aluno.class);
			avaliadorDAO = DaoManager.createDao(Conexao.getConexao(), Avaliador.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
