package com.snake.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Reception implements Runnable {

	private PrintWriter out = null;
	private Socket s;
	private BufferedReader in;
	private String message = null;

	public Reception(BufferedReader in,PrintWriter out, Socket s){

		this.in = in;
	}

	public void run() {
		while(true){
			try {

				message = in.readLine();
				System.out.println("Le serveur vous dit : " +message);
				if (message.equals("Au revoir")) {
					break;
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		try {
			s.close();
			System.exit(1);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
