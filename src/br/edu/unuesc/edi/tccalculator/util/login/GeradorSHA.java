package br.edu.unuesc.edi.tccalculator.util.login;


	import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
	  /**
	   * Gerador de SHA-256 para fazer a encriptação da senha. 
	   * A senha passa para Sha-256 e ainda é convertido em String de Hexadecimal. 
	   * @author jonas
	   *
	   */
	  public class GeradorSHA{
		  /**
		   * 
		   * @param senha senha para ser encriptada
		   * @return retorna a senha em hexadecimal
		   * @throws NoSuchAlgorithmException
		   * @throws UnsupportedEncodingException
		   */
	   public static String login(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	            {     
	            	MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
                    byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
                     
                    StringBuilder hexString = new StringBuilder();
                    for (byte b : messageDigest) {
                      hexString.append(String.format("%02X", 0xFF & b));
                    }
                    String senhahex = hexString.toString();
                    return senhahex;
	           } 
	  }
	  }

