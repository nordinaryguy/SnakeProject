package com.snake.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Reception implements Runnable {

	private BufferedReader in;
	private PrintWriter out = null;
	private Socket s;
	private String message = null, login = null;

	public Reception(BufferedReader in, String login, PrintWriter out, Socket s){

		this.in = in;
		this.login = login;
		this.out = out;
		this.s = s;
	}

	public void run() {

		while(true){
			try {

				message = in.readLine();
				System.out.println(login+" : "+message);
				//Gérer déconnexion
				if (message.equals("Quitter")) {
					System.out.println("Déconnexion de " + login + "...");
					out.println("Au revoir");
					out.flush();
					break;
					
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

