package main;

import com.formdev.flatlaf.FlatLightLaf;
import gui.*;
import javax.swing.UIManager;

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
<<<<<<< HEAD
BuildAfterGui gui = new BuildAfterGui();
//BuildPreGui gui = new BuildPreGui();

=======
//BuildAfterGui gui = new BuildAfterGui();
  BuildPreGui gui = new BuildPreGui();
  
>>>>>>> 23acca46d54fa2cec42bb6e777cf4a886529da6b
gui.start();
    }
    
}
