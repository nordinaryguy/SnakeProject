package com.snake.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.snake.model.Serpent;
import com.snake.model.SnakeEngine;

public class AuthenticationView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SnakeEngine se;
	private AuthenticationPane ap;
	private String pseudo;
	private String password;
	private String passwordConf;
	private Color couleur;

	public AuthenticationView(SnakeEngine pse) {
		this.se = pse;
		this.setTitle("Online SnakeRPG");
		this.setSize(750, 750);
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pseudo=null;
		this.password=null;
		this.passwordConf=null;
		this.couleur=null;
		ap = new AuthenticationPane();
		this.activeActionListener();
		this.setContentPane(ap);               
		this.setVisible(true);
	}

	public void activeActionListener() {
		this.ap.getConnexion().addActionListener(new BoutonConnexionListener());
		this.ap.getInscription().addActionListener(new BoutonInscriptionListener());
		this.ap.getRedColor().addActionListener(new RedColorListener());
		this.ap.getBlackColor().addActionListener(new BlackColorListener());
		this.ap.getGreenColor().addActionListener(new GreenColorListener());
	}

	//Class Pour les ActionListener des elements de AuthenticationView
	class BoutonConnexionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pseudo = ap.getPseudoCo().getText();
			password = String.valueOf(ap.getPassCo().getPassword());
			if (pseudo.isEmpty()|| password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erreur connexion !", 
						"Erreur Connexion",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Connexion en cours... login : [" +pseudo+"] mot de passe : ["+password+"]...", 
						"Connexion infos",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println(String.valueOf(password));
				se.controlConnexion(pseudo, password);
				
			}
		}
	}

	class BoutonInscriptionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pseudo = ap.getPseudoIns().getText();
			password = String.valueOf(ap.getPassIns().getPassword());
			passwordConf = String.valueOf(ap.getPassInsConf().getPassword());
			if (pseudo.isEmpty()|| password.isEmpty() || passwordConf.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Erreur Inscription ! Vérifiez vos informations.", 
						"Erreur Inscription",JOptionPane.ERROR_MESSAGE);
			}else if (!password.equals(passwordConf)) {
				JOptionPane.showMessageDialog(null, "Erreur Inscription ! Les mots de passe ne sont pas identiques !", 
						"Erreur Mot De Passe",JOptionPane.ERROR_MESSAGE);
			} else {
				if (couleur==null) {
					JOptionPane.showMessageDialog(null, "Erreur Inscription ! Aucune couleur sélectionnée !", 
							"Erreur Couleur",JOptionPane.ERROR_MESSAGE);
				}else {
					se.snakeBuilder(pseudo, password, couleur);
					JOptionPane.showMessageDialog(null, "Inscription en cours... login : ["+pseudo+"] mot de passe : ["+password+"]...", 
							"Inscription infos",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		}
	}

	class RedColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ap.getRedColor().isSelected()) {
				couleur=Color.RED;
				ap.getBlackColor().setEnabled(false);
				ap.getGreenColor().setEnabled(false);
			}else {
				couleur = null;
				ap.getBlackColor().setEnabled(true);
				ap.getGreenColor().setEnabled(true);
			}
			if (couleur == null) {
				System.out.println("couleur = vide");
			}else {
				System.out.println(couleur);
			}
		}

	}

	class BlackColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ap.getBlackColor().isSelected()) {
				couleur = Color.BLACK;
				ap.getRedColor().setEnabled(false);
				ap.getGreenColor().setEnabled(false);
			}else {
				couleur = null;
				ap.getRedColor().setEnabled(true);
				ap.getGreenColor().setEnabled(true);
			}
			if (couleur == null) {
				System.out.println("couleur = vide");
			}else {
				System.out.println(couleur);
			}
		}
	}

	class GreenColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ap.getGreenColor().isSelected()) {
				couleur = Color.green;
				ap.getBlackColor().setEnabled(false);
				ap.getRedColor().setEnabled(false);
			}else {
				couleur = null;
				ap.getBlackColor().setEnabled(true);
				ap.getRedColor().setEnabled(true);
			}
			if (couleur == null) {
				System.out.println("couleur = vide");
			}else {
				System.out.println(couleur);
			}
		}
	}
}
