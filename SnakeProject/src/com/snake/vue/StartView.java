package com.snake.vue;

import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;

public class StartView extends JFrame {
	private StartPane sp;
	
	public StartView() {
		this.init();
	}

	public void init() {
		this.setTitle("Online SnakeRPG");
		this.setSize(750, 750);
		this.setLocationRelativeTo(null);   
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Instanciation d'un objet JPanel
		sp = new StartPane();
		//On prévient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(sp);               
		this.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();

	}
}
