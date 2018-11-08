package main;

import java.awt.EventQueue;
import java.util.Vector;

import Gui.App_GUI;
import Gui.MyFrame;

public class main {

	public static void main(String[] args) {
		
		 Automat automat = new Automat(5, 1, 5, 4);
		
		automat.printAutomat();
		
		App_GUI.main();
	}
}

/*
 * TO DO:
 * 	-Buttons
 * 		-check if word is in automaton
 * 
 * 	-TextFields
 *	  -INPUT:
 * 		-filename
 * 		-isWordInAutomat
 * 
 * 	-CheckBox
 * 		-Generate XML
 * 		-generate DOT
 *  
 *  */
