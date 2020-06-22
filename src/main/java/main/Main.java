package main;

import com.formdev.flatlaf.FlatLightLaf;

import view.gui.BuildPreGui;

import java.io.IOException;

import javax.swing.UIManager;

/**
 * Starting the GUI.
 */

public class Main {
	/*
	 * Load the look and feel theme.
	 */
	public static void main(String[] args) throws SecurityException, IOException {
		// <----------LOOK AND FEEL FOR THE GUI -------->
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		BuildPreGui gui = new BuildPreGui();

		gui.start();
		
		
		
		
	}

}
