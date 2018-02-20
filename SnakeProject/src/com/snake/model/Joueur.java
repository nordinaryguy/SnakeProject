package com.snake.model;

public class Joueur {

	private String pseudo, password;
	
	public Joueur(String pPseudo, String pPassword) {
		this.pseudo = pPseudo;
		this.password = pPassword;
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
		String msg = "Bonjour moi c'est : "+this.pseudo+" et mon mot de passe est : "+this.password;
		return msg;
	}
	
	
}
