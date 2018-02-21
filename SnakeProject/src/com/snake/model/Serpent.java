package com.snake.model;

import java.awt.Color;

public class Serpent {

	private static int nbInstnacesSerpent = 0;

	private int idSerpent;
	private String pseudo,password;
	private Color couleur;
	private int xp, level, score;
	private int nbEnnemisTues, nbMorts;
	private int nbBonusPris;
	//vitesse, bonus, comportements... a ajouter plus tard

	public Serpent(String pPseudo, String pPassword, Color pCouleur) {
		nbInstnacesSerpent++;

		this.idSerpent = nbInstnacesSerpent;
		this.pseudo = pPseudo;
		this.password = pPassword;
		this.couleur = pCouleur;
		this.xp = this.level = this.score= 0;
		this.nbEnnemisTues = this.nbMorts = 0;
		this.nbBonusPris = 0;
	}

	public String toString() {
		String msg = "Hello " +this.pseudo+" !\n";
		msg+= "Ton serpent est de couleur : " + this.couleur+"\n";
		msg+= "Voici tes stats à l'heure actuelle : \n";
		msg+= "Lvl : "+this.level+"\n";
		msg+= "XP : "+this.xp+"\n";
		msg+= "Ennemis tués : "+this.nbEnnemisTues+"\n";
		msg+= "Tué : "+this.nbMorts+" fois \n";
		msg+= "Nombre de Bonus récupérés : "+this.nbBonusPris+"\n";
		msg+= "Score : "+this.score+" points \n";

		return msg;

	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNbEnnemisTues() {
		return nbEnnemisTues;
	}

	public void setNbEnnemisTues(int nbEnnemisTues) {
		this.nbEnnemisTues = nbEnnemisTues;
	}

	public int getNbMorts() {
		return nbMorts;
	}

	public void setNbMorts(int nbMorts) {
		this.nbMorts = nbMorts;
	}

	public int getNbBonusPris() {
		return nbBonusPris;
	}

	public void setNbBonusPris(int nbBonusPris) {
		this.nbBonusPris = nbBonusPris;
	}

	public int getIdSerpent() {
		return idSerpent;
	}

	public String getPseudo() {
		return pseudo;
	}

	public static int getNbInstancesSerpent() {
		return nbInstnacesSerpent;
	}
}
