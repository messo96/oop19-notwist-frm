package view.profile;


import java.awt.Color;

import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import message.MessagePan;
import model.base.User;
import user.UserDiscussions;
import user.Infos;
import user.UserComments;
import view.util.StrikePan;

public class Profile extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
     * Creates new Profile Panel
     */
    public Profile(final User user) {
        initComponents(user);
    }  
 
    private void initComponents(final User user) {

    	//If user is a mod
    	if(user.isModerator()) {
    	   
    	   	profile_panel = new JPanel();
            profile_panel.setLayout(new AbsoluteLayout());   
            
            reportedDiscussions = new UserDiscussions();
            profile_panel.add(reportedDiscussions, new AbsoluteConstraints(10, 0, -1, -1));
            
            myinfos_panel = new Infos(user);
            profile_panel.add(myinfos_panel, new  AbsoluteConstraints(730, 0, -1, -1));

            reportedComments = new UserComments();
            profile_panel.add(reportedComments, new  AbsoluteConstraints(10, 200, -1, -1)); 	   
    	   
            strike_panel = new StrikePan();
            profile_panel.add(strike_panel, new  AbsoluteConstraints(730, 150, 310, 310));
           add(profile_panel);
    	 
       }
       
       //If user is not a mod
       else{
    	
    	profile_panel = new  JPanel();
        profile_panel.setLayout(new  AbsoluteLayout());   
        
        activities_panel = new UserDiscussions();
        profile_panel.add(activities_panel, new  AbsoluteConstraints(10, 0,  -1, -1));
        

        myinfos_panel = new Infos(user);
        profile_panel.add(myinfos_panel, new  AbsoluteConstraints(730, 0, -1, -1));

        
        add(profile_panel);
       }
    }
    
 
    
    // Variables declaration
    private JPanel profile_panel;
    private UserDiscussions activities_panel;
    private Infos myinfos_panel;
    private UserComments reportedComments;
    private StrikePan strike_panel;
    private UserDiscussions reportedDiscussions;
    // End of variables declaration
    
   
}
