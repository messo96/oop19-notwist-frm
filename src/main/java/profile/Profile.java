package profile;

import java.awt.Color;

import javax.swing.JPanel;

import message.MessagePan;
import notwist.base.User;
import notwist.database.DBUserImpl;
import user.Activities;
import user.Infos;

public class Profile extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
     * Creates new Profile Panel
     */
    public Profile(final User user) {
        initComponents(user);
    }  
 
    private void initComponents(final User user) {

        profile_panel = new javax.swing.JPanel();
        profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());   
        
        activities_panel = new Activities();
        profile_panel.add(activities_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        

        myinfos_panel = new Infos(user);
        profile_panel.add(myinfos_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, -1));

        message_panel = new MessagePan();
        profile_panel.add(message_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        
        add(profile_panel);
    }
    
 
    
    // Variables declaration
    private JPanel profile_panel;
    private Activities activities_panel;
    private Infos myinfos_panel;
    private MessagePan message_panel;
    // End of variables declaration
    
   
}
