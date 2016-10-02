package br.edu.unuesc.edi.tccalculator.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class LerProperties {
	public static ArrayList<String> lerPropriedades() {
		Properties properties = new Properties();
		try {
			//seta o arquivo que vai ser lido
			FileInputStream fis = new FileInputStream("c:/dados.properties");
			//metodo load faz a leitura atraves do objeto
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<String> list = new ArrayList<>();
		list.add(properties.getProperty("user"));
		list.add(properties.getProperty("senha"));
		return list;
		}
		
	}

