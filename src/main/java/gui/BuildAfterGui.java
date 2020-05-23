package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import main.Loader;
import notwist.base.User;
import notwist.database.DBDiscussion;
import notwist.database.DBDiscussionImpl;
import table.Nofilter;
import util.CategoryPan;
import util.Header;
import util.UpperPan;

public class BuildAfterGui extends JFrame {
 
	private static final long serialVersionUID = 1L;

    private DBDiscussion discussion = new DBDiscussionImpl();
	private User actualUser = null;
	private Loader loader;
	
	
	  public BuildAfterGui(User user) {
	      initComponents();
		  this.actualUser = user;
		  this.loader = new Loader();
		  this.setVisible(true);
		  this.pack();
    }


    private void initComponents() {

       	bodyHolder = new JPanel(); //Holder for body
       
        //JFrame properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        //Get upper panel and add it to the main frame
        upper_panel = new UpperPan();
        upper_panel.setVisible(true);
       
        getContentPane().add(upper_panel, new AbsoluteConstraints(670, 0, -1, 40));
        
        //Header
        
        header_panel = new Header();
        header_panel.setVisible(true);
        
        getContentPane().add(header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1080, 90));

        //Qua chiamo il pannello no filter con la tabella principale non filtrata, basta togliere il commento /* sotto
     /*   Nofilter drag_panel = new Nofilter(this.actualUser);
        drag_panel.setVisible(true);
        
        
       
        getContentPane().add(drag_panel, new AbsoluteConstraints(820, 0, 260, 40));
        //qua era dove addavo la card, ma per i test è rimasta commentata
     /*   CategoryPan category_panel = new CategoryPan();
        category_panel.setVisible(true);
        bodyHolder.add(category_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 240, 200));
       
        */
        pack();
        
        //<--------------METHODS---------------------------------------->
        
        //Call Drag the frame
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
		
    	//<------------------------END---------------------------->
    
    //Drag the frame 
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
    
  

    // Variables declaration - do not modify
    private JPanel bodyHolder;   
    private UpperPan upper_panel;
    private Header header_panel;
    // End of variables declaration
}