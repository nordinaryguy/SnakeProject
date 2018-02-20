package com.snake.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.snake.patternObservateur.*;

public class ComClientToserver extends JFrame  implements Runnable,Observer, KeyListener {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	//private Scanner sc;
	private Thread t3, t4;
	private String commande = "INIT";
	private JPanel container = new JPanel();
	private JLabel label = new JLabel();

	public ComClientToserver(Socket s){
		socket = s;
		this.setSize(500, 500);

		this.setTitle("SnakeVueClient");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setResizable(false);

		initComposant();                

		//this.controler = controler;                

		this.setContentPane(container);

		this.setVisible(true);
	}

	private void initComposant(){
		Font police = new Font("Arial", Font.BOLD, 20);
		label.setText("NULL");
		label.setFont(police);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(100,20));
		addKeyListener(this);
		container.add(label, BorderLayout.CENTER);
	}

	public void run() {
		try {

			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//sc = new Scanner(System.in);

			Thread t4 = new Thread(new Emission(out,commande));
			t4.start();
			Thread t3 = new Thread(new Reception(in,out,socket));
			t3.start();


		} catch (IOException e) {
			System.err.println("Le serveur distant s'est deconnecte !");
		}

	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int code = arg0.getKeyCode();
		//char Caract = arg0.getKeyChar();
		switch (code) {
		case 37:
			label.setText("Gauche");
			this.commande="Gauche";
			this.run();
			break;
		case 38:
			label.setText("Haut");
			this.commande="Haut";
			this.run();
			break;

		case 39:
			label.setText("Droite");
			this.commande="Droite";
			this.run();
			break;

		case 40:
			label.setText("Bas");
			this.commande="Bas";
			this.run();
			break; 

		case 81:
			label.setText("Quitter");
			this.commande="Quitter";
			this.run();
			System.exit(1);

			break; 

		default:
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void update(String str) {
		// TODO Auto-generated method stub

	}

}
