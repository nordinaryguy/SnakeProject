package com.snake.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

	private PrintWriter out;
	private String login = null;
	//private Scanner sc = null;
	private String cmd;

	public Emission(PrintWriter out, String cmd) {
		this.out = out;
		this.cmd = cmd;
	}

	public void run() {

		//sc = new Scanner(System.in);

		//while(true){
			/*System.out.println("Votre message :");
			message = sc.nextLine();
			out.println(message);
			out.flush();*/
			
		//}
		System.out.println("Envoi de la commande : " +cmd);
		out.println(cmd);
		out.flush();

	}
}
