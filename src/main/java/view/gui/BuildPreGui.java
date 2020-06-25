package view.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import view.login.LoginPan;
import view.signup.RegisterPan;
import view.util.LogoPan;
import view.util.UpperPan;

public class BuildPreGui extends JFrame {
 
	private static final long serialVersionUID = 1L;

	/*Builder.*/
	public BuildPreGui() {
    	
        initComponents();
    }

    private void initComponents() {

        panelHolder = new JPanel(); //Holder for Login and Register

        //JFrame properties.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());


        Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("img/icon.jpg"));    
        setIconImage(icon);   
        //Get upper panel and add it to the main frame.
        upperPanel = new UpperPan();
        upperPanel.setVisible(true);

        getContentPane().add(upperPanel, new AbsoluteConstraints(510, 0, 420, 40));

        //Card space.
        panelHolder.setLayout(new CardLayout());

        //Add login to card.
        loginPanel = new LoginPan();
        loginPanel.setVisible(true);
        panelHolder.add(loginPanel, "login");

        //Add register to card.
        registerPanel = new RegisterPan();
        registerPanel.setVisible(true);
		panelHolder.add(registerPanel, "registerPanel");

        //Adding card.
        getContentPane().add(panelHolder, new AbsoluteConstraints(510, 40, 370, 480));
        

     
        //Get logo panel and add it to the main frame.
        logo = new LogoPan();
        logo.setVisible(true);
        logo.setBackground(new Color(67, 71, 91));
    	
        getContentPane().add(logo, new AbsoluteConstraints(0, 0, -1, -1));
        
        pack();
        
        //Methods place.
        
        //Call Drag the frame.
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                FrameMouseDragged(evt);
            }
        });
		getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                FrameMousePressed(evt);
            }
        });
    }
		
    	//End methods place.
    
    //Drag the frame. 
    private  int xy;
    private  int xx;
    
    private void FrameMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }
    
    private void FrameMousePressed(MouseEvent evt) {  
        xx = evt.getX();
        xy = evt.getY();
    }
    
   
    
    
    
    
    
   //Builder GUI.
    public void start() {

    	EventQueue.invokeLater(new Runnable() {
            public void run() {
            	  new BuildPreGui().setVisible(true);
            	  
            }
        });
    }
    
  

    
    private JPanel panelHolder;   
    private LoginPan loginPanel;
    private LogoPan logo;
    private UpperPan upperPanel;
    private RegisterPan registerPanel;

}