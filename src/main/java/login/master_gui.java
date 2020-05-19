package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import homepage.Homepage_gui;
import notwist.base.User;
import notwist.database.DBUser;
import notwist.database.DBUserImpl;
import sign_up.register;

/*
 * import javax.swing.*;
 * import javax.awt.*;
 * import javax.awt.event.*;
 * import org.netbeans.lib.awtextra.*
 * import homepage.Homepage_gui;
 * import notwist.base.User;
 * import notwist.database.DBUser;
 * import notwist.database.DBUserImpl;
 * import sign_up.register;
*/

/**
 * Initialize GUI
 */
public class master_gui extends JFrame {

	private static final long serialVersionUID = 1L;
	
    // Creates new form master_gui
	private DBUser user = new DBUserImpl();
	
	public master_gui() {
        initComponents();
    }

    /**
     * Draw components
     */

    private void initComponents() {

       	login_panel = new JPanel();
       	pssw_label= new JLabel();
        jSeparator1 = new JSeparator();
        mail_field = new JTextField();
        jSeparator2 = new JSeparator();
        pssw_field = new JPasswordField();
        mail_label = new JLabel();
        login_button = new JButton();
        signup_label = new JLabel();
        dot = new JLabel();
        signup_link = new JLabel();
        upper_panel = new JPanel();
        close_label = new JLabel();
        logo_panel = new JPanel();
        logo = new JLabel();

        //JFrame properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(80, 24, 24));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());
        
		//Beware! Always have component.something() and component.add() sticking together or 
		//it is going to mess with the display!
		
        //Draw login panel
        login_panel.setBackground(new Color(250, 250, 250));
        login_panel.setLayout(new AbsoluteLayout());
        
        //Password section
        pssw_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        pssw_label.setText("Password");
        login_panel.add(pssw_label, new AbsoluteConstraints(60, 170, -1, -1));
 
        pssw_field.setBackground(new Color(250, 250, 250));
        pssw_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        pssw_field.setBorder(null);        
        login_panel.add(pssw_field, new AbsoluteConstraints(60, 200, 270, 20));

        //Separator
        jSeparator1.setBackground(new Color(255, 255, 245));
        login_panel.add(jSeparator1, new AbsoluteConstraints(60, 140, 290, -1));

        //Mail section
        mail_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        mail_label.setText("Mail");
        login_panel.add(mail_label, new AbsoluteConstraints(60, 80, -1, -1));        
        
        mail_field.setBackground(new Color(250, 250, 250));
        mail_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        mail_field.setActionCommand("<Not Set>");
        mail_field.setBorder(null);
        login_panel.add(mail_field, new AbsoluteConstraints(60, 110, 270, 20));

        //Separator
        jSeparator2.setBackground(new Color(255, 255, 245));
        login_panel.add(jSeparator2, new AbsoluteConstraints(60, 230, 290, -1));

        //Login button
        login_button.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        login_button.setText("LOGIN");
        login_panel.add(login_button, new AbsoluteConstraints(60, 270, 300, 60));
       
        //Loader after Login
        JLabel loader = new JLabel(new ImageIcon("img/loader_login.gif"));
    	loader.setBounds(login_button.getBounds());
       	login_panel.add(loader,new AbsoluteConstraints(60, 270, 300, 60));

       	//Link section
        signup_label.setText("Non hai un account? Registrati");
        signup_label.setToolTipText("Hai bisogno di un account per poter entrare");
        signup_link.setForeground(new Color(250, 0, 0));
        signup_link.setText("qui");      
        dot.setText(".");
        login_panel.add(signup_label, new AbsoluteConstraints(60, 350, -1, -1));
        login_panel.add(signup_link, new AbsoluteConstraints(240, 350, -1, -1));
        login_panel.add(dot, new AbsoluteConstraints(260, 350, -1, -1));
        
        //Add login_panel to main frame
        getContentPane().add(login_panel, new AbsoluteConstraints(510, 40, 420, 470));
     
        //Draw upper menu panel
        upper_panel.setBackground(new Color(250, 250, 250));
        upper_panel.setLayout(new AbsoluteLayout());

        //Close "button"
        close_label.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        close_label.setForeground(new Color(250, 0, 0));
        close_label.setText("X");
        upper_panel.add(close_label, new AbsoluteConstraints(398, 10, 10, -1));

        //Add upper_panel to main frame
        getContentPane().add(upper_panel, new AbsoluteConstraints(510, 0, 420, 40));

        //Draw logo_panel, get the picture and fix the size to fit the panel itself
        logo_panel.setBackground(new Color(67, 71, 91));
        logo.setIcon(new ImageIcon("img/font_test_1.png")); // NOI18N
        logo.setDoubleBuffered(true);
        logo.setFocusable(false);
        logo.setRequestFocusEnabled(false);
        logo.setVerifyInputWhenFocusTarget(false);

        GroupLayout logo_panelLayout = new GroupLayout(logo_panel);
        logo_panel.setLayout(logo_panelLayout);
        
        logo_panelLayout.setHorizontalGroup(
            logo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(logo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        logo_panelLayout.setVerticalGroup(
            logo_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, logo_panelLayout.createSequentialGroup()
            		.addComponent(logo, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
            		.addGap(0, 0, Short.MAX_VALUE))
        );
        
        //Add login_panel to main frame
        getContentPane().add(logo_panel, new AbsoluteConstraints(0, 0, -1, -1));

        //Pack to fix things
        pack();
        
        //<-------------- END ------------------------------------>
              
        /*
         * Calling all the required methods
         */
        
        //Frame methods
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
		
		//Close method
        close_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                close_labelMouseClicked(evt);
            }
        });
        
        //Change label color on focus
        mail_field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                mail_fieldFocusGained(evt);
            }
        });
        
        pssw_field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                pssw_fieldFocusGained(evt);
            }
        });
		
		//Login_button method		
        this.login_button.addActionListener(e ->{
        	login_button.setVisible(false);
        	loader.setVisible(true);
        	
        	new SwingWorker<String,Object>(){

        		@Override
        		protected String doInBackground() throws Exception {
        			Optional<User> user = getCredential();
        			if(user.isPresent()) {
        				JOptionPane.showMessageDialog(null, "Credenziali corrette, Benvenuto!");
        				dispose();
        				new Homepage_gui(user.get());
        				return  "Credenziali corrette";
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "Credenziali errate, riprovare! :(");
        				loader.setVisible(false);
        				login_button.setVisible(true);
        				return "Credenziali errate";
        			}
        		}
        	}.execute();
        });
        

        //Button register
        signup_link.addMouseListener( new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				new register().start();
				dispose();
			}
			
			//Necessary stuff to return no error
			@Override
			public void mousePressed(MouseEvent e) {		
			}
			@Override
			public void mouseReleased(MouseEvent e) {		
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {		
			}    	
        });       
    }

    //<------------METHODS-------------------->
    
    //Close
    private void close_labelMouseClicked(MouseEvent evt) {
    	System.exit(0);
    }

    //Drag 
    private  int xy;
    private  int xx;
    
    private void FrameMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }
    
    private void FrameMousePressed(java.awt.event.MouseEvent evt) {  
        xx = evt.getX();
        xy = evt.getY();
    }
    
    //Focus
    private void mail_fieldFocusGained(java.awt.event.FocusEvent evt) {
        pssw_label.setForeground(new Color(0, 0, 0));
        mail_label.setForeground(new Color(0, 150, 0));
    }

    private void pssw_fieldFocusGained(java.awt.event.FocusEvent evt) {
        mail_label.setForeground(new Color(0, 0, 0));
        pssw_label.setForeground(new Color(0, 150, 0));
    }

    //Getter
    public String getMail() {
    	return this.mail_field.getText();
    }
    
    public String getPassword() {
    	return this.pssw_field.getText();
    }
    
    /**
     * Control if user exist
     * if not exist, return null, otherwise return current User
     */
    
    public Optional<User> getCredential() {
    	return user.login(getMail(), getPassword());	
    }
    
    public void start() {
    	
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_gui().setVisible(true);
            }
        });
    }
    
    // Variables declaration 
    private javax.swing.JButton login_button;
    private javax.swing.JLabel pssw_label;
    private javax.swing.JLabel signup_label;
    private javax.swing.JLabel mail_label;
    private javax.swing.JLabel signup_link;
    private javax.swing.JLabel dot;
    private javax.swing.JLabel close_label;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logo_panel;
    private javax.swing.JPanel login_panel;
    private javax.swing.JPanel upper_panel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField mail_field;
    private javax.swing.JPasswordField pssw_field;
    // End of variables declaration
}
