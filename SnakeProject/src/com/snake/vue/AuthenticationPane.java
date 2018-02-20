package com.snake.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AuthenticationPane extends JPanel {
	
	private JTextField pseudoCo, pseudoIns;
	private JPasswordField passCo, passIns, passInsConf;
	private JButton connexion, inscription;
	
	
	public AuthenticationPane() {
		
		this.init();
	}
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("src/ressources/Authentication.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}               
	}  
	
	public void init() {
		this.setLayout(null);
		//-----------------Connexion -----------------

		pseudoCo = new JTextField();
		pseudoCo.setPreferredSize(new Dimension(120,30));
		this.add(pseudoCo);
		pseudoCo.setBounds(27, 450, 130,30);
		
		passCo = new JPasswordField();
		passCo.setPreferredSize(new Dimension(120,30));
		this.add(passCo);
		passCo.setBounds(27, 580, 130,30);
		
		connexion = new JButton("Connexion");
		this.add(connexion);
		connexion.setBounds(90, 655, 130,30);
		
		//-----------------Inscription -----------------
		
		pseudoIns = new JTextField(null);
		pseudoIns.setPreferredSize(new Dimension(120,30));
		this.add(pseudoIns);
		pseudoIns.setBounds(340, 450, 130,30);
		
		passIns = new JPasswordField(null);
		passIns.setPreferredSize(new Dimension(120,30));
		this.add(passIns);
		passIns.setBounds(340, 535, 130,30);
	  
		passInsConf = new JPasswordField(null);
		passInsConf.setPreferredSize(new Dimension(120,30));
		this.add(passInsConf);
		passInsConf.setBounds(340, 615, 130,30);
		
		inscription = new JButton("Inscription");
		this.add(inscription);
		inscription.setBounds(450, 655, 130,30);
	}

	public JTextField getPseudoCo() {
		return pseudoCo;
	}

	public JTextField getPseudoIns() {
		return pseudoIns;
	}

	public JPasswordField getPassCo() {
		return passCo;
	}

	public JPasswordField getPassIns() {
		return passIns;
	}

	public JPasswordField getPassInsConf() {
		return passInsConf;
	}

	public JButton getConnexion() {
		return connexion;
	}

	public JButton getInscription() {
		return inscription;
	}
}
