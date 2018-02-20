package com.snake.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.snake.model.Joueur;

public class AuthenticationView extends JFrame {
	private AuthenticationPane ap;

	public AuthenticationView() {
		this.setTitle("Online SnakeRPG");
		this.setSize(750, 750);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ap = new AuthenticationPane();
		this.activeActionListener();
		this.setContentPane(ap);               
		this.setVisible(true);
	}

	public void activeActionListener() {
		this.ap.getConnexion().addActionListener(new BoutonConnexionListener());
		this.ap.getInscription().addActionListener(new BoutonInscriptionListener());
	}



	//Class Pour les ActionListener des éléments de AuthenticationView
	class BoutonConnexionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String pseudo = ap.getPseudoCo().getText();
			String password = String.valueOf(ap.getPassCo().getPassword());
			if (pseudo.isEmpty()|| password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erreur connexion !", 
						"Erreur Connexion",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Connexion en cours... login : [" +pseudo+"] mot de passe : ["+password+"]...", 
						"Connexion infos",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(String.valueOf(password));

			}
		}
	}

	class BoutonInscriptionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String pseudo = ap.getPseudoIns().getText();
			String password = String.valueOf(ap.getPassIns().getPassword());
			String passwordConf = String.valueOf(ap.getPassInsConf().getPassword());
			if (pseudo.isEmpty()|| password.isEmpty() || passwordConf.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erreur Inscription ! Vérifiez vos informations.", 
						"Erreur Inscription",JOptionPane.ERROR_MESSAGE);
			}else if (!password.equals(passwordConf)) {
				JOptionPane.showMessageDialog(null, "Erreur Inscription ! Les mots de passe ne sont pas identiques !", 
						"Erreur Mot De Passe",JOptionPane.ERROR_MESSAGE);
			} else {
				Joueur j = new Joueur(pseudo, password);
				JOptionPane.showMessageDialog(null, "Inscription en cours... login : ["+pseudo+"] mot de passe : ["+password+"]...", 
						"Inscription infos",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(j.toString());
			}
		}
	}
}
