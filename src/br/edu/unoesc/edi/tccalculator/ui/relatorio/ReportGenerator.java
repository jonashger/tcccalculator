package br.edu.unoesc.edi.tccalculator.ui.relatorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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

	public static void test(int id) throws ClassNotFoundException, SQLException {
		String fileName = "src/relatorio/TCC1Reporta.jasper";
		String outFileName = "test.pdf";
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
			System.out.println("Created file: " + outFileName);
			JasperViewer viewer = new JasperViewer(print, true);
			viewer.setVisible(true);
			viewer.setDefaultCloseOperation(viewer.DISPOSE_ON_CLOSE);

		}

		catch (JRException e) {
		} catch (Exception e) {
		}
	}
}