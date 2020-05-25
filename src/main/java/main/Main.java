package main;

import com.formdev.flatlaf.FlatLightLaf;
import gui.BuildPreGui;
import javax.swing.UIManager;
import gui.BuildAfterGui;

/**
 * Starting the GUI.
 */

public class Main {
  /*
   * Load the look and feel theme.
   */
  public static void main(String[] args) {
    //<----------LOOK AND FEEL FOR THE GUI -------->
    try {
      UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (Exception ex) {
      System.err.println("Failed to initialize LaF");
      }
BuildAfterGui gui = new BuildAfterGui();
gui.start();
    }
    
}