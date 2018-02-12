package com.snake.serveur;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Serveur {
	public static ServerSocket ss = null;
	public static Thread t;


	public static void main(String[] args) {
		
		try {
			ss = new ServerSocket(2009);
			System.out.println("Le serveur est a  l'ecoute du port "+ss.getLocalPort());

			t = new Thread(new Accepter_connexion(ss));
			t.start();
		} catch (IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est deja utilise !");
		}
		//CTRL + SHIFT + O pour générer les imports

		/*try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:postgresql://172.29.110.218:5432/SnakeProject";
			String user = "postgres";
			String passwd = "root";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !"); 


			//Connection conn = DriverManager.getConnection(url, user, passwd);

			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM joueur");
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();

			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			System.out.println("\n**********************************");

			while(result.next()){         
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() + "\t |");

				System.out.println("\n---------------------------------");

			}

			result.close();
			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		}    */  

	}


}
