package br.edu.unuesc.edi.tccalculator.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

// import com.mycompany.helper.* ;
// import com.mycompany.dbi.*;

public class ReportGenerator {
 private static HashMap hm;

public static void gerar() {
  // System.out.println("Usage: ReportGenerator ....");

  try {
   System.out.println("Start ....");
   // Get jasper report
   String jrxmlFileName = "C:/Users/jonas/git/tccalculator/src/rempor.jrxml";
   String jasperFileName = "C:/Users/jonas/git/tccalculator/src/rempor.jasper";
   String pdfFileName = "/C1_report.pdf";

 //  JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);

   JasperCompileManager.compileReportToFile(jasperFileName);

   System.out.println("ccc");
   // String dbUrl = props.getProperty("jdbc.url");
   String dbUrl = "jdbc:sqlite:C:/Users/jonas/git/tccalculator/db/tccalculator.db";
   // String dbDriver = props.getProperty("jdbc.driver");
   String dbDriver = "org.sqlite.JDBC";
   // String dbUname = props.getProperty("db.username");
   String dbUname = "";
   // String dbPwd = props.getProperty("db.password");
   String dbPwd = "";

   // Load the JDBC driver
   Class.forName(dbDriver);
   // Get the connection
   Connection conn = DriverManager
     .getConnection(dbUrl, dbUname, dbPwd);

   // Create arguments
   // Map params = new HashMap();

   hm = null;
   JasperPrint jprint =  JasperFillManager.fillReport(jasperFileName, hm, conn);

   System.out.println("ccc");
   // Export pdf file
   JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
   
   System.out.println("Done exporting reports to pdf");
   
  } catch (Exception e) {
   System.out.print("Exceptiion" + e);
  }
 }
}
 