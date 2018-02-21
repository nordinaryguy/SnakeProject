package com.snake.model;

import java.awt.Color;
import java.util.ArrayList;

public class SnakeEngine {
	
	private ArrayList<Serpent> serpentsList;
	
	public SnakeEngine() {
		this.serpentsList = new ArrayList<Serpent>();
	}
	
	public void snakeBuilder(String pPseudo, String pPassword, Color pCouleur) {
		serpentsList.add(new Serpent(pPseudo, pPassword, pCouleur));
	}

	public ArrayList<Serpent> getSerpentsList() {
		return serpentsList;
	}

	public void setSerpentsList(ArrayList<Serpent> serpentsList) {
		this.serpentsList = serpentsList;
	}
	
	public boolean controlConnexion(String pPseudo, String pPassword) {
		for(Serpent s : serpentsList) {
			if (s.getPseudo().equals(pPseudo)) {
				if (s.getPassword().equals(pPassword)) {
					System.out.println("Connexion OK!");
					System.out.println(s.toString());
					return true;
				}
			}
		}
		System.out.println("Connexion KO!");
		return false;
	}
	
}
