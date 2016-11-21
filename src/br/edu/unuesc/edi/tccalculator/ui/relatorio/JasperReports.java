package br.edu.unuesc.edi.tccalculator.ui.relatorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReports {
	 
	 private static final String url = "jdbc:sqlite:src/database/tccalculator.db";
	 private static final String driver = "org.sqlite.JDBC";
	 private static final String login = "";
	 private static final String pwd = "";
	 
	 public JasperReports() {
	 }
	 
	 public static void gerar() throws JRException , SQLException, ClassNotFoundException {
	 //gerando o jasper design
		 String layout = "tcc1";
	 JasperDesign desenho = JRXmlLoader.load("C:\\Users\\jonas\\git\\tccalculator\\src\\TCC1Reporta.jrxml");
	 
	 //compila o relatório
	 JasperReport relatorio = JasperCompileManager.compileReport( desenho );
	 
	 //estabelece conexão
	 Class.forName( driver );
	 Connection con = DriverManager.getConnection( url , login , pwd );
	 Statement stm = con.createStatement();
	 String query = "select * from usuarioAluno where nUsuario=1";
	 ResultSet rs = stm.executeQuery( query );
	 
	 //implementação da interface JRDataSource para DataSource ResultSet
	 JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
	 
	 //executa o relatório
	 Map parametros = new HashMap();
	 parametros.put("id", new Integer(1));
	 JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
	 
	 //exibe o resultado
	 JasperViewer viewer = new JasperViewer( impressao , true );
	 viewer.show();
	 }
	 
	 
	 }