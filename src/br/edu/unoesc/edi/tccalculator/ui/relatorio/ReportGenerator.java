package br.edu.unoesc.edi.tccalculator.ui.relatorio;
/**
 * classe que represente o chamando do jasper report
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {

	private static final String url = "jdbc:sqlite:src/database/tccalculator.db";
	private static final String driver = "org.sqlite.JDBC";
	private static final String login = "";
	private static final String pwd = "";

	public static void tcc1e2(int id) throws ClassNotFoundException, SQLException {
		String fileName = "src/relatorio/TCCReporta.jasper";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, login, pwd);
		Statement stm = con.createStatement();
		String query = "select * from usuarioAluno where nUsuario = " + id;
		ResultSet rs = stm.executeQuery(query);

		// implementação da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

		try {
			JasperPrint print = JasperFillManager.fillReport(fileName, hm, jrRS);
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setVisible(true);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		}

		catch (JRException e) {
		} catch (Exception e) {
		}
	}

	public static void tcc3(int id) throws ClassNotFoundException, SQLException {
		System.out.println("Entro" + id);
		String fileName = "src/relatorio/TCC3R.jasper";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, login, pwd);
		Statement stm = con.createStatement();
		String query = "select * from usuarioAluno where nUsuario = " + id;
		ResultSet rs = stm.executeQuery(query);

		// implementação da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

		try {
			JasperPrint print = JasperFillManager.fillReport(fileName, hm, jrRS);
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setVisible(true);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			

		}

		catch (JRException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}