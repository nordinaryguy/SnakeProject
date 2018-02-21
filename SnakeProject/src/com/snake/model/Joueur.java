package com.snake.model;

import java.awt.Color;

public class Joueur {

	private String pseudo, password;
	private Color couleur;
	
	public Joueur(String pPseudo, String pPassword, Color pCouleur) {
		this.pseudo = pPseudo;
		this.password = pPassword;
		this.couleur = pCouleur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String msg = "Bonjour moi c'est : "+this.pseudo+" et mon mot de passe est : "+this.password +". \n Mon serpent est de couleur : " + this.couleur.toString();
		return msg;
	}
	
	
}
