package com.locar.ui;
import javax.swing.SwingUtilities;
public class Main {
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Login tela = new Login();
	            tela.setVisible(true);
	        });
	    }
	}

