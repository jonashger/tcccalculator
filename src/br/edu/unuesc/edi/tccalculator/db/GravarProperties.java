package br.edu.unuesc.edi.tccalculator.db;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GravarProperties {

	static Dados dados = new Dados();
		public static void init(String user, String senha){
		Properties properties = new Properties();
		dados.setUser(user);
		dados.setSenha(senha);

		//setando as propriedades(key) e os seus valores(value)
		properties.setProperty("user", dados.getUser());
		properties.setProperty("senha", dados.getSenha());
		try {
			//Criamos um objeto FileOutputStream            
			FileOutputStream fos = new FileOutputStream("c:/dados.properties");
			//grava os dados no arquivo
			properties.store(fos, "FILE Senha");
			//fecha o arquivo
			fos.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}
		
		}
		 
