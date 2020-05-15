package login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import homepage.Homepage_gui;
import notwist.base.User;
import notwist.database.DBUser;
import notwist.database.DBUserImpl;
public class LoginPan extends JPanel {
	private static final long serialVersionUID = 1L;
	private DBUser user = new DBUserImpl();
	public LoginPan() {
		
		drawComp();
	}
	
	private void drawComp() {
		
	       
	       
        jSeparator2 = new JSeparator();
     
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

		
		  //<------------Draw login panel------------------->
        login_panel.setLayout(new AbsoluteLayout());
        
        //Password section
        pssw_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        pssw_label.setText("Password");
        pssw_label.setToolTipText("Utilizza una password sicura!");
        login_panel.add(pssw_label, new AbsoluteConstraints(60, 170, -1, -1));
        
    //    pssw_field.setBackground(new Color(242, 242, 242));
              
        pssw_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        pssw_field.setBorder(null);          
      
        login_panel.add(pssw_field, new AbsoluteConstraints(60, 200, 290, 20));

        //Separator
        jSeparator1.setBackground(new Color(0,0,0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(194, 192, 192)));
        jSeparator1.setMinimumSize(new java.awt.Dimension(30, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(30, 20));
        login_panel.add(jSeparator1, new AbsoluteConstraints(60, 140, 290, -1));

        //Mail section
        mail_label.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        mail_label.setText("Mail");
        mail_label.setToolTipText("Utilizza una mail valida!");
        login_panel.add(mail_label, new AbsoluteConstraints(60, 80, -1, -1));        
  
       // mail_field.setBackground(new Color(242, 242, 242));
        mail_field.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        mail_field.setBorder(null);
        login_panel.add(mail_field, new AbsoluteConstraints(60, 110, 290, 20));
  
        //Separator
        jSeparator2.setBackground(new Color(0,0,0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(194, 192, 192)));
        jSeparator2.setMinimumSize(new java.awt.Dimension(30, 20));
        jSeparator2.setPreferredSize(new java.awt.Dimension(30, 20));
        login_panel.add(jSeparator2, new AbsoluteConstraints(60, 230, 290, -1));
        
        //Login button
        login_button.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        login_button.setText("LOGIN");
        login_panel.add(login_button, new AbsoluteConstraints(60, 270, 290, 60));
       
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
        login_panel.add(signup_link, new AbsoluteConstraints(230, 350, -1, -1));
        login_panel.add(dot, new AbsoluteConstraints(250, 350, -1, -1));

        signup_link.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                signup_linkMouseClicked(evt);
            }
        });
        
        add(login_panel);
               
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
        	if(this.login_button.getActionListeners().length == 0)
        		throw new IllegalStateException();
        	new SwingWorker<String,Object>(){

        		@Override
        		protected String doInBackground() throws Exception {
        			Optional<User> user = getCredential();
        			if(user.isPresent()) {
        				JOptionPane.showMessageDialog(null, "Credenziali corrette, Benvenuto!");
        				((Window) getParent()).dispose();
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
    }

        private void mail_fieldFocusGained(FocusEvent evt) {
            pssw_label.setForeground(new Color(0, 0, 0));
            mail_label.setForeground(new Color(135, 175, 218));
         
        }

        private void pssw_fieldFocusGained(FocusEvent evt) {
            mail_label.setForeground(new Color(0, 0, 0));
            pssw_label.setForeground(new Color(135, 175, 218));
        }


        public JButton getLogBtn() {
        	return this.login_button;
        }

        public String getMail() {
        	return this.mail_field.getText();
        }
        
        public String getPassword() {
        	return this.pssw_field.getText();
        }
         
        public Optional<User> getCredential() {
        	return user.login(getMail(), getPassword());	
        }
        

        
        private void signup_linkMouseClicked(MouseEvent evt) {
            CardLayout card = (CardLayout)getParent().getLayout();
            card.show(getParent(), "register_panel");
        }
        

	
	  private JLabel pssw_label;
	    private JLabel mail_label;
	    private JLabel signup_link;
	    private JLabel dot;
	    private JButton login_button; 
	  

	    private JLabel signup_label;

	   

	    private JPanel login_panel;

	    private JSeparator jSeparator1;
	    private JSeparator jSeparator2;

	    private JTextField mail_field;
	    private JPasswordField pssw_field; 
	    private JButton checkP;
}
